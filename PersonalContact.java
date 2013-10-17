package contactManager;

import java.util.ArrayList;
import org.joda.time.DateTime;

public class PersonalContact extends Contact
{
	private ArrayList<SpecialEvent> specialEvents;
	private int addedSpecialEventCount = 0; //Counter for ArrayList<SpecialEvent> size
	private static final int MAX_SPECIAL_EVENT_SIZE = 100;

	//Constructor -- With middle name
	public PersonalContact(String firstName, String middleName, String lastName)
	{
		super(firstName, middleName, lastName);
		this.setSpecialEvents(new ArrayList<SpecialEvent>());
	}

	//Constructor -- Without middle name
	public PersonalContact(String firstName, String lastName)
	{
		super(firstName, lastName);
		this.setSpecialEvents(new ArrayList<SpecialEvent>());
	}

	
	private boolean ifSpecialEventExist(SpecialEvent event)
	{		
		for(int i = 0; i < specialEvents.size(); i++) 
		{
			if(specialEvents.get(i).equals(event))
				return true; //Previous event exists	
		}
		
		return false; //Previous meeting not exists
	}
	
	public void addSpecialEvent(SpecialEvent event)
	{
		boolean ifEventNotAdded = !ifSpecialEventExist(event);
		boolean ifEventSizeValid = specialEvents.size() < MAX_SPECIAL_EVENT_SIZE;
		
		if (ifEventNotAdded == true && ifEventSizeValid == true)
		{
			specialEvents.add(addedSpecialEventCount, event);
			addedSpecialEventCount++;
		}
	}
	
	@Override
	public ArrayList<Event> getEventsWithinPeriod(DateTime startDate, DateTime endDate)
	{
		ArrayList<Event> foundEvents = new ArrayList<Event>();
		
		for(int i = 0; i < specialEvents.size(); i++)
		{
			if(specialEvents.get(i).isWithinPeriod(startDate, endDate) == true)
				foundEvents.add(i, specialEvents.get(i));					
		}
		
		return foundEvents;
	}
	
	public ArrayList<SpecialEvent> getSpecialEvents() {
		return specialEvents;
	}

	public void setSpecialEvents(ArrayList<SpecialEvent> specialEvents) {
		this.specialEvents = specialEvents;
	}
}
