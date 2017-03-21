/**
 * This class represents an object that represents how the contact list is printed as a whole. Also, 
 * one object of this class represents the search feature that find matches based on last name
 * and displaying them on the console. Another feature is save on exit where all contact list 
 * entries are stored in disk and reopens on the next run of the program.
 * 
 * By: DA
 */
import java.util.ArrayList; // Class for saving added contact list to an ArrayList
import java.io.FileInputStream; // Interface used for saving/opening to disk
import java.io.FileNotFoundException; // Interface used for saving/opening to disk
import java.io.FileOutputStream; // Interface used for saving/opening to disk
import java.io.IOException; // Interface used for saving/opening to disk
import java.io.ObjectInputStream; // Interface used for saving/opening to disk
import java.io.ObjectOutputStream; // Interface used for saving/opening to disk
import java.io.Serializable;// Interface used for saving/opening to disk
import java.util.Collections; // Class for sorting the ArrayList
import java.util.Comparator; // Class for sorting the ArrayList
import java.util.List; // Class for sorting the ArrayList
import java.util.Scanner;

public class AllContactList implements Serializable {
	private static final long serialVersionUID = 1L;
	private Scanner userInput;
	private ArrayList<Person> allPersonArray = new ArrayList<Person>(); // Arraylist that store one object of one person info
	
	/**
	 * This method adds a person object information to the ArrayList allPersonArray
	 * By: DA
	 */
	public boolean addContact(Person newPerson) {
		if (newPerson.getLastname().equals("")) {
			return false;
		}
		allPersonArray.add(newPerson);
		return true;
		
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
			System.out.println("\n" + allPersonArray.get(index) + "\n");
			index++;
		}
	}

	/**
	 * This method sorts the array list last name in alphabetical order. By: DA
	 */
	public void sortAllContact() {
		Collections.sort(allPersonArray);
		//System.out.println(allPersonArray);
	}

	/**
	 * This method sorts the array list first name in alphabetical order. By: DA
	 */
	public void sortFirstName() {

	}

	/**
	 * This method returns and prints the search result according to last name.
	 */
	public void searchLastName(String searchPerson) {
		boolean matchfound = false;
		for (int i = 0; i < allPersonArray.size(); i++) {
			if(searchPerson.equalsIgnoreCase(allPersonArray.toString())) {
			   System.out.println(allPersonArray.get(i).toString());
			   matchfound = true;
			}
			
			/* WORKING!!! NEED ALT.
			if (allPersonArray.get(i).matchLastname(searchPerson)) {
				System.out.println(allPersonArray.get(i).toString());
				matchfound = true;
			}*/
		}
		if (!matchfound) {
			System.out.println("\n" + "Sorry match not found.\n");
		}
	}

	/**
	 * This method saves all entries to the contact list program to disk then
	 * exits the program.
	 */
	public void save() {
		System.out.println("Writing file!");
		
		FileOutputStream outFile;
		ObjectOutputStream outObject;
		try {
			outFile = new FileOutputStream("Contactlist 2.0.sav");
			outObject = new ObjectOutputStream(outFile);
			
			outObject.writeObject(allPersonArray);
			
			outFile.close();
			outObject.close();
		} catch (IOException ioe) {
			System.out.println("Error writing objects to the file: " + ioe.getMessage());
		}

	}

	public void open() {
		System.out.println("Initializing...Please wait.");
		FileInputStream inFile;
		ObjectInputStream inObject;

		try {
			inFile = new FileInputStream("Contactlist 2.0.sav");
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
		System.out.println("Current Contact List entries: " + allPersonArray.size());
		
	}

}