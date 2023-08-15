package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegisterPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	public void test_account_Registration() {

		try {

			logger.info("*** Starting TC_001_AccountRegistrationTest ***");

			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();

			logger.info("Clicked on My Account");

			hp.clickRegister();

			logger.info("Clicked on Register Link");

			AccountRegisterPage regpage = new AccountRegisterPage(driver);

			logger.info("Providing Customer Data");

			regpage.sendFirstName(randomAlphabetic());
			regpage.sendLastName(randomAlphabetic());
			regpage.sendEmailId(randomAlphabetic() + "@gmail.com");
			regpage.sendPassword(randomAlphanumeric());
			regpage.clickCheckBox();
			regpage.clickContinueButton();

			logger.info("Clicked on Continue Button");

			String confirmsg = regpage.getConfirmationMgs();
			Assert.assertEquals(confirmsg, "Your Account Has Been Created!");

			logger.info("Validating on Excepted Message");

		} catch (Exception e) {
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("*** Ending TC_001_AccountRegistrationTest ***");
	}
}
