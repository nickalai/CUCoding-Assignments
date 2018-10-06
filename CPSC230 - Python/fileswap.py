# -*- coding: utf-8 -*-
"""
Created on Tue May 16 20:52:30 2017

@author: nickl
"""

#1. prompts for 2 file names, swaps content of them. if file dne, reprompt

firstFile = input("Input the first file's name: ")
secondFile = input("Input the second file's name: ")

try:
    file1 = open(firstFile, "r")
    file2 = open(secondFile, "r")
    f1stored = ''
    for line in file1:
        f1stored += line
    
    f2stored = ''
    for line in file2:
        f2stored += line
    
    file1.close()
    file2.close()
    
    file1 = open(firstFile, "w")
    file2 = open(secondFile, "w")
    
    print(f1stored, file = file2)
    print(f2stored, file = file1)
    
    file1.close()
    file2.close()

except FileNotFoundError:
    print("Error. File(s) do not exist. Retry")
    
