package pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRobotPage extends BasePage{
	
	//constructor
	public LoginRobotPage (WebDriver driver){
		super(driver);
	}
	
	//locator
	@FindBy(id = "input-email")
	WebElement txtEmailAddress;

	@FindBy(id = "input-password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement btnLogin;
	
	//actions methods
	public void setEmail(String email) throws AWTException {
		
		txtEmailAddress.sendKeys(email);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
	}
	
	public void setPassword(String password) throws AWTException {
		
		txtPassword.sendKeys(password);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
	}
	
	public void clickLogin() throws AWTException {
		Robot r2 = new Robot();
		r2.keyPress(KeyEvent.VK_TAB);
		r2.keyRelease(KeyEvent.VK_TAB);
		r2.keyPress(KeyEvent.VK_ENTER);
		r2.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
}
