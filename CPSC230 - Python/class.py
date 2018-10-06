# -*- coding: utf-8 -*-
"""
Created on Thu May  4 15:03:07 2017

@author: nickl
"""

class Employee:
    
    def __init__(self, first, last, pay):
        self.first = first
        self.last = last
        self.pay = pay
        self.email = first + '.' + last + '@company.com'
        
    def fullname(self):
        return '{} {}'.format(self.first, self.last)

emp_1 = Employee('Corey', 'Schafer', 50000)
emp_2 = Employee('Test', 'User', 60000)

#print(emp_1.email)
#print(emp_2.email)



#these 2 lines do the same thing
print(emp_1.fullname())
print(Employee.fullname(emp_1))