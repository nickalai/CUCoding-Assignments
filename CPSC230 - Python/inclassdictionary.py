# -*- coding: utf-8 -*-
"""
Created on Tue Apr 18 15:22:33 2017

@author: nickl
"""

int_input = int(input("Please enter an integer: "))
ints = [int(i) for i in str(int_input)]

wordnum_dict = {'1':'one', '2':'two', '3':'three', '4':'four', '5':'five', '6':'six', '7':'seven', '8':'eight', '9':'nine', '0':'zero'}
empty_dict = {}

for num in ints:
    if num in wordnum_dict:
        empty_dict = empty_dict + wordnum_dict.val(num)
    else:
        print("nop")
print(empty_dict)



