# -*- coding: utf-8 -*-
"""
Created on Tue Apr 11 14:44:15 2017

@author: nickl
"""

def complement(DNAstrand):
    DNAstrand = DNAstrand.upper()
    compStrand = ''
    for elem in range(0, len(DNAstrand)):
        if DNAstrand[elem] == "A":
            compStrand += "T"
        elif DNAstrand[elem] == "C":
            compStrand += "G"
        elif DNAstrand[elem] == "T":
            compStrand += "A"
        elif DNAstrand[elem] == "G":
            compStrand += "C"
        else:
            compStrand = "invalid DNA Sequence"
            break
    return compStrand
    
def revComplement(DNAstrand):
    return complement(DNAstrand[::-1])
     
strandFile = input("What is the file name?: ")
try:
    input_file = open(strandFile, "r")
    result = open("results_complement.txt", "w")
    for line in input_file:
        line = line.strip()
        print("Original:", line, file = result)
        #comp = complement(line)
        print("The complement of your string is:", complement(line), file = result)
        print("The reverse complement of your string is:", revComplement(line), file = result)
        print(file = result)
    print("Changes to the file", strandFile, "have been made.")
    input_file.close()
    result.close()

except FileNotFoundError:
    print("The file", strandFile, "does not exist.")

