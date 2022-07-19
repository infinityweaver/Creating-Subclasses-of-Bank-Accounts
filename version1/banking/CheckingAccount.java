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
		boolean canWithdraw = false;

		if (super.getBalance() >= amt)
		{
			canWithdraw = super.withdraw(amt);
		}

		else if (this.overdraftProtection > 0)
		{
			double overdraft = amt - super.getBalance();

			if(overdraft <= this.overdraftProtection)
			{
				canWithdraw = super.withdraw(super.getBalance());
				this.overdraftProtection -= overdraft;
			}
		}
		return canWithdraw;
	}
}
