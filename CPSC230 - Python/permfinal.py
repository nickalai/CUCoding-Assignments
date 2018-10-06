# -*- coding: utf-8 -*-
"""
Created on Sat Mar 25 14:02:33 2017

@author: nickl
"""

#def make_even(n):
#    return 2 * n

#print(make_even(2))
#print(make_even('2'))
#n = 3
#print(make_even(n))
#print(1 + make_even(3))

#try:
#    print(make_even(2))
#except TypeError:
#    print("Invalid input.")


def number_type(a_int):
    if a_int < 0:
        return "negative"
    if a_int > 0:
        return "positive"
    else:
        return "zero"
    
print(number_type(19))