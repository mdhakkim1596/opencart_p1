package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	// constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// locator
	@FindBy(id = "input-email")
	WebElement txtEmailAddress;

	@FindBy(id = "input-password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement btnLogin;

	// actions methods
	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

}
