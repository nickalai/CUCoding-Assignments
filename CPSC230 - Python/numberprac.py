# -*- coding: utf-8 -*-
"""
Created on Thu Feb 16 14:48:21 2017

@author: nickl
"""

#num = int(input("Enter a number: "))

#if num > 0:
#    print("Positive")
#    if num % 2 == 0:
#        print("Even")
#    elif num % 2 == 1:
#        print("Odd")
        
#else:
#    print("Negative")
    
#i = 1

#while i < 9:
#    i += 1
#    print(i)
 
#the_sum = 0
#add_num = True

#while add_num:
#    choice = input("Would you like to add a number sum? Enter 'y' or 'n': ")
#    if choice == 'y':
#        num = int(input("Enter a number: "))
#        the_sum = the_sum + num
#    elif choice == 'n':
#        add_num = False
#    else:
#        print("You're a fucking dumbass, put in 'y' or 'n' or I'll cut you.")
        
#print("The total sum is:", the_sum)

import math
def is_square(integer):
    root = math.sqrt(integer)
    if int(root + 0.5) ** 2 == integer: 
        return True
    else:
        return False