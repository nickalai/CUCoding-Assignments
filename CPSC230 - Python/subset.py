# -*- coding: utf-8 -*-
"""
Created on Tue May 16 22:19:09 2017

@author: nickl
"""

def subset(r,s):
    isSubset = True
    for elem in r:
        if not elem in s:
            isSubset = False
            break
    return isSubset

r = [1,2,3,4,5]
s = [3,2,4,5,1]

print(subset(r,s))