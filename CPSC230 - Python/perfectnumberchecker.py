# -*- coding: utf-8 -*-
"""
Created on Thu Feb 23 14:26:10 2017

@author: nickl
"""

#perfect number checker

#get a number to check
number = int(input("Please input a number to check: "))

#find and sum up the divisors
divisor = 1
divisor_sum = 0
while divisor < number:
    if number % divisor == 0:
        divisor_sum = divisor_sum + divisor
    divisor += 1
    
#classify the result
if number == divisor_sum:
    print(number, "is perfect")
else:
    print(number, "is not perfect")
             