/**
 * This class represents an object that represents how the contact list is printed as a whole. Also, 
 * one object of this class represents the search feature that find matches based on last name
 * and displaying them on the console. Another feature is save on exit where all contact list 
 * entries are stored in disk and reopens on the next run of the program.
 * 
 * By: DA
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;// Interface used for saving to disk

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AllContactList implements Serializable, Comparator<Person> {
	private static final long serialVersionUID = 1L;
	private List<Person> allPersonArray = new ArrayList<Person>(); // Arraylist that store one object of one person info
	
	/**
	 * This method adds a person object information to the ArrayList allPersonArray
	 * By: DA
	 */
	public void addContact(Person newPerson) {
		allPersonArray.add(newPerson);
		
	}

	// FIXME: Not sure if needed and what to comment
	/**
	 * This method defines a toString method. Display all
	 */
	public String toString() {
		return "";
	}

	/**
	 * This method returns and prints all entries of the contact list sorted
	 * alphabetically.
	 */
	public void printToConsole() {
		int index = 0;
		while (allPersonArray.size() > index) {
			System.out.println(allPersonArray.get(index));
			index++;
		}
	}

	/**
	 * This method sorts the array list last name in alphabetical order. By: DA
	 */
	public void sortLastName() {
		Collections.sort(allPersonArray);
		System.out.println(allPersonArray);
	}

	/**
	 * This method sorts the array list first name in alphabetical order. By: DA
	 */
	public void sortFirstName() {

	}

	/**
	 * This method returns and prints the search result according to last name.
	 */
	public String searchLastName() {
		return "";
	}

	/**
	 * This method saves all entries to the contact list program to disk then
	 * exits the program.
	 */
	public void save(String filename) {
		System.out.println("Writing file!");
		
		FileOutputStream outFile;
		ObjectOutputStream outObject;
		try {
			outFile = new FileOutputStream(filename);
			outObject = new ObjectOutputStream(outFile);
			
			outObject.writeObject(allPersonArray);
			
			outFile.close();
			outObject.close();
		} catch (IOException ioe) {
			System.out.println("Error writing objects to the file: " + ioe.getMessage());
		}

	}

	public void open(String filename) {
		
		System.out.println("Reading File!");
		
		
		FileInputStream inFile;
		ObjectInputStream inObject;

		try {
			inFile = new FileInputStream(filename);
			inObject = new ObjectInputStream(inFile);
			
			allPersonArray = (ArrayList<Person>)inObject.readObject();
			
			inObject.close();
			inFile.close();
		}
		catch (FileNotFoundException fnf) {
			return;
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			return;
		}
		catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Read file:\n" + allPersonArray);
		
	}

	@Override
	public int compare(Person p1, Person p2) {
		
		return p1.compareTo(p2);
	}

}