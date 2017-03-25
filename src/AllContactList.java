/**
 * FIXME: COMMENT NEEDS TO BE REVISED BASED ON ELAINE'S FEEDBACK 3/21/17 12:54PM
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
	 * By: JT
	 */
	public void addContact(Person newPerson) {
		if (newPerson.getLastname().equals("")) {
			return;
		}
		allPersonArray.add(newPerson);
		
	}

	// FIXME: Not sure if needed and what to comment
	/**
	 * This method defines a toString method. Display all
	 * 
	 * By: MM
	 */
	public String toString() {
		return "";
	}

	/**
	 * This method returns and prints all entries of the contact list sorted alphabetically.
	 * 
	 * By: JT
	 */
	public void printToConsole() {
		int index = 0;
		while (allPersonArray.size() > index) {
			System.out.println("\n" + allPersonArray.get(index) + "\n");
			index++;
		}
	}

	/**
	 * This method sorts the array list last name elements in alphabetical order.
	 * By: JT
	 */
	public void sortAllContact() {
		Collections.sort(allPersonArray);
		//System.out.println(allPersonArray);
	}

	/**
	 * This method prints the search result according to the userInput last name.
	 * 
	 * By: MM
	 */
	public void searchLastName(String searchPerson) {
		boolean matchfound = false;
		
		for (int i = 0; i < allPersonArray.size(); i++) {
			/*
			if(searchPerson.equalsIgnoreCase(allPersonArray.toString())) {
			   System.out.println(allPersonArray.get(i).toString());
			   matchfound = true;
			}
			*/
			
			// WORKING!!! NEED ALT.
			if (allPersonArray.get(i).matchLastname(searchPerson)) {
				System.out.println("\n" + allPersonArray.get(i).toString() + "\n");
				matchfound = true;
			}
		}
		if (!matchfound) {
			System.out.println("\n" + "Sorry match not found.\n");
			matchfound = false;
		}
	}
	/* Below is Nat experimental
	public Person searchByLastName (String searchLastname) {

		//String givenLastName = userInput.nextLine();

		for (int i = 0; i < allPersonArray.size(); i++) {

			//Person foundByLastName = allPersonArray.get(i);

			if (allPersonArray.get(i).getLastname().equalsIgnoreCase(searchLastname)) {

				//foundByLastName = allPersonArray.get(i);

				return allPersonArray.get(i++);

			}


		}
		return null;
	}
	*/

	/**
	 * This method saves all entries to the contact list program to disk.
	 * 
	 * By: DA
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
	
	/**
	 * This method reads the saved file when the program starts
	 * 
	 * By: DA
	 */
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