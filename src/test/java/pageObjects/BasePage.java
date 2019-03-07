package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	public WebDriver driver;
	
	public void waitForElementToBeVisible(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}
	
	public void waitForElementToBeClickable(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 30); // 30 seconds
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void scrollToTheBottomOfThePage() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public void scrollToTheTopOfThePage() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, 0);");
	}
	
	public void waitForModalToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'modal fade')]")));
	}
	
}
