package banking;

public class CheckingAccount extends Account
{
	private double overdraftProtection;

	public CheckingAccount(double balance)
	
	{
		super(balance);
	}

	public CheckingAccount(double balance, double protect)
	{
		super(balance);
		this.overdraftProtection = protect;
	}

	@Override
	public boolean withdraw(double amt)
	{
		if (super.getBalance() >= amt)
		{
			super.withdraw(amt);
			return true;
		}
		else if (overdraftProtection > 0)
		{
			double bal = amt - super.getBalance();
			if (overdraftProtection >= bal)
			{
				super.withdraw(super.getBalance());
				overdraftProtection -= bal;
				return true;
			}
			else
				return false;
		} 		
		else
			return false;
	}
}