Feature: As an Employer, I want to input my employee data so that I can get a preview of benefit costs.

Description: One of the critical functions that we provide for our clients is the ability to pay for their employees’ benefits packages. A portion of these costs are deducted from their paycheck, And we handle that deduction.

Rules:
- All employees are paid $2000 per paycheck before deductions
- There are 26 paychecks in a year
- The cost of benefits is $1000/year for each employee
- Each dependent incurs a cost of $500/year
- Employees whose first name begins with "A" or "a" receive a 10% discount

  Background: 
    Given I am an Employer
      And I am on the Benefits Dashboard page
      
  @automated
  Scenario: Employee changes their legal name and becomes eligible for discount
	When I select Add Employee
     And I enter valid Employee first name not starting with letter A
     And I enter valid Employee last name
	 And I enter valid Dependents value
	 And I click Submit on Add Employee modal
	 And I select Edit action for most recently created employee
	 And I enter new valid employee first name starting with letter A
	 And I click Submit on Edit Employee modal
	Then I should see the employee's record contains the new name on the table
	 And I should see that the employee now has a 10% discount
