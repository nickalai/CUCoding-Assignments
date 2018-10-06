# -*- coding: utf-8 -*-
"""
Created on Tue Mar  7 14:44:51 2017

@author: Nick Lai
"""

function = input("Would you like to construct (c) or deconstruct (d) an alternade?: ")


if function == 'c':
    cword1 = input("Enter the first word: ")
    while cword1.isalpha() == False:
        cword1 = input("The first word is not a word. Please try again: ")
    cword2 = input("Enter the second word: ")
    while cword2.isalpha() == False:
        cword2 = input("The second word is not a word. Please try again: ")
    newWord = ''
    for i in range(len(cword1)):
        newWord += cword1[i]
        if i < len(cword2):
            newWord += cword2[i]
    print("The alternade of the words you inputted is:", newWord)
    
    
elif function == 'd':
    dword = input("Enter an alternade: ")
    while dword.isalpha() == False:
        dword = input("That is not a word. Please try again: ")
    else:
        xd = dword[0:len(dword):2]
        yd = dword[1:len(dword):2]
        print("The words that make up the alternade you inputted are:", xd,"and", yd)
        

        
        
    