package contactManager;

import java.util.ArrayList;
import org.joda.time.DateTime;


/**
 * This is the Contact class. The main purpose of this class is to create instances with first & last name, addresses, phone #s, and their social accounts.
 * Each Contact instance will have a first & last name. Each instance can add up to 10 address, phone #s, and social accounts.
 * 
 * Currently, we can ...
 * 
 * 	1. Add addresses via addAddress(Address address);
 *  2. Add phone numbers via addPhoneNumber(Phone number);
 *  3. Add social network accounts via addSocialNetworkAccount(SocialNetworkAccount socialNetworkAccount);
 *  4. Check if a contact has account in certain social network via contactsBySocialNetworkType(SocialNetworkAccountType type);
 */

public abstract class Contact 
{
	private String lastName = "";
	private String firstName = "";
	private String middleName = "";
	
	private Address[] addresses;
	private PhoneNumber[] phoneNumbers;
	private SocialNetworkAccount[] socialNetworkAccounts;
	
	//Address, phone #, and account counts. Also acts as current array position pointers.
	private int addedAddressCount = 0;
	private int addedPhoneNumberCount = 0;
	private int addedSocialNetworkAccountCount = 0;
	
	//Maximum allowed address, phone#, social network account per each Contact instance.
	private static final int MAX_ADDRESS = 10;
	private static final int MAX_PHONE_NUMBER = 10;
	private static final int MAX_SOCIAL_NETWORK_ACT = 10;
	
	//Constructor with middleName
	public Contact (String firstName, String middleName, String lastName)
	{
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		
		this.addresses = new Address[MAX_ADDRESS];
		this.phoneNumbers = new PhoneNumber[MAX_PHONE_NUMBER];
		this.socialNetworkAccounts = new SocialNetworkAccount[MAX_SOCIAL_NETWORK_ACT];
	}

	//Constructor without middleName
	public Contact (String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.addresses = new Address[MAX_ADDRESS];
		this.phoneNumbers = new PhoneNumber[MAX_PHONE_NUMBER];
		this.socialNetworkAccounts = new SocialNetworkAccount[MAX_SOCIAL_NETWORK_ACT];
	}

	//An address is added only if not duplicate.
	//It is considered duplicate if they have the same country, city, street name, street number, postal code, and apartment code.
	private boolean isAddressAdded(Address address)
	{
		for(int i=0; i<addedAddressCount; i++)
		{
			Address addedAddress = addresses[i];
			
			boolean ifCountryEqual    = addedAddress.getCountry().equalsIgnoreCase(address.getCountry());
			boolean ifCityEqual       = addedAddress.getCity().equalsIgnoreCase(address.getCity());
			boolean ifStrNameEqual    = addedAddress.getStreetName().equalsIgnoreCase(address.getStreetName());
			boolean ifAptEqual        = addedAddress.getStreetNumber() == address.getApartmentNumber();
			boolean ifPostalCodeEqual = addedAddress.getPostalCode().equalsIgnoreCase(address.getPostalCode());
			boolean ifAptNumEqual     = addedAddress.getApartmentNumber() == address.getApartmentNumber();
			
			if(ifCountryEqual == ifCityEqual == ifStrNameEqual == ifAptEqual == ifPostalCodeEqual == ifAptNumEqual == true)
				return true; //Duplicate exists. New address not added.						
		}	
		return false;//Duplicate not exist. New address is added.
	}
	
	//Add an address to the Address[] if isAddressAdded() is false (not duplicate)
	public void addAddress(Address address)
	{
		if(!isAddressAdded(address) && addedAddressCount < MAX_ADDRESS)
		{
			addresses[addedAddressCount] = address;	
			addedAddressCount++;
		}
	}
	
