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


public class LeaveApplicationTestCases extends BaseClass {
	methods Methods;
	UserInformation user = new UserInformation();
	Login Login;

	@BeforeMethod
	private void open() throws IOException, InterruptedException {
		browserOpen();
		Login=new Login(driver);
		Methods = new methods(driver);
		
	}

	@Test(priority = 0, enabled = true)
	private void Create_Leave_Application() throws InterruptedException, IOException {
		Login.loginUser("juniorbeforedate65267@softsuave.com", "softsuave");
		Methods.clickOnHRTab();
		Methods.createNewLeaveApplication("20-03-2023", "20-03-2023");

	}
 
	@Test(priority = 1 , enabled = false )
	private void Create_Leave_Application_on_duplicatedate() throws InterruptedException, IOException {
		Login.loginUser("juniorbeforedate65267@softsuave.com", "softsuave");
		Methods.clickOnHRTab();
		Methods.create_Leave_Application_On_Already_CreatedDate("20-03-2023", "20-03-2023");

	}
	
	@Test(priority = 2, enabled = true )
	private void APProve_Leave_appication() throws InterruptedException, IOException {
		Login.loginUser("adminqa@softsuave.com", "softsuave");
		Methods.clickOnHRTab();
		Methods.approve_Leave_Application("Approved");
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		Methods.logout_User();
		driver.close();
	}
	
	@AfterTest
	public void close() throws InterruptedException {
		driver.quit();
	}

}
