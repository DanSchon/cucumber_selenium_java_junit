package objectRepository;

public class Employee {
	public String firstName;
	public String lastName;
	public int numberOfDependents = 0;
	private boolean discountEligible;
	private double benefitCost;
	private double netPay;
	
	public Employee(String firstName) {
		this.firstName = firstName;
	}
	
	public boolean isDiscountEligible() {
		if (this.firstName.startsWith("a") || this.firstName.startsWith("A")) {
			this.setDiscountEligible(true);
		} else {
			this.setDiscountEligible(false);
		}
		return this.discountEligible;
	}

	private void setDiscountEligible(boolean discountEligible) {
		this.discountEligible = discountEligible;
	}

	public double getBenefitCost() {
		double costPerPeriod;
		double totalCost;
		int employeeCost = 1000;
		int dependentCost = 500;
		int numberOfPayPeriods = 26;
		double discount = 0.10;
		
		totalCost = employeeCost + (dependentCost * this.numberOfDependents);

		if (this.isDiscountEligible()) {
			totalCost = totalCost - (totalCost * discount);
			costPerPeriod = totalCost / numberOfPayPeriods;
			this.setBenefitCost(costPerPeriod);
		} else {
			costPerPeriod = totalCost / numberOfPayPeriods;
			this.setBenefitCost(costPerPeriod);
		}
		return this.benefitCost;
	}

	private void setBenefitCost(double benefitCost) {
		this.benefitCost = benefitCost;
	}

	public double getNetPay() {
		double biWeeklyPay = 2000;
		this.setNetPay(biWeeklyPay - this.getBenefitCost());
		return this.netPay;
	}

	private void setNetPay(double netPay) {
		this.netPay = netPay;
	}
	
	
}