	//A phone number is added only if not duplicate.
	//It is considered duplicate if they have the same country code, city code, phone number, and extension.
	private boolean isPhoneNumberAdded(PhoneNumber phoneNumber)
	{
		for(int i=0; i<addedPhoneNumberCount; i++)
		{
			PhoneNumber addedPhoneNumbers = phoneNumbers[i];
			
			boolean ifCountryCodeEqual = addedPhoneNumbers.getCountryCode() == phoneNumber.getCountryCode();
			boolean ifAreaCodeEqual    = addedPhoneNumbers.getAreaCode() == phoneNumber.getAreaCode();
			boolean ifPhoneNumberEqual = addedPhoneNumbers.getPhoneNumbers() == phoneNumber.getPhoneNumbers();
			boolean ifExtensionEqual   = addedPhoneNumbers.getExtension() == phoneNumber.getExtension();
			
			if(ifCountryCodeEqual == ifAreaCodeEqual == ifPhoneNumberEqual == ifExtensionEqual == true)
				return true;//Duplicate exists. New phone number not added.
		}
		
		return false;//Duplicate not exist. New phone number is added.
	}
	
	//Add a phone number to the phoneNumbers[] if isPhoneNumberAdded() is false (not duplicate)
	public void addPhoneNumber(PhoneNumber phoneNumber)
	{
		if(!isPhoneNumberAdded(phoneNumber) && addedPhoneNumberCount < MAX_PHONE_NUMBER)
		{
			phoneNumbers[addedPhoneNumberCount] = phoneNumber;	
			addedPhoneNumberCount++;
		}
	}
	
	//A social network account is added only if not duplicate.
	//It is considered duplicate if they have the same account type and the same ID.
	private boolean isSocialNetworkAccountAdded(SocialNetworkAccount socialNetworkAccount)
	{
		for(int i=0; i<addedSocialNetworkAccountCount; i++)
		{
			SocialNetworkAccount addedSocialNetworkAct = socialNetworkAccounts[i];
			
			boolean ifAccountTypeEqual = addedSocialNetworkAct.getSocialNetworkAccountType().equals(socialNetworkAccount.getSocialNetworkAccountType());
			boolean ifAccountIDEqual   = addedSocialNetworkAct.getAccountID() == socialNetworkAccount.getAccountID();
			boolean ifAccountNameEqual = addedSocialNetworkAct.getAccountName().equalsIgnoreCase(socialNetworkAccount.getAccountName());
			
			//If they have the same account type ...
			if(ifAccountTypeEqual == ifAccountIDEqual == ifAccountNameEqual == true)
				return true;
		}		
		
		return false;
	}
	
	//Add social network account to the socialNetworkAccounts[] if isSocialNetworkAccountAdded() is false (not duplicate)
	public void addSocialNetworkAccount(SocialNetworkAccount socialNetworkAccount)
	{
		if(!isSocialNetworkAccountAdded(socialNetworkAccount) && addedSocialNetworkAccountCount < MAX_SOCIAL_NETWORK_ACT)			
		{
			socialNetworkAccounts[addedSocialNetworkAccountCount] = socialNetworkAccount;		
			addedSocialNetworkAccountCount++;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	//Check if a contact contain the argument social network type account, return true if yes
	public Boolean contactsBySocialNetworkType(SocialNetworkAccountType socialNetworkAccountType)
	{
		for(int i=0; i<addedSocialNetworkAccountCount; i++)
		{
			SocialNetworkAccount searchedAccounts = socialNetworkAccounts[i];
							
			if(searchedAccounts.getSocialNetworkAccountType().equals(socialNetworkAccountType))
				return true;
		}		
		return false;
	}
	
	public abstract ArrayList<Event> getEventsWithinPeriod(DateTime startDate, DateTime endDate);
	
	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		
		if(o instanceof Contact)
		{
			Contact contact = (Contact)o;
			
			boolean ifLastNameEqual   = this.lastName.equals(contact.lastName);
			boolean ifFirstNameEqual  = this.firstName.equals(contact.firstName);
			boolean ifMiddleNameEqual = this.middleName.equals(contact.middleName);
			
			return (ifLastNameEqual == true && ifFirstNameEqual == true && ifMiddleNameEqual == true);
		}
		
		return false;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(firstName).append(" ");
		
		if(middleName != "")
			sb.append(middleName).append(" ");
		
		sb.append(lastName);
		
		return sb.toString();
	}
}
