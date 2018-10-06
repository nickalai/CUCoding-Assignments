# -*- coding: utf-8 -*-
"""
Created on Thu Apr 13 15:05:10 2017

@author: nickl
"""

#exception handling: try-except 2

#read a particular line from a file - user provides both the line number and the file name

file1 = input("Open what file?: ")
file_line = input("Which line?(integer): ")

try:
    input_file = open(file1, "r") #try to open the inputted file name - possible error 
    find_line = int(file_line) #try to convert line input to an int - possible error
    line_count = 1
    for line in input_file:
        if line_count == find_line:
            print("Line", file_line, "of file", file1, "is", line)
            break
        line_count += 1
        
    else:
        print("Line", file_line, "of file", file1, "does not exist.")
    input_file.close()

except FileNotFoundError:
    print("The file", file1, "does not exist.")
except ValueError:
    print("Line", file_line, "is not a legal line number.")
    
print("End of program.")