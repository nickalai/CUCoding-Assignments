# -*- coding: utf-8 -*-
"""
Created on Thu Mar 30 14:46:16 2017

@author: nickl
"""

def length(word):
    number = 0
    for elem in word:
        number += 1
    return number

def total_tax(price, rate):
    tax = price * rate/100
    return tax

def total_price(price, rate):
    tax = total_tax(price, rate)
    total =  price + tax
    return total

p = float(input("What is the price of the item?: "))
t = float(input("What is the sales tax percentage?: "))
total = total_price(p, t)
print(total)


word = input("Input a word: ")
print("There are", length(word),"of letters in the word '", word,"'.") 