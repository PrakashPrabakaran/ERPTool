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

public class LessHourAttendenceRequest extends BaseClass{
	
	
	methods Methods;
	Login Login;
	UserInformation user = new UserInformation();

	
	@BeforeMethod
	private void open() throws IOException, InterruptedException {
		browserOpen();
		Login=new Login(driver);
		Methods = new methods(driver);
		
	}
	
	@Test(priority = 0)
	public void HR() throws InterruptedException, IOException
	{
		Login.loginUser("juniorbeforedate65267@softsuave.com", "softsuave");
		Methods.HR2();
		Methods.less_Hour_Attendance_Request("02-03-2023");
		
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

