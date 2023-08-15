package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	public void test_login() {
		
		try {
			
		logger.info("*** Starting TC_002_LoginTest ***");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		
		logger.info("*** Clicked on My Account ***");
		
		hp.clickLogin();
		
		logger.info("*** Clicked on Login Link ***");
		
		LoginPage lp = new LoginPage(driver);
		
		logger.info("*** Providing Login Details ***");
		
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		
		logger.info("*** Clicked on Login Button ***");
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		
		boolean targetpage = myAccountPage.isMyAccountPageExist();
		Assert.assertEquals(targetpage, true);
		
		logger.info("*** Confirmation on Target Page ***");
		
		myAccountPage.clickLogout();
		logger.info("*** Clicked on Login Button ***");
		
	}
		catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Ending TC_002_LoginTest ***");
	}
	
}
