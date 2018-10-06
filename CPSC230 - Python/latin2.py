# -*- coding: utf-8 -*-
"""
Created on Sun Apr 16 00:22:30 2017

@author: nickl
"""

def wordToPig(word):
    if len(word) > 0 and word.isalpha():
        word = word.lower()
        first = word[0]
        if first == 'a':
            return word + 'yay'
        elif first == 'e':
            return word + 'yay'
        elif first == 'i':
            return word + 'yay'
        elif first == 'o':
            return word + 'yay'
        elif first == 'u':
            return word + 'yay'
        else:
            return word[1:] + first + 'ay'
    return wordToPig(word) 
    

def nameToPig(name):
    name = name.split()
    return wordToPig(name[0])[0].upper() + wordToPig(name[0])[1:] + " " + wordToPig(name[1])[0].upper() + wordToPig(name[1])[1:]
    
    
names = input("What is the file name?: ")
try:
    input_file = open(names, "r")
    result = open("results_latin.txt", "w")
    
    for line in input_file:
        print("Your name in Pig Latin is:", nameToPig(line), file = result)
            
    print("Changes to the file", names, "have been made.")
    input_file.close()
    result.close()
    
except FileNotFoundError:
    print("The file", names, "does not exist.")
    
