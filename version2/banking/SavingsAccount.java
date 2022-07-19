package banking;

public class SavingsAccount extends Account
{
	private double interestRate;

	public SavingsAccount(double balance, double interest_Rate)
	{
		super(balance);
		this.interestRate = interest_Rate;
	}
}