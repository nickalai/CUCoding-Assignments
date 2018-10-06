# -*- coding: utf-8 -*-
"""
Created on Thu Apr 27 14:33:21 2017

@author: Nick Lai
"""
def makeDict(mappingFile):
    encryptionFile = (mappingFile, "r")
    createDict = {}
    revDict = {}
    for line in encryptionFile:
        key, value = line.split()
        createDict[key] = value
    for line in encryptionFile:
        value, key = line.split()
        revDict[key] = value
               
    encryptionFile.close()
    return createDict, revDict

def encrypt(line, createDict):
    line_str = ''
    for char in input_file:
        if char in createDict:
            line_str += createDict[char]
        else:
            line_str += char
    return line_str


#createDict, revDict = makeDict(mappingFile)

while True:
    try: 
        input_file = open(input("Enter the name of the file you wish to encrypt: "), "r")
        encryption_code = open(input("Enter the name of the encryption code file: "), "r")
    except FileNotFoundError:
        print("Error. File not found.")
        continue
    else:
        break

createDict, revDict = makeDict("replace.txt")

encryptedText = open("encrypt.txt", "w")
decryptedText = open("decrypt.txt", "w")

for line in input_file:
    print(encrypt(line, createDict), file = encryptedText, end = '')
    
encryptedText.close()

while True:
    try:
        encryptedText = open(input("Enter the name of the file you wish to decrypt: "), "r")
    except FileNotFoundError:
        print("Error. File not found.")
        continue
    else:
        break

for line in encryptedText:
    print(encrypt(revDict, line), file = decryptedText, end = '')
    
decryptedText.close()
input_file.close()
encryption_code.close()