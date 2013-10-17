package contactManager;

import org.joda.time.DateTime;

public class SpecialEvent implements Event
{
	private DateTime eventDate;
	
	private SpecialEventType eventType;
	
	private boolean ifRecurringYearly;
	

	public SpecialEvent(SpecialEventType eventType, DateTime eventDate,  boolean ifRecurring) 
	{
		this.setEventType(eventType);
		this.setEventDate(eventDate);
		this.ifRecurringYearly = ifRecurring;
	}


	@Override
	//Check if the current meeting is within the interval of calling start, end Date
	//If the special event is recurring yearly, then we will set all the year to 0000
	//and then compare as usual.
	public boolean isWithinPeriod(DateTime start, DateTime end)
	{	
		boolean ifEventAfterStart = eventDate.plusMillis(1).isAfter(start);
		boolean ifEventBeforeEnd = eventDate.minusMillis(1).isBefore(end);
				
		if(ifRecurringYearly == false)
		{
			if(ifEventAfterStart == true && ifEventBeforeEnd == true)
				return true;
		}
		else
		{			
			DateTime eventZeroYear = eventDate.withYear(0);
			DateTime startZeroYear = start.withYear(0);
			DateTime endZeroYear   = end.withYear(0);
			
			ifEventAfterStart = eventZeroYear.plusMillis(1).isAfter(startZeroYear);
			ifEventBeforeEnd  = eventZeroYear.minusMillis(1).isBefore(endZeroYear);
					
			if (ifEventAfterStart == true && ifEventBeforeEnd == true)
				return true;
		}	

		return false;
	}


	public SpecialEventType getEventType() 
	{
		return eventType;
	}

	public void setEventType(SpecialEventType eventType)
	{
		this.eventType = eventType;
	}


	public boolean isIfRecurringYearly() {
		return ifRecurringYearly;
	}


	public void setIfRecurringYearly(boolean ifRecurringYearly) {
		this.ifRecurringYearly = ifRecurringYearly;
	}


	public DateTime getEventDate() 
	{
		return eventDate;
	}


	public void setEventDate(DateTime eventDate) 
	{
		this.eventDate = eventDate;
	}
	
	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		
		//Two special enents are considered equal if 
		//1. Event type are equal
		//2. Event date are equal
		if(o instanceof SpecialEvent)
		{
			SpecialEvent specialEvent = (SpecialEvent)o;
			
			boolean ifEventTypeEqual = this.eventType.equals(specialEvent.eventType);
			boolean ifEventDateEqual = this.eventDate.equals(specialEvent.eventDate);
			
			if(ifEventTypeEqual == true && ifEventDateEqual == true)
				return true;
		}
		
		return false;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Event Type: ");
		sb.append(eventType);
		sb.append("\n");
		sb.append("Event Date: ");
		sb.append(eventDate);
		sb.append("\n");
		sb.append("Recurring Yearly: ");
		sb.append(ifRecurringYearly);
		sb.append("\n");

		return sb.toString();
	}

}
