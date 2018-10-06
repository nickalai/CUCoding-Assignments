# -*- coding: utf-8 -*-
"""
Created on Tue Mar 14 15:00:48 2017

@author: nickl
"""

a_list = [1, 2, 'a', 3.14159]
b_list = list('hello')
s_list = [['Name', 'Age', 'GPA'], ['Bill', 25, 3.55], ['Rich', 26, 4.00]]
my_list = [1, 12, 5, 8]
row = s_list[1]
column = row[2]
my_list.append([4, 5, 6]) #adds the actual list to list
my_list.extend([4, 5, 6]) #adds elements of list to list
my_list.pop(4)

#assignment statement
a_list[0] = True
print(a_list)
print(b_list)
print(s_list[1])
print(row)
print(column)

#slicing works the same way
print(a_list[1::2])

for elem in a_list:
    print(elem)
    
print(a_list + b_list)
print(b_list * 3)
print(my_list)