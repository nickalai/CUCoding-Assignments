/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 2 - Game of Life
*/
#include <iostream>
#include "assignment2.h"
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <cmath>
#include <ctime>
#include <unistd.h>
#include <sstream>

using namespace std;

Game::Game() //default constructor
{
  string outStyle = "";
  int genCount;
  string outString = "";
  string outputFile = "";
}

Game::~Game() //destrucor
{
  cout << "object deleted" << endl;
}

//prints out the board to the console if the output style is either Pause or Enter
void Game::printBoard(string outStyle, int genCount, char**& board, int length, int width)
{
  bool enter = false;

  if((outStyle == "Pause") || (outStyle == "pause"))
  {
    sleep(1);
    cout << "Generation: " << genCount << "\n";

    for(int i = 0; i < length; ++i)
    {
      for(int j = 0; j < width; ++j)
      {
        cout << board[i][j];
      }
      cout << "\n";
    }
  }

  else if((outStyle == "Enter") || (outStyle == "enter"))
  {
    cout << "Press the enter key to continue: " << endl;
    cin.get();

    if(cin.get())
    {
      enter = true;
    }

    if(enter = true)
    {
      cout << "Generation: " << genCount << endl;

      for(int i = 0; i < length; ++i)
      {
        for(int j = 0; j < width; ++j)
        {
          cout << board[i][j];
        }
        cout << "\n";
      }
    }
  }
}

