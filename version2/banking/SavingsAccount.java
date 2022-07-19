package banking;

public class SavingsAccount extends Account
{
	double interestRate;

	public SavingsAccount(double balance, double interest_rate)
	{
		super(balance);
		this.interestRate = interest_rate;
	}
} 