package contactManager;

import org.joda.time.DateTime;

/**
 * The driver class populates attributes for ContactManager class and Contact instances. 
 * Each ContactManager instance can have up to 10 contacts, so we can imagine each ContactManager instance as a separate contact book.
 * The driver class populates the variable instances used in each contacts, such as first & last names, address, phone numbers and their types.
 * The driver class also runs all the public methods inside of ContactManager class.
 * 
 * Currently, we can ...
 * 
 * (Contact class)
 * 	1. Add addresses via addAddress(Address address);
 *  2. Add phone numbers via addPhoneNumber(Phone number);
 *  3. Add social network accounts via addSocialNetworkAccount(SocialNetworkAccount socialNetworkAccount);
 *  
 * (ContactManager class)
 *  1. Add contacts via addContact(Contact contact);
 *  2. Show currently total number of contacts added via numberOfContacts();
 *  3. Search contacts that contain certain words via searchContacts(String str);
 *  4. Search contacts within certain social network via findContactsInSocialNetwork(SocialNetworkAccountType socialNetworkType);
 *  5. Sort contacts alphabetically via sortContacts();
 */

public class Driver 
{
	public static void main(String[] args)
	{
		ContactManager contactManager = new ContactManager();

		/*Address address1 = new Address(AddressType.Home, 1936, "99th Street", "Grande Prairie", "Canada");
		PhoneNumber phoneNumber1 = new PhoneNumber (PhoneNumberType.Home, 1, 438, 6586472);
		SocialNetworkAccount socialNetworkAccount1 = new SocialNetworkAccount (SocialNetworkAccountType.Facebook, "Isengrim.Longhole");
		
		contact1.addAddress(address1);
		contact1.addPhoneNumber(phoneNumber1);
		contact1.addSocialNetworkAccount(socialNetworkAccount1);*/
		
		DateTime date0 = new DateTime(2013, 8, 27, 7, 40);
		
		DateTime date1 = new DateTime(2013, 8, 27, 7, 40); 
		DateTime date2 = new DateTime(2013, 9, 28, 8, 50); 
				
		DateTime date3 = new DateTime(2013, 10, 21, 6, 40); 
		DateTime date4 = new DateTime(2013, 10, 22, 7, 50);
		
		DateTime date5 = new DateTime(2013, 11, 27, 7, 00); 
		DateTime date6 = new DateTime(2013, 11, 27, 7, 00);
		
		/*1st contact*/
		Contact b1 = new BusinessContact("Isengrim", "Hornblower", "Longhole");
		
		contactManager.addContact(b1);
		
		Meeting m1 = new Meeting (date1, date1, "Montreal", "Class Meeting"); //DateTime startTime, DateTime endTime, String eventLocation, String eventDescription
		Meeting m2 = new Meeting (date3, date4, "Montreal", "Job Interview");
		
		//Meeting m3 = new Meeting (date3, date4, "Montreal", "Job Interview"); //Should be error
		
		
		((BusinessContact) b1).addMeeting(m1);
		((BusinessContact) b1).addMeeting(m2);
		//((BusinessContact) b1).addMeeting(m3); //Should be error
					
		Contact c1 = new PersonalContact("Mary", "Jane");
		
		contactManager.addContact(c1);
			
		SpecialEvent s1 = new SpecialEvent(SpecialEventType.Anniversary, date1, true);
		SpecialEvent s2 = new SpecialEvent(SpecialEventType.Birthday, date2, true);
		SpecialEvent s3 = new SpecialEvent(SpecialEventType.Other, date2, false);
		
		//SpecialEvent s4 = new SpecialEvent(SpecialEventType.Birthday, date2, true); //Should be error
		
		((PersonalContact) c1).addSpecialEvent(s1);
		((PersonalContact) c1).addSpecialEvent(s2);
		((PersonalContact) c1).addSpecialEvent(s3);
		//((PersonalContact) c1).addSpecialEvent(s4);
		
		contactManager.printEventsWithinPeriod(date0, date6);
		
	}
}
