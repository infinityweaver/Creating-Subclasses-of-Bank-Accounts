package banking;

public class CheckingAccount extends Account
{
	private SavingsAccount protectedBy;

	public CheckingAccount(double balance)
	{
		super(balance);
	}

	public CheckingAccount(double balance, SavingsAccount protect)
	{
		super(balance);
		this.protectedBy = protect;
	} 

	@Override
	public boolean withdraw(double amt)
	{	
		boolean canWithdraw = false;

		if (super.getBalance() >= amt)
		{
			canWithdraw = super.withdraw(amt);
		}

		else if (this.protectedBy != null)
		{
			double overdraft = amt - super.getBalance();

			if(overdraft <= this.protectedBy.getBalance())
			{
				canWithdraw = super.withdraw(super.getBalance());
				this.protectedBy.withdraw(overdraft);
			}
		}
		return canWithdraw;
	}
}

