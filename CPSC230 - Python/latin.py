# -*- coding: utf-8 -*-
"""
Created on Mon Apr  3 15:14:05 2017

@author: Nick Lai
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
    
    
def nameToPig(firstName, lastName):
    if wordToPig(firstName) == '' or wordToPig(lastName) == '':
        firstName == ''
        lastName == ''
    return wordToPig(firstName)[0].upper() + wordToPig(firstName)[1:] + " " + wordToPig(lastName)[0].upper() + wordToPig(lastName)[1:]
    

firstName = input("What is your first name?: ")
lastName = input("What is your last name?: ")
12

print("Your name in Pig Latin is:", nameToPig(firstName, lastName))

    

