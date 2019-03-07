package stepDefinitions;

import objectRepository.Employee;
import objectRepository.Employer;
import pageObjects.AddEmployeeForm;
import pageObjects.DashboardPage;
import pageObjects.EditEmployeeForm;
import pageObjects.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

public class ChallengeSteps {
	public WebDriver driver;
	public Employer employer;
	public Employee employee;
	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	
	@Before("@automated")
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "drivers" + File.separator +  "chromedriver");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Given("^I am an Employer$")
    public void i_am_an_employer() throws Throwable {
        employer = new Employer();
    }
	
    @And("^I am on the Benefits Dashboard page$")
    public void i_am_on_the_benefits_dashboard_page() throws Throwable {
        loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login(employer.username, employer.password);
        dashboardPage = new DashboardPage(driver);
        assertEquals(dashboardPage.getHeaderText(), "Benefits Dashboard");
    }
    
    @When("^I select Add Employee$")
    public void i_select_add_employee() throws Throwable {
        dashboardPage.clickAddEmployeeButton();
    	dashboardPage.addEmployeeForm = new AddEmployeeForm(driver);
    }
    
    @And("^I enter valid Employee first name not starting with letter A$")
    public void i_enter_valid_employee_first_name_not_starting_with_letter_a() throws Throwable {
    	employee = new Employee("Benjamin");
    	dashboardPage.addEmployeeForm.enterFirstName(employee.firstName);
    }

    @And("^I enter valid Employee last name$")
    public void i_enter_valid_employee_last_name() throws Throwable {
    	Faker faker = new Faker();
    	String lastName = faker.lastName();
    	employee.lastName = lastName;
    	dashboardPage.addEmployeeForm.enterLastName(employee.lastName);
    }

    @And("^I enter valid Dependents value$")
    public void i_enter_valid_dependents_value() throws Throwable {
        employee.numberOfDependents = 1;
    	dashboardPage.addEmployeeForm.enterNumberOfDependents(employee.numberOfDependents);
    }

    @And("^I click Submit on Add Employee modal$")
    public void i_click_submit_on_add_employee_modal() throws Throwable {
    	dashboardPage.addEmployeeForm.submit();
    }
    
    @And("^I select Edit action for most recently created employee$")
    public void i_select_edit_action_for_created_employee() throws Throwable {
    	dashboardPage.clickEditActionOnLastEmployeeRecord();
    	dashboardPage.editEmployeeForm = new EditEmployeeForm(driver); 
    }
    
	@And("^I enter new valid employee first name starting with letter A$")
    public void i_enter_new_valid_employee_first_name_starting_with_letter_a() throws Throwable {
        employee.firstName = "Adam";
    	dashboardPage.editEmployeeForm.enterFirstName(employee.firstName);
    }

    @And("^I click Submit on Edit Employee modal$")
    public void i_click_submit_on_edit_employee_modal() throws Throwable {
    	dashboardPage.addEmployeeForm.submit();
    }
    
    @Then("^I should see the employee's record contains the new name on the table$")
    public void i_should_see_the_employees_record_contains_the_new_name_on_the_table() throws Throwable {
    	String firstNameOfLastEmployeeRecord = dashboardPage.driver.findElement(dashboardPage.firstNameOfLastEmployeeRecord).getText();
    	assertEquals(employee.firstName, firstNameOfLastEmployeeRecord);
    }

    @And("^I should see that the employee now has a 10% discount$")
    public void i_should_see_that_the_employee_now_has_a_10_discount() throws Throwable {
    	String netPayOfLastEmployeeRecord = dashboardPage.driver.findElement(dashboardPage.netPayOfLastEmployeeRecord).getText();
    	String benefitCostOfLastEmployeeRecord = dashboardPage.driver.findElement(dashboardPage.benefitCostOfLastEmployeeRecord).getText();

    	assertEquals(String.format("%.2f", employee.getNetPay()), netPayOfLastEmployeeRecord);
    	assertEquals(String.format("%.2f", employee.getBenefitCost()), benefitCostOfLastEmployeeRecord);
    }
	
	@After("@automated")
	public void tearDown() {
		driver.quit();
	}

}
