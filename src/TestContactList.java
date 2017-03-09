/**
 * This program allows a user to enter a new person into a contact list, print the entire contact list in the console,
 * search a person's information by last name, saves sessions on exit, and start the program again with saved info.
 *  
 * By: DA
 */
import java.util.Scanner;

public class TestContactList {

	public static void main(String[] args) {
		final String datafile = "Contactlist 2.0.sav";
		
		// Object userInput from class Scanner
		Scanner userInput;
		userInput = new Scanner(System.in);
		
		// Object contactsEdit from class AllContactList
		AllContactList addressbook;
		addressbook = new AllContactList();
		
		addressbook.open(datafile);
		
		// Object person1 from class Person
		Person person1;
		person1 = new Person();
		if (person1.read()) { // add first contact
			addressbook.addContact(person1); // adds to arraylist allPersonArray
		}
		else {
			System.out.println("Contact information not saved. Last name required.");
		}
		
		// Object person2 from class Person
		Person person2;
		person2 = new Person();
		if (person2.read()) { // add second contact
			addressbook.addContact(person2); // adds to arraylist allPersonArray
		}
		else {
			System.out.println("Contact information not saved. Last name required.");
		}
		
		System.out.println("Here's the contact list: ");
		
		addressbook.printToConsole();
		addressbook.sortFirstName();
		addressbook.sortLastName();
		addressbook.searchLastName();
		
		System.out.println("Calling method to save/open");
		
		addressbook.save(datafile);
		
		addressbook.open(datafile);
		
		userInput.close();

		System.out.println("Reached the end of main(), Program ran successfully.");

	}
}