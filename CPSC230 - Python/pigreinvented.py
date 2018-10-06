# -*- coding: utf-8 -*-
"""
Created on Sat Mar  4 20:49:26 2017

@author: nickl
"""

import random

#shows which player's turn it is
turn = 1
#holds scores for the player and the CPU
CPUtotal = 0
score1 = 0
score2 = 0
#acts as the 6-sided die
points = random.randint(1,6)

#limits the program to only continue if the scores are below 100
while score1 < 100 and score2 < 100:
    #starts if it is the player's turn
    if turn == 1 and score1 < 100:
        points = random.randint(1,6)
        score1 = score1 + points
        print("You rolled a", points)
        #ends turn if player rolls a 1
        if points == 1:
            score1 = score1 - 1
            print("You rolled a 1. Your turn is over. Your current score is:", score1)
            #changes it to the CPU's turn
            turn = 0
        #prompts user to roll again or end turn if anything other than 1 is rolled
        while points > 1 and score1 < 100:
            score1 = score1 + points
            choice = input("Would you like to roll again (r) or hold (h)?: ")
            if choice == 'r':
                print("You rolled a", points)
                points = random.randint(1,6)
                print("Your current score is:", score1)
            elif choice == 'h':
                print("You ended your turn. Your current score is:", score1)
                #changes it to the other CPU's turn
                turn = 0
            #fail checks the input    
            else:
                choice = input("That wasn't a valid response. Retry: ")
    #starts if it is the CPU's turn    
    if turn == 0:
        points = random.randint(1,6)
        #ends the CPU's turn if it rolled a 1
        if points == 1:
            print("CPU rolled a 1. CPU's turn is over. CPU's current score is:", score2)
            #sets it to the player's turn
            turn = 1
        #continuously rolls for the CPU until it rolls a 1 
        while points > 1 and CPUtotal < 20:
            CPUtotal = CPUtotal + points
            score2 = score2 + CPUtotal
            print("CPU rolled a", points)
            points = random.randint(1,6)
            print("CPU's current score is:", score2)

#triggers when the score cap is met            
if score1 >= 100:
    print("Player wins! Overall score:", score1, "to", score2)
    
elif score2 >= 100:
    print("CPU wins! Overall score:", score2, "to", score1)