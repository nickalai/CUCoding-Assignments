# -*- coding: utf-8 -*-
"""
Created on Thu Feb  9 14:53:51 2017

@author: Nick Lai
"""
#takes inputs for price of item
price = float(input("Enter the price of the item: "))
#checks for errors and asks for corrections from the user
while price < 0:
    price = float(input("Invalid price value. Please try again: "))

#takes inputs for tax rate
tax = float(input("Enter the sales tax(do not put the percent sign): " ))
#checks for errors and asks for corrections from the user
while tax < 0:
    tax = float(input("Invalid tax value. Please try again: "))
  
#prints out total price if both values are correct
else:
    total = price + price * (tax/100)
    print("The total price of your item is", total)