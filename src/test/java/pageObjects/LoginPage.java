package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import objectRepository.Employer;

public class LoginPage extends BasePage {

	public By usernameField = By.cssSelector("input[name='form-username']");
	public By passwordField = By.cssSelector("input[name='form-password']");
	public By loginButton = By.id("btnLogin");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigate() {
		this.driver.get("file:///Users/danielschonfeld/Desktop/InterviewChallenge/login.html");		
	}
	
	public void login(String username, String password) {
		this.enterUsername(username);
		this.enterPassword(password);
		this.clickLoginButton();
	}
	
	public void login(Employer employer) {
		this.enterUsername(employer.username);
		this.enterPassword(employer.password);
		this.clickLoginButton();
	}

	private void enterUsername(String username) {
		this.waitForElementToBeVisible(usernameField);
		driver.findElement(usernameField).clear();
		driver.findElement(usernameField).sendKeys(username);
	}
	
	private void enterPassword(String password) {
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}
	
	private void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

}
