# calculates the circumference and area of a circle given its radius
"""
Created on Tue Feb  7 14:38:54 2017

@author: nickl
"""

import math
radius_str = input("Enter the radius of your circle: ")
radius_int = int(radius_str)

circumference = 2 * math.pi * radius_int
area = math.pi * radius_int**2

print("The circumference of the circle is: ", circumference)
print("The area of the circle is: ", area)


# to have multiple, write as print("The circumference is: ", circumference, "and the area is: ", area)
