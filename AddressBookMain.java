package addressbookday9;



import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ContactDetails{
	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String state;
	public int zip;
	public String phoneNum;
	public String emailId;
	
	
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
	public LinkedList<ContactDetails> contactLinkedListDetails;
	public Map<String,ContactDetails> nameKeyInMap;
	
	static Scanner detailInput=new Scanner(System.in);
	private static final Logger logger = LogManager.getLogger(AddressBookMain.class);
	
	public AddressBookMain() {
		this.contactLinkedListDetails = new LinkedList<ContactDetails>();
		this.nameKeyInMap= new HashMap<String,ContactDetails>();
	}
	
		
	
	public void addNewContact(ContactDetails contactDetail) {
		
		logger.debug("enter the number of contacts to be fed: ");
		int numOfContacts=detailInput.nextInt();
		String firstName,lastName;
		logger.debug("enter the first name to be fed: ");
		firstName=detailInput.nextLine();
		logger.debug("enter the last name to be fed: ");
		lastName=detailInput.nextLine();
		
		for(int indexOfContact=0;indexOfContact<numOfContacts;indexOfContact++) {
			for(int index = 0;index < indexOfContact; index++) 
				if(contactLinkedListDetails.get(index).firstName.equals(firstName) && contactLinkedListDetails.get(index).lastName.equals(lastName)) {
					System.out.println("Name already present");
					
				}
			
			}contactLinkedListDetails.add(contactDetail);
			nameKeyInMap.put(contactDetail.getFirstName()+" ", contactDetail);
			
		
		}
		
		
		
	
	
	public void editContactDetails(String testName,String testAddress,String testCity,String testState,
			int testZip,String testPhoneNum,String testEmailId) {
		nameKeyInMap.get(testName).setAddress(testAddress);
		System.out.println("Setting Address.");
		nameKeyInMap.get(testName).setCity(testCity);
		System.out.println("Setting City.");
		
		nameKeyInMap.get(testName).setState(testState);
		System.out.println("Setting State.");
		
		nameKeyInMap.get(testName).setZip(testZip);
		System.out.println("Setting Zip.");
		
		nameKeyInMap.get(testName).setPhoneNum(testPhoneNum);
		System.out.println("Setting Phone Number.");
		
		nameKeyInMap.get(testName).setEmailId(testEmailId);
		System.out.println("Setting Email-Id.");
		
		
		
   }
			     
			
	
	public void deleteContactDetails(String testName) {
		
		
		contactLinkedListDetails.remove(nameKeyInMap.get(testName));
		
    }
	
	
	public static void main(String[] args) {
		AddressBookMain addressBookMain = new AddressBookMain();
		String choice;
		do {
			
		System.out.println("Select what operation you want to perform== ");
		System.out.println("1.Adding the details");
		System.out.println("2.Editing the details");
		System.out.println("3.Deleting the details");
		
		int option=detailInput.nextInt();
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
		         ContactDetails contactDetails=new ContactDetails(detailInput.nextLine(),detailInput.nextLine(),detailInput.nextLine(),detailInput.nextLine(),detailInput.nextLine(),
	                      Integer.parseInt(detailInput.nextLine()),detailInput.nextLine(),detailInput.nextLine());
		
		         addressBookMain.addNewContact(contactDetails);
		         break;
		case 2: System.out.println("Enter the first name of that person whose data has to be edited == " );
                String testName=detailInput.nextLine();
                System.out.println("enter the data of that person as follows");
                System.out.println("First Name");
		        System.out.println("Last Name");
		        System.out.println("Address ");
		        System.out.println("City ");
		        System.out.println("State ");
		        System.out.println("Zip ");
		        System.out.println("Phone Number");
		        System.out.println("Email ID");
		
		        addressBookMain.editContactDetails(detailInput.nextLine(),detailInput.nextLine(),detailInput.nextLine(),detailInput.nextLine(),
                                       Integer.parseInt(detailInput.nextLine()),detailInput.nextLine(),detailInput.nextLine());
		        System.out.println("The details has been updated.");
		        break;
		case 3:System.out.println("Enter the first name of that person whose data has to be DELETED == " );
               String Name=detailInput.nextLine();
        
		       addressBookMain.deleteContactDetails(Name);
		       System.out.println("The details has been updated.");
		       break;
		      
		default: System.out.println("Wrong option selected");
	
		}System.out.println("Do you want to perform again(yes/no)== ");
		 choice =detailInput.nextLine();
		
	}while(choice =="y");

        
	}
	

}