# -*- coding: utf-8 -*-
"""
Created on Thu Feb 23 14:57:39 2017

@author: nickl
"""


user_str = input("Enter a postitive integer: ") #Line 1
my_int = int(user_str)
count = 0

while my_int > 0:
    if my_int % 2 == 1:
        my_int = my_int//2
    else:
        my_int = my_int - 1
    count = count + 1 #Line 2

print(count) #Line 3
print(my_int) #Line 4 
    