//Code for the Classic mode of Game of Life
int Game::classicMode(int length, int width, char**& board)
{
	int count = 0;
	genCount = 1;
	bool stable = false;

  char** nextGen = new char*[length];

  for (int i = 0; i < length; ++i)
  {
    nextGen[i] = new char[width];
  }
  //logic for counting cells
  while(stable == false)
  {
    for(int i = 0; i < length; ++i)
    {
			for(int j = 0; j < width; ++j)
      {
        count = 0;
			  if (i == 0 && j == 0)
        {
          if (board[i+1][j] == 'X')
            count++;
	        if (board[i][j+1] == 'X')
            count++;
    	    if (board[i+1][j+1] == 'X')
            count++;
				}

				else if (i == 0 && j == (width - 1))
        {
          if (board[i+1][j] == 'X')
            count++;
          if (board[i][j-1] == 'X')
            count++;
          if (board[i+1][j-1] == 'X')
            count++;
				}

				else if (i == (length - 1 ) && j == (width - 1))
        {
          if (board[i-1][j] == 'X')
            count++;
          if (board[i][j-1] == 'X')
            count++;
          if (board[i-1][j-1] == 'X')
            count++;
				}

				else if (i == (length - 1) && j == 0)
        {
          if (board[i-1][j] == 'X')
            count++;
          if (board[i][j+1] == 'X')
            count++;
          if (board[i-1][j+1] == 'X')
            count++;
        }

        else if (i == 0)
        {
          if (board[i+1][j] == 'X')
            count++;
	        if (board[i][j+1] == 'X')
            count++;
    	    if (board[i+1][j+1] == 'X')
            count++;
        	if (board[i][j-1] == 'X')
            count++;
	        if (board[i+1][j-1] == 'X')
            count++;
    	  }

				else if (j == 0)
        {
          if (board[i-1][j] == 'X')
            count++;
          if (board[i+1][j] == 'X')
            count++;
	        if (board[i][j+1] == 'X')
            count++;
    	    if (board[i+1][j+1] == 'X')
            count++;
        	if (board[i-1][j+1] == 'X')
            count++;
				}

        else if (i == (length - 1))
        {
          if (board[i-1][j] == 'X')
            count++;
        	if (board[i][j+1] == 'X')
            count++;
          if (board[i-1][j+1] == 'X')
            count++;
	        if (board[i][j-1] == 'X')
            count++;
    	    if (board[i-1][j-1] == 'X')
            count++;
				}

				else if (j == (width - 1))
        {
          if (board[i-1][j] == 'X')
            count++;
	        if (board[i+1][j] == 'X')
            count++;
    	    if (board[i][j-1] == 'X')
            count++;
        	if (board[i+1][j-1] == 'X')
            count++;
          if (board[i-1][j-1] == 'X')
            count++;
				}

				else
        {
          if(board[i+1][j] == 'X')
            count++;
					if(board[i][j+1] == 'X')
            count++;
					if(board[i+1][j+1] == 'X')
            count++;
					if(board[i][j-1] =='X')
            count++;
					if(board[i-1][j] == 'X')
            count++;
					if(board[i-1][j-1] == 'X')
            count++;
					if(board[i+1][j-1] =='X')
            count++;
					if(board[i-1][j+1] == 'X')
            count++;
        }

        if (count < 2) //if a space has less than 2 neighbors, the cell dies
        {
          nextGen[i][j] = '-';
        }
        else if (count == 2) //if a space has exactly 2 neighbors, nothing changes
        {
	        nextGen[i][j] = board[i][j];
        }
        else if (count == 3) //if a space has 3 neighbors, a new cell is created
        {
         nextGen[i][j] = 'X';
    		}

	      else if (count > 3) //if a space has more than 3 neighbors, cells die due to overpopulation
        {
          nextGen[i][j] = '-';
        }
	     }
    	}
      //checks to see if the board is stablizied
      int checker = 0;

      for (int i = 0; i <length; ++i)
      {
       	for (int j = 0; j < width; ++j)
        {
          //adds one to checker if the specific locations are equal
	       	if (nextGen[i][j] == board[i][j])
          {
	       	   checker++;
	        }
          //if the specific location is not equal, sets stable to false
          else
          {
            stable = false;
         	}
       	}
    	}
      //if every spot on the previous and the current generation are the same, set stable to true
    	if (checker == (length*width))
      {
    		stable = true;
    		cout << "\nThis world is stable. There will be no further changes." << endl;
    	}
      //Continues to store each generation's board as long as the current generation is not stable
    	if (stable == false)
      {
    	  std::stringstream sstm;
    		sstm << "Generation: " << genCount << "\n";
        outString += sstm.str();

        if (genCount == 1)
        {
          for(int i = 0; i < length; ++i)
          {
      			for(int j = 0; j < width; ++j)
            {
      				std::stringstream sstm;
   						sstm << board[i][j];
   						outString += sstm.str();
   					}
   					std::stringstream sstm;
   					sstm << "\n";
   					outString += sstm.str();
  				}

          //Prints to console based on which option the user has chosen
          printBoard(outStyle, genCount, board, length, width);
          //stores the current board into a different board (nextGen)
          for(int i = 0; i < length; ++i)
          {
      			for(int j = 0; j < width; ++j)
            {
      			  board[i][j] = nextGen[i][j];
      			}
      		}
        }
        else //after the first generation
        {
          for(int i = 0; i < length; ++i)
          {
      			for(int j = 0; j < width; ++j)
            {
      				board[i][j] = nextGen[i][j];
      				std::stringstream sstm;
      				sstm << board[i][j];
      				outString += sstm.str();
      			}
      			std::stringstream sstm;
   					sstm << "\n";
   					outString += sstm.str();
      		}
      		printBoard(outStyle, genCount, board, length, width);
      	}
    	}
    	genCount++;
    }
    //If there is an output file, then print to the file
    if(outputFile != "")
    {
    	ofstream output;
    	output.open(outputFile.c_str());
    	output << outString << "\n";
    	output.close();
	  }
    return 0;
}

