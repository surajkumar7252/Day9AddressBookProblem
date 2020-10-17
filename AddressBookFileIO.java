package addressbookday9;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AddressBookFileIO {
	private static final Logger log=LogManager.getLogger(AddressBookFileIO.class);
	public String addressBookFile; 
	
	public AddressBookFileIO(String addressBookFile) {
		
		this.addressBookFile = addressBookFile;
	}
	
	public void writeContactDetails(List<ContactDetails> contactDetails) {
		StringBuffer bufferedContacts=new StringBuffer();
		contactDetails.forEach(ContactDetails-> bufferedContacts.append(contactDetails.toString().concat("\n")));
		try {
			Files.write(Paths.get(addressBookFile),bufferedContacts.toString().getBytes());
		}catch(IOException e) {
			log.info(e.getMessage());
		}
	}
	public List<ContactDetails> readContactDetails(){
		List<ContactDetails> contactDetails=null;
		try {
			contactDetails= Files.lines(Paths.get(addressBookFile))
					.map(detailsString->{
						String[] contactDetailsArray = detailsString.split(", ");
						
						ContactDetails entryPointforContatDetails= new ContactDetails();
						entryPointforContatDetails(contactDetailsArray[0].split(" ")[0],
								contactDetailsArray[0].split(" ")[1],
								contactDetailsArray[1],
								contactDetailsArray[2],
								contactDetailsArray[3],
								Integer.parseInt(contactDetailsArray[4]),
								Long.parseLong(contactDetailsArray[5]),
								contactDetailsArray[6]
								);
						}).collect(Collectors.toList());
		}catch(IOException e) {
			log.info(e.getMessage());
		}
		return contactDetails;
	}

}
