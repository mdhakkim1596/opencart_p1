package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginRobotPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_004_LoginTest_RobotClass extends BaseClass{
	
	
	@Test(groups = {"Sanity","Master"})
	public void test_loginRobotClass() throws AWTException {
		
		try {
		logger.info("*** Starting TC_004_LoginTest_RobotClass ***");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		logger.info("*** Clicked on My Account ***");
		
		hp.clickLogin();
		logger.info("*** Clicked on Login Link ***");
		
		LoginRobotPage lr = new LoginRobotPage(driver);
		logger.info("*** Providing Login Details ***");
		
		lr.setEmail(rb.getString("email"));
		logger.info("*** Enter Email Id ***");
		
		lr.setPassword(rb.getString("password"));
		logger.info("*** Enter Password ***");
		
		lr.clickLogin();
		logger.info("*** Clicked on Login Button ***");
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		boolean targetpage = myAccountPage.isMyAccountPageExist();
		Assert.assertEquals(targetpage, true);
		
		logger.info("*** Confirmation on Target Page ***");
		
		myAccountPage.clickLogout();
		logger.info("*** Clicked on Logout Button ***");
	}
		catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Ending TC_004_LoginTest_RobotClass ***");
		}
}
