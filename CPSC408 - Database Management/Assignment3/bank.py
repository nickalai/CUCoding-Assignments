# Refereces: Worked with Alex Hamel and Brandon Makin

import pymysql
import uuid
from datetime import datetime

# Connects to the database
def create_mysql_connection(db_user, db_password, host_name, db_name):
    conn = None
    try:
        conn = pymysql.connect(user=db_user, password=db_password, host=host_name, db=db_name)
    except:
        print("Connection failed..")
    return conn

# Prompts the Customer to create an Account
def promptToCreateAccount(mysql_cur, currentUser):
    account_type = ''
    chooseType = input("\nWould you like to create a checkings or savings account? Enter 'c' or 's': ")
    while (True):
        if (chooseType == 'c'):
            account_type = 'Checkings'
            break
        elif (chooseType == 's'):
            account_type = 'Savings'
            break
        else:
            chooseType = input("Error. Invalid input. Try again: ")
    createAccount(mysql_cur, currentUser, account_type)

# Creates a Customer
def createCustomer(mysql_cur, id, ssn, first_name, last_name):
    mysql_cur.execute(f"INSERT INTO Customer VALUES ('{id}', {ssn}, '{first_name}', '{last_name}')")
    print(f"Welcome, {first_name} {last_name}. Your customer ID is:\n")
    print(id)
    print("\nPlease remember this ID number, as it is your login ID.\n")

# Creates an Account
def createAccount(mysql_cur, customer_id, account_type):
    account_num = makeId()
    mysql_cur.execute(f"INSERT INTO Account VALUES ('{account_num}', '{account_type}', 0)")
    mysql_cur.execute(f"INSERT INTO Account_xref VALUES ('{customer_id}', '{account_num}')")
    print(f"\nYour account number is:\n{account_num}\n")

# Checks the balance of a given Account number
def checkBalance(mysql_cur, account_num):
    mysql_cur.execute(f"SELECT balance FROM Account WHERE account_num = '{account_num}'")
    result = mysql_cur.fetchone()
    return float(result[0])

# Adds money to a given Account number
def depositMoney(mysql_cur, account_num, amount):
    mysql_cur.execute(f"UPDATE Account SET balance = balance + {amount} WHERE account_num = '{account_num}'")
    logTransaction(mysql_cur, account_num=account_num, trans_type="deposit", trans_amount=amount)

# Removes money from a given Account number
def withdrawMoney(mysql_cur, account_num, amount):
    mysql_cur.execute(f"UPDATE Account SET balance = balance - {amount} WHERE account_num = '{account_num}'")
    logTransaction(mysql_cur, account_num=account_num, trans_type="withdraw", trans_amount=amount)

# Moves money between Account numbers
def transferMoney(mysql_cur, account_num1, account_num2, amount):
    # Withdraws money from account 1
    mysql_cur.execute(f"UPDATE Account SET balance = balance - {amount} WHERE account_num = '{account_num1}'")
    logTransaction(mysql_cur, account_num=account_num1, trans_type="transfer remove", trans_amount=amount)
    # Deposits money into account 2
    mysql_cur.execute(f"UPDATE Account SET balance = balance + {amount} WHERE account_num = '{account_num2}'")
    logTransaction(mysql_cur, account_num=account_num2, trans_type="transfer add", trans_amount=amount)

# Logs transactions in the Transaction_log table
def logTransaction(mysql_cur, account_num, trans_type, trans_amount):
    mysql_cur.execute(f"INSERT INTO Transaction_log VALUES ('{datetime.now()}', '{makeId()}', '{account_num}', '{trans_type}', '{trans_amount}')")

# Changes a Customer's first name
def updateCustomerFirstName(mysql_cur, customer_id, first_name):
    mysql_cur.execute(f"UPDATE Customer SET first_name = '{first_name}' WHERE customer_id = '{customer_id}'")

# Changes a Customer's last name
def updateCustomerLastName(mysql_cur, customer_id, last_name):
    mysql_cur.execute(f"UPDATE Customer SET last_name = '{last_name}' WHERE customer_id = '{customer_id}'")

# Changes a Customer's SSN
def updateCustomerSSN(mysql_cur, customer_id, ssn):
    mysql_cur.execute(f"UPDATE Customer SET ssn = {ssn} WHERE customer_id = '{customer_id}'")

# Checks if a Customer has access to an Account
def crossCheckCustomerAccount(mysql_cur, customer_id, account_num):
    try:
        mysql_cur.execute(f"SELECT customer_id FROM Account_xref WHERE account_num = '{account_num}'")
        result = mysql_cur.fetchone()
        return str(result[0])
    except:
        return None

# Creates a unique ID
def makeId():
    return uuid.uuid4().hex

