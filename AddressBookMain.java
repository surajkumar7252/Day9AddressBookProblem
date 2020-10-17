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
		return "Contact Details : "+ firstName+ " "+ lastName +"|"+ address+ "|" +city+"|"+state+"|"
				+ zip+"|"+phoneNum+"|"+emailId+";";
	}
	
}

public class AddressBookMain {
	public static LinkedList<ContactDetails> contactLinkedListDetails;
	public static Map<String,ContactDetails> cityKeyToEntryMap;
	public static Map<String,ContactDetails> stateKeyToEntryMap;
	public static Map<String,ContactDetails> nameKeyToEntryMap;
	
	
	static Scanner detailInput=new Scanner(System.in);
	private static final Logger log = LogManager.getLogger(AddressBookMain.class);
	
	public AddressBookMain() {
		contactLinkedListDetails = new LinkedList<ContactDetails>();
		cityKeyToEntryMap= new HashMap<String,ContactDetails>();
		stateKeyToEntryMap= new HashMap<String,ContactDetails>();
		nameKeyToEntryMap= new HashMap<String,ContactDetails>();
		
	}
	
		
	
	public void addNewContact(ContactDetails contactDetail) {
		
		log.info("enter the number of contacts to be fed: ");
		int numOfContacts=detailInput.nextInt();
		String firstName,lastName;
		log.info("enter the first name to be fed: ");
		firstName=detailInput.nextLine();
		log.info("enter the last name to be fed: ");
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
		log.info("Setting Address.");
		nameKeyToEntryMap.get(testName).setCity(testCity);
		log.info("Setting City.");
		
		nameKeyToEntryMap.get(testName).setState(testState);
		log.info("Setting State.");
		
		nameKeyToEntryMap.get(testName).setZip(testZip);
		log.info("Setting Zip.");
		
		nameKeyToEntryMap.get(testName).setPhoneNum(testPhoneNum);
		log.info("Setting Phone Number.");
		
		nameKeyToEntryMap.get(testName).setEmailId(testEmailId);
		log.info("Setting Email-Id.");
		
		
		
   }
			     
			
	
	public void deleteContactDetails(String testName) {
		
		
		contactLinkedListDetails.remove(nameKeyToEntryMap.get(testName));
		
    }
	
	private static void searchingContactsByGivenCity(String testCity) {
		log.info(cityKeyToEntryMap.get(testCity));
		}

	private static void  searchingContactsByGivenState(String testState) {
		log.info(stateKeyToEntryMap.get(testState));
		
	}

	
	private static void  ContactByCity() {
		Set<String> cityList=contactLinkedListDetails.stream().map(ContactDetails->ContactDetails.getCity()).collect(Collectors.toSet());
		cityKeyToEntryMap = cityList.stream()
				.collect(Collectors.toMap(cityList -> cityList,
						cityList -> {
							return contactLinkedListDetails.stream().filter(ContactDetails ->ContactDetails.getCity().equals(cityList)).sorted((c1, c2) -> {
								return c1.getFirstName().compareTo(c2.getFirstName());
							}).collect(Collectors.toList());
						}));
		
		
		}
	
	
	private static void  ContactByState() {
		Set<String> stateList=contactLinkedListDetails.stream().map(ContactDetails->ContactDetails.getState()).collect(Collectors.toSet());
		stateKeyToEntryMap = stateList.stream()
				.collect(Collectors.toMap(stateList -> stateList,
						stateList -> {
							return contactLinkedListDetails.stream().filter(ContactDetails ->ContactDetails.getState().equals(stateList)).sorted((c1, c2) -> {
								return c1.getFirstName().compareTo(c2.getFirstName());
							}).collect(Collectors.toList());
						}));
		
		
		}
	
	
	
	
	private static void CountByCity() {
		Set<String> cityList = cityKeyToEntryMap.keySet();
		for(String nameOfCity : cityList) {
			log.info("Number of contact for" + nameOfCity + " " + cityKeyToEntryMap.get(nameOfCity));
		}
	}

	private static void CountByState() {
		Set<String> stateList = stateKeyToEntryMap.keySet();
		for(String nameOfState : stateList) {
			
			log.info("Number of contact for " + nameOfState + " " + stateKeyToEntryMap.get(nameOfState));
		}
	}
	public static void main(String[] args) {
		AddressBookMain addressBookMain = new AddressBookMain();
		String choice;
		do {
			
			log.info("Select what operation you want to perform== ");
			log.info("1.Adding the details");
			log.info("2.Editing the details");
			log.info("3.Deleting the details");
			log.info("4.Seaching by city");
			log.info("5.Seaching by state");
			log.info("6.Show city and person dictionary");
			log.info("7.Show state and person dictionary");
			log.info("8.City Contact Count");
			log.info("9.State Contact Count");
			
			
		
		int option=detailInput.nextInt();
		switch(option)
		{
		case 1:  
			log.info("Editing Address Book via Console");
			log.info("Enter the Details to be added as follows :");
			log.info("First Name");
			log.info("Last Name");
			log.info("Address ");
			log.info("City ");
			log.info("State ");
			log.info("Zip ");
			log.info("Phone Number");
			log.info("Email ID");
		         ContactDetails contactDetails;
		         contactDetails=new ContactDetails(detailInput.nextLine(),detailInput.nextLine(),detailInput.nextLine(),detailInput.nextLine(),detailInput.nextLine(),
	                      Integer.parseInt(detailInput.nextLine()),detailInput.nextLine(),detailInput.nextLine());
		
		         addressBookMain.addNewContact(contactDetails);
		         break;
		case 2: log.info("Enter the first name of that person whose data has to be edited == " );
                String testName=detailInput.nextLine();
                log.info("enter the data of that person as follows");
                log.info("Last Name");
                log.info("Address ");
                log.info("City ");
                log.info("State ");
                log.info("Zip ");
                log.info("Phone Number");
                log.info("Email ID");
		
		        addressBookMain.editContactDetails(testName,detailInput.nextLine(),detailInput.nextLine(),detailInput.nextLine(),
                                       Integer.parseInt(detailInput.nextLine()),detailInput.nextLine(),detailInput.nextLine());
		        log.info("The details has been updated.");
		        break;
		case 3:log.info("Enter the first name of that person whose data has to be DELETED == " );
               String Name=detailInput.nextLine();
        
		       addressBookMain.deleteContactDetails(Name);
		       log.info("The details has been updated.");
		       break;
		case 4:log.info("Enter the first name of the city to be searched form == " );
                  String testCity=detailInput.nextLine();
                  searchingContactsByGivenCity(testCity);
                  break;
		case 5:log.info("Enter the first name of the state to be searched form ==" );
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

  
		      
		default: log.info("Wrong option selected");
	
		}log.info("Do you want to perform again(yes/no)== ");
		 choice =detailInput.nextLine();
		
	}while(choice =="y");

        
	}
	

}