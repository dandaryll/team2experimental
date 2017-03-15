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

		showMenu();

		// Object contactsEdit from class AllContactList
		//AllContactList addressbook2;
		//addressbook2 = new AllContactList();

		// FIXME: IF you move save method first, error would be eliminated
		// addressbook.open(datafile);

		// Object person1 from class Person
		/*
		Person person1;
		person1 = new Person();
		if (person1.read()) { // add first contact
			addressbook2.addContact(person1); // adds to arraylist allPersonArray
		} else {
			System.out.println("Contact information not saved. Last name required.");
		}*/

		// Object person2 from class Person
		/*
		Person person2;
		person2 = new Person();
		if (person2.read()) { // add second contact
			addressbook2.addContact(person2); // adds to arraylist allPersonArray
		} else {
			System.out.println("Contact information not saved. Last name required.");
		}

		// Object person2 from class Person
		Person person3;
		person3 = new Person();
		if (person3.read()) { // add second contact
			addressbook2.addContact(person3); // adds to arraylist allPersonArray
		} else {
			System.out.println("Contact information not saved. Last name required.");
		}*/

		// System.out.println("Here's the contact list: ");

		// addressbook.printToConsole();
		// System.out.println("Here's the sorted contact list: ");
		//addressbook2.sortFirstName();
		//addressbook2.sortAllContact();
		//addressbook2.searchLastName();

		System.out.println("Calling method to save/open");

		// addressbook.save(datafile);

		// addressbook.open(datafile);

		// userInput.close();

		System.out.println("Reached the end of main(), Program ran successfully.");

	}

	public static void showMenu() {
		Scanner userInput;
		userInput = new Scanner(System.in);
		Person newContact1;
		AllContactList addressbook;
		addressbook = new AllContactList();
		int menuchoice;
		boolean done = false;
		
		while (!done) {
			System.out.println("Show menu method call!");

			System.out.println("Enter 1 to add contact. \n" + "Enter 2 to print list. \n" + "Enter 3 to exit.");

			menuchoice = userInput.nextInt();
			switch (menuchoice) {
			case 1:
				newContact1 = new Person();
				newContact1.read();
				System.out.println("Adding contact!");
				addressbook.addContact(newContact1);
				addressbook.printToConsole();
				System.out.println("Printing list printToConsole.");
				addressbook.sortAllContact();
				done = false;
				break;
			case 2:
				addressbook.printToConsole();
				System.out.println("Printing list printToConsole.");
				addressbook.sortAllContact();
				done = false;
				break;
				
			case 3:
				done = true;
				break;
			default:
				System.out.println("Please select from 1-3");
				done = false;
				break;

			}
		
		}
	}

}