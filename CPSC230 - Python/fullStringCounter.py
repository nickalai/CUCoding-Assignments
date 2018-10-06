# -*- coding: utf-8 -*-
"""
Created on Tue May 16 21:31:32 2017

@author: nickl
"""

#2b. Takes string as an input, returns dictionary of the letter counts

def letterCounter(str_letterCount):
    emptyDict = {}
    str_letterCount = str_letterCount.replace(" ","")
    str_letterCount = str_letterCount.lower()   
    for char in str_letterCount:
        if char in emptyDict:
            emptyDict[char] += 1
        else:
            emptyDict[char] = 1
    return emptyDict           

str_letterCount = input("Enter a string: ")

print(letterCounter(str_letterCount))