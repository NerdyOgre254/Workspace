public class TaxCalculator {

	public static void main(String[] args) throws InvalidSalaryException, InvalidTaxRateException 
	{
		System.out.println(getTax(1000, 0.55));
		System.out.println(getTax(0, 0.98));
		System.out.println(getTax(2500, 2));
		System.out.println(getTax(-666, -480));
		// TODO Auto-generated method stub
		//test code by calling getTax();
		

	}
	public static double getTax(double salary, double taxRate) throws InvalidSalaryException, InvalidTaxRateException
	{
		if(salary <0)
		{
			throw new InvalidSalaryException("Incorrect salary value: Must be greater than 0");
		}
		else if (taxRate <0)
		{
			throw new InvalidTaxRateException("Tax rate cannot be negative");
		}
		else if (taxRate >1)
		{
			throw new InvalidTaxRateException("Tax rate cannot be greater than 1");
		}
		else
		{
			return salary * taxRate;
		}
		//salary must be greater than 0
		//tax rate must be between 0 and 1 inclusive
		//if neither of these conditions are met, throw IllegalArgumentException
		//Otherwise return salary * taxRate
	}

}
/*
try
{
	getTax(good, bad);
}
catch (IAE iae)
{
	iae.getmessage(one good, one bad);
}

try
{
	getTax(bad, good);
}
catch (IAE iae)
{
	iae.getmessage(one bad, one good);
}


*/