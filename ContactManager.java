package contactManager;

import java.util.ArrayList;
import org.joda.time.DateTime;

/**
 * This is the ContactManger class. The main purpose of this class is to create instances for array of Contact class. 
 * Imagine whenever an instance of Contact[] is created that is equal to a contact book being created. 
 * 
 * Currently, we can ...
 * 
 * 1. Add individual contact to the Contact[] via addContact(Contact contact);
 * 2. Show total number of contacts added in the Contact[] via numberOfContacts();
 * 3. Search contacts that contain certain words via searchContacts(String str);
 * 4. Search contacts within certain social network via findContactsInSocialNetwork(SocialNetworkAccountType socialNetworkType);
 * 5. Sort contacts alphabetically via sortContacts();
 */

public class ContactManager 
{
	private Contact[] contacts;
	private int addedContactCount  = 0;	//Total of number contacts added. Also acts as an indicator for current array position.
	private static final int MAX_CONTACT = 10; //Maximum number of contacts allowed in each Contact[]
	
	//Constructor
	public ContactManager ()
	{	
		this.contacts = new Contact[MAX_CONTACT];
	}
	
	//Preliminary check if previous contact is already created to prevent duplication.
	//It is considered duplicated if the first, last, and middle names are equal.
	private boolean isContactAdded(Contact contact)
	{
		for(int i=0; i<addedContactCount; i++)
		{
			Contact addedContact = contacts[i];
			
			if(addedContact.equals(contact))
				return true; //duplicate exists
		}
		
		return false; //duplicate not exist, proceed to add contact
	}
	
	//Add contact to a Contact[] instance if 
	//1. isContactAdded() is false
	//2. if addedContactCount (array position indicator) is smaller than maximum allowed length. 
	public void addContact(Contact contact)
	{
		if(!isContactAdded(contact) && addedContactCount < MAX_CONTACT)
		{
			contacts[addedContactCount] = contact;
			addedContactCount++;
		}
	}
	
	//Show total number of contacts added and print out their first and last name.
	public void numberOfContacts()
	{
		System.out.println("There are currently: " + addedContactCount + " contacts.");
	}
	
	//Search Contact[] with given string argument and print out all the contacts that contain the string.
	public Contact[] searchContacts(String name)
	{
		//An Contact[] to store search results
		Contact[] searchedContacts = new Contact[MAX_CONTACT];
		int searchFound = 0; //Counter on how many contacts found
		
		System.out.println("Searching contact[s] contains " + "<< " + name + " >> ...");
		
		//Loop through Contact[], and check if any given contact has their first name or last name contains the string argument.
		for(int i=0; i < addedContactCount; i++)
		{
			Contact contact = contacts[i];
			
			if(contact.getFirstName().contains(name) || contact.getLastName().contains(name))
			{
				searchedContacts[i] = contacts[i];
				searchFound++;
			}
			else if(contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name))
			{
				searchedContacts[i] = contacts[i];
				searchFound++;
			}
		}
		
		System.out.println(searchFound + " of cotact[s] found contains << " + name + " >>. \n");
		
		return searchedContacts;
	}
	
	
	//Find if any contact has social account that is equal to argument socialNetworkAccountType.
	public Contact[] findContactsInSocialNetwork(SocialNetworkAccountType socialNetworkAccountType)
	{
		Contact[] searchedContacts = new Contact[MAX_CONTACT]; //Hold result array
		int searchFound = 0; //Result counter; hold number of result found.
				
		//Loop through all Contact[], check if a contact has argument socialNetworkAccountType = true.
		//If true, added to result array, and increase result counter.
		for(int i=0; i<addedContactCount; i++)
		{
			Contact contact = contacts[i];
						
			//True if a contact has the same social account type as the argument.
			if(contact.contactsBySocialNetworkType(socialNetworkAccountType))
			{
				searchedContacts[i] = contacts[i];
				searchFound++;
			}
		}

		System.out.println("\n" + searchFound + " of cotact[s] found in " + socialNetworkAccountType.getType() + ". \n");	
		
		return searchedContacts;
	}
	
	//Sort the current Contact[] alphabetically by last name, and first name if last name is the same.
	public Contact[] sortContacts()
	{
		//Stored the stored Contact[]
		Contact[] sortedContactArray = new Contact[addedContactCount];
		
		//Create a copy of the original Contact[] so the original Contact[] won't be contaminated after sorted.
        System.arraycopy(contacts, 0, sortedContactArray, 0, addedContactCount);
		
        int sortedContactLength = sortedContactArray.length;
		             
        //Insertion sort; example @ http://java2novice.com/java-interview-programs/insertion-sort/
        //Loop through the Contact[], starting at 2nd position (Contact[1]) until the end.
        //Store the string at current position -> cP
        //Start position counter (pP) = current loop - 1
        //Compare the String at current position (cP) with the one before it (pP) and we get an int (x) as result.
        //If x is positive, that means the current string (cP) should comes before the the string at (pP)
        //So, we copy cP by pP, and move the position counter (pP) back 1
        //we continue to check again as long as pP > -1 (>= 0, so not out of bound) and compare the string at pP to cP 
        for (int j = 1; j < sortedContactLength; j++) 
        {
            String currentLastName = sortedContactArray[j].getLastName();
            String currentFirstName = sortedContactArray[j].getFirstName();
            
            Contact currentContact = sortedContactArray[j]; //hold the current contact @ loop position      
            int previousPosition = j-1;     //previous position pointer
                  
            //as long as pP != out of bound (> -1) ... we want to compare string @ pP to string @ cP; + means cP comes before pP, = means they are the same, - means cP comes after pP                 
            while ( (previousPosition > -1) && ( sortedContactArray[previousPosition].getLastName().compareToIgnoreCase(currentLastName) > 0) )
            {         	           	 	         	
            	sortedContactArray[previousPosition + 1] = sortedContactArray[previousPosition];
                previousPosition-- ;
            }
            
            //in the case cP == pP, we want to compare by their first name
            if ((previousPosition > -1) && (sortedContactArray[previousPosition].getLastName().compareToIgnoreCase(currentLastName) == 0))
            {
        		while ((previousPosition > -1) && ( sortedContactArray[previousPosition].getFirstName().compareToIgnoreCase(currentFirstName) > 0) )
        		{
                	sortedContactArray[previousPosition + 1] = sortedContactArray[previousPosition];
                    previousPosition-- ;    			
        		} 
            }
            
            //in the case 
            //1. pP = -1 (that means cP is at the first position, Contact[0])
            //or ...
            //2. String @ pP < String @ cP (that means alphabetically correct)
            sortedContactArray[previousPosition + 1] = currentContact;                    
        }
            
		return sortedContactArray;
	}

	public void printEventsWithinPeriod(DateTime start, DateTime end)
	{
		ArrayList<Event> foundEvents = new ArrayList<Event>();
		
		for (int i = 0; i < addedContactCount; i++)
		{
			Contact contact = contacts[i];
					
			foundEvents = contact.getEventsWithinPeriod(start, end);
					
			System.out.print("Event under the name of ... ");
			System.out.println(contact.getFirstName() + " " + contact.getMiddleName() + " " + contact.getLastName() + "\n");
			
			int j = 0;
			while (foundEvents.size() > j) 
			{
				System.out.println(foundEvents.get(j));
				j++;
			}	
		}			
	}
}
