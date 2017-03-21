/**
 * This program allows a user to enter a new person into a contact list, print the entire contact list in the console,
 * search a person's information by last name, saves sessions on exit, and start the program again with saved info.
 *  
 * By: DA
 */
import java.util.Scanner;

public class TestContactList {
	static Scanner userInput = new Scanner(System.in);
	static AllContactList addressbook = new AllContactList();
	static Person newContact;
	static String menuChoice;

	public static void main(String[] args) {
		System.out.println("Welcome to the ContactLister2.0!");
		
		showMenu();

		System.out.println("Reached the end of main(), Program ran successfully.");
		System.out.println("Thank you for using the ContactLister2.0!");
	}
	
	/**
	 * NOTE: CURRENTLY HAVE 29 LINES!
	 */
	public static void showMenu() {
		boolean done = false;
		addressbook.open(); // Opens existing ContactList file if any
		
		while (!done) {
			System.out.print("[1] Add contact\n" + "[2] Print the contact list\n" + "[3] Search contact information\n"
							 + "[4] Quit the program\n" + "Please select an option from the above menu: ");
			
			menuChoice = userInput.nextLine();
			switch (menuChoice) {
			case "1":
				newContact = new Person();
				newContact.read();
				addressbook.addContact(newContact);
				addressbook.sortAllContact();
				break;
			case "2":
				addressbook.printToConsole();
				break;
			case "3":
				System.out.print("\nEnter last name to search: ");
				String searchPerson = userInput.nextLine();
				System.out.println("Search results: ");
				addressbook.searchLastName(searchPerson);
				break;
			case "4":
				addressbook.save();
				done = true;
				break;
			default:
				System.out.println("Please select from 1-3");
				break;
			}
		}
	}
}