# Checks if an input ID matches any IDs in the Customer table
def checkValidLogin(mysql_cur, login):
    counter = 0
    mysql_cur.execute('SELECT customer_id FROM Customer')
    result = mysql_cur.fetchall()
    for id in result:
        if (login == result[counter][0]):
            return True
            break
        counter += 1
    return False

# Checks if an input ID matches any IDs in the Account table
def checkValidAccount(mysql_cur, accountNum):
    counter = 0
    mysql_cur.execute('SELECT account_num FROM Account')
    result = mysql_cur.fetchall()
    for num in result:
        if (accountNum == result[counter][0]):
            return True
            break
        counter += 1
    return False

# Returns all Account IDs for a Customer
def getAccountNums(mysql_cur, customer_id):
    counter = 0
    mysql_cur.execute(f"SELECT account_num FROM Account_xref WHERE customer_id = '{customer_id}'")
    accID = mysql_cur.fetchall()
    for id in accID:
        mysql_cur.execute(f"SELECT account_type FROM Account WHERE account_num = '{accID[counter][0]}'")
        accType = mysql_cur.fetchone()
        print(f"Account number: {accID[counter][0]} >> Account Type: {accType[0]}")
        counter += 1

# Returns the customer's name
def getCustomerName(mysql_cur, customer_id):
    mysql_cur.execute(f"SELECT first_name, last_name FROM Customer WHERE customer_id = '{customer_id}'")
    result = mysql_cur.fetchone()
    name = (result[0] + ' ' + result[1])
    return name

