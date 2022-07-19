package banking;

public class Customer
{
	private String firstName;
	private String lastName;
	private SavingsAccount savingsAccount;
	private CheckingAccount checkingAccount;

	public Customer(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public String getLastName()
	{
		return this.lastName;
	}

	public SavingsAccount getSavingsAccount()
	{
		return this.savingsAccount;
	}

	public CheckingAccount getCheckingAccount()
	{
		return this.checkingAccount;
	}

	public void setSavingsAccount(SavingsAccount savings)
	{
		this.savingsAccount = savings;
	}

	public void setCheckingAccount(CheckingAccount checking)
	{
		this.checkingAccount = checking;
	}
}	