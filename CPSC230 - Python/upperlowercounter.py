# -*- coding: utf-8 -*-
"""
Created on Tue May 16 21:47:17 2017

@author: nickl
"""

#3 use string, calc num of upper case and lower case
def upperLowerCounter(inputStr):
    upperCount = 0
    lowerCount = 0
    for char in inputStr:
        if char.isupper():
            upperCount += 1
        if char.islower():
            lowerCount += 1
        else:
            continue
    return upperCount, lowerCount


inputStr = input("Enter a string: ")
upper, lower = upperLowerCounter(inputStr)
print("There are",upper,"uppercase letters and",lower,"lowercase letters.")