package contactManager;

public enum SocialNetworkAccountType 
{
	Skype("Skype"),
	Facebook("Facebook"), 
	Google("Google+"), 
	Twitter("Twitter"), 
	LinkedIn("LinkedIn");
	
	private final String typeValue;
	
	private SocialNetworkAccountType(String type)
	{
		this.typeValue = type;		
	}
	
	public String getType()
	{
		return typeValue;
	}
}
