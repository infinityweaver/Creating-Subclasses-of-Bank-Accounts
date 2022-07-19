package banking;

public class Account
{
	private double balance;

	public Account(double init_balance)
	{
		this.balance = init_balance;
	}

	public double getBalance()
	{
		return this.balance;
	}

	public boolean deposit(double amt)
	{
		this.balance += amt;
		return true;
	}

	public boolean withdraw(double amt)
	{
		boolean flag = false;
		if(amt <= this.balance)
		{
			this.balance -= amt;
			flag = true;
		}

		return flag;
	}
}