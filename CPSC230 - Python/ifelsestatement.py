# -*- coding: utf-8 -*-
"""
Created on Tue Feb 14 15:08:33 2017

@author: nick lai
"""

temp = int(input("Input the temperature outside: "))

if 80 < temp <= 100:
    print("It's hot as balls, wear shorts.")
elif 60 < temp <= 80:
    print("Wear a t-shirt ya dingo.")
elif 40 < temp <= 60:
    print("It's colder than my heart out there. You need a jacket")
else:
    print("Don't go outside you'll die.")
    
