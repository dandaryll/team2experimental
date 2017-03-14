/**
 * This class represents an object that stores the first name, last name, email, phone, and  notes for one person.
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
	 * This methods reads userInput for firstname, lastname, address, email address,
	 * phone, and notes user input for Person class private data member
	 * variables
	 */
	public boolean read() {
		Scanner userInput;
		userInput = new Scanner(System.in);
		
		// Setters
		System.out.print("First name: ");
		String newFirstname = userInput.nextLine();
		setFirstname(newFirstname);
		System.out.print("Last name: ");
		newLastname = userInput.nextLine();
		if (newLastname.equals("")) {
			return false;
		}
		setLastname(newLastname);
		readAddress();
		System.out.print("E-mail: ");
		String newEmail = userInput.nextLine();
		setEmail(newEmail);
		System.out.print("Phone: ");
		String newPhone = userInput.nextLine();
		setPhone(newPhone);
		System.out.print("Notes: ");
		String newNotes = userInput.nextLine();
		setNotes(newNotes);
		return true;
	}
	
	/**
	 * This methods reads userInput for house, city, state, and zip. userInput
	 * for Address class private data member variables
	 */
	public void readAddress() {
		Scanner userInput;
		userInput = new Scanner(System.in);
		System.out.print("House: ");
		String newHouse = userInput.nextLine();
		setHouse(newHouse);
		System.out.print("City: ");
		String newCity = userInput.nextLine();
		setCity(newCity);
		System.out.print("State: ");
		String newState = userInput.nextLine();
		setState(newState);
		System.out.print("Zip: ");
		String newZip = userInput.nextLine();
		setZip(newZip);
		
	}
	
	/**
	 * Sets the value for firstname to "newFirstname". By: DA
	 */
	public void setFirstname(String newFirstname) {
		firstName = newFirstname;
		
	}

	/**
	 * Sets the value for lastname to "newLastname". By: DA
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
	public void setHouse(String newHouse) {
		house = newHouse;
		
	}

	/**
	 * Sets the value for city to "newCity".
	 * By: DA
	 */
	public void setCity(String newCity) { // newCity is a parameter
		city = newCity;
		
	}

	/**
	 * Sets the value for state to "newState".
	 * By: DA
	 */
	public void setState(String newState) { // newState is a parameter
		state = newState;
	}

	/**
	 * Sets the value for zip to "newZip".
	 * By: DA
	 */
	public void setZip(String newZip) { // newZip is a parameter
		zip = newZip;
	}

	/**
	 * Sets the value for email to "newEmail". By: DA
	 */
	public boolean setEmail(String newEmail) {
		if (newEmail.contains("@") && newEmail.contains(".")) {
			email = newEmail;
			return true;
		}
		else {
			System.out.println("Invalid email!");
			return false;
		}

	}

	/**
	 * Sets the value for phone to "newPhone". By: DA
	 */
	public void setPhone(String newPhone) {
		
		if (newPhone.length() > 10) {
			
			newPhone = newPhone.substring(0, 3) + "-" + newPhone.substring(3, 6) + "-" + newPhone.substring(6, newPhone.length());
			phone = newPhone;
			
		}
		else if (newPhone.length() == 10) {
			newPhone = newPhone.substring(0, 3) + "-" + newPhone.substring(3, 6) + "-" + newPhone.substring(6, newPhone.length());
			phone = newPhone;
			
		}

	}

	/**
	 * Sets the value for notes to "newNotes". By: DA
	 */
	public void setNotes(String newNotes) {
		notes = newNotes;
	}

	/**
	 * Returns the value of firstname. By: DA
	 */
	public String getFirstname() {
		return firstName;
	}

	/**
	 * Returns the value of lastname. By: DA
	 */
	public String getLastname() {
		return lastName;
	}
	
	/**
	 * Returns the value of house.
	 * By: DA
	 */
	public String getHouse () {
		return house;
	}
	
	/**
	 * Returns the value of city.
	 * By: DA
	 */
	public String getCity () {
		return city;
	}
	
	/**
	 * Returns the value of state.
	 * By: DA
	 */
	public String getState () {
		return state;
	}
	
	/**
	 * Returns the value of zip.
	 * By: DA
	 */
	public String getZip () {
		return zip;
	}

	/**
	 * Returns the value of email. By: DA
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Returns the value of phone. By: DA
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Returns the value of zip. By: DA
	 */
	public String getNotes() {
		return notes;
	}
	
	public String toString() { 
		return "Name: " + firstName + " " + lastName + "\n" + "Address: " + house + " " + city + ", " +
			   state + " " + zip + "\n" + "E-mail: " + email + "\n" + "Phone: " + phone + "\n" + "Notes: " + notes;
	}

	@Override
	public int compareTo(Person otherPerson) {
		if (this.lastName.equalsIgnoreCase(otherPerson.lastName)) {
			return this.firstName.compareTo(otherPerson.firstName);
		}
		
		return this.lastName.compareTo(otherPerson.lastName);
	}

}