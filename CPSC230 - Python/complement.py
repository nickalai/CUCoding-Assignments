# -*- coding: utf-8 -*-
"""
Created on Mon Apr  3 14:55:32 2017

@author: Nick Lai
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
            compStrand = ''
    return compStrand
    
def revComplement(DNAstrand):
    return complement(DNAstrand[::-1])
     

strand = True
DNAstrand = input("What is your DNA strand?: ")


if complement(DNAstrand) == '':
    strand = False
    
             
while strand == False:
        DNAstrand = input("Error. Not a valid strand of DNA. Please try again: ")
        if complement(DNAstrand) != '':
            strand = True
            

if strand == True:
        print("The complement of your string is:", complement(DNAstrand))
        print("The reverse complement of your string is:", revComplement(DNAstrand))

    