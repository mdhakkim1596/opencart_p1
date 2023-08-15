package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {

	// constructor
	public AccountRegisterPage(WebDriver driver) {
		super(driver);
	}

	// locator
	@FindBy(id = "input-firstname")
	WebElement txtfirstname;

	@FindBy(id = "input-lastname")
	WebElement txtlastname;

	@FindBy(id = "input-email")
	WebElement txtemail;

	@FindBy(id = "input-password")
	WebElement txtpassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement lnkcheckbox;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement lnkcontinuebutton;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement mgsconfirm;

	// action methods
	public void sendFirstName(String fname) {
		txtfirstname.sendKeys(fname);
	}

	public void sendLastName(String lname) {
		txtlastname.sendKeys(lname);
	}

	public void sendEmailId(String email) {
		txtemail.sendKeys(email);
	}

	public void sendPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}

	public void clickCheckBox() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", lnkcheckbox);

//		lnkcheckbox.click();
	}

	public void clickContinueButton() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", lnkcontinuebutton);

//		lnkcontinuebutton.click();
	}

	public String getConfirmationMgs() {
		try {
			return (mgsconfirm.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
