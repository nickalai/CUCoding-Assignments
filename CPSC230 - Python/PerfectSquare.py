# -*- coding: utf-8 -*-
"""
Created on Tue Feb 21 14:36:54 2017

@author: Nick
"""

#imports the math module
import math

#asks the user for input on what number they would like to see
num = int(input("Enter a number that you would like to check if it is a perfect root: "))

#checks if the number is a perfect square
while math.sqrt(num) % 1 != 0:
    num = int(input("Error. Not a perfect square. Retry: "))

#prints out the number if it is a perfect square    
else:
    print(num, "is a perfect square!")