//Code for the Mirror mode of Game of Life
int Game::mirrorMode(int length, int width, char**& board)
{
	int count = 0;
	genCount = 1;
	bool stable = false;

  char** nextGen = new char*[length];

  for (int i = 0; i < length; ++i)
  {
    nextGen[i] = new char[width];
  }
  //logic for counting cells
  while(stable == false)
  {
    for(int i = 0; i < length; ++i)
    {
			for(int j = 0; j < width; ++j)
      {
        count = 0;
			  if (i == 0 && j == 0)
        {
					if(board[i+1][j] == 'X')
            count+=2;
					if(board[i][j+1] == 'X')
            count+=2;
					if(board[i+1][j+1] == 'X')
            count++;
					if(board[i][j] == 'X')
            count+=3;
				}

				else if (i == 0 && j == (width - 1))
        {
					if(board[i+1][j] == 'X')
            count+=2;
					if(board[i][j-1] == 'X')
            count+=2;
					if(board[i+1][j-1] == 'X')
            count++;
					if(board[i][j] == 'X')
            count+=3;
				}

				else if (i == (length - 1 ) && j == (width - 1))
        {
					if(board[i-1][j] == 'X')
            count+=2;
					if(board[i][j-1] == 'X')
            count+=2;
					if(board[i-1][j-1] == 'X')
            count++;
					if(board[i][j] == 'X')
            count+=3;
				}

				else if (i == (length - 1) && j == 0)
        {
					if(board[i-1][j] == 'X')
            count+=2;
					if(board[i][j+1] == 'X')
            count+=2;
					if(board[i-1][j+1] == 'X')
            count++;
					if(board[i][j] == 'X')
            count+=3;
        }

        else if (i == 0)
        {
					if(board[i+1][j] == 'X')
            count++;
					if(board[i][j+1] == 'X')
            count+=2;
					if(board[i+1][j+1] == 'X')
            count++;
					if(board[i][j-1] =='X')
            count+=2;
					if(board[i+1][j-1] == 'X')
            count++;
					if(board[i][j] == 'X')
            count++;
    	  }

				else if (j == 0)
        {
					if(board[i-1][j] == 'X')
            count+=2;
					if(board[i+1][j] == 'X')
            count+=2;
					if(board[i][j+1] == 'X')
            count++;
					if(board[i+1][j+1] == 'X')
            count++;
					if(board[i-1][j+1] == 'X')
            count++;
					if(board[i][j] == 'X')
            count++;
				}

        else if (i == (length - 1))
        {
					if(board[i-1][j] == 'X')
            count++;
					if(board[i][j+1] == 'X')
            count+=2;
					if(board[i-1][j+1] == 'X')
            count++;
					if(board[i][j-1] =='X')
            count+=2;
					if(board[i-1][j-1] == 'X')
            count++;
					if(board[i][j] == 'X')
            count++;
				}

				else if (j == (width - 1))
        {
					if(board[i-1][j] == 'X')
            count+=2;
					if(board[i+1][j] == 'X')
            count+=2;
					if(board[i][j-1] == 'X')
            count++;
					if(board[i+1][j-1] == 'X')
            count++;
					if(board[i-1][j-1] == 'X')
            count++;
					if(board[i][j] == 'X')
            count++;
				}

				else
        {
					if(board[i+1][j] == 'X')
            count++;
					if(board[i][j+1] == 'X')
            count++;
					if(board[i+1][j+1] == 'X')
            count++;
					if(board[i][j-1] =='X')
            count++;
					if(board[i-1][j] == 'X')
            count++;
					if(board[i-1][j-1] == 'X')
            count++;
					if(board[i+1][j-1] =='X')
            count++;
					if(board[i-1][j+1] == 'X')
            count++;
        }

        if (count < 2) //if a space has less than 2 neighbors, the cell dies
        {
          nextGen[i][j] = '-';
        }
        else if (count == 2) //if a space has exactly 2 neighbors, nothing changes
        {
          nextGen[i][j] = board[i][j];
        }
        else if (count == 3) //if a space has 3 neighbors, a new cell is created
        {
         nextGen[i][j] = 'X';
        }

        else if (count > 3) //if a space has more than 3 neighbors, cells die due to overpopulation
        {
          nextGen[i][j] = '-';
        }
       }
      }
      //checks to see if the board is stablizied
      int checker = 0;

      for (int i = 0; i <length; ++i)
      {
        for (int j = 0; j < width; ++j)
        {
          //adds one to checker if the specific locations are equal
          if (nextGen[i][j] == board[i][j])
          {
             checker++;
          }
          //if the specific location is not equal, sets stable to false
          else
          {
            stable = false;
          }
        }
      }
      //if every spot on the previous and the current generation are the same, set stable to true
      if (checker == (length*width))
      {
        stable = true;
        cout << "\nThis world is stable. There will be no further changes." << endl;
      }
      //Continues to store each generation's board as long as the current generation is not stable
      if (stable == false)
      {
        std::stringstream sstm;
        sstm << "Generation: " << genCount << "\n";
        outString += sstm.str();

        if (genCount == 1)
        {
          for(int i = 0; i < length; ++i)
          {
            for(int j = 0; j < width; ++j)
            {
              std::stringstream sstm;
              sstm << board[i][j];
              outString += sstm.str();
            }
            std::stringstream sstm;
            sstm << "\n";
            outString += sstm.str();
          }

          //Prints to console based on which option the user has chosen
          printBoard(outStyle, genCount, board, length, width);
          //stores the current board into a different board (nextGen)
          for(int i = 0; i < length; ++i)
          {
            for(int j = 0; j < width; ++j)
            {
              board[i][j] = nextGen[i][j];
            }
          }
        }
        else //after the first generation
        {
          for(int i = 0; i < length; ++i)
          {
            for(int j = 0; j < width; ++j)
            {
              board[i][j] = nextGen[i][j];
              std::stringstream sstm;
              sstm << board[i][j];
              outString += sstm.str();
            }
            std::stringstream sstm;
            sstm << "\n";
            outString += sstm.str();
          }
          printBoard(outStyle, genCount, board, length, width);
        }
      }
      genCount++;
    }
    //If there is an output file, then print to the file
    if(outputFile != "")
    {
      ofstream output;
      output.open(outputFile.c_str());
      output << outString << "\n";
      output.close();
    }
    return 0;
}

