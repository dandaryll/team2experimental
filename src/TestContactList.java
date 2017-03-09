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
		
		// FIXME: Opens saved contact list if any -- HAS ERROR IF FILE NOT FOUND!
		addressbook.open(datafile);
		
		// Object person1 from class Person
		Person person1;
		person1 = new Person();
		//person1.read(); // adds first contact
		if (person1.read()) {
			addressbook.addContact(person1); // adds to arraylist allPersonArray
		}
		else {
			System.out.println("Sorry your contact has not been added!");
		}
		
		// Object person2 from class Person
		Person person2;
		person2 = new Person();
		//person2.read(); // add second contact
		if (person2.read()) {
			addressbook.addContact(person2); // adds to arraylist allPersonArray
		}
		else {
			System.out.println("Not added!");
		}
		
		//System.out.print(person1.toString());
		System.out.println("Here's the contact list: ");
		//contactsEdit.readPerson();
		//contactsEdit.readPerson();
		
		//System.out.println(contactsEdit.toString());
		addressbook.printToConsole();
		//contactsEdit.sortFirstName();
		//contactsEdit.sortLastName();
		addressbook.searchLastName();
		
		//contactsEdit.addContactTest();
		
		
		System.out.println("Calling method to save/open");
		
		addressbook.save(datafile);
		
		
		
		addressbook.open(datafile);
		
		

		userInput.close();

		System.out.println("Reached the end of main(), Program ran successfully.");

	}
}