package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_loginDDT(String email, String password, String exp) {

		logger.info("*** Starting TC_003_LoginDDT ***");

		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			logger.info("*** Clicked on My Account ***");
			
			hp.clickLogin();
			logger.info("*** Clicked on Login Link ***");

			LoginPage lp = new LoginPage(driver);
			logger.info("*** Providing Login Details ***");
			
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();
			logger.info("*** Clicked on Login Button ***");

			MyAccountPage myAccountPage = new MyAccountPage(driver);
			boolean targetpage = myAccountPage.isMyAccountPageExist();
//			Assert.assertEquals(targetpage, true);
//			myAccountPage.clickLogout();

			if (exp.equals("Valid")) {

				if (targetpage == true) {
					myAccountPage.clickLogout();
					Assert.assertTrue(true);
			logger.info("*** Confirmation on Target Page ***");
				} else {
					Assert.assertTrue(false);
			logger.info("*** Target Page not Displayed ***");
				}
				
			}

			if (exp.equals("Invalid")) {

				if (targetpage == true) {
					myAccountPage.clickLogout();
					Assert.assertTrue(false);
			logger.info("*** Target Page not Displayed ***");
				} else {
					Assert.assertTrue(true);
			logger.info("*** Target Page not Displayed ***");
				}

			}	
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Ending TC_003_LoginDDT ***");
	}
}
