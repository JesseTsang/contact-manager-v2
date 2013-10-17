package contactManager;

/**
 * This is the PhoneNumber class. The main purpose is to create PhoneNumber instances that used in the Contact class (for each contacts).
 * Each instance will have an PhoneNumber type (Work, Home, Mobile, Fax), country code, area code, phone number, and extension (optional).
 */

public class PhoneNumber 
{
	private int countryCode = 0;
	private int areaCode = 0;
	private int phoneNumbers = 0;
	private int extension = 0;
	
	private PhoneNumberType phoneNumberType;
	
	//Constructor with extension
	public PhoneNumber(PhoneNumberType phoneNumberType, int countryCode, int areaCode, int phoneNumbers, int extension) 
	{
		this.setPhoneNumberType(phoneNumberType);
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.phoneNumbers = phoneNumbers;
		this.extension = extension;
		this.setPhoneNumberType(phoneNumberType);
	}

	//Constructor without extension
	public PhoneNumber(PhoneNumberType phoneNumberType, int countryCode, int areaCode, int phoneNumbers) 
	{
		this.setPhoneNumberType(phoneNumberType);
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.phoneNumbers = phoneNumbers;
		this.setPhoneNumberType(phoneNumberType);
	}

	public int getCountryCode() {
		return countryCode;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public int getPhoneNumbers() {
		return phoneNumbers;
	}

	public int getExtension() {
		return extension;
	}

	public PhoneNumberType getPhoneNumberType() {
		return phoneNumberType;
	}

	public void setPhoneNumberType(PhoneNumberType phoneNumberType) {
		this.phoneNumberType = phoneNumberType;
	}
	
	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		
		if(o instanceof PhoneNumber)
		{
			PhoneNumber phone = (PhoneNumber)o;
			
			
			boolean ifPhoneTypeEqual = this.phoneNumberType.equals(phone.phoneNumberType);
			boolean ifCountryCodeEqual = this.countryCode == phone.countryCode;
			boolean ifAreaCodeEqual = this.areaCode == phone.areaCode;
			boolean ifPhoneNumberEqual = this.phoneNumbers == phone.phoneNumbers;
			boolean ifExtensionEqual = this.extension == phone.extension ;
			
			return (ifPhoneTypeEqual == true && ifCountryCodeEqual == true && 
					ifAreaCodeEqual == true && ifPhoneNumberEqual == true && ifExtensionEqual == true);
		}
		return false;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(phoneNumberType).append(":").append("\n");
		sb.append(countryCode).append(" ").append(areaCode).append(" ").append(phoneNumbers);
		
		if(extension != 0)
			sb.append(" ext. ").append(extension);
		
		return sb.toString();
	}
	
}
