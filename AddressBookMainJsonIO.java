package addressbookday9;

import java.io.*;
import java.util.*;
import com.google.gson.Gson;
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
}


public class AddressBookMainJsonIO {
	private static Logger log = LogManager.getLogger(AddressBookMainJsonIO.class);
	public String addressBookMainJsonIOFile;

	public AddressBookMainJsonIO(String addressBookMainJsonFile) {
		addressBookMainJsonIOFile = addressBookMainJsonFile;
	}
	public List<ContactDetails> readingContactsFromFile() {
		List<ContactDetails> contactdetails = null;
		try {
			Gson gson = new Gson();
			BufferedReader bufferedReader = new BufferedReader(new FileReader(addressBookMainJsonIOFile));
			ContactDetails[] contactsContainer = gson.fromJson(bufferedReader,ContactDetails[].class);
			 contactdetails = new LinkedList<ContactDetails>(Arrays.asList(contactsContainer));
			bufferedReader.close();
		} catch (IOException e) {
			log.info(e.getMessage());
		}
		return contactdetails;
	}
	
	public void writingContactsToFile(List<ContactDetails> contactdetails) {
		try {
			Gson gsonForFileIO = new Gson();
			String json = gsonForFileIO.toJson(contactdetails);
			FileWriter fileWriter = new FileWriter(addressBookMainJsonIOFile);
			fileWriter.write(json);
			fileWriter.close();
		} catch (IOException e) {
			log.info(e.getMessage());
		}
	}
	
}
