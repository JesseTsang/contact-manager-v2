package contactManager;

import org.joda.time.DateTime;

public interface Event 
{
	public boolean isWithinPeriod(DateTime start, DateTime end);
}
