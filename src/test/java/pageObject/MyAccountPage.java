package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	// constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// locator
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement mgsHeading;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement lnkLogout;

	// action methods
	public boolean isMyAccountPageExist() {

		try {
			return mgsHeading.isDisplayed();
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", lnkLogout);
		
//		lnkLogout.click();
	}
}
