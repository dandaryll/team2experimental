/**
 * This program allows a user to enter a new person into a contact list, print the entire contact list in the console,
 * search a person's information by last name, saves sessions on exit, and start the program again with saved info.
 *  
 * By: DA
 */
import java.util.Scanner;

public class TestContactList {

	public static void main(String[] args) {
		System.out.println("Welcome to the ContactLister2.0!");
		// Object contactsEdit from class AllContactList
		//AllContactList addressbook;
		//addressbook = new AllContactList();

		// FIXME: IF you move save method first, error would be eliminated
		//addressbook.open(datafile);

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
		
		showMenu();
		
		//System.out.println("Calling method to save/open");

		//addressbook.save(datafile);

		//addressbook.open(datafile);

		// userInput.close();

		System.out.println("Reached the end of main(), Program ran successfully.");

	}

	public static void showMenu() {
		final String datafile = "Contactlist 2.0.sav";
		Scanner userInput;
		userInput = new Scanner(System.in);
		Person newContact1;
		AllContactList addressbook;
		addressbook = new AllContactList();
		String menuchoice;
		boolean done = false;
		
		addressbook.open(datafile);
		
		while (!done) {
			System.out.println("Show menu method call!");

			System.out.print("[1] Add contact\n" + "[2] Print the contact list\n" + "[3] Search contact information\n"
							 + "[4] Quit the program\n" + "Please select an option from the above menu: ");

			menuchoice = userInput.nextLine();
			switch (menuchoice) {
			case "1":
				newContact1 = new Person();
				newContact1.read();
				System.out.println("Adding contact!");
				addressbook.addContact(newContact1);
				System.out.println();
				addressbook.printToConsole();
				System.out.println("Sorting list!");
				addressbook.sortAllContact();
				done = false;
				break;
			case "2":
				addressbook.printToConsole();
				System.out.println();
				//System.out.println("Printing list printToConsole.");
				addressbook.sortAllContact();
				done = false;
				break;
			case "3":
				addressbook.save(datafile);
				done = true;
				break;
			case "4":
				System.out.print("\nEnter last name to search: ");
				String searchPerson = userInput.nextLine();
				System.out.println("Search results: ");
				addressbook.searchLastName(searchPerson);
				done = false;
				break;
			default:
				System.out.println("Please select from 1-3");
				done = false;
				break;

			}
		
		}
	}

}