package banking;


public class SavingsAccount extends Account
{
	private double balance;
	private double interestRate;
	
	public SavingsAccount(double balance, double ineterest_rate)
	{
		super(balance);
		this.interestRate = ineterest_rate;
	}
}