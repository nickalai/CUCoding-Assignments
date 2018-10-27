/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: In-class 2

Stores the functions of taking out and putting into the bank account. Also stores the functionality of saving progress of a simulation and loading it.
*/

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class BankAccount implements Serializable
{
	public int amount;
	
	public BankAccount()
	{
		amount = 50;
	}
	
	public BankAccount(int amount)
	{
		this.amount = amount;
	}
	
	//getters and setters
	public BankAccount(BankAccount newAcct)
	{
		this.amount = newAcct.amount;
	}
	
	
	public int getAmount()
	{
		return amount;
	}
	
	//function to deposit to the account
	public synchronized void Deposit()
	{
		amount++;
	}
	
	//function to withdraw from the account
	public synchronized void Withdraw()
	{
		amount--;
	}
	
	//function to create a save state. used when the program is exitted
	public void SaveState()
	{
	   try
       {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("bank_account"));

            outputStream.writeObject(this);

            outputStream.close( );
       } 
		catch(IOException e)
		{
			System.out.println("Problem with file output.");
		}
	}

	//function used to load a save state. if a save state does not exist, set the amount in the account to 50.
	public void LoadSave()
	{
		try
		{
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("bank_account"));
			BankAccount x = (BankAccount)(inputStream.readObject( ));
			this.amount = x.amount;
			inputStream.close();
		}
		catch(FileNotFoundException e)
		{
			this.amount = 50;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Problems with file input.");
		}
		catch(IOException e)
		{
			System.out.println("Problems with file input.");
		}
   }
   
	//prints out the total amount, used live in the GUI
	public String toString()
	{
		return "Total in Account: $" + this.amount;
	}
}