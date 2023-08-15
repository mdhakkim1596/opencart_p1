package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProviders always use in multi dimensional array

	// DataProvider 1

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String path = ".\\testData\\Opencart_LoginData.xlsx"; // take a data from testData

		ExcelUtility xlutility = new ExcelUtility(path); // create a object
		int totalrows = xlutility.getRowCount("Sheet1");
		int totalcells = xlutility.getCellCount("Sheet1", 1);

		String[][] logindata = new String[totalrows][totalcells]; // create two dimensional array

		for (int i = 1; i <= totalrows; i++) {

			for (int j = 0; j < totalcells; j++) {
				logindata[i - 1][j] = xlutility.getCellData("Sheet1", i, j);
			}

		}
		return logindata;	//returning two dimensional array
	}
	// DataProvider 2

	// DataProvider 3

}
