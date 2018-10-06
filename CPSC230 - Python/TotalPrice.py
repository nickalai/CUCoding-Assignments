# -*- coding: utf-8 -*-
"""
Created on Thu Feb  9 14:53:51 2017

@author: Nick Lai
"""
#takes inputs for price of item and tax rate
price = float(input("Enter the price of the item: "))
tax = float(input("Enter the sales tax(do not put the percent sign): " ))

#determines whether or not the input is valid
if price < 0 and tax < 0:
    print("Error. Invalid price and tax values.")
elif price < 0:
    print("Error. Invalid price value.")
elif tax < 0:
    print("Error. Invalid tax value.")
    
#prints out total price if both input values are valid
else:
    total = price + price * (tax/100)
    print("The total price of your item is:", total)  