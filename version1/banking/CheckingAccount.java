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
		boolean possibleWithdrawal = false;

		if(super.getBalance() >= amt)
		{
			possibleWithdrawal = super.withdraw(amt);
		}

		else if(this.overdraftProtection > 0)
		{
			double overDraft = amt - super.getBalance();

			if(overDraft <= this.overdraftProtection)
			{
				possibleWithdrawal = super.withdraw(super.getBalance());
				this.overdraftProtection -= overDraft;
				
			}
		}

		return possibleWithdrawal;
	}
}