//Code for the Donut mode of Game of Life
int Game::donutMode(int length, int width, char**& board)
{
	int count = 0;
	genCount = 1;
	bool stable = false;

  char** nextGen = new char*[length];

  for (int i = 0; i < length; ++i)
  {
    nextGen[i] = new char[width];
  }
  //logic for counting cells
  while(stable == false)
  {
    for(int i = 0; i < length; ++i)
    {
			for(int j = 0; j < width; ++j)
      {
        count = 0;
			  if (i == 0 && j == 0)
        {
          if(board[i+1][j] == 'X')
            count++;
					if(board[i][j+1] == 'X')
            count++;
					if(board[i+1][j+1] == 'X')
            count++;
					if(board[length-1][j] == 'X')
            count++; 
					if(board[length-1][j+1] == 'X')
            count++;
					if(board[length-1][width-1] == 'X')
            count++;
					if(board[i][width-1] == 'X')
            count++;
					if(board[i+1][width-1] == 'X')
            count++;
				}

				else if (i == 0 && j == (width - 1))
        {
          if(board[i+1][j] == 'X')
            count++;
					if(board[i][j-1] == 'X')
            count++;
					if(board[i+1][j-1] == 'X')
            count++;
					if(board[length-1][j] == 'X')
            count++;
					if(board[length-1][j-1] == 'X')
            count++;
					if(board[length-1][0] == 'X')
            count++;
					if(board[i][0] == 'X')
            count++;
					if(board[i+1][0] == 'X')
            count++;
				}

				else if (i == (length - 1 ) && j == (width - 1))
        {
          if(board[i-1][j] == 'X')
            count++;
					if(board[i][j-1] == 'X')
            count++;
					if(board[i-1][j-1] == 'X')
            count++;
					if(board[0][j-1] == 'X')
            count++;
					if(board[0][j] == 'X')
            count++;
					if(board[0][0] == 'X')
            count++;
					if(board[i][0] == 'X')
            count++;
					if(board[i-1][0] == 'X')
            count++;
				}

				else if (i == (length - 1) && j == 0)
        {
          if(board[i-1][j] == 'X')
            count++;
					if(board[i][j+1] == 'X')
            count++;
					if(board[i-1][j+1] == 'X')
            count++;
					if(board[0][j] == 'X')
            count++;
					if(board[0][j+1] == 'X')
            count++;
					if(board[0][width-1] == 'X')
            count++;
					if(board[i-1][width-1] == 'X')
            count++;
					if(board[i][width-1] == 'X')
            count++;
        }

        else if (i == 0)
        {
          if(board[i+1][j] == 'X')
            count++;
					if(board[i][j+1] == 'X')
            count++;
					if(board[i+1][j+1] == 'X')
            count++;
					if(board[i][j-1] =='X')
            count++;
					if(board[i+1][j-1] == 'X')
            count++;
					if(board[length-1][j-1] == 'X')
            count++;
					if(board[length-1][j] == 'X')
            count++;
					if(board[length-1][j+1] == 'X')
            count++;
    	  }

				else if (j == 0)
        {
          if(board[i-1][j] == 'X')
            count++;
					if(board[i+1][j] == 'X')
            count++;
					if(board[i][j+1] == 'X')
            count++;
					if(board[i+1][j+1] == 'X')
            count++;
					if(board[i-1][j+1] == 'X')
            count++;
					if(board[i-1][width-1] == 'X')
            count++;
					if(board[i][width-1] == 'X')
            count++;
					if(board[i+1][width-1] == 'X')
            count++;
				}

        else if (i == (length - 1))
        {
          if(board[i-1][j] == 'X')
            count++;
					if(board[i][j+1] == 'X')
            count++;
					if(board[i-1][j+1] == 'X')
            count++;
					if(board[i][j-1] =='X')
            count++;
					if(board[i-1][j-1] == 'X')
            count++;
					if(board[0][j-1] == 'X')
            count++;
					if(board[0][j] == 'X')
            count++;
					if(board[0][j+1] == 'X')
            count++;
				}

				else if (j == (width - 1))
        {
          if(board[i-1][j] == 'X')
            count++;
					if(board[i+1][j] == 'X')
            count++;
					if(board[i][j-1] == 'X')
            count++;
					if(board[i+1][j-1] == 'X')
            count++;
					if(board[i-1][j-1] == 'X')
            count++;
					if(board[i-1][0] == 'X')
            count++;
					if(board[i][0] == 'X')
            count++;
					if(board[i+1][0] == 'X')
            count++;
				}

				else
        {
          if(board[i+1][j] == 'X')
            count++;
					if(board[i][j+1] == 'X')
            count++;
					if(board[i+1][j+1] == 'X')
            count++;
					if(board[i][j-1] =='X')
            count++;
					if(board[i-1][j] == 'X')
            count++;
					if(board[i-1][j-1] == 'X')
            count++;
					if(board[i+1][j-1] =='X')
            count++;
					if(board[i-1][j+1] == 'X')
            count++;
        }

        if (count < 2) //if a space has less than 2 neighbors, the cell dies
        {
          nextGen[i][j] = '-';
        }
        else if (count == 2) //if a space has exactly 2 neighbors, nothing changes
        {
          nextGen[i][j] = board[i][j];
        }
        else if (count == 3) //if a space has 3 neighbors, a new cell is created
        {
         nextGen[i][j] = 'X';
        }

        else if (count > 3) //if a space has more than 3 neighbors, cells die due to overpopulation
        {
          nextGen[i][j] = '-';
        }
       }
      }
      //checks to see if the board is stablizied
      int checker = 0;

      for (int i = 0; i <length; ++i)
      {
        for (int j = 0; j < width; ++j)
        {
          //adds one to checker if the specific locations are equal
          if (nextGen[i][j] == board[i][j])
          {
             checker++;
          }
          //if the specific location is not equal, sets stable to false
          else
          {
            stable = false;
          }
        }
      }
      //if every spot on the previous and the current generation are the same, set stable to true
      if (checker == (length*width))
      {
        stable = true;
        cout << "\nThis world is stable. There will be no further changes." << endl;
      }
      //Continues to store each generation's board as long as the current generation is not stable
      if (stable == false)
      {
        std::stringstream sstm;
        sstm << "Generation: " << genCount << "\n";
        outString += sstm.str();

        if (genCount == 1)
        {
          for(int i = 0; i < length; ++i)
          {
            for(int j = 0; j < width; ++j)
            {
              std::stringstream sstm;
              sstm << board[i][j];
              outString += sstm.str();
            }
            std::stringstream sstm;
            sstm << "\n";
            outString += sstm.str();
          }

          //Prints to console based on which option the user has chosen
          printBoard(outStyle, genCount, board, length, width);
          //stores the current board into a different board (nextGen)
          for(int i = 0; i < length; ++i)
          {
            for(int j = 0; j < width; ++j)
            {
              board[i][j] = nextGen[i][j];
            }
          }
        }
        else //after the first generation
        {
          for(int i = 0; i < length; ++i)
          {
            for(int j = 0; j < width; ++j)
            {
              board[i][j] = nextGen[i][j];
              std::stringstream sstm;
              sstm << board[i][j];
              outString += sstm.str();
            }
            std::stringstream sstm;
            sstm << "\n";
            outString += sstm.str();
          }
          printBoard(outStyle, genCount, board, length, width);
        }
      }
      genCount++;
    }
    //If there is an output file, then print to the file
    if(outputFile != "")
    {
      ofstream output;
      output.open(outputFile.c_str());
      output << outString << "\n";
      output.close();
    }
    return 0;
}

