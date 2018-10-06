# -*- coding: utf-8 -*-
"""
Created on Thu Feb  9 15:01:30 2017

@author: Nick Lai
"""

#prompts user for temperature in Celsius
tempC = float(input("Enter the temperature in Celsius: "))

#converts Celsius to Fahrenheit
tempF = tempC * 9/5 +32

#prints results
print("The temperature in Fahrenheit is:", tempF)