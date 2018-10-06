# -*- coding: utf-8 -*-
"""
Created on Tue Apr 11 15:08:53 2017

@author: nickl
"""

#read from one file and write to another
input_file = open("replace.txt", "r") #read from this file
output_file = open("readit.txt", "w")   #write to this file
createDict = {}
for line in input_file: #one line at a time
    #createDict = {}
    value, key = line.split()   
    createDict[key] = value
print(createDict)
#line = line.strip() #remove the carriage return
    #new_str = "" #empty string
    #for char in line: #one character at a time
    #    new_str = char + new_str #concatenating backwards
    #print(new_str, file = output_file)
#print(key, value, file = output_file)
    
input_file.close()
output_file.close()

