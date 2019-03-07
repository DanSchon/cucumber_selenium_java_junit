package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeeForm extends BasePage {

	public By firstNameField = By.xpath("//*[@id='employees-form']/div[1]//input");
	public By lastNameField = By.xpath("//*[@id='employees-form']/div[2]//input");
	public By dependentsField = By.xpath("//*[@id='employees-form']/div[3]//input");
	public By submitButton = By.xpath("//*[@id='employees-form']/div[4]//button");
	
	public AddEmployeeForm(WebDriver driver) {
		this.driver = driver;
	}

	public void enterFirstName(String firstName) {
		this.waitForElementToBeVisible(this.firstNameField);
		this.driver.findElement(this.firstNameField).clear();
		this.driver.findElement(this.firstNameField).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		this.driver.findElement(this.lastNameField).clear();
		this.driver.findElement(this.lastNameField).sendKeys(lastName);
	}

	public void enterNumberOfDependents(int numberOfDependents) {
		String dependents = Integer.toString(numberOfDependents);
		this.driver.findElement(this.dependentsField).clear();
		this.driver.findElement(this.dependentsField).sendKeys(dependents);
	}

	public void submit() {
		this.waitForElementToBeClickable(this.submitButton);
		this.driver.findElement(this.submitButton).click();
		this.waitForModalToDisappear();
	}

}
