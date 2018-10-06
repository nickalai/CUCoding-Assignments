# -*- coding: utf-8 -*-
"""
Created on Tue Apr 18 15:10:31 2017

@author: nickl
"""

#dictionary - word count example

s = 'to be or not to be'
s_list = s.split()
print(s_list) #['to', 'be', 'or', 'not', 'to', 'be']

count_dict = {}
for word in s_list:
    if word in count_dict: #add 1 to the value , word in already in my dictionary
        count_dict[word] = count_dict[word] + 1 #count_dict[word] += 1
    else: #add word to the dictionary, first occurance
        count_dict[word] = 1
print(count_dict)