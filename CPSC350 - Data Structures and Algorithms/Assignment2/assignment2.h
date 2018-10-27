/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 2 - Game of Life
*/
#include <iostream>
#include <fstream>
#include <cstring>

using namespace std;

class Game
{
  private:
    string outStyle; //keeps track of how output will happen
    int genCount; //keeps track of each generation that passes
    string outString; //holds strings that are outputted
    string outputFile; //name of file to be outputted to

  public:
    Game(); //constructor
    ~Game(); //destructor

    void printBoard(string outStyle, int genCount, char**& board, int length, int width); //prints out the board to the console if the output style is either Pause or Enter

    //gamemodes
    int classicMode(int length, int width, char**& board);
    int mirrorMode(int length, int width, char**& board);
    int donutMode(int length, int width, char**& board);

    void selectMode(int& length, int& width, char**& board); //used to pick a gamemode
    
    void createBoardFromFile(string inputFile); //creates a board based on file input
    void createRandomBoard(int& length, int& width); //creates a random board given user input dimensions

    void selectSettings(); //used in main method to choose settings
};
