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
		if(super.getBalance() >= amt)
		{
			super.withdraw(amt);
			return true;
		}
		else if(protectedBy != null)
		{
			double bal = amt - super.getBalance();
			if(protectedBy.getBalance() >= bal)
			{
				super.withdraw(super.getBalance());
				protectedBy.withdraw(bal);
				return true;
			}
			else
				return false;
		} 		
		else
			return false;
	}
}