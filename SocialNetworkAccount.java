package contactManager;

/**
 * This is the SocialNetworkAccount class. The main purpose is to create SocialNetworkAccount instances that used in the Contact class (for each contacts).
 * Each instance will have an SocialNetworkAccount type (Facebook, Skype, Google+, LinkedIn, or Twitter), account ID or account name.
 */

public class SocialNetworkAccount 
{
	private int accountID = 0;
	private String accountName = "";
	private SocialNetworkAccountType socialNetworkAccountType;

	//Constructor with accountID (int)
	public SocialNetworkAccount(SocialNetworkAccountType socialNetworkType, int accountID)
	{
		this.socialNetworkAccountType = socialNetworkType;
		this.accountID = accountID;
	}
	
	//Constructor with account name (String)
	public SocialNetworkAccount(SocialNetworkAccountType socialNetworkType, String accountName)
	{
		this.socialNetworkAccountType = socialNetworkType;
		this.accountName = accountName;
	}

	public int getAccountID() {
		return accountID;
	}

	public String getAccountName() {
		return accountName;
	}

	public SocialNetworkAccountType getSocialNetworkAccountType() {
		return socialNetworkAccountType;
	}
	
	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		
		if(o instanceof SocialNetworkAccount)
		{
			SocialNetworkAccount account = (SocialNetworkAccount)o;
			
			boolean ifAccountTypeEqual = this.socialNetworkAccountType.equals(account.socialNetworkAccountType) ;
			boolean ifAccountNameEqual = this.accountName.equals(account.accountName);
			boolean ifAccountIDEqual   = this.accountID == account.accountID;
			
			if (ifAccountTypeEqual == true && ifAccountNameEqual == true && ifAccountIDEqual == true)
				return true;
		}
		
		return false;
	}
	
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(socialNetworkAccountType).append(": ");
		sb.append("\n");
		
		if(accountName != "")
		{
			sb.append(accountName);
			sb.append("\n");
		}
					
		if(accountID != 0)
		{
			sb.append(accountID);
			sb.append("\n");
		}
			
		return sb.toString();
	}
	
}
