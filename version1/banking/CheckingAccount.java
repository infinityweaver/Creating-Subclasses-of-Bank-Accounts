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
		boolean flag = false;
		if(amt <= super.getBalance())
		{
			flag = super.withdraw(amt);
		}
		else if(this.overdraftProtection > 0)
		{
			double difference = amt - super.getBalance();

			if(difference <= this.overdraftProtection)
			{
				super.withdraw(super.getBalance());
				flag = true;
			}
			else return flag;
		}
		return flag;
	}
}