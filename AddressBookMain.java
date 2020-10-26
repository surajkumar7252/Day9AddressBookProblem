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
	
	public void editContactDetails(String testName,String testAddress,String testCity,String testState,
			int testZip,String testPhoneNum,String testEmailId) {
		
		for(int index=0;index<sizeOfAddressBook;index++) {
			     if(contactDetails[index]==null)
			     continue;
			     if(testName.equals(contactDetails[index].getFirstName())) {
			      
			    	 contactDetails[index].setAddress(testAddress);
			    	 contactDetails[index].setCity(testCity);
			    	 contactDetails[index].setState(testState);
			    	 contactDetails[index].setZip(testZip);
			    	 contactDetails[index].setPhoneNum(testPhoneNum);
			    	 contactDetails[index].setEmailId(testEmailId);
			    	
			     }
			     
		}
	}
	
	public void deleteContactDetails(String testName) {
		
		for(int index =0;index<sizeOfAddressBook;index++) {
			if(contactDetails[index]==null)
			     continue;
			     if(testName.equals(contactDetails[index].getFirstName())) {
			    	 {
			    		 contactDetails[index]=null;
			    		 sizeOfAddressBook=sizeOfAddressBook-1;
			    	 }
		}
	}
 }
	
	public static void main(String[] args) {
		AddressBookMain addressBookMain = new AddressBookMain();
		String choice;
		do {
			
		System.out.println("Select what operation you want to perform== ");
		System.out.println("1.Adding the details");
		System.out.println("2.Editing the details");
		System.out.println("3.Deleting the details");
		
		int option=sc.nextInt();
		switch(option)
		{
		case 1:  
		         System.out.println("Editing Address Book via Console");
		         System.out.println("Enter the Details to be added as follows :");
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
		         break;
		case 2: System.out.println("Enter the first name of that person whose data has to be edited == " );
                String testName=sc.nextLine();
                System.out.println("enter the data of that person as follows");
                System.out.println("First Name");
		        System.out.println("Last Name");
		        System.out.println("Address ");
		        System.out.println("City ");
		        System.out.println("State ");
		        System.out.println("Zip ");
		        System.out.println("Phone Number");
		        System.out.println("Email ID");
		
		        addressBookMain.editContactDetails(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),
                                       Integer.parseInt(sc.nextLine()),sc.nextLine(),sc.nextLine());
		        System.out.println("The details has been updated.");
		        break;
		case 3:System.out.println("Enter the first name of that person whose data has to be DELETED == " );
               String Name=sc.nextLine();
        
		       addressBookMain.deleteContactDetails(Name);
		       System.out.println("The details has been updated.");
		       break;
		      
		default: System.out.println("Wrong option selected");
	
		}System.out.println("Do you want to perform again(yes/no)== ");
		 choice =sc.nextLine();
		
	}while(choice =="y");

        
	}
	

}