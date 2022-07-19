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
			super.deposit(-amt);
			possibleWithdrawal = true;
		}

		else if(overdraftProtection > 0)
		{
			double overDraft = super.getBalance() - amt;

			if(overdraftProtection + overDraft > 0)
			{
				possibleWithdrawal = true;
				super.deposit(-super.getBalance());
			}
		}

		return possibleWithdrawal;
	}
}