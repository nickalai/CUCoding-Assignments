1# -*- coding: utf-8 -*-
"""
Created on Thu Feb  9 15:04:30 2017

@author: Nick Lai
"""
#imports the math module
import math

#asks user for inputs for the coefficients of the function
a = float(input("Enter the first coefficient: "))
b = float(input("Enter the second coefficient: "))
c = float(input("Enter the third coefficient: "))

#calculates the discriminant of the function
d = b**2 - ( 4 * a * c )

#checks for invalid discriminant values. if the values are invalid, ask user for reinput
while d < 0:
    print("Error. Invalid discriminant value. Try again.")
    a = float(input("Enter the first coefficient: "))
    b = float(input("Enter the second coefficient: "))
    c = float(input("Enter the third coefficient: "))
    d = b**2 - ( 4 * a * c )
    
#prints out the result if values of the function pass the check.
else: 
    rootpos = ((-b + math.sqrt(d)) / 2 * a)
    rootneg = ((-b - math.sqrt(d)) / 2 * a)
    print("The roots of the function are", rootpos, "and", rootneg)

