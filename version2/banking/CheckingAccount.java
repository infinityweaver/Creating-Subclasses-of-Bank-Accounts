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
		boolean possibleWithdrawal = false;

		if(super.getBalance() >= amt)
		{
			possibleWithdrawal = super.withdraw(amt);
		}

		else if(this.protectedBy != null)
		{
		 	double draft = amt - super.getBalance();

		 	if(draft <= this.protectedBy.getBalance())
		 	{
		 	 	possibleWithdrawal = super.withdraw(super.getBalance());
		 	 	this.protectedBy.withdraw(draft);
		 		
		 	}
		}

		return possibleWithdrawal;
	}
}