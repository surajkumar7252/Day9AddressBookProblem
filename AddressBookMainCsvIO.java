package addressbookday9;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.stream.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.opencsv.*;
import com.opencsv.bean.*;
import java.util.stream.Collectors;
import com.opencsv.exceptions.*;

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

public class AddressBookMainCsvIO {
	private static Logger log = LogManager.getLogger(AddressBookMainCsvIO.class);
	public String addressBookMainCSVFile;
	
	public AddressBookMainCsvIO(String addressBookMainFile) {
			addressBookMainCSVFile= addressBookMainFile;
	}
	public List<ContactDetails> readingContactsFromFile() {
		List<ContactDetails> contactdetails=null;
		try (Reader fileReader = Files.newBufferedReader(Paths.get(addressBookMainCSVFile));){
			CSVReader csvReader = new CSVReader(fileReader);
			List<String[]> contactContents = csvReader.readAll();
			contactContents.remove(0);
			contactdetails = contactContents.stream().map(contents -> {
				String firstName = contents[3], lastName = contents[4], address = contents[0];
				String city = contents[1]; String state =contents[6];
				int zip = Integer.parseInt(contents[7]);
				String phoneNum = contents[5];
				String emailId = contents[2];
				return new ContactDetails(firstName, lastName, address, city, state, zip, phoneNum, emailId);
			}).collect(Collectors.toList());
			csvReader.close();
		} catch (IOException e) {
			log.info(e.getMessage());
		}
		return contactdetails;
	}
	
	public void writingContactsToFile(List<ContactDetails> contactdetails) {
		try (Writer fileWriter = Files.newBufferedWriter(Paths.get(addressBookMainCSVFile));) {
			StatefulBeanToCsv<ContactDetails> beansToCSVFile = new StatefulBeanToCsvBuilder(fileWriter)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
			beansToCSVFile.write(contactdetails);
		} catch (CsvException | IOException e) {
			log.info(e.getMessage());
		}
	}	
}