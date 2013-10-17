package contactManager;

import org.joda.time.DateTime;

public class Meeting implements Event 
{
	private DateTime startTime;
	private DateTime endTime;
	
	private String eventLocation;
	private String eventDescription;
	
	//Constructor
	public Meeting(DateTime startTime, DateTime endTime, String eventLocation, String eventDescription)
	{
		this.startTime = startTime;
		this.endTime = endTime;
		this.eventLocation = eventLocation;
		this.eventDescription = eventDescription;
	}

	@Override
	//Check if the current meeting is within the interval of call start, end time.
	//Return true if yes
	public boolean isWithinPeriod(DateTime start, DateTime end) 
	{
		boolean ifMeetingAfterStartTime = startTime.plusMillis(1).isAfter(start);
		boolean ifMeetingsBeforeEndTime = endTime.minusMillis(1).isBefore(end);

		if(ifMeetingAfterStartTime == true && ifMeetingsBeforeEndTime == true)		
			return true;

		return false;
	}

	public DateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}

	public DateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
	//Two boolean objects are equal to each other if the ...
	//Start time, End time, and location are equal
	public boolean equals(Object o)
	{
		if(this == o)
			return true;		
				
		if(o instanceof Meeting)
		{
			Meeting meeting = (Meeting)o;
			
			boolean ifStartTimeEqual = this.startTime.equals(meeting.startTime);
			boolean ifEndTimeEqual   = this.endTime.equals(meeting.endTime);
			boolean ifLocationEqual  = this.eventLocation.equals(meeting.eventLocation);
			
			if (ifStartTimeEqual == true && ifEndTimeEqual == true && ifLocationEqual == true)
				return true;
		}
		
		return false;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Event Description: ").append(eventDescription).append("\n");
		sb.append("Event Location: ").append(eventLocation).append("\n");
		sb.append("Start Time: ").append(startTime).append("\n");
		sb.append("End Time: ").append(endTime).append("\n");
		
		return sb.toString();
	}
}
