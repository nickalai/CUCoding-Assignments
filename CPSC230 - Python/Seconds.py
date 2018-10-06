# -*- coding: utf-8 -*-
"""
Created on Thu Feb  9 15:15:01 2017

@author: Nick Lai
"""

#prompts user for a number between 1 and 86400
totalTime = int(input("Enter a number of between 1 and 86400: "))

#calculates the number into hours, minutes, and seconds
hours = totalTime // 3600
minutes = (totalTime % 3600) // 60
seconds = (totalTime %3600 )% 60 #totalTime - (hours * 3600) - (minutes * 60) works as well, more complicated

#prints results
print("The time is", hours, "hour(s),", minutes, "minute(s), and", seconds, "second(s).")