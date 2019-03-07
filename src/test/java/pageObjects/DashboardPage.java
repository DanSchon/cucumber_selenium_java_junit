package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

	public AddEmployeeForm addEmployeeForm;
	public EditEmployeeForm editEmployeeForm;
	
    public By header = By.cssSelector("#header > h1");
	public By addEmployeeButton = By.id("btnAddEmployee");
	
	public By editActionOfLastEmployeeRecord = By.cssSelector("#employee-table > tbody > tr:nth-last-child(1) > td:nth-child(9) > #btnEdit");
	public By netPayOfLastEmployeeRecord = By.cssSelector("#employee-table > tbody > tr:nth-last-child(1) > td:nth-child(8)");
	public By benefitCostOfLastEmployeeRecord = By.cssSelector("#employee-table > tbody > tr:nth-last-child(1) > td:nth-child(7)");
    public By firstNameOfLastEmployeeRecord = By.cssSelector("#employee-table > tbody > tr:nth-last-child(1) > td:nth-child(2)");
    
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHeaderText() {		
		this.waitForElementToBeVisible(this.header);
		return this.driver.findElement(this.header).getText();		

	}

	public void clickAddEmployeeButton() {
		this.waitForElementToBeClickable(this.addEmployeeButton);
		this.driver.findElement(this.addEmployeeButton).click();
		
	}

	public void clickEditActionOnLastEmployeeRecord() {
		this.waitForElementToBeVisible(editActionOfLastEmployeeRecord);
		this.driver.findElement(editActionOfLastEmployeeRecord).click();
	}

}
