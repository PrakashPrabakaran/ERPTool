package hrTests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ERP.methods;
import basePackage.BaseClass;
import basePackage.Login;
import basePackage.UserInformation;

public class CreateTimeSheet extends BaseClass{
	
	methods Methods;
	Login Login;
	UserInformation user = new UserInformation();
	
	@BeforeMethod
	private void open() throws IOException, InterruptedException {
		browserOpen();
		Login = new Login(driver);
		Methods = new methods(driver);
	}
	
	@Test(priority = 0, enabled = true)
	public void create_Timesheet() throws InterruptedException, IOException {
		Login.loginUser("juniorbeforedate65267@softsuave.com", "softsuave");
		Methods.clickOnHRTab();
		Methods.clickOnProjectTab();
		Methods.create_TimeSheet(user.Employee_ID_Junior1);
	}
	
	@Test(priority = 1, enabled = true)
	public void create_Timesheet_On_Same_Date() throws InterruptedException, IOException {
		Login.loginUser("juniorbeforedate65267@softsuave.com", "softsuave");
		Methods.clickOnHRTab();
		Methods.clickOnProjectTab();
		Methods.create_TimeSheet(user.Employee_ID_Junior1);
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		Methods.logout_User();
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