def main():
    isRunning = True
    userLogin = False;
    mysql_conn = create_mysql_connection(db_user='root', db_password='password', host_name='104.197.101.227', db_name='bank')
    mysql_cur = mysql_conn.cursor()

    while (isRunning == True):
        print("\nHello, Welcome to <bank_name>! You can do the following:")
        print("1. Login")
        print("2. Register")
        print("3. Exit")
        inputSelection = input("Please select an option: ")


        # Starting Login/Account creation prompts
        while (userLogin == False):
            # Logs into an existing account
            if (inputSelection == '1'):
                loginCred = input("\nEnter your Customer ID: ")
                # Checks if the entered Customer ID exists
                loginCheck = checkValidLogin(mysql_cur, loginCred)
                while(loginCheck == False):
                    loginCred = input("\nError. Not a valid login. Try again: ")
                    loginCheck = checkValidLogin(mysql_cur, loginCred)
                currentUser = loginCred
                userLogin = True
                print("\nSuccessful login.\n")
                customerName = getCustomerName(mysql_cur, currentUser)
                print(f"Welcome {customerName}. Your account IDs are:\n")
                getAccountNums(mysql_cur, currentUser)
            # Create a new account
            elif (inputSelection == '2'):
                print("\nTo create an account, please enter the following: ")
                firstName = input("First Name: ")
                lastName = input("Last Name: ")
                ssn = input("SSN: ")
                id = makeId()
                # Creates the customer with given information and commits it to the DB
                createCustomer(mysql_cur, id, ssn, firstName, lastName)
                mysql_conn.commit()
                currentUser = id
                userLogin = True
                # Prompts the Customer to create an Account
                promptToCreateAccount(mysql_cur, currentUser)
                mysql_conn.commit()
            # Exits the program
            elif (inputSelection == '3'):
                print("\nThank you for using <bank_name>! Now exiting...\n")
                mysql_conn.close()
                isRunning = False;
                break
            # Basic error handling
            else:
                inputSelection = input("\nERROR: Not a valid input. Retry: ")


        # Main Menu after login
        while (userLogin == True):
            print("\nWelcome back to <bank_name>!\n")
            print("1. Create Account")
            print("2. Show My Account Numbers")
            print("3. Check Balance")
            print("4. Deposit Money")
            print("5. Withdraw Money")
            print("6. Transfer Money")
            print("7. Update Account Information")
            print("8. Logout\n")

            inputSelection = input("Please select an option: ")

            # Create a new Account under logged in Customer ID
            if (inputSelection == '1'):
                promptToCreateAccount(mysql_cur, currentUser)
                mysql_conn.commit()
            # Returns all account numbers associated with the customer ID
            elif (inputSelection == '2'):
                print("\nYour account IDs are: ")
                getAccountNums(mysql_cur, currentUser)
            # Checks the balance of an entered Account number
            elif (inputSelection == '3'):
                accountNum = input("\nEnter your account number: ")
                if (currentUser == crossCheckCustomerAccount(mysql_cur, currentUser, accountNum)):
                    print("\nYour balance is: $" + str(checkBalance(mysql_cur, accountNum)))
                else:
                    print("\nERROR: Invalid Account ID for your login.")
                pass
            # Deposits money into an entered Account number
            elif (inputSelection == '4'):
                accountNum = input("\nEnter your account number: ")
                if (currentUser == crossCheckCustomerAccount(mysql_cur, currentUser, accountNum)):
                    depositAmt = float(input("Enter the amount you wish to deposit: $"))
                    depositMoney(mysql_cur, accountNum, depositAmt)
                    mysql_conn.commit()
                    print("\nSUCCESS: Account balance after deposit is: $" + str(checkBalance(mysql_cur, accountNum)))
                else:
                    print("\nERROR: Invalid Account ID for your login.")
                pass
            # Withdraws money from an entered Account number
            elif (inputSelection == '5'):
                accountNum = input("\nEnter your account number: ")
                if (currentUser == crossCheckCustomerAccount(mysql_cur, currentUser, accountNum)):
                    withdrawAmt = float(input("Enter the amount you wish to withdraw: $"))
                    if(withdrawAmt > checkBalance(mysql_cur, accountNum)):
                        print("\nERROR: Not enough funds in the account for this transaction. Returning to menu..")
                    else:
                        withdrawMoney(mysql_cur, accountNum, withdrawAmt)
                        mysql_conn.commit()
                        print("\nSUCCESS: Account balance after withdraw is: $" + str(checkBalance(mysql_cur, accountNum)))
                else:
                    print("\nERROR: Invalid Account ID for your login.")
                pass
            # Transfers money between entered Account numbers
            elif (inputSelection == '6'):
                # Checks user inputs to make sure valid accounts are used
                checkingAccounts = True
                while (checkingAccounts == True):
                    accountNum1 = input("\nEnter the account number of the account you wish to transfer money out of: ")
                    if (currentUser == crossCheckCustomerAccount(mysql_cur, currentUser, accountNum1)):
                        accountNum2 = input("\nEnter the account number of the account you wish to transfer money into: ")
                        checkingAccount2 = checkValidAccount(mysql_cur, accountNum2)
                        while(checkingAccount2 == False):
                            accountNum2 = input("\nERROR: Not a valid account. Retry: ")
                            checkingAccount2 = checkValidAccount(mysql_cur, accountNum2)
                        checkingAccounts = False
                        break
                    else:
                        print("\nERROR: Invalid Account ID for your login.")

                # Checks for valid fund transfer
                transferring = True
                while (transferring == True):
                    amount = float(input("\nPlease enter the amount of money you would like to transfer: $"))
                    if (amount > 5000.00):
                        amount = float(input("\nERROR: Transfers cannot exceed $5000. Please enter a valid amount: $"))
                    elif (amount > checkBalance(mysql_cur, accountNum1)):
                        print("\nERROR: Not enough funds in the account for this transaction. Returning to menu..")
                        break
                    else:
                        transferMoney(mysql_cur, accountNum1, accountNum2, amount)
                        mysql_conn.commit()
                        print(f"\nSUCCESS: ${amount} has been transferred from account {accountNum1} to {accountNum2}.")
                        break
            # Updates the Customer's information
            elif (inputSelection == '7'):
                selecting = True
                print("\nPlease select an option: ")
                print("1. Change Fist Name")
                print("2. Change Last Name")
                print("3. Change SSN")
                print("4. Return to Menu")

                while (selecting == True):
                    inputSelection = input("Enter the number of the information you would like to change: ")
                    if (inputSelection == '1'):
                        firstName = input("\nEnter new first name: ")
                        updateCustomerFirstName(mysql_cur, currentUser, firstName)
                        mysql_conn.commit()
                        print(f"SUCCESS: Your first name has been changed to: {firstName}")
                        selecting = False
                        break
                    elif (inputSelection == '2'):
                        lastName = input("\nEnter new last name: ")
                        updateCustomerLastName(mysql_cur, currentUser, lastName)
                        mysql_conn.commit()
                        print(f"SUCCESS: Your last name has been changed to: {lastName}")
                        selecting = False
                        break
                    elif (inputSelection == '3'):
                        ssn = int(input("\nEnter new SSN: "))
                        updateCustomerSSN(mysql_cur, currentUser, ssn)
                        mysql_conn.commit()
                        print(f"SUCCESS: Your SSN has been changed to: {ssn}")
                        selecting = False
                        break
                    elif (inputSelection == '4'):
                        print("\nReturning to Menu... No changes made.")
                        break
                    else:
                        print("ERROR: Invalid input")
            # Account logout and program exit
            elif (inputSelection == '8'):
                print("\nThank you for using the <bank_name> banking service. Now exitting..\n")
                mysql_conn.close()
                userLogin = False
                isRunning = False
            # Basic error handling
            else:
                inputSelection = input("ERROR: Not a valid input. Retry: ")


if __name__ == "__main__":
    main()
