/**
 * COMP 249 - Assignment 2 - Contact Manager v.2
 * Author: Tsang Chi Kit
 * Student ID: 5692636
 */

package contactManager;

/**
 * This is the Address class. The main purpose is to create Address instances that used in the Contact class (for each contacts).
 * Each instance will have an address type (Work, Home, etc), apartment # (optional), street name, city, postal code, and country.
 *
 */

public class Address
{
	private String streetName ="";
	private String city = "";
	private String postalCode = "";
	private String country = "";
	private AddressType addressType;
	
	private int streetNumber = 0;
	private int apartmentNumber = 0;
	
	//Constructor - with apartment #
	public Address(AddressType addressType, int apartmentNumber, int streetNumber, String streetName, String city, String country)
	{
		this.setAddressType(addressType);
		this.apartmentNumber = apartmentNumber;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.country = country;
	}
	
	//Constructor - without apartment #
	public Address(AddressType addressType, int streetNumber, String streetName, String city, String country)
	{
		this.setAddressType(addressType);
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.country = country;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCountry() {
		return country;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public int getApartmentNumber() {
		return apartmentNumber;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	
	//Two address objects are considered equal if all 7 properties are equal ...
	//Address Type, Street Name, Street #, City, Postal Code, Country, and Apartment Number
	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		
		if(o instanceof Address)
		{
			Address address = (Address)o;
			
			boolean ifAddressTypeEqual     = this.addressType.equals(address.addressType);
			boolean ifStreetNameEqual      = this.streetName.equals(address.streetName);
			boolean ifStreetNumberEqual    = this.city.equals(address.city);
			boolean ifCityEqual            = this.postalCode.equals(address.postalCode) ;
			boolean ifPostalCodeEqual      = this.postalCode.equals(address.postalCode);
			boolean ifCountryEqual         = this.country.equals(address.country);
			boolean ifApartmentNumberEqual = this.apartmentNumber == address.apartmentNumber;
			
			if(ifAddressTypeEqual == true && ifStreetNameEqual == true && ifStreetNumberEqual == true && 
			          ifCityEqual == true && ifPostalCodeEqual == true && ifCountryEqual      == true && ifApartmentNumberEqual == true) 
				return true;
		}
		return false;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(addressType).append(":").append("\n");
		sb.append(streetNumber).append(" ").append(streetName);
		
		if(apartmentNumber != 0)
			sb.append(" ").append(apartmentNumber);
			
		sb.append("\n");
		sb.append(city).append(" ").append(postalCode).append(" ").append(country);
		
		return sb.toString();
	}
	
}
