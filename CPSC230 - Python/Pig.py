# -*- coding: utf-8 -*-
"""
Created on Thu Mar  2 15:09:24 2017

@author: Nick Lai
"""

import random

#shows which player's turn it is
turn = 0
#holds scores for the player and the CPU
score1 = 0
total1 = 0
score2 = 0
total2 = 0
#acts as the 6-sided die
points = random.randint(1,6)

#limits the program to only continue if the total scores are below 100
while total1 < 100 and total2 < 100:
    #starts if it is the player's turn
    if turn == 0 and score1 < 100:
        points = random.randint(1,6)
        #ends turn if player rolls a 1
        if points == 1:
            print("You rolled a 1. Your turn is over. Your current total score is:", total1)
            score1 = 0
            #changes it to the CPU's turn
            turn = 1
        #prompts user to roll again or end turn if anything other than 1 is rolled.
        while points > 1 and score1 < 100:
            print("You rolled a", points)
            score1 = score1 + points
            print("Your current score is:", score1)
            choice = input("Would you like to roll again (r) or hold (h)?: ")
            if choice == 'r':
                points = random.randint(1,6)
            elif choice == 'h':
                total1 = total1 + score1
                print("You ended your turn. Your current total score is:", total1)
                score1 = 0
                turn = 1
                break
            #fail checks the input
            else:
                choice = input("That wasn't a valid option. Retry: ")
    #starts if it is the CPU's turn    
    if turn == 1:
        points = random.randint(1,6)
        #ends the CPU's turn if it rolled a 1
        if points == 1:
            print("CPU rolled a 1. CPU's turn is over. CPU's current score is:", total2)
            #sets it to the player's turn
            turn = 0
        #continuously rolls for the CPU until it rolls a 1 or hits 20 points, then the CPU holds
        while points > 1 and score2 < 20:
            score2 = score2 + points
            print("CPU rolled a", points)
            if score2 >= 20:
                total2 = total2 + score2
                print("CPU's ended their turn. CPU's current score is:", total2)
                turn = 0
                break
            points = random.randint(1,6)
            print("CPU's current score is:", score2)
       

#triggers when the score cap is met            
if total1 >= 100 or score1 >= 100:
    print("Player wins! Overall score:", total1, "to", total2)
    
elif total2 >= 100 or score2 >= 100:
    print("CPU wins! Overall score:", total2, "to", total1)
        
                    
 
    
    
    
    
    
    
    
    
    
    