/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 7

All of the functionality of the Library System. Takes input from the user and traverses through a menu and it's deeper options.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem
{
	public static void main(String[] args)
	{
		//ArrayLists that store up to 10 of each type
		ArrayList<Movie> movies = new ArrayList<Movie>(10);
		ArrayList<Book> books = new ArrayList<Book>(10);
		ArrayList<Periodical> periodicals = new ArrayList<Periodical>(10);
		ArrayList<Room> rooms = new ArrayList<Room>(10);
		ArrayList<Student> student = new ArrayList<Student>(10);
		
		//automatically generated data
		Movie m1 = new Movie("The_Great_Gatsby", 2013, 143, false, 0);
		Movie m2 = new Movie("Kingsman_The_Secret_Service", 2014, 141, false, 4);
		Movie m3 = new Movie("The_Hitman's_Bodyguard", 2017, 118, false, 8);
		Book b1 = new Book("Ready_Player_One", "Ernest_Cline", 452, 9782266, false, 1);
		Book b2 = new Book("Fahrenheit_451", "Ray_Bradbury", 272, 8580001, false, 5);
		Book b3 = new Book("To_Kill_a_Mockingbird", "Harper_Lee", 281, 9788429, false, 9);
		Periodical p1 = new Periodical("The_New_York_Times", 2017, false, 2);
		Periodical p2 = new Periodical("Vogue", 2015, false, 6);
		Periodical p3 = new Periodical("National Geographic", 2012, false, 10);
		Room r1 = new Room(112, 10, true, false, 3);
		Room r2 = new Room(256, 15, false, false, 7);
		Room r3 = new Room(310, 5, true, false, 11);
		Student s1 = new Student(2282417, "Nick", "Lai", "lai137@mail.chapman.edu", 8020989, false, -1);
		Student s2 = new Student(2281307, "Alex", "Xu", "xu167@mail.chapman.edu", 9094132, true, 1);
		Student s3 = new Student(2283614, "Weber", "Cheng", "cheng163@mail.chapman.edu", 6084132, false, -1);
		//adds automatically generated data to the ArrayLists
		movies.add(m1);
		movies.add(m2);
		movies.add(m3);
		books.add(b1);
		books.add(b2);
		books.add(b3);
		periodicals.add(p1);
		periodicals.add(p2);
		periodicals.add(p3);
		rooms.add(r1);
		rooms.add(r2);
		rooms.add(r3);
		student.add(s1);
		student.add(s2);
		student.add(s3);
		
		//instantiates the ability to read inputs from the user
		Scanner keyboard = new Scanner(System.in);
		
		//all instance variables at default
		int barcode  = 11;
		int choice = 0;
		int itemBarcode = 0;
		//The amount of items the student currently has. Set to -1 by default meaning no items 
		int itemNumber = - 1; 
		String movieTitle, bookTitle, bookAuthor, periodicalName;
		String studentFirstName, studentLastName, studentEmail = "";
		String firstNameRemoved = "",lastNameRemoved = "";
		int movieYear, movieRuntime, bookPages, bookIsbn, periodicalYear,roomNumber, roomCap, roomCom;
		int studentID = 0;
		int studentPhone = 0; 
		Movie m;
		Book b;
		Periodical p;
		Room r;
		Student s;
		boolean hasPC = false, hasItem = false, checkedOut = false;
		
		//Continues the loop until an exit is chosen
		while(choice != 9)
		{
			//options menu shown to the user
			System.out.println("---");
			System.out.println("Enter the number of the option you wish to use: ");
			System.out.println("---\n");
			System.out.println("1. Add a new item to the catalog");
			System.out.println("2. Remove a lost item from the catalog");
			System.out.println("3. Register a new student");
			System.out.println("4. Unregister an old student");
			System.out.println("5. Check the status of an item");
			System.out.println("6. Checkout a particular item to a particular student by ID number");
			System.out.println("7. Return an item");
			System.out.println("8. List items in the catalog.");
			System.out.println("9. Exit\n");
			
			choice = keyboard.nextInt();
			
			if (choice == 1) //Add a new item to the catalog
			{
				//resets the choice to allow for reuse of the variable for menu selection
				choice = 0;
				//automatically sets items to be in stock
				checkedOut  = false;
				System.out.println("---");
				System.out.println("Enter the item type: ");
				System.out.println("---");
				System.out.println("1. Movie");
				System.out.println("2. Book");
				System.out.println("3. Periodical");
				System.out.println("4. Room\n");
			
				choice = keyboard.nextInt();
				
				if(choice == 1) //Route if movie is selected
				{
					System.out.println("Enter the title of the movie(Use _ for any spaces): ");
					movieTitle = keyboard.next();
					System.out.println("Enter the Year of the movie: ");
					movieYear = keyboard.nextInt();
					System.out.println("Enter the runtime of the movie in minutes: ");
					movieRuntime = keyboard.nextInt();
							
					//creates a new instance of a movie with the given information, then adds it to the ArrayList		
					m = new Movie(movieTitle, movieYear, movieRuntime, checkedOut, barcode);
					movies.add(m);
					barcode++;
									
					System.out.println("Successfully added " + movieTitle + " with a barcode number: "  + (barcode - 1) + " to the Catalog.");
				}
				
				else if(choice == 2) //Route if book is selected
				{
					System.out.println("Enter the title of the book: ");
					bookTitle = keyboard.next();
					System.out.println("Enter the author of the book(Use _ for any spaces): ");
					bookAuthor = keyboard.next();
					System.out.println("Enter the amount of pages in the book: ");
					bookPages = keyboard.nextInt();
					System.out.println("Enter the ISBN of the boo(Do not enter -): ");
					bookIsbn = keyboard.nextInt();
							
					//creates a new instance of a book with the given information, then adds it to the ArrayList		
					b = new Book(bookTitle, bookAuthor, bookPages, bookIsbn, checkedOut, barcode);
					books.add(b);
					barcode++;
							
					System.out.println("Successfully added " + bookTitle + " with a barcode number: "  + (barcode-1) + " to the Catalog.");
				}
				
				else if(choice == 3) //Route if Periodical is selected
				{
					System.out.println("Enter the name of Periodical(Use _ for any spaces): ");
					periodicalName= keyboard.next();
					System.out.println("Enter the year the Periodical released: ");
					periodicalYear = keyboard.nextInt();
						
					//creates a new instance of a Periodical with the given information, then adds it to the ArrayList	
					p = new Periodical(periodicalName,periodicalYear, checkedOut, barcode);
					periodicals.add(p);
					barcode++;
							
					System.out.println("Successfully added " + periodicalName  + " with a barcode number: "  + (barcode-1) + " to the Catalog.");	
				}
				
				else if (choice == 4) //Route if room is selected
				{
					System.out.println("Enter the room number: ");
					roomNumber= keyboard.nextInt();
					System.out.println("Enter the capacity of the room: ");
					roomCap = keyboard.nextInt();
					System.out.println("Does this room have a computer? (Enter 1 for Yes or 2 for No): ");
					roomCom = keyboard.nextInt();
					//sets hasPC to true if there is a computer in the room (defaulted at false)
					if (roomCom == 1)
						hasPC = true;
					//creates a new instance of a room with the given information, then adds it to the ArrayList		
					r = new Room(roomNumber, roomCap, hasPC, checkedOut, barcode);
					rooms.add(r);
					hasPC = false;
					barcode++;
							
					System.out.println("Successfully added Room: " + roomNumber + " with a barcode number: "  + (barcode-1)  + " to the Catalog.");				
				}
				
				else //error check
				{
					System.out.println("Error: Please Type in a valid number.");
				}
			}
			
			
			
			
			else if (choice == 2) //Removes a lost item from the catalog
			{
				choice = 0;
				checkedOut  = true;
				System.out.println("---");
				System.out.println("Enter the type of item:");
				System.out.println("---");
				System.out.println("1. Movie");
				System.out.println("2. Book");
				System.out.println("3. Periodical");
				System.out.println("4. Room\n");
				
				choice = keyboard.nextInt();
					
				if(choice == 1) //route if movie is selected
				{
					System.out.println("Enter the title of the movie(Use _ for any spaces): ");
					movieTitle = keyboard.next();
					System.out.println("Enter the year of the movie: ");
					movieYear = keyboard.nextInt();
					System.out.println("Enter the runtime of the movie in minutes: ");
					movieRuntime = keyboard.nextInt();
					System.out.println("Enter the barcode number: ");
					itemBarcode =  keyboard.nextInt();
							
					//creates a new instance of a movie using given information, will be used to checked against the ArrayList		
					m = new Movie(movieTitle, movieYear, movieRuntime, checkedOut, itemBarcode);
					
					//navigates through the movie ArrayList
					for(int i = 0; i < movies.size(); i++)
					{
						//checks for a matching movie title and barcode in comparison to all in the ArrayList
						if((movies.get(i)).getTitle().equals(m.getTitle()) && (movies.get(i)).getBarcode() == m.getBarcode())
						{			
							movieTitle = (movies.get(i)).getTitle();
							//removes the movie from the catalog if it is the same as the inputted movie
							movies.remove(i);	
							System.out.println("Successfully removed " + movieTitle + " from the Catalog.");
						}	
						//error check
						else
						{
							System.out.println("Error. The information given does not appear on the system.");
						}
					}		
				}
				
				else if(choice == 2) //route if book is selected
				{
					System.out.println("Enter the title of the book? (Use _ for any spaces): ");
					bookTitle = keyboard.next();
					System.out.println("Enter the author of the book? (Use _ for any spaces)");
					bookAuthor = keyboard.next();
					System.out.println("Enter the amount of pages in the book: ");
					bookPages = keyboard.nextInt();
					System.out.println("Enter the ISBN of the book(Do not enter -): ");
					bookIsbn = keyboard.nextInt();
					System.out.println("Enter the barcode number: ");
					itemBarcode =  keyboard.nextInt();				
							
					//creates a new instance of a book with inputted information, used to check against all in the ArrayList		
					b = new Book(bookTitle, bookAuthor, bookPages, bookIsbn, checkedOut, itemBarcode);
					//iterates through all books in the ArrayList
					for(int i = 0; i < books.size(); i++)
					{
						//checks if barcode and title of inputted book match any books in the ArrayList
						if((books.get(i)).getTitle().equals(b.getTitle()) && (books.get(i)).getBarcode() == b.getBarcode())
						{
							bookTitle = (movies.get(i)).getTitle();
							books.remove(i);	
							System.out.println("Successfully removed " + bookTitle + " from the Catalog.");
						}		
						//error check
						else
						{
							System.out.println("Error. The information given does not appear on the system.");
						}
					}
				}
				
				else if(choice == 3) //route if Periodical is selected
				{
					System.out.println("Enter the name of Periodical?(Use _ for any spaces): ");
					periodicalName= keyboard.next();
					System.out.println("Enter the year the Periodical was released: ");
					periodicalYear = keyboard.nextInt();
					System.out.println("Enter the barcode number: ");
					itemBarcode =  keyboard.nextInt();			
							
					//creates a new instance of a Periodical, used to check against ArrayList		
					p = new Periodical(periodicalName,periodicalYear, checkedOut, itemBarcode);
					//iterates through the periodical ArrayList
					for(int i = 0; i < periodicals.size(); i++)
					{
						//checks if barcode and title of inputted periodical match any periodicals in the ArrayList
						if((periodicals.get(i)).getName().equals(p.getName()) && (periodicals.get(i)).getBarcode() == p.getBarcode())
						{	
							periodicalName = (periodicals.get(i)).getName();
							periodicals.remove(i);	
							System.out.println("Successfully removed " + periodicalName + " from the Catalog.");
						}		
						//error check		
						else
						{
							System.out.println("Error. The information given does not appear on the system.");
						}
					}
				}
				
				else if (choice == 4) //route if room is selected
				{
					System.out.println("Enter the room number:");
					roomNumber= keyboard.nextInt();
					System.out.println("Enter the capacity of the room: ");
					roomCap = keyboard.nextInt();
					System.out.println("Does this room have a computer? (Enter 1 for Yes or 2 for No)");
					roomCom = keyboard.nextInt();
					if (roomCom == 1)
						hasPC = true;
					System.out.println("What is the barcode number?");
					itemBarcode =  keyboard.nextInt();
							
					//creates a new instance of a room, used to check against the ArrayList		
					r = new Room(roomNumber, roomCap, hasPC, checkedOut, itemBarcode);
					//iterates through the ArrayList
					for(int i = 0; i < rooms.size(); i++)
					{
						//checks if barcode and title of inputted room match any in the ArrayList
						if((rooms.get(i)).getBarcode() == r.getBarcode())
						{	
							roomNumber = (rooms.get(i)).getRoomNumber();
							rooms.remove(i);	
							System.out.println("Successfully removed Room Number: " + roomNumber + " from the Catalog.");
						}
						//error check
						else
						{
							System.out.println("Error. The information given does not appear on the system.");
						}
					}
					hasPC = false;
				}
				
				else //error check
				{
					System.out.println("Error: Please Type in a valid number.");
				}
			
			}
			
			
			
			else if (choice == 3) //register a student in the system
			{
				System.out.println("Enter the Student's ID Number: ");
				studentID = keyboard.nextInt();
				//iterates through the ArrayList of students, checks for duplicate ID
				for(int i = 0;  i < student.size(); i++)
				{
					do
					{
						//asks for reinput if the ID# matches a current student's ID# in the system
						System.out.println("Re-enter the student's ID number for verification");
						studentID = keyboard.nextInt();
						//ends the process of adding a new student if the ID# already exists
						if(studentID == (student.get(i)).getID())
						{
							System.out.println("Error: ID already exists");
						}
					}
					while (studentID == (student.get(i)).getID());
				}	
				
				System.out.println("Enter the student's first name: ");
				studentFirstName = keyboard.next();
				System.out.println("Enter the student's last name: ");
				studentLastName = keyboard.next();
				System.out.println("Enter the student's email address: ");
				studentEmail = keyboard.next();
				//iterates through the ArrayList of students, checks for duplicate email address
				for(int i = 0;  i < student.size(); i++)
				{
					do
					{
						System.out.println("Re-enter the student's email address for verification: ");
						studentEmail = keyboard.next();
						//ends the process of adding a new student if the email already exists.
						if(studentEmail.equals((student.get(i)).getEmail()))
						{
							System.out.println("Error: E-Mail already exists");
						}
					}
					while (studentEmail.equals((student.get(i)).getEmail()));
				}
				
				System.out.println("Enter the student's phone number(without spaces, dashes, or area code): ");
				studentPhone = keyboard.nextInt();
				//creates a new instance of a student with the given information, then adds it to the ArrayList of students
				s = new Student(studentID, studentFirstName, studentLastName, studentEmail, studentPhone, hasItem, -1);
				student.add(s);
				
				System.out.println("Successfully added: " + studentFirstName + " " + studentLastName + " to the System.");
			}
			
			
			
			else if (choice == 4) //unregister a student from the system
			{
				System.out.println("Enter the student's ID number: ");
				studentID = keyboard.nextInt();
				//iterates through the ArrayList of students
				for(int i = 0; i < student.size(); i++)
				{
					//checks if the inputted student ID# is equal to any on the ArrayList
					if(((student.get(i)).getID()) == studentID)
					{
						//checks if the student has an item checked out or not, if not, removes them from the system
						if(((student.get(i)).getHasItem()) == false)
						{
							firstNameRemoved = (student.get(i)).getFirstName();
							lastNameRemoved = (student.get(i)).getLastName();
							student.remove(i);	
							System.out.println("Successfully removed: " + firstNameRemoved + " " + lastNameRemoved + " from the system.");
						}
						//Does not remove the student if they have an item checked out
						else
						{
							System.out.println("Error: Student has an item checked out");
						}
					}
					//error check
					else
					{
						System.out.println("Error. Student with this ID number does not exist on the system.");
					}
				}
			}

			
			
			else if (choice  == 5) //check status of an item on the catalog
			{
				choice = 0;
				checkedOut  = false;
				System.out.println("---");
				System.out.println("Enter the type of item: ");
				System.out.println("---");
				System.out.println("1. Movie");
				System.out.println("2. Book");
				System.out.println("3. Periodical");
				System.out.println("4. Room\n");
				
				choice = keyboard.nextInt();
					
				if(choice == 1) //route if movie is selected
				{
					System.out.println("Enter the title of the movie: ");
					movieTitle = keyboard.next();
					System.out.println("Enter the year of the movie: ");
					movieYear = keyboard.nextInt();
					System.out.println("Enter the runtime of the movie in minutes: ");
					movieRuntime = keyboard.nextInt();
					System.out.println("Enter the barcode number: ");
					itemBarcode =  keyboard.nextInt();
							
					//creates a new instance of a book, used to check against the ArrayList		
					m = new Movie(movieTitle, movieYear, movieRuntime, checkedOut, itemBarcode);
					//iterates through the ArrayList of books
					for(int i = 0; i < movies.size(); i++)
					{
						//checks if the inputted movie matches any movie in the ArrayList
						if(movies.get(i).getTitle().equals(m.getTitle()) && movies.get(i).getBarcode() == m.getBarcode())
						{
							movieTitle = (movies.get(i)).getTitle();
							checkedOut = (movies.get(i)).getCheckedOut();
							//checks if the movie is checked out or not
							if (checkedOut == true)
							{
								System.out.println(movieTitle + " is already checked out.");
							}
							//if the movie is not checked out, displays a message
							else if(checkedOut == false)
							{
								System.out.println(movieTitle + " is available.");
							}			
						}
						//error check
						else
						{
							System.out.println("Error. Movie not found in the system.");
						}
					}		
				}
				
				else if(choice == 2) //route if book is selected
				{
					System.out.println("Enter the title of the book: ");
					bookTitle = keyboard.next();
					System.out.println("Enter the author of the book: ");
					bookAuthor = keyboard.next();
					System.out.println("Enter the amount of pages in the book: ");
					bookPages = keyboard.nextInt();
					System.out.println("Enter the ISBN of the book(Do not enter any dashes): ");
					bookIsbn = keyboard.nextInt();
					System.out.println("Enter the barcode number: ");
					itemBarcode =  keyboard.nextInt();
					//creates a new instance of a book, used to compare against books on the ArrayList
					b = new Book(bookTitle, bookAuthor, bookPages, bookIsbn, checkedOut, itemBarcode);
					//iterates through the ArrayList of books
					for(int i = 0; i < books.size(); i++)
					{
						//checks if inputted book matches a book on the ArrayList
						if(books.get(i).getTitle().equals(b.getTitle()) && books.get(i).getBarcode() == b.getBarcode())
						{
							bookTitle = (books.get(i)).getTitle();
							checkedOut = (books.get(i)).getCheckedOut();
							if (checkedOut == true)
							{
								System.out.println(bookTitle + " is already checked out.");
							}
							
							else if(checkedOut == false)
							{
								System.out.println(bookTitle + " is available");
							}
						}
						//error check
						else
						{
							System.out.println("Error. Book does not exist on the catalog.");
						}	
					}
				}
				
				else if(choice == 3)//route if periodical is selected
				{
					System.out.println("Enter the name of Periodical: ");
					periodicalName = keyboard.next();
					System.out.println("Enter the year the Periodical was released: ");
					periodicalYear = keyboard.nextInt();
					System.out.println("Enter the barcode number: ");
					itemBarcode =  keyboard.nextInt();
						
					//creates a new instance of a periodical with the given information, used to check against the ArrayList			
					p = new Periodical(periodicalName, periodicalYear, checkedOut, itemBarcode);
					//iterates through the ArrayList of Periodicals
					for(int i = 0; i < periodicals.size(); i++)
					{
						//checks if inputted information matches any Periodicals on the ArrayList
						if(periodicals.get(i).getName().equals(p.getName()) && periodicals.get(i).getBarcode() == p.getBarcode())
						{
							periodicalName = (periodicals.get(i)).getName();
							checkedOut = (periodicals.get(i)).getCheckedOut();
							if (checkedOut == true)
							{
								System.out.println(periodicalName + " is already checked out.");
							}
							
							else if(checkedOut == false)
							{
								System.out.println(periodicalName + " is available.");
							}
						}
						//error check
						else
						{
							System.out.println("Error. Periodical does not exist on the catalog.");
						}	
					}			
				}
				
				else if (choice == 4)//route if room is selected
				{
					System.out.println("Enter the room number: ");
					roomNumber= keyboard.nextInt();
					System.out.println("Enter the capacity of the room: ");
					roomCap = keyboard.nextInt();
					System.out.println("Does this room have a computer? (Enter 1 for Yes or 2 for No): ");
					roomCom = keyboard.nextInt();
					if (roomCom == 1)
						hasPC = true;
					System.out.println("Enter the barcode number: ");
					itemBarcode =  keyboard.nextInt();
							
					//creates a new instance of a room, used to check against the ArrayList		
					r = new Room(roomNumber, roomCap, hasPC, checkedOut, itemBarcode);
					//iterates through the ArrayList
					for(int i = 0; i < rooms.size(); i++)
					{
						//checks if inputted information matches any room on the ArrayList
						if(rooms.get(i).getRoomNumber() == r.getRoomNumber() && rooms.get(i).getBarcode() == r.getBarcode())
						{
							roomNumber = (rooms.get(i)).getRoomNumber();
							checkedOut = (rooms.get(i)).getCheckedOut();
							if (checkedOut == true)
							{
								System.out.println("Room:  " + roomNumber + " is already checked out.");
							}
							
							else if(checkedOut == false)
							{
								System.out.println("Room: " + roomNumber + " is available.");
							}
						}
						//error check
						else
						{
							System.out.println("Error. Room not found on the catalog.");
						}
					}
				}
					
				else //error check path
				{
					System.out.println("Error: Please Type in a valid number.");
				}
			}
			
			
			
			else if (choice == 6) //check out an item to a student by ID#
			{
				choice = 0;
				System.out.println("---");
				System.out.println("Enter the type of item you wish to check out: ");
				System.out.println("---");
				System.out.println("1. Movie");
				System.out.println("2. Book");
				System.out.println("3. Periodical");
				System.out.println("4. Room\n");
				
				choice = keyboard.nextInt();
					
				if(choice == 1) //route if movie is selected
				{
					System.out.println("Enter the title of the movie(Enter _ for any spaces): ");
					movieTitle = keyboard.next();
					System.out.println("Enter the year of the movie: ");
					movieYear = keyboard.nextInt();
					System.out.println("Enter the runtime of the movie in minutes: ");
					movieRuntime = keyboard.nextInt();
					System.out.println("Enter the barcode number: ");
					itemBarcode =  keyboard.nextInt();
					System.out.println("Enter the student's ID number: ");
					studentID = keyboard.nextInt();
							
					//creates a new instance of a movie, used to check against the ArrayList		
					m = new Movie(movieTitle, movieYear, movieRuntime, checkedOut, itemBarcode);
					
					//iterates through the ArrayList
					for(int i = 0; i < movies.size(); i++)
					{
						//checks if inputted information matches any of the movies on the ArrayList
						if((movies.get(i)).getBarcode() == m.getBarcode() && (movies.get(i)).getTitle().equals(m.getTitle()))
						{						
							//iterates through the ArrayList
							for(int j = 0; j < student.size(); j++)
							{
								//checks if inputted information matches any of the students on the ArrayList
								if(((student.get(j)).getID()) == studentID && student.get(j).getItemNum() < 1)
								{
									movieTitle = (movies.get(i)).getTitle();
									movies.get(i).setCheckedOut(true);
									student.get(j).setHasItem(true);
									student.get(j).setItemNum(1);
									System.out.println("Successfully checked out " + movieTitle + " from the Catalog.");
								}
								//checks if student already has a book checked out or not
								else if(student.get(j).getItemNum() == 1)
								{
									System.out.println("Error. Student already has an item checked out.");
								}
								
								else
								{
									System.out.println("Error. Student with this ID number does not exist.");
								}
							}		
						}
						//error check
						else
						{
							System.out.println("Error. Movie with this barcode does not exist on the system.");
						}
					}		
				}
				
				else if(choice == 2) //route if book is selected
				{
					System.out.println("Enter title of the book(Enter _ for any spaces): ");
					bookTitle = keyboard.next();
					System.out.println("Enter the author of the book(Enter _ for any spaces): ");
					bookAuthor = keyboard.next();
					System.out.println("Enter the amount of pages in the book: ");
					bookPages = keyboard.nextInt();
					System.out.println("Enter the ISBN of the book(Do not enter dashes): ");
					bookIsbn = keyboard.nextInt();
					System.out.println("Enter the barcode number: ");
					itemBarcode =  keyboard.nextInt();
					System.out.println("Enter the student's ID number: ");
					studentID = keyboard.nextInt();
										
					//creates a new instance of a book, used to check against ArrayList					
					b = new Book(bookTitle, bookAuthor, bookPages, bookIsbn, checkedOut, itemBarcode);
					//iterates through the ArrayList of books
					for(int i = 0; i < books.size(); i++)
					{
						//checks if inputted information matches a book in the ArrayList
						if((books.get(i)).getBarcode() == b.getBarcode() && books.get(i).getTitle().equals(b.getTitle()))
						{
							//iterates through the ArrayList of students
							for(int j = 0; j < student.size(); j++)
							{
								//checks if student exists on the system and if they already have a book checked out or not
								if(((student.get(j)).getID()) == studentID && student.get(j).getItemNum() < 1)
								{
									bookTitle = (books.get(i)).getTitle();
									books.get(i).setCheckedOut(true);
									student.get(j).setHasItem(true);
									student.get(j).setItemNum(1);
									System.out.println("Successfully checked out " + bookTitle + " from the Catalog.");
								}
								
								else if(student.get(j).getItemNum() == 1)
								{
									System.out.println("Error. Student already has an item checked out.");
								}
								
								else
								{
									System.out.println("Error. Student is not registered on the system.");
								}
							}								
						}
						//error check
						else
						{
							System.out.println("Error. Book is not on the catalog.");
						}
					}
				}
				
				else if(choice == 3)//path if Periodical is selected
				{
					System.out.println("Enter the name of the Periodical(Enter _ for any spaces): ");
					periodicalName= keyboard.next();
					System.out.println("Enter the year the Periodical was released: ");
					periodicalYear = keyboard.nextInt();
					System.out.println("Enter the barcode number: ");
					itemBarcode =  keyboard.nextInt();
					System.out.println("Enter the student's ID number: ");
					studentID = keyboard.nextInt();					
							
					//creates a new instance of a Periodical, used to check against the ArrayList		
					p = new Periodical(periodicalName,periodicalYear, checkedOut, itemBarcode);
					//iterates through the ArrayList of Periodicals
					for(int i = 0; i < periodicals.size(); i++)
					{
						//checks if inputted information matches any Periodicals on the ArrayList
						if((periodicals.get(i)).getBarcode() == p.getBarcode() && periodicals.get(i).getName().equals(p.getName()))
						{
							//iterates through the ArrayList of students
							for(int j = 0; j < student.size(); j++)
							{
								//checks if student exists on the system and whether or not they have an item checked out already
								if(((student.get(j)).getID()) == studentID && student.get(j).getItemNum() < 1)
								{
									periodicalName = (periodicals.get(i)).getName();
									periodicals.get(i).setCheckedOut(true);	
									student.get(j).setHasItem(true);
									student.get(j).setItemNum(1);
									System.out.println("Successfully checked out " + periodicalName + " from the Catalog.");
								}
								//displays a message if student already has a book checked out
								else if(student.get(j).getItemNum() == 1)
								{
									System.out.println("Error. Student already has an item checked out.");
								}
								
								else
								{
									System.out.println("Error. Student not registered on the system.");
								}
							}	
						}	
						//error check
						else
						{
							System.out.println("Error. Periodical does not exist on the catalog.");
						}
					}
				}
				
				else if (choice == 4)//path if room is selected
				{
					System.out.println("Enter the room number: ");
					roomNumber= keyboard.nextInt();
					System.out.println("Enter the capacity of the room: ");
					roomCap = keyboard.nextInt();
					System.out.println("Does this room have a computer? (Enter 1 for Yes or 2 for No): ");
					roomCom = keyboard.nextInt();
					System.out.println("Enter the student's ID number: ");
					studentID = keyboard.nextInt();
					
					if (roomCom == 1)
						hasPC = true;
					System.out.println("What is the barcode number?");
					itemBarcode =  keyboard.nextInt();
							
					//creates a new instance of a room, used to check against the ArrayList
					r = new Room(roomNumber, roomCap, hasPC, checkedOut, itemBarcode);
					//iterates through the ArrayList of rooms
					for(int i = 0; i < rooms.size(); i++)
					{
						//checks if inputted information matches any rooms on the ArrayList
						if((rooms.get(i)).getBarcode() == r.getBarcode() && rooms.get(i).getRoomNumber() == r.getRoomNumber())
						{		
							//iterates through the ArrayList of students
							for(int j = 0; j < student.size(); j++)
							{
								//checks if information inputted matches any students on the ArrayList and whether or not they have an item checked out
								if(((student.get(j)).getID()) == studentID && student.get(j).getItemNum() < 1)
								{
									roomNumber = (rooms.get(i)).getRoomNumber();
									rooms.remove(i);
									student.get(j).setHasItem(true);
									student.get(j).setItemNum(1);
									System.out.println("Successfully checked out " + roomNumber + " from the Catalog.");
								}
								//displays a message if student already has an item checked out
								else if(student.get(j).getItemNum() == 1)
								{
									System.out.println("Error. Student already has an item checked out.");
								}
								//error check
								else
								{
									System.out.println("Error. The student does not exist on the system.");
								}
							}	
						}
						//error check
						else
						{
							System.out.println("Error. Room does not exist on the catalog.");
						}
					}
					hasPC = false;
				}
				
				else//error check path
				{
					System.out.println("Error: Please Type in a valid number.");
				}
			}
			
			
			
			else if (choice == 7) //return an item
			{
				choice = 0;
				System.out.println("---");
				System.out.println("Enter the type of item you wish to return: ");
				System.out.println("---");
				System.out.println("1. Movie");
				System.out.println("2. Book");
				System.out.println("3. Periodical");
				System.out.println("4. Room\n");
				
				choice = keyboard.nextInt();
				if(choice == 1) //route if movie is selected
				{
					System.out.println("Enter the title of the movie(Enter _ for any spaces): ");
					movieTitle = keyboard.next();
					System.out.println("Enter the year of the movie: ");
					movieYear = keyboard.nextInt();
					System.out.println("Enter the runtime of the movie in minutes: ");
					movieRuntime = keyboard.nextInt();
					System.out.println("Enter the barcode number: ");
					itemBarcode =  keyboard.nextInt();
					System.out.println("Enter the student's ID number: ");
					studentID = keyboard.nextInt();
							
					//creates a new instance of a movie, used to check against the ArrayList		
					m = new Movie(movieTitle, movieYear, movieRuntime, checkedOut, itemBarcode);
					
					//iterates through the ArrayList
					for(int i = 0; i < movies.size(); i++)
					{
						//checks if inputted information matches any of the movies on the ArrayList
						if((movies.get(i)).getBarcode() == m.getBarcode() && (movies.get(i)).getTitle().equals(m.getTitle()))
						{						
							//iterates through the ArrayList
							for(int j = 0; j < student.size(); j++)
							{
								//checks if inputted information matches any of the students on the ArrayList
								if(((student.get(j)).getID()) == studentID && student.get(j).getItemNum() == 1)
								{
									movieTitle = (movies.get(i)).getTitle();
									movies.get(i).setCheckedOut(false);
									student.get(j).setHasItem(false);
									student.get(j).setItemNum(-1);
									System.out.println("Successfully returned " + movieTitle + ".");
								}
								//checks if student has a book checked out or not
								else if(student.get(j).getItemNum() < 1)
								{
									System.out.println("Error. Student does not have a movie checked out.");
								}
								//error check
								else
								{
									System.out.println("Error. Student with this ID number does not exist.");
								}
							}		
						}
						//error check
						else
						{
							System.out.println("Error. Movie with this barcode does not exist on the system.");
						}
					}		
				}
				
				else if(choice == 2) //route if book is selected
				{
					System.out.println("Enter title of the book(Enter _ for any spaces): ");
					bookTitle = keyboard.next();
					System.out.println("Enter the author of the book(Enter _ for any spaces): ");
					bookAuthor = keyboard.next();
					System.out.println("Enter the amount of pages in the book: ");
					bookPages = keyboard.nextInt();
					System.out.println("Enter the ISBN of the book(Do not enter dashes): ");
					bookIsbn = keyboard.nextInt();
					System.out.println("Enter the barcode number: ");
					itemBarcode =  keyboard.nextInt();
					System.out.println("Enter the student's ID number: ");
					studentID = keyboard.nextInt();
										
					//creates a new instance of a book, used to check against ArrayList					
					b = new Book(bookTitle, bookAuthor, bookPages, bookIsbn, checkedOut, itemBarcode);
					//iterates through the ArrayList of books
					for(int i = 0; i < books.size(); i++)
					{
						//checks if inputted information matches a book in the ArrayList
						if((books.get(i)).getBarcode() == b.getBarcode() && books.get(i).getTitle().equals(b.getTitle()))
						{
							//iterates through the ArrayList of students
							for(int j = 0; j < student.size(); j++)
							{
								//checks if student exists on the system and if they already have a book checked out or not
								if(((student.get(j)).getID()) == studentID && student.get(j).getItemNum() == 1)
								{
									bookTitle = (books.get(i)).getTitle();
									books.get(i).setCheckedOut(false);
									student.get(j).setHasItem(false);
									student.get(j).setItemNum(-1);
									System.out.println("Successfully returned " + bookTitle + ".");
								}
								//checks if student has a book checked out or not
								else if(student.get(j).getItemNum() < 1)
								{
									System.out.println("Error. Student does not have a book checked out.");
								}
								//error check
								else
								{
									System.out.println("Error. Student is not registered on the system.");
								}
							}								
						}
						//error check
						else
						{
							System.out.println("Error. Book is not on the catalog.");
						}
					}
				}
				
				else if(choice == 3)//path if Periodical is selected
				{
					System.out.println("Enter the name of the Periodical(Enter _ for any spaces): ");
					periodicalName= keyboard.next();
					System.out.println("Enter the year the Periodical was released: ");
					periodicalYear = keyboard.nextInt();
					System.out.println("Enter the barcode number: ");
					itemBarcode =  keyboard.nextInt();
					System.out.println("Enter the student's ID number: ");
					studentID = keyboard.nextInt();					
							
					//creates a new instance of a Periodical, used to check against the ArrayList		
					p = new Periodical(periodicalName,periodicalYear, checkedOut, itemBarcode);
					//iterates through the ArrayList of Periodicals
					for(int i = 0; i < periodicals.size(); i++)
					{
						//checks if inputted information matches any Periodicals on the ArrayList
						if((periodicals.get(i)).getBarcode() == p.getBarcode() && periodicals.get(i).getName().equals(p.getName()))
						{
							//iterates through the ArrayList of students
							for(int j = 0; j < student.size(); j++)
							{
								//checks if student exists on the system and whether or not they have an item checked out already
								if(((student.get(j)).getID()) == studentID && student.get(j).getItemNum() == 1)
								{
									periodicalName = (periodicals.get(i)).getName();
									periodicals.get(i).setCheckedOut(false);	
									student.get(j).setHasItem(false);
									student.get(j).setItemNum(-1);
									System.out.println("Successfully returned " + periodicalName + ".");
								}
								//displays a message if student already has a book checked out
								else if(student.get(j).getItemNum() < 1)
								{
									System.out.println("Error. Student does not have a Periodical checked out.");
								}
								
								else
								{
									System.out.println("Error. Student not registered on the system.");
								}
							}	
						}	
						//error check
						else
						{
							System.out.println("Error. Periodical does not exist on the catalog.");
						}
					}
				}
				
				else if (choice == 4)//path if room is selected
				{
					System.out.println("Enter the room number: ");
					roomNumber= keyboard.nextInt();
					System.out.println("Enter the capacity of the room: ");
					roomCap = keyboard.nextInt();
					System.out.println("Does this room have a computer? (Enter 1 for Yes or 2 for No): ");
					roomCom = keyboard.nextInt();
					System.out.println("Enter the student's ID number: ");
					studentID = keyboard.nextInt();
					
					if (roomCom == 1)
						hasPC = true;
					System.out.println("What is the barcode number?");
					itemBarcode =  keyboard.nextInt();
							
					//creates a new instance of a room, used to check against the ArrayList
					r = new Room(roomNumber, roomCap, hasPC, checkedOut, itemBarcode);
					//iterates through the ArrayList of rooms
					for(int i = 0; i < rooms.size(); i++)
					{
						//checks if inputted information matches any rooms on the ArrayList
						if((rooms.get(i)).getBarcode() == r.getBarcode() && rooms.get(i).getRoomNumber() == r.getRoomNumber())
						{		
							//iterates through the ArrayList of students
							for(int j = 0; j < student.size(); j++)
							{
								//checks if information inputted matches any students on the ArrayList and whether or not they have an item checked out
								if(((student.get(j)).getID()) == studentID && student.get(j).getItemNum() == 1)
								{
									roomNumber = (rooms.get(i)).getRoomNumber();
									rooms.get(i).setCheckedOut(false);
									student.get(j).setHasItem(false);
									student.get(j).setItemNum(-1);
									System.out.println("Successfully returned room #" + roomNumber + ".");
								}
								//displays a message if student already has an item checked out
								else if(student.get(j).getItemNum() < 1)
								{
									System.out.println("Error. Student does not have a room checked out.");
								}
								//error check
								else
								{
									System.out.println("Error. The student does not exist on the system.");
								}
							}	
						}
						//error check
						else
						{
							System.out.println("Error. Room does not exist on the catalog.");
						}
					}
					hasPC = false;
				}
				
				else//error check path
				{
					System.out.println("Error: Please Type in a valid number.");
				}
			}
			
			
			
			else if(choice == 8) //lists items in the catalog
			{
				choice = 0;
				System.out.println("---");
				System.out.println("Enter the type of items you wish to see: ");
				System.out.println("---");
				System.out.println("1. Movie");
				System.out.println("2. Book");
				System.out.println("3. Periodical");
				System.out.println("4. Room\n");
				choice = keyboard.nextInt();
				
				if(choice == 1) //path if movie is selected
				{
					//iterates through the ArrayList of movies
					for(int i = 0; i < movies.size(); i++)
					{
						//checks if there are any movies in the ArrayList
						if(movies.size() >= 1)
						{
							//prints out movies in the catalog in order
							System.out.println((i+1) + ". " + movies.get(i));
						}
						//error check
						else if(movies.size() < 1)
						{
							System.out.println("Error. No movies exist in the catalog");
						}
					}
				}
				
				else if(choice == 2) //path if book is selected
				{
					//iterates through the ArrayList of books
					for(int i = 0; i < books.size(); i++)
					{
						//checks if there are any books in the ArrayList
						if(books.size() >= 1)
						{
							//prints out books in the catalog in order
							System.out.println((i+1) + ". " + books.get(i));
						}
						//error check
						else if(books.size() < 1)
						{
							System.out.println("Error. No books exist in the catalog");
						}
					}
				}
				
				else if(choice == 3) //path if Periodical is selected
				{
					//iterates through the ArrayList of Periodicals
					for(int i = 0; i < periodicals.size(); i++)
					{
						//checks if there are any Periodicals in the ArrayList
						if(periodicals.size() >= 1)
						{
							//prints out the Periodicals in the catalog in order
							System.out.println((i+1) + ". " + periodicals.get(i));
						}
						//error check
						else if(periodicals.size() < 1)
						{
							System.out.println("Error. No Periodicals exist in the catalog");
						}
					}
				}
				
				else if(choice == 4)//path if room is selected
				{
					//iterates through the ArrayList of rooms
					for(int i = 0; i < rooms.size(); i++)
					{
						//checks if there are any rooms in the ArrayList
						if(rooms.size() >= 1)
						{
							//prints out the rooms in the catalog in order
							System.out.println((i+1) + ". " + rooms.get(i));
						}
						//error check
						else if(rooms.size() < 1)
						{
							System.out.println("Error. No rooms exist in the catalog");
						}
					}
				}
				
				else //error check path
				{
					System.out.println("Error. Please enter a valid number.");
				}
			}
			
			else if (choice == 9) //exits the system
			{
				System.out.println("Thank you for using the Library System. System now exiting.");
				System.exit(1);
			}
			
			else //error check path
			{
				System.out.println("Error: Please Type in a valid number.");
			}
		}
	}
}
