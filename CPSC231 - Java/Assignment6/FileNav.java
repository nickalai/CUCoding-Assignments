/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 6

Functionality of the options for FileNavDriver
**/

import java.io.*;
import java.util.*;

public class FileNav
{
	private File[] files;
	private String logFile;
	private String textToWrite;
	private String fileToLocate;
	private String directoryName;
	private String extName;
	private String fileToCopy;
	private String newFile;
	private String firstFile;
	private String secondFile;
	private String finalFile;
	
	public FileNav()
	{
		this.logFile = logFile;
		this.textToWrite = textToWrite;
		this.fileToLocate = fileToLocate;
		this.directoryName = directoryName;
		this.extName = extName;
		this.fileToCopy = fileToCopy;
		this.newFile = newFile;
		this.firstFile = firstFile;
		this.secondFile = secondFile;
		this.finalFile = finalFile;
	}
	
	//getters and setters for all of these variables...
	public String getLogFile()
	{
		return logFile;
	}
	
	public void setLogFile(String logFile)
	{
		this.logFile = logFile;
	}
	
	public String getTextToWrite()
	{
		return textToWrite;
	}
	
	public void setTextToWrite(String textToWrite)
	{
		this.textToWrite = textToWrite;
	}
	
	public String getFileToLocate()
	{
		return fileToLocate;
	}
	
	public void setFileToLocate(String fileToLocate)
	{
		this.fileToLocate = fileToLocate;
	}
	
	public String getDirectoryName()
	{
		return directoryName;
	}
	
	public void setDirectoryName(String directoryName)
	{
		this.directoryName = directoryName;
	}
	
	public String getExtName()
	{
		return extName;
	}
	
	public void setExtName(String extName)
	{
		this.extName = extName;
	}
	
	public String getFileToCopy()
	{
		return fileToCopy;
	}
	
	public void setFileToCopy(String fileToCopy)
	{
		this.fileToCopy = fileToCopy;
	}
	
	public String getNewFile()
	{
		return newFile;
	}
	
	public void setNewFile(String newFile)
	{
		this.newFile = newFile;
	}
	
	public String getFirstFile()
	{
		return firstFile;
	}
	
	public void setFirstFile(String firstFile)
	{
		this.firstFile = firstFile;
	}
	
	public String getSecondFile()
	{
		return secondFile;
	}
	
	public void setSecondFile(String secondFile)
	{
		this.secondFile = secondFile;
	}
	
	public String getFinalFile()
	{
		return finalFile;
	}
	
	public void setFinalFile(String finalFile)
	{
		this.finalFile = finalFile;
	}
	
	//searches for files in a specific directory
	public void DirSearch(File[] files)
	{
		for(File file: files)
		{
			System.out.println("File: " + file.getName());
		}
	}
			
	//searches for files in a directory and all of its sub-directories
	public void DirSubSearch(File[]files)
	{
		for(File file: files)
		{
			if(file.isDirectory())
			{
				System.out.println("Directory: " + file.getName());
				DirSubSearch(file.listFiles()); //calls same method again
			}
			else
			{
				System.out.println("File: " + file.getName());
			}
		}
	}
	
	//locates a file's path given its name
	public void FileLocator(String fileToLocate)
	{
		File file = new File(fileToLocate);
		String path = file.getAbsolutePath();
		System.out.println("The path to the file, " + fileToLocate + ", is: "+ path);
	}
	
	//locates all files with a given extension in a specific directory
	public void FindByExtn(String directoryName, String extName)
	{
		File files = new File(directoryName);
		for(File file: files.listFiles())
		{
			if(file.getName().endsWith((extName)))
			{
				System.out.println("File " + file.getName());
			}
		}
	}
	
	//concatenates the contents of 2 text files into a new file
	public void ConcatenateFile(String firstFile, String secondFile, String finalFile) throws FileNotFoundException
	{
		String output = "";
		try(Scanner sc1 = new Scanner((new File(firstFile))); Scanner sc2 = new Scanner((new File(secondFile))))
		{
			while(sc1.hasNext())
			{
				output += sc1.next() + " ";
				output +="\n";
			}
					
			while(sc2.hasNext())
			{
				output += sc2.next() + " ";
				output += "\n";
			}
		}
				
		try(PrintWriter pw = new PrintWriter(new File(finalFile)))
		{
			pw.write(output);
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Error. File not found error.");
		}
	}
	
	
	//copies a text file into a new text file
	public void CopyFile(String fileToCopy, String newFile) throws IOException
	{
		FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(fileToCopy);
            fw = new FileWriter(newFile);
            int c = fr.read();
            while(c!=-1) 
			{
                fw.write(c);
                c = fr.read();
            }
        } 
		catch(IOException e) 
		{
            e.printStackTrace();
        }
		finally
		{
			fr.close();
			fw.close();
		}
    }
	
	//writes to a file
	public void writeToLog(String logFile, String textToWrite)
	{
		try(FileWriter fw = new FileWriter(logFile, true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
		{
			out.println(textToWrite);
		} 
		
		catch(FileNotFoundException e)
		{
			System.out.println("Error. File not found.");
		}
		
		catch(IOException e)
		{
			System.out.println("Error. Unknown IO error.");
		}
	}
	
	//toString statement
	public String toString()
	{
		return "Log File Name: " + logFile + "\nText to Write: " + textToWrite + "\nFile to Locate: " + fileToLocate + "\nDirectory Name: " + directoryName + "\nExtension Name: " + extName +
			   "\nFile to Copy: " + fileToCopy + "\nNew File: " + newFile + "\nFirst file: " + firstFile + "\nSecond File: " + secondFile + "\nFinal File: " + finalFile;
	}
	
	//equals statement
	public boolean isEquals(FileNav other)
	{
			return logFile.equals(other.logFile) && textToWrite.equals(other.textToWrite) && fileToLocate.equals(other.fileToLocate) && directoryName.equals(other.directoryName) &&
				   extName.equals(other.extName) && fileToCopy.equals(other.fileToCopy) && newFile.equals(other.newFile) && firstFile.equals(other.firstFile) &&
				   secondFile.equals(other.secondFile) && finalFile.equals(other.finalFile); 
	}
}