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
		boolean flag = false;
		if(amt <= super.getBalance())
		{
			flag = super.withdraw(amt);
		}
		else if(this.protectedBy != null)
		{
			double difference = amt - super.getBalance();
			if(difference <= this.protectedBy.getBalance())
			{
				flag = super.withdraw(super.getBalance());
				this.protectedBy.withdraw(difference);
			}
		}
		return flag;
	}
}