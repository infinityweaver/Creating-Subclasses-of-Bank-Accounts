package banking;
public class CheckingAccount extends Account
{
	private SavingsAccount protectedby;

	public CheckingAccount(double balance)
	{
		super(balance);
	}

	public CheckingAccount(double balance, SavingsAccount protect)
	{
		super(balance);
		this.protectedby = protect;
	}

	@Override
	public boolean withdraw(double amt)
	{
		{
		boolean flag = false;
		if(amt <= super.getBalance())
		{
			flag = super.withdraw(amt);
		}
		else if(this.protectedby != null)
		{
			double gap = amt - super.getBalance();
			if(gap <= this.protectedby.getBalance())
			{
				flag = super.withdraw(super.getBalance());
				this.protectedby.withdraw(gap);
			}
		}
		return flag;
		}
	}
}