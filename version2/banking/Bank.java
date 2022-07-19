package banking;
import java.util.*;

public class Bank
{
	private ArrayList<Customer> customers;

	public Bank()
	{
		this.customers = new ArrayList<Customer>();
	}

	public void addCustomer(String firstName, String lastName)
	{
		this.customers.add(new Customer(firstName, lastName));
	}

	public int getNumOfCustomers()
	{
		return this.customers.size();
	}

	public Customer getCustomer(int index)
	{
		return this.customers.get(index);
	}
}