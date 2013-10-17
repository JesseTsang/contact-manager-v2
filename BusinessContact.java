package contactManager;

import java.util.ArrayList;
import org.joda.time.DateTime;

/**
 * This is the BusinessContact class. The main purpose is to create meetings instances to store a list of meeting associate that is with the contact.
 */

public class BusinessContact extends Contact
{
	private ArrayList<Meeting> meetings;
	private static final int MAX_MEETING_SIZE = 100;
	private int addedMeetingCount = 0; //acts as counter of current array size

	//Constructor -- With middle name
	public BusinessContact(String firstName, String middleName, String lastName)
	{
		super(firstName, middleName, lastName);
		this.setMeetings(new ArrayList<Meeting>());
	}

	//Constructor -- Without middle name
	public BusinessContact(String firstName, String lastName)
	{
		super(firstName, lastName);
		this.setMeetings(new ArrayList<Meeting>());
	}
	
	//Pre-test for addMeeting() to see if there exist a duplication
	private boolean ifMeetingExist(Meeting meeting)
	{		
		for(int i = 0; i < meetings.size(); i++) 
		{
			if(meetings.get(i).equals(meeting))
				return true; //Previous meeting exists		
		}
		
		return false; //Previous meeting not exists
	}
	
	//New meeting will be add if it is not previously exist, and existing number of meetings < maximum allowed meeting size
	public void addMeeting(Meeting meeting)
	{
		boolean ifMeetingNotAdded = !ifMeetingExist(meeting);
		boolean ifMeetingSizeValid = meetings.size() < MAX_MEETING_SIZE;
		
		DateTime start = meeting.getStartTime();
		DateTime end   = meeting.getEndTime();
		
		boolean ifMeetingWithinPeriod = meeting.isWithinPeriod(start, end);
		
		if (ifMeetingNotAdded == true && ifMeetingWithinPeriod == true && ifMeetingSizeValid == true)
		{
			meetings.add(addedMeetingCount, meeting);
			addedMeetingCount++;
		}
	}
	
	@Override
	//Get all events that are within startDate and endDate
	public ArrayList<Event> getEventsWithinPeriod(DateTime startDate, DateTime endDate)
	{
		ArrayList<Event> foundEvents = new ArrayList<Event>();
		
		for(int i = 0; i < meetings.size(); i++)
		{
			if(meetings.get(i).isWithinPeriod(startDate, endDate) == true)
				foundEvents.add(i, meetings.get(i));				
		}
		
		return foundEvents;
	}
	
	public ArrayList<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(ArrayList<Meeting> meetings) {
		this.meetings = meetings;
	}
}
