# -*- coding: utf-8 -*-
"""
Created on Thu Feb 23 22:34:36 2017

@author: Nick Lai
"""

#Choose Your Own Adventure

import random

# variable creation & setting loop control variable
next_room = 1
# generating a random number
death_die = random.randint(1,100)
print("You suddenly awake to the sound of harsh winds ravaging groups of leaves. After you gather your bearings, you realize that you're in the middle of the forest. You don't know how you got there and it's pitch dark out. As you rustle around in the nearby fallen leaves, you find a flashlight and a note that says 'Wait for me to come back for you c:'")


while next_room != 0:
    if next_room == 1:
        print("As you look around with your flashlight, you can see a small cabin in the distance.")
        print()
        choice = input("Do you head towards the cabin? 'Y' or 'N': ")
        print()
        if choice == 'N':
            if death_die <= 25:
                print("You decided to adventure deeper into the woods. Sadly however, nobody ever heard from you again. Search teams only found the skin of your face duct taped to a canvas with the words 'I'm Free' written in your blood.")
                next_room = 0
            else:
                next_room = 2
                death_die = random.randint(1,100)
                if 5 < death_die < 10:
                    print("You sense a strange, evil aura nearby. Almost as if it's right next to you...")
                elif 10 < death_die < 20:
                    print("You heard footsteps behind you, but when you turned around, nobody was there...")
                elif 20 < death_die < 40:
                    print("You heard footsteps behind you, but when you turned around, nobody was there...")
                elif 40 < death_die < 100:
                    print("The deep silence is almost peaceful...")
        elif choice == 'Y':
            if 5 < death_die < 10:
                print("You sense a strange, evil aura nearby. Almost as if it's right next to you...")
            elif 10 < death_die < 20:
                print("You heard footsteps behind you, but when you turned around, nobody was there...")
            elif 20 < death_die < 40:
                print("You heard footsteps behind you, but when you turned around, nobody was there...")
            elif 40 < death_die < 100:
                print("The deep silence is almost peaceful...")
            next_room = 3
        else:
            print(choice, " wasn't one of the options. Try again." )



    # section for choosing 'Y' 
    elif next_room == 3:
        print("You entered the cabin. The lights are on and there's a homecooked meal on the dinner table. There's a note next to the plate that says 'You must be hungry. Eat this while you wait for me to come for you c:'. You can 'EAT' the meal or 'EXPLORE' the cabin and try to find something useful")
        print()
        choice = input("What do you do?: ")
        print()
        if choice == 'EAT':
            if death_die <= 95:
                print("You ate the meal that was on the table. You felt your body slowly start to shut down. Just as you're about to pass out, a man with a cinder block opens the cabin door. 'Oh, how lovely. You waited for me,' he said while grinning. Unable to move, the man slowly approaches you, then bashes your head in with the cinder block.")
                next_room = 0
            else:
                print("You ate the meal that was on the table. To some miracle, you felt no side effects and began to explore the cabin.")
                next_room = 5
                death_die = random.randint(1,100)
                if 5 < death_die < 10:
                    print("You sense a strange, evil aura nearby. Almost as if it's right next to you...")
                elif 10 < death_die < 20:
                    print("You heard footsteps behind you, but when you turned around, nobody was there...")
                elif 20 < death_die < 40:
                    print("You heard footsteps behind you, but when you turned around, nobody was there...")
                elif 40 < death_die < 100:
                    print("The deep silence is almost peaceful...")
        elif choice == 'EXPLORE':
            if 5 < death_die < 10:
                print("You sense a strange, evil aura nearby. Almost as if it's right next to you...")
            elif 10 < death_die < 20:
                print("You heard footsteps behind you, but when you turned around, nobody was there...")
            elif 20 < death_die < 40:
                print("You heard footsteps behind you, but when you turned around, nobody was there...")
            elif 40 < death_die < 100:
                print("The deep silence is almost peaceful...")
            next_room = 5
        else:
            print(choice, " wasn't one of the options. Try again." )
            
   
    # section for choosing 'EXPLORE' or for surviving 'EAT'
    elif next_room == 5:
        print("As you are exploring the cabin, all you can find is a tattered-up journal. You can either 'READ' it or 'LEAVE' the cabin.")
        print()
        choice = input("What do you do?: ")
        print()
        if choice == 'READ':
            if death_die <= 50:
                print("You begin to read the journal. As you quickly scan through all of the pages, you quickly realize each page is about a unique (and tested) method on how to kill a person. Horrified, you back away from the journal and step into a deep pit that was beneath the rug on the floor, and fall to your death.")
                next_room = 0
            else:
                print("You begin to read the journal. As you quickly scan through all of the pages, you quickly realize each page is about a unique (and tested) method on how to kill a person. You hear the door you entered the cabin from slowly creek open, and you quietly make your way out the back door.")
                next_room = 7
                death_die = random.randint(1,100)
                if 5 < death_die < 10:
                    print("You sense a strange, evil aura nearby. Almost as if it's right next to you...")
                elif 10 < death_die < 20:
                    print("You heard footsteps behind you, but when you turned around, nobody was there...")
                elif 20 < death_die < 40:
                    print("You heard footsteps behind you, but when you turned around, nobody was there...")
                elif 40 < death_die < 100:
                    print("The deep silence is almost peaceful...")
        elif choice == 'LEAVE':
            if 5 < death_die < 10:
                print("You sense a strange, evil aura nearby. Almost as if it's right next to you...")
            elif 10 < death_die < 20:
                print("You heard footsteps behind you, but when you turned around, nobody was there...")
            elif 20 < death_die < 40:
                print("You heard footsteps behind you, but when you turned around, nobody was there...")
            elif 40 < death_die < 100:
                print("The deep silence is almost peaceful...")
            next_room = 7
        else:
            print(choice, " wasn't one of the options. Try again." )
    
   
    # section for choosing 'LEAVE' or surviving 'READ'
    elif next_room == 7:
        print("You quietly made your way outside the cabin. In the distance, you can see an old pickup truck. You head towards it and try to open the door, but it's locked. As you look around in hopes of finding a key, you spot it with your flashlight hanging by a string from the top branch of a tree. You can either 'TRY' to get it or 'GIVE UP' on the truck and keep going on foot.")
        print()
        choice = input("What do you do?: ")
        print()
        if choice == 'TRY':
            if death_die <= 40:
                print("You attempt to climb the tree to grab the key. Halfway up the tree you notice there was a man in a ghillie suit armed with a tire iron perched on one of the branches. He grins at you and launches himself towards you screaming 'YOU SHOULD HAVE WAITED FOR ME!!!' and hits your hands with the tire iron. You lose your grip and fall from the tree on your head, breaking your neck.")
                next_room = 0
            else:
                print("You attempt to climb the tree to grab the key. You manage to grab the key and rip it from the string holding it to the branch. You unlock the car and begin drive quickly and follow the tracks made by the owner of the truck.")
                next_room = 8
                death_die = random.randint(1,100)
                print("You sense a strange, evil aura nearby. Almost as if it's right next to you...")
        elif choice == 'GIVE UP':
            if 5 < death_die < 10:
                print("You sense a strange, evil aura nearby. Almost as if it's right next to you...")
            elif 10 < death_die < 20:
                print("You heard footsteps behind you, but when you turned around, nobody was there...")
            elif 20 < death_die < 40:
                print("You heard footsteps behind you, but when you turned around, nobody was there...")
            elif 40 < death_die < 100:
                print("The deep silence is almost peaceful...")
            next_room = 2
        else:
            print(choice, " wasn't one of the options. Try again." )
    
   
    # section for surviving 'TRY'        
    elif next_room == 8:
        print("After a few minutes, you reach the main road. You begin to relax as you recognize the street that you ended up on. However, you carelessly didn't check the back seat, and a man slowly rises from the floor of the back seat and smashes your hand with a hammer. As you scream in pain, he pulls out a centipede and places it in your mouth and force-closes your mouth. Your car swerves off the road and you crash into a tree. You fly out the front windshield and splatter your head on a tree.")
        next_room = 0
        
   
    # section for surviving 'N' or choosing 'GIVE UP'
    elif next_room == 2:
        print("You decided to adventure deeper into the woods. You see a very deep hole. You can't see the bottom. You can 'JUMP IN' or 'WALK PAST' it.")
        print()
        choice = input("What do you do?: ")
        if choice == 'JUMP IN':
            if death_die > 0:
                print("You jumped into what seemed like a bottomless pit. After falling for what seemed like hours, you were impaled by a sharp rock, which triggered a pressure-sensitive pad that opened a door which revealed the silhouette of the killer. 'I told you to wait for me...', he said in an excited voice.")
                next_room = 0
        elif choice == 'WALK PAST':
            if 5 < death_die < 10:
                    print("You sense a strange, evil aura nearby. Almost as if it's right next to you...")
            elif 10 < death_die < 20:
                    print("You heard footsteps behind you, but when you turned around, nobody was there...")
            elif 20 < death_die < 40:
                    print("You heard footsteps behind you, but when you turned around, nobody was there...")
            elif 40 < death_die < 100:
                    print("The deep silence is almost peaceful...")
            next_room = 4
        else:
            print(choice, " wasn't one of the options. Try again." ) 
        
        
        
    # section for choosing 'WALK PAST'      
    elif next_room == 4:
        print("You continued onwards, ignore the hole that seems to have no bottom. You stumble upon a wrapped present on the floor. You can either 'OPEN IT' or 'IGNORE IT'")
        print()
        choice = input("What do you do?: ")
        print()
        if choice == 'OPEN IT':
            if death_die <= 75:
                print("You open the present and see a timer ticking down from 5. You watch in horror as the numers count down. The package explodes in your face, ripping the skin off of the front of your body. You slowly crumble to your knees, the last thing you see is a large, burly man charging at you with a sledgehammer screaming 'I'M NOT DONE WITH YOU YET!'")
                next_room = 0
            else:
                print("You open the present and see a timer ticking down from 5. You watch in horror as the numers count down. The counter reaches 0, but then nothing happens. Confused, you put the package down and continue onwards.")
                next_room = 6
                death_die = random.randint(1,100)
                if 5 < death_die < 10:
                    print("You sense a strange, evil aura nearby. Almost as if it's right next to you...")
                elif 10 < death_die < 20:
                    print("You heard footsteps behind you, but when you turned around, nobody was there...")
                elif 20 < death_die < 40:
                    print("You heard footsteps behind you, but when you turned around, nobody was there...")
                elif 40 < death_die < 100:
                    print("The deep silence is almost peaceful...")
        elif choice == 'IGNORE IT':
            if 5 < death_die < 10:
                print("You sense a strange, evil aura nearby. Almost as if it's right next to you...")
            elif 10 < death_die < 20:
                print("You heard footsteps behind you, but when you turned around, nobody was there...")
            elif 20 < death_die < 40:
                print("You heard footsteps behind you, but when you turned around, nobody was there...")
            elif 40 < death_die < 100:
                print("The deep silence is almost peaceful...")
            next_room = 6
        else:
            print(choice, " wasn't one of the options. Try again." )
            
            
            
    # section for surviving 'OPEN IT' or choosing 'IGNORE IT'
    elif next_room == 6:
        print("While wandering aimlessly in the forrest and began to lose hope, you accidentally stepped on a pressure pad. Alarm sounds began to echo throughout the forest, and a spotlight pointed directly at you. You can either 'HIDE' or stay 'FIGHT BACK' against your assailant.")
        print()
        choice = input("What do you do?: ")
        print()
        if choice == 'HIDE':
            print("You attempted to try to hide. You climbed a tree and perched yourself on a high branch within the leaves. All you hear is a distant gunshot, then a sudden warmth in your stomach. You look down and notice the massive hole in your chest. You fall out of the tree and notice that you are surround by many people, each armed with various blunt weapons. 'So glad you could join us,' they all said together with a grin. ")
            next_room = 0
        elif choice == 'FIGHT BACK':
            print("You stay out in the open and wait for the person who's been toying with you. Slowly from the darkness, a man comes into view, armed with a baseball bat wrapped in barbed wire. You pick up a rock with the intention to fight, but you slowly realize that more figures are appearing from the darkness. Eventually, you are surround by many people, each armed with various blunt weapons. 'So glad you could join us,' they all said together with a grin.")
            next_room = 0
        else:
            print(choice, " wasn't one of the options. Try again." )
        
            
	
