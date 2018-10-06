# -*- coding: utf-8 -*-
"""
Created on Thu Apr  6 15:07:48 2017

@author: nickl
"""

#read from a file

#file_descriptor = open(file_name, access/mode)
file1 = open("file.txt", "r") #one line at a time, open file for reading - "r" specifies access to read
for line in file1:
    print(line, end = '') #end = '', removes the carriage return
    for char in line:
        print(char)
file1.close() #closes the file

           
output_file = open("temp_file1.txt", "w") #open file for writing - "w" specifies acces to write
#if the file doesn't exist, it will be created
print("Yay First Line", file = output_file) #is always file = (whatever the file descriptror is)
print("LUL second line", file = output_file)
output_file.close()