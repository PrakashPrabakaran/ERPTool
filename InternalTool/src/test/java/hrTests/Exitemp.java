package hrTests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ERP.methods;
import basePackage.BaseClass;
import basePackage.Login;
import basePackage.UserInformation;

public class Exitemp extends BaseClass{

	methods Methods;
	Login Login;
	UserInformation user = new UserInformation();


	
	@BeforeMethod
	private void open() throws IOException, InterruptedException {
		browserOpen();
		Login=new Login(driver);
		Methods = new methods(driver);
	
}
	
	@Test(enabled = false)
	public void exit() throws IOException, InterruptedException
	{
		Login.loginUser("adminqa@softsuave.com","softsuave");
	    Methods.exitEmp();

	}
	
	@Test
	public void exit_employee() throws InterruptedException, IOException {
		Login.loginUser("adminqa@softsuave.com","softsuave");
		Methods.createNewUser(user.Employee1_FirstName, user.Employee1_LastName);
		Methods.clickOnAppLogoButton();
		Methods.clickOnHRTab();
		System.out.println("Creating the junior employee details with a joining date before 25th");
		Methods.clickOnEmployeeButton();
		Methods.createNewEmployee(user.Employee1_FirstName, user.Employee1_LastName, user.Employee_DOJ1, user.Employee_Leave_Policy_Tech_Junior, user.Employee_Fresher);
		Methods.exitEmp();
	}
	
}