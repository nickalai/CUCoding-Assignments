1.) Identifying Information
  a. Full Name: Nick Lai
  b. Student ID: 2282417
  c. Chapman email: lai137@mail.chapman.edu
  d. Course number and section: 350-02
  e. Assignment Number: 01

2.) List of source files submitted
  a. assignment1.cpp
  b. assignment1.h
  c. main.cpp
  d. DNA.txt

3.) Description of any known compile/runtime errors, or bugs.
  a. The number of 'A's are over-counted, while the rest of the nucleotide counts
     are under-counted. This in my eyes shows that it is counting characters as
     'A's that should not be counted as such. While debugging, switching which
     variable was counted first gave different results, although I am still
     unsure why. Since the count is off, the statistics are slightly off as well.

4.) References used to complete the assignment
  a. Zach Jagoda, for help on the Gaussian Distribution implementation
  b. stackoverflow.com for command line input
  c. cplusplus.com for input and output stream related help

5.) Instructions for running the assignment
  1.) Unzip the .tgz file
  2.) cd to the project folder
  3.) input "g++ *.cpp"
  4.) input "./a.exe DNA.txt"
