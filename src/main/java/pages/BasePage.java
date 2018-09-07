package pages;

import driver.DriverInstanceManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.Closeable;

public class BasePage implements Closeable  {

	protected By locator;
	public BasePage(By by) {
		this.locator = by;
	}

	protected WebDriver getDriver() {
		return DriverInstanceManager.getDriverInstance();
	}
	protected WebElement findElementInside(By by) {
		return getDriver().findElement(this.locator).findElement(by);
	}
	
	protected Iterable<WebElement> findElementsInside(By by) {
		return getDriver().findElement(this.locator).findElements(by);
	}
	
	@Override
	public void close(){ DriverInstanceManager.closeDriver(); }
	
	public String getUrl() {
		return getDriver().getCurrentUrl();
	}
	public String getTitle(){
		return getDriver().getTitle();
	}
}
