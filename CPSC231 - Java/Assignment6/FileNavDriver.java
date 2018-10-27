/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 6

Takes input from the user to browse files on the system.
**/

import java.io.*;
import java.util.*;

public class FileNavDriver
{
	
	public static void main(String[] args) throws IOException
	{
		//sets up to take input from user
		Scanner keyboard = new Scanner(System.in);
		//keeps the while loop going so that the program can be used until closed.
		boolean isActive = true;
		//holds content of what to print into the log file when each option is selected
		String logFileContent;
		String logFileName = null;
		
		System.out.println("Would you like to dump results to a log?(y/n)");
		String logFile = keyboard.nextLine();
		
		//continues to ask for a response until user chooses a proper one.
		while(!logFile.equals("y") && !logFile.equals("n"))
		{
			System.out.println("Error. Not a valid response. Try again: ");
			logFile = keyboard.nextLine();
		}
		if(logFile.equals("y"))
		{
			System.out.println("File Name(If it already exists, file will be overwritten): ");
			logFileName = keyboard.nextLine();
		}
		else if(logFile.equals("n"))
		{
			System.out.println("No log file will be created.");
		}
		
		FileNav fileRunner = new FileNav();
		
		//continues the program until the user selects to exit.
		while(isActive == true)
		{
			//options list that is shown to the user.
			System.out.println("---");
			System.out.println("OPTIONS MENU");
			System.out.println("---");
			System.out.println("1. List the contents of a directory.");
			System.out.println("2. List the contents of a directory and all of it's sub-directories.");
			System.out.println("3. Locate a file given the file name.");
			System.out.println("4. Locate files with a given extension.");
			System.out.println("5. Concatenate the contents of 2 files into a new file.");
			System.out.println("6. Copies the contents of a text file into a new text file.");
			System.out.println("7. Exit.");
			System.out.println("---");
			System.out.println("Enter the number of the option you wish to use: ");
			int optionPick = keyboard.nextInt();
			keyboard.nextLine();
			
			//option to list the contents of a directory
			if(optionPick == 1)
			{
				System.out.println("Enter the name of the driectory(i.e. C:/...): ");
				String dirName = keyboard.nextLine();
				


				File[] files1 = new File(dirName).listFiles();
				//error checking
				if(files1 == null)
				{
					System.out.println("Error. Pathname " + dirName + " does not exist.");
					continue;
				}
				
				System.out.println("Items in this location: ");
				//finds file in specific directory
				fileRunner.DirSearch(files1);
				
				//adds to the log file, if it exists
				if(logFileName != null)
				{
					logFileContent = "Contents of directory, " + dirName + " , have been listed.\n";
					fileRunner.writeToLog(logFileName, logFileContent);
				}
			}
			
			//option to list the contents of a directory and its sub-directories
			if(optionPick == 2)
			{
				System.out.println("Enter the name of the directory(i.e. C:/...): ");
				String directoryName = keyboard.nextLine();
				File[] files2 = new File(directoryName).listFiles();
				//error checking
				if(files2 == null)
				{
					System.out.println("Error. Pathname " + directoryName + " does not exist.");
					continue;
				}
				
				System.out.println("---");
				//finds files in directory and its sub directories
				fileRunner.DirSubSearch(files2);
				
				//adds to the log file, if it exists
				if(logFileName != null)
				{
					logFileContent = "Contents of directory, " + directoryName + " , and it's sub-directories have been listed.\n";
					fileRunner.writeToLog(logFileName, logFileContent);
				}
			}
			
			//option to locate a file given it's name
			if(optionPick == 3)
			{
				System.out.println("Enter the name of the file you wish to locate: ");
				String fileToLocate = keyboard.nextLine();
				System.out.println("---");
				//locates the path to the desired file.
				fileRunner.FileLocator(fileToLocate);
				
				//adds to the log file, if it exists
				if(logFileName != null)
				{
					logFileContent = "File, " + fileToLocate + ", has been located!\n";
					fileRunner.writeToLog(logFileName, logFileContent);
				}
			}
			
			//option to locate all files with a given extension in a directory
			if(optionPick == 4)
			{
				System.out.println("Enter the name of the directory you wish to search(i.e. C:/Users/...): ");
				String direcName = keyboard.nextLine();
				System.out.println("Enter the name of the file extension(i.e. .java): ");
				String extName = keyboard.nextLine();
				
				
				File files4 = new File(direcName);
				//error checking
				if(files4 == null)
				{
					System.out.println("Error. Pathname " + direcName + " does not exist.");
					continue;
				}
			    System.out.println("---");
				//locates files with a given extension in a specific directory
				fileRunner.FindByExtn(direcName, extName);
				
				//adds to the log file, if it exists
				if(logFileName != null)
				{
					logFileContent = "All files with extension, " + extName + ", in the directory, " + direcName + ", have been displayed!\n";
					fileRunner.writeToLog(logFileName, logFileContent);
				}
			}
			
			//option to write the contents of 2 files into a new file.
			if(optionPick == 5)
			{
				System.out.println("Enter the name of the first txt file(i.e. Something.txt): ");
				String firstFile = keyboard.nextLine();
				
				System.out.println("Enter the name of the second txt file: ");
				String secondFile = keyboard.nextLine();
				
				System.out.println("Enter the name of the file you'd like to create(.txt): ");
				String finalFile = keyboard.nextLine();
				
				fileRunner.ConcatenateFile(firstFile, secondFile, finalFile);
				System.out.println("---");
				System.out.println("Done! File " + finalFile + " has been created. Files " + firstFile + " and " + secondFile + " have been concatenated into " + finalFile);
				
				//adds to the log file, if it exists
				if(logFileName != null)
				{
					logFileContent = "File " + finalFile + " has been created. Files " + firstFile + " and " + secondFile + " have been concatenated into " + finalFile + "!\n";
					fileRunner.writeToLog(logFileName, logFileContent);
				}
			}
			
			//option to make a copy of a file (bonus)
			if(optionPick == 6)
			{
				System.out.println("File wish copy: ");
				String fileToCopy = keyboard.nextLine();
				System.out.println("Name of new file: ");
				String newFile = keyboard.nextLine();
				fileRunner.CopyFile(fileToCopy, newFile);
				System.out.println("Done");
				
				//adds to the log file, if it exists
				if(logFileName != null)
				{
					logFileContent = "Contents of the file, " + fileToCopy + ", have been copied into the file, " + newFile + "!\n";
					fileRunner.writeToLog(logFileName, logFileContent);
				}
			}
			
			//option to exit the program.
			if(optionPick == 7)
			{
				System.out.println("Exitting.");
				isActive = false;
				
				//adds to the log file, if it exists
				if(logFileName != null)
				{
					logFileContent = "Program has been closed!";
					fileRunner.writeToLog(logFileName, logFileContent);
				}
				
				System.exit(0);
			}
		}
	}
}