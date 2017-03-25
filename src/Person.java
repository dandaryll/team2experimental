/**
 * This class represents an object that stores the first name, last name, house, city, state, zip, email, phone, and  notes for one person.
 * 
 * By: DA
 */
import java.util.Scanner;
import java.io.Serializable; // Interface used for saving and opening to disk
import java.util.Collections;
import java.util.Comparator;

public class Person implements Serializable, Comparable<Person> {
	private String firstName;
	private String lastName;
	private String house;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String phone;
	private String notes;
	private String newLastname;
	
	/**
	 * Default constructor to initialize private data members
	 * 
	 * By: DA
	 */
	public Person() {
		firstName   = "";
		lastName    = "";
		house       = "";
		city        = "";
		state       = "";
		zip         = "";
		email       = "";
		phone       = "";
		notes       = "";
		newLastname = "";
		
	}
	
	/**
	 * This method reads userInput and prompts user to assign values to firstName, lastName,
	 * email, phone and notes
	 * 
	 * By: MM
	 */
	public boolean read() {
		Scanner userInput;
		userInput = new Scanner(System.in);
		
		// Setters
		System.out.print("First name or Press [0] to cancel: ");
		String newFirstname = userInput.nextLine();
		if (newFirstname.equalsIgnoreCase("0"))
			return false;
		System.out.print("Last name or Press [0] to cancel: ");
		newLastname = userInput.nextLine();
		if (newLastname.equals("") || newLastname.equalsIgnoreCase("0")) {
			System.out.println("Contact information not added. Last name required.");
			return false;
		}
		setFirstname(newFirstname);
		setLastname(newLastname);
		readAddress();
		System.out.print("E-mail or Press [0] to cancel: ");
		String newEmail = userInput.nextLine();
		if (newEmail.equalsIgnoreCase("0"))
			return false;
		setEmail(newEmail);
		System.out.print("Phone or Press [0] to cancel: ");
		String newPhone = userInput.nextLine();
		if (newPhone.equalsIgnoreCase("0"))
			return false;
		setPhone(newPhone);
		System.out.print("Notes or Press [0] to cancel: ");
		String newNotes = userInput.nextLine();
		if (newNotes.equalsIgnoreCase("0"))
			return false;
		setNotes(newNotes);
		System.out.println("Contact information has been added successfully!");
		return true;
	}
	
	/**
	 * This methods reads userInput for address section which are the house, city, state, and zip.
	 * 
	 * By: DA
	 */
	public void readAddress() {
		Scanner userInput;
		userInput = new Scanner(System.in);
		System.out.print("House or Press [0] to cancel: ");
		String newHouse = userInput.nextLine();
		setHouse(newHouse);
		System.out.print("City or Press [0] to cancel: ");
		String newCity = userInput.nextLine();
		setCity(newCity);
		System.out.print("State or Press [0] to cancel: ");
		String newState = userInput.nextLine();
		setState(newState);
		System.out.print("Zip or Press [0] to cancel: ");
		String newZip = userInput.nextLine();
		setZip(newZip);
	}
	
	/**
	 * Sets the value for firstname to "newFirstname".
	 * By: DA
	 */
	public boolean setFirstname(String newFirstname) {
		//  removed
		if (newFirstname.equalsIgnoreCase("0")) {
			TestContactList.showMenu();
			return false;
		}
		firstName = newFirstname;
		return true;
		
	}

	/**
	 * Sets the value for lastname to "newLastname".
	 * By: DA
	 */
	public boolean setLastname(String newLastname) {
		if (newLastname.equals("")) {
			System.out.println("Contact not added. Last name required.");
			return false;
		}
		else {
			lastName = newLastname;
			return true;
		}
		
	}
	
	/**
	 * This method Sets the value for house to "newHouse".
	 * By: DA
	 */
	public boolean setHouse(String newHouse) {
		if (newHouse.equalsIgnoreCase("0")) {
			TestContactList.showMenu();
			return false;
		}
		house = newHouse;
		return true;
	}

	/**
	 * Sets the value for city to "newCity".
	 * By: DA
	 */
	public boolean setCity(String newCity) { // newCity is a parameter
		if (newCity.equalsIgnoreCase("0")) {
			TestContactList.showMenu();
			return false;
		}
		city = newCity;
		return true;
	}

	/**
	 * Sets the value for state to "newState".
	 * By: DA
	 */
	public boolean setState(String newState) { // newState is a parameter
		if (newState.equalsIgnoreCase("0")) {
			TestContactList.showMenu();
			return false;
		}
		state = newState;
		return true;
	}

