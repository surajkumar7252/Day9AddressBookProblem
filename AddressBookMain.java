import java.util.*;

class ContactDetails{
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private String phoneNum;
	private String emailId;
	
	
	public ContactDetails(String firstName,String lastName,String address,String city,String state,
			        int zip,String phoneNum,String emailId) {
		
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phoneNum=phoneNum;
		this.emailId=emailId;
		
	     }


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getZip() {
		return zip;
	}


	public void setZip(int zip) {
		this.zip = zip;
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String toString() {
		return "Contact Details : "+ firstName+ " "+ lastName +"||"+ address+ "||" +city+"||"+state+"||"
				+ zip+"||"+phoneNum+"||"+emailId+";";
	}
	
}

public class AddressBookMain {
	
	public static ContactDetails[] contactDetails;
	public static int sizeOfAddressBook;
	static Scanner sc=new Scanner(System.in);
	
	public AddressBookMain() {
		contactDetails = new ContactDetails[20];
		sizeOfAddressBook = 0;
	}
	
	public void addNewContact(String firstName,String lasttName,String address,String city,String state,
			int zip,String phoneNum,String emailId) {
		
		sizeOfAddressBook=sizeOfAddressBook+1;
	}
	
	
	public static void main(String[] args) {
		AddressBookMain addressBookMain = new AddressBookMain();
		System.out.println("Adding to Address Book via Console");
		System.out.println("Enter the Details as follows :");
		System.out.println("First Name");
		System.out.println("Last Name");
		System.out.println("Address ");
		System.out.println("City ");
		System.out.println("State ");
		System.out.println("Zip ");
		System.out.println("Phone Number");
		System.out.println("Email ID");
		
		addressBookMain.addNewContact(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),
				                      Integer.parseInt(sc.nextLine()),sc.nextLine(),sc.nextLine());
		
		System.out.println(contactDetails);
	}
	

}