//code for selecting between Classic, Mirror, and Donut mode
void Game::selectMode(int& length, int& width, char**& board)
{
  string mode = "";
  bool modeSelected = false;

  while(modeSelected == false)
  {
    cout << "Enter the mode you wish to use(type out one of the 3 options): " << endl;
    cout << "1. Classic" << endl;
    cout << "2. Mirror" << endl;
    cout << "3. Donut\n" << endl;
    cin >> mode;
    //selects mode based off of input
    if((mode == "Classic") || (mode == "classic"))
    {
      classicMode(length, width, board);
      modeSelected = true;
    }

    else if((mode == "Mirror") || (mode == "mirror"))
    {
      mirrorMode(length, width, board);
      modeSelected = true;
    }

    else if((mode == "Donut") || (mode == "donut"))
    {
      donutMode(length, width, board);
      modeSelected = true;
    }
    //continues to ask for input until a correct input is given
    else
    {
      //cout << "Error. Invalid input. Try again." << endl;
      modeSelected = false;
    }
  }
}

//code for creating a randomized board
void Game::createRandomBoard(int& length, int&width)
{
  double densityNumber = 0.0;
  bool isCorrect = false;
  int numOfCells = 0;
  int randLength = 0;
  int randWidth = 0;
  //prompts user to input length and width of board
  cout << "Enter the length of your board: " << endl;
  cin >> length;

  cout << "Enter the width of your board: " << endl;
  cin >> width;

  //checks to make sure a number between 0 and 1 is inputted
  while(isCorrect == false)
  {
    cout << "Enter a number between 0 and 1: " << endl;
    cin >> densityNumber;

    if((densityNumber >= 0.0) && (densityNumber <= 1.0))
    {
      isCorrect = true;
    }

    else
    {
      cout << "Error. Invalid input. Try again." << endl;
      isCorrect = false;
    }
  }
  //creates a board based on given values of length, width and density
  char** transferBoard = new char*[length];

  for(int i = 0; i < length; ++i)
  {
    transferBoard[i] = new char[width];
  }

  numOfCells = round((length * width) * densityNumber);

  //sets all spots on board to -
  for(int i = 0; i < length; i++)
  {
    for(int j = 0; j < width; j++)
    {
      transferBoard[i][j] = '-';
    }
  }

  srand(time(NULL));

  //randomly puts in X's in spots that they do not exist in on the board
  for(int k = 0; k < numOfCells; k++)
  {
    randLength = rand() % (length);
    randWidth = rand() % (width);

    int numCells = 1;

    while(numCells > 0)
    {
      if(transferBoard[randLength][randWidth] == '-')
      {
        transferBoard[randLength][randWidth] = 'X';
        numCells--;
      }

      else
      {
        randLength = rand() % (length);
        randWidth = rand() % (width);
      }
    }
  }
  //continues the code after creating the board
  selectMode(length, width, transferBoard);
}