	/**
	 * Sets the value for zip to "newZip".
	 * By: MM
	 */
	public boolean setZip(String newZip) { // newZip is a parameter
		if (newZip.equalsIgnoreCase("0")) {
			TestContactList.showMenu();
			return false;
		}
		zip = newZip;
		return true;
	}

	/**
	 * Sets the value for email to "newEmail".
	 * By: MM
	 */
	public boolean setEmail(String newEmail) {
		Scanner userInput;
		userInput = new Scanner(System.in);
		if (newEmail.equalsIgnoreCase("0")) {
			TestContactList.showMenu();
			return false;
		}
		else if (newEmail.contains("@") && newEmail.contains(".")) {
			email = newEmail;
			return true;
		}
		else {
			System.out.println("Invalid email, please try again with correct format!");
			System.out.print("Re-enter e-mail: ");
			newEmail = userInput.nextLine();
			phone = newEmail;
			return true;
		}

	}

	/**
	 * Sets the value for phone to "newPhone".
	 * By: MM
	 */
	public boolean setPhone(String newPhone) {
		Scanner userInput;
		userInput = new Scanner(System.in);
		if (newPhone.equalsIgnoreCase("0")) {
			TestContactList.showMenu();
			return false;
		}
		else if (newPhone.length() > 13) {
			phone = newPhone;
			return true;
		}
		else if (newPhone.length() == 10) {
			newPhone = newPhone.substring(0, 3) + "-" + newPhone.substring(3, 6) + "-" + newPhone.substring(6, newPhone.length());
			phone = newPhone;
			return true;
		}
		else {
			System.out.println("Invalid phone format, please use \"###-###-####\"");
			System.out.print("Re-enter phone: ");
			newPhone = userInput.nextLine();
			phone = newPhone;
			return true;
		}

	}

	/**
	 * Sets the value for notes to "newNotes".
	 * By: MM 
	 */
	public boolean setNotes(String newNotes) {
		if (newNotes.equalsIgnoreCase("0")) {
			TestContactList.showMenu();
			return false;
		}
		notes = newNotes;
		return true;
	}

	/**
	 * Returns the value of firstname.
	 * By: MM
	 */
	public String getFirstname() {
		return firstName;
	}

	/**
	 * Returns the value of lastname.
	 * By: MM
	 */
	public String getLastname() {
		return lastName;
	}
	
	/**
	 * Returns the value of house.
	 * By: MM
	 */
	public String getHouse () {
		return house;
	}
	
	/**
	 * Returns the value of city.
	 * By: JT
	 */
	public String getCity () {
		return city;
	}
	
	/**
	 * Returns the value of state.
	 * By: JT
	 */
	public String getState () {
		return state;
	}
	
	/**
	 * Returns the value of zip.
	 * By: JT
	 */
	public String getZip () {
		return zip;
	}

	/**
	 * Returns the value of email.
	 * By: JT
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Returns the value of phone.
	 * By: JT
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Returns the value of zip.
	 * By: JT
	 */
	public String getNotes() {
		return notes;
	}
	
	/**
	 * This method returns the lastname that matches the search query from main "lastNameToMatch" and acts as a boolean so it can be used
	 * for the searchLastname method in class AllContactList.
	 * By: JT
	 */
	public boolean matchLastname(String lastNameToMatch) {
		return (this.lastName.equalsIgnoreCase(lastNameToMatch));
	}
	
	/**
	 * This method returns a toString of all the private data members in class Person e.g. firstName, lastName, house, city, state,
	 * zip, email, phone, and notes.
	 * By: JT
	 */
	public String toString() { 
		return "Name: " + firstName + " " + lastName + "\n" + "Address: " + house + " " + city + ", " +
			   state + " " + zip + "\n" + "E-mail: " + email + "\n" + "Phone: " + phone + "\n" + "Notes: " + notes;
	}
	
	/**
	 * FIXME: COMMENT NEEDS TO BE REVISED BASED ON ELAINE'S FEEDBACK 3/21/17 12:54PM
	 * One of the methods that calls this methods is Collections.sort in class AllContactList used for alphabetizing lastnames and firstnames.
	 * When this.lastname object occurs before alphabetically compared to the otherPerson.lastName object it will return a positive number.
	 * However, when this.lastname object is alphabetically ordered after the otherPerson.lastName it will return a negative number.
	 * Then, if the the two objects compared "this.lastName" and "otherPerson.lastName" are equal it will return a "0" value.
	 * By: JT
	 */
	@Override
	public int compareTo(Person otherPerson) {
		if (this.lastName.equalsIgnoreCase(otherPerson.lastName)) {
			return this.firstName.compareTo(otherPerson.firstName);
		}
		
		return this.lastName.compareTo(otherPerson.lastName);
	}

}