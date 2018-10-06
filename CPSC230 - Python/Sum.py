# -*- coding: utf-8 -*-
"""
Created on Sun Feb 19 23:29:33 2017

@author: Nick Lai
"""

#asks user to input the amount of numbers they would like to add up
totalnum = int(input("How many numbers would you like to sum? "))

#stores the total sum
total_sum = 0

#asks the user to input the numbers they want to be added up
i = 0
while i < totalnum:
    num = int(input("Enter a number: "))
    total_sum = total_sum + num
    i = i + 1  

#responds to the user if an invalid amount of numbers to add is entered
if totalnum <= 0:
    print("I guess you don't want me to add anything for you...:/")

#prints out the total sum after adding up the numbers inputted
else:
    print("The total sum is:", total_sum)