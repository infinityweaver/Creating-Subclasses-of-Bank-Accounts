package banking;

public class CheckingAccount extends Account
{
	double overdraftProtection;

	public CheckingAccount(double balance)
	{
		super(balance);
	}

	public CheckingAccount(double  balance, double protect)
	{
		super(balance);
		this.overdraftProtection = protect;
	}

	@Override
	public boolean withdraw(double amt)
	{
		boolean pwithdrawal = false;

		if(super.getBalance() >= amt)
		{
			pwithdrawal = super.withdraw(amt);
		}
		else if(this.overdraftProtection > 0)
		{
			double diff = amt - super.getBalance();

			if(diff <= this.overdraftProtection )
			{
				pwithdrawal = super.withdraw(super.getBalance());
				this.overdraftProtection -= diff;
			}
		}
		return pwithdrawal;
	}
}