# -*- coding: utf-8 -*-
"""
Created on Tue Apr 11 15:31:42 2017

@author: nickl
"""


input_file = open("thisFile.txt", "r")
output_file = open("thatFile.txt", "w")

total = 1
for line in input_file:
    line = line.strip()
    if total % 2 == 1:
        print(line, file = output_file)
    total = total + 1
    
input_file.close()
output_file.close()