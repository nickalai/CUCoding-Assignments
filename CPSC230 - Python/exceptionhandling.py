# -*- coding: utf-8 -*-
"""
Created on Thu Apr 13 15:00:06 2017

@author: nickl
"""

#exception handling: try-except 1

not_valid = True
while not_valid:
    try:
        a = input("Enter a number: ")
        b = int(a)
        print(b * b + 2)
        not_valid = False

    except ValueError:
        print("Invalid input. Please enter an integer.")
    
print("lmaozedong")