//code for creating a board based on a premade file
void Game::createBoardFromFile(string inputFile)
{
  ifstream inputStream;
  inputStream.open(inputFile.c_str());

  int length = 0;
  int width = 0;
  int counter = 0;
  string line = "";

  while(!inputStream.eof())
  {
    getline(inputStream, line);
    if(counter == 0)
      length = atoi(line.c_str());
    else if(counter == 1)
      width = atoi(line.c_str());
    else
      break;
    counter++;
  }

  counter = 0;

  char** transferBoard = new char*[length];

  for(int i = 0; i < length; ++i)
  {
    transferBoard[i] = new char[width];
  }

  for(int i = 0; i < length; i++)
  {
    for(int j = 0; j < width; j++)
    {
      transferBoard[i][j] = '-';
    }
  }

  inputStream.seekg(0, inputStream.beg);

  int row = 0;

  while(!inputStream.eof())
  {
    getline(inputStream, line);

    if(counter == 0)
    {

    }

    else if(counter == 1)
    {

    }

    else
    {
      for(int i = 0; i < width; i++)
      {
        char element = line[i];
        transferBoard[row][i] = element;
      }
      row++;
    }
    counter++;
  }
  selectMode(length, width, transferBoard);
}

//code for selecting settings prior to simulation starting
void Game::selectSettings()
{
  string setting = "";
  bool isValid = false;
  bool isValid2 = false;

  while(isValid == false)
  {
    cout << "Enter the the method of printing the board(type out one of the 3 options): " << endl;
    cout << "1. Pause" << endl;
    cout << "2. Enter" << endl;
    cout << "3. File\n" << endl;
    cin >> outStyle;

    if((outStyle == "Pause") || (outStyle == "pause"))
      isValid = true;
    else if((outStyle == "Enter") || (outStyle == "enter"))
      isValid = true;
    else if((outStyle == "File") || (outStyle == "file"))
    {
      cout << "Enter the name of the file you want to print out to(include '.txt'): " << endl;
      cin >> outputFile;

      isValid = true;
    }
    else
    {
      cout << "Error. Invalid input. Try again." << endl;
      isValid = false;
    }
  }

  while(isValid2 == false)
  {
    string outputFile = "";
    cout << "Enter the method of board generation you wish to use(type out one of the 2 options): " << endl;
    cout << "1. Randomized" << endl;
    cout << "2. File\n" << endl;
    cin >> setting;

    if((setting == "Randomized") || (setting == "randomized"))
    {
      int length = 0;
      int width = 0;

      createRandomBoard(length, width);
      isValid2 = true;
    }

    else if((setting == "File") || (setting == "file"))
    {
      string fileName;

      cout << "Enter the name of the file (include '.txt'): " << endl;
      cin >> fileName;

      createBoardFromFile(fileName);

      isValid2 = true;
    }

    else
    {
      cout << "Error. Invalid input. Try again." << endl;
      isValid2 = false;
    }
  }
}
