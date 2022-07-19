package banking;

public class CheckingAccount extends Account
{
	private SavingsAccount protectedBy;

	public CheckingAccount(double balance)
	{
		super(balance);
	}

	public CheckingAccount(double  balance, SavingsAccount protect)
	{
		super(balance);
		this.protectedBy = protect;
	}

	@Override
	public boolean withdraw(double amt)
	{
		flag = false;

		if(super.getBalance() >= amt)
		{
			flag = super.withdraw(amt);
		}
		else if(this.protectedBy  != null)
		{
			double diff = amt - super.getBalance();

			if(diff <= this.protectedBy.getBalance())
			{
				flag = super.withdraw(super.getBalance());
				this.protectedBy.withdraw(diff);
			}
		}
		return draw;
	}
}