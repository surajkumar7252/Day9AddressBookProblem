package addressbookday9;



import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.*;

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
	public static Map<String,ContactDetails> cityKeyToEntryMap;
	public static Map<String,ContactDetails> stateKeyToEntryMap;
	public static Map<String,ContactDetails> nameKeyToEntryMap;
	
	
	static Scanner detailInput=new Scanner(System.in);
	private static final Logger logger = LogManager.getLogger(AddressBookMain.class);
	
	public AddressBookMain() {
		this.contactLinkedListDetails = new LinkedList<ContactDetails>();
		cityKeyToEntryMap= new HashMap<String,ContactDetails>();
		stateKeyToEntryMap= new HashMap<String,ContactDetails>();
		nameKeyToEntryMap= new HashMap<String,ContactDetails>();
		
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
			nameKeyToEntryMap.put(contactDetail.getFirstName()+" ", contactDetail);
			
		
		}
		
		
		
	
	
	public void editContactDetails(String testName,String testAddress,String testCity,String testState,
			int testZip,String testPhoneNum,String testEmailId) {
		nameKeyToEntryMap.get(testName).setAddress(testAddress);
		System.out.println("Setting Address.");
		nameKeyToEntryMap.get(testName).setCity(testCity);
		System.out.println("Setting City.");
		
		nameKeyToEntryMap.get(testName).setState(testState);
		System.out.println("Setting State.");
		
		nameKeyToEntryMap.get(testName).setZip(testZip);
		System.out.println("Setting Zip.");
		
		nameKeyToEntryMap.get(testName).setPhoneNum(testPhoneNum);
		System.out.println("Setting Phone Number.");
		
		nameKeyToEntryMap.get(testName).setEmailId(testEmailId);
		System.out.println("Setting Email-Id.");
		
		
		
   }
			     
			
	
	public void deleteContactDetails(String testName) {
		
		
		contactLinkedListDetails.remove(nameKeyToEntryMap.get(testName));
		
    }
	
	private static void searchingContactsByGivenCity(String testCity) {
		logger.debug(cityKeyToEntryMap.get(testCity));
		}

	private static void  searchingContactsByGivenState(String testState) {
		logger.debug(stateKeyToEntryMap.get(testState));
		
	}

	
	private static void  ContactByCity() {
		Set<String> cityList = cityKeyToEntryMap.keySet();
		for(String nameOfCity : cityList) {
			System.out.println("Contact as per  city : " + nameOfCity);
			searchingContactsByGivenCity(nameOfCity);
		}
	}
	
	private static void  ContactByState() {
		Set<String> stateList = stateKeyToEntryMap.keySet();
		for(String nameOfState : stateList) {
			System.out.println("Contact as per  State: " + nameOfState);
			searchingContactsByGivenState(nameOfState);
		}
	}
	
	
	private static void CountByCity() {
		Set<String> cityList = cityKeyToEntryMap.keySet();
		for(String nameOfCity : cityList) {
			System.out.println("Number of contact for" + nameOfCity + " " + cityKeyToEntryMap.get(nameOfCity));
		}
	}

	private static void CountByState() {
		Set<String> stateList = stateKeyToEntryMap.keySet();
		for(String nameOfState : stateList) {
			
			System.out.println("Number of contact for " + nameOfState + " " + stateKeyToEntryMap.get(nameOfState));
		}
	}
	public static void main(String[] args) {
		AddressBookMain addressBookMain = new AddressBookMain();
		String choice;
		do {
			
			logger.debug("Select what operation you want to perform== ");
			logger.debug("1.Adding the details");
			logger.debug("2.Editing the details");
			logger.debug("3.Deleting the details");
			logger.debug("4.Seaching by city");
			logger.debug("5.Seaching by state");
			logger.debug("6.Show city and person dictionary");
			logger.debug("7.Show state and person dictionary");
			logger.debug("8.City Contact Count");
			logger.debug("9.State Contact Count");
			
			
		
		int option=detailInput.nextInt();
		switch(option)
		{
		case 1:  
			logger.debug("Editing Address Book via Console");
			logger.debug("Enter the Details to be added as follows :");
			logger.debug("First Name");
			logger.debug("Last Name");
			logger.debug("Address ");
			logger.debug("City ");
			logger.debug("State ");
			logger.debug("Zip ");
			logger.debug("Phone Number");
			logger.debug("Email ID");
		         ContactDetails contactDetails=new ContactDetails(detailInput.nextLine(),detailInput.nextLine(),detailInput.nextLine(),detailInput.nextLine(),detailInput.nextLine(),
	                      Integer.parseInt(detailInput.nextLine()),detailInput.nextLine(),detailInput.nextLine());
		
		         addressBookMain.addNewContact(contactDetails);
		         break;
		case 2: logger.debug("Enter the first name of that person whose data has to be edited == " );
                String testName=detailInput.nextLine();
                logger.debug("enter the data of that person as follows");
                logger.debug("Last Name");
                logger.debug("Address ");
                logger.debug("City ");
                logger.debug("State ");
                logger.debug("Zip ");
                logger.debug("Phone Number");
                logger.debug("Email ID");
		
		        addressBookMain.editContactDetails(testName,detailInput.nextLine(),detailInput.nextLine(),detailInput.nextLine(),
                                       Integer.parseInt(detailInput.nextLine()),detailInput.nextLine(),detailInput.nextLine());
		        logger.debug("The details has been updated.");
		        break;
		case 3:logger.debug("Enter the first name of that person whose data has to be DELETED == " );
               String Name=detailInput.nextLine();
        
		       addressBookMain.deleteContactDetails(Name);
		       logger.debug("The details has been updated.");
		       break;
		case 4:logger.debug("Enter the first name of the city to be searched form == " );
                  String testCity=detailInput.nextLine();
                  searchingContactsByGivenCity(testCity);
                  break;
		case 5:logger.debug("Enter the first name of the state to be searched form ==" );
		       String testState=detailInput.nextLine();
		       searchingContactsByGivenState(testState);
	             break;
		case 6:
	           ContactByCity();
               break;
		case 7: ContactByState();
		        break;
		case 8: CountByCity();
        break;
		case 9: CountByState();
        break;

  
		      
		default: logger.debug("Wrong option selected");
	
		}logger.debug("Do you want to perform again(yes/no)== ");
		 choice =detailInput.nextLine();
		
	}while(choice =="y");

        
	}
	

}