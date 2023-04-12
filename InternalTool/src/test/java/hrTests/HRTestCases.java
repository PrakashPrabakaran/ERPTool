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



public class HRTestCases extends BaseClass {
	
	methods Methods;
	UserInformation user = new UserInformation();

	@BeforeMethod
	private void open() throws IOException, InterruptedException {
		browserOpen();
		new Login(driver).loginUser("adminqa@softsuave.com", "softsuave");
		Methods = new methods(driver);
	}
	
	//Creating a new Employee-Fresher with Joining Date Before 25
	@Test(priority = 0, description ="P0: Verify the user is able to create Junior Employee", enabled = false)
	private void create_Junior_Employee_Before_Buffer_Date() throws IOException, InterruptedException {
//		Methods.createNewUser(user.Employee1_FirstName, user.Employee1_LastName);
		Methods.clickOnAppLogoButton();
		Methods.clickOnHRTab();
		System.out.println("Creating the junior employee details with a joining date before 25th");
		Methods.clickOnEmployeeButton();
		Methods.createNewEmployee(user.Employee1_FirstName, user.Employee1_LastName, user.Employee_DOJ1, user.Employee_Leave_Policy_Tech_Junior, user.Employee_Fresher);
		Methods.clickOnAppLogoButton();
		Methods.clickOnHRTab();
		Methods.verifyTotalLeaveAllocation(user.Before_Buffer_Date);
		System.out.println("Successfully created the junior employee details with a joining date before the 25th");
	}
	
	//Creating a new Employee-Fresher with Joining Date After 25
	@Test(priority = 1, description ="P0: Verify the user is able to create Junior Employee", enabled = false)
	private void create_Junior_Employee_After_Buffer_Date() throws IOException, InterruptedException {
		Methods.createNewUser(user.Employee2_FirstName, user.Employee2_LastName);
		Methods.clickOnAppLogoButton();
		Methods.clickOnHRTab();
		System.out.println("creating the experienced employee details with a join date after 25th");
		Methods.clickOnEmployeeButton();
		Methods.createNewEmployee(user.Employee2_FirstName, user.Employee2_LastName, user.Employee_DOJ2, user.Employee_Leave_Policy_Tech_Junior, user.Employee_Fresher);
		Methods.clickOnAppLogoButton();
		Methods.clickOnHRTab();
		Methods.verifyTotalLeaveAllocation(user.After_Buffer_Date);
		System.out.println("Successfully created the junior employee details with a joining date after the 25th");
	}
	
	//Creating a new Employee-Senior with Joining Date Before 25
	@Test(priority = 2, description ="P0: Verify the user is able to create Senior Employee", enabled = true)
	private void create_Senior_Employee_Before_Buffer_Date() throws IOException, InterruptedException {
//		Methods.createNewUser(user.Employee3_FirstName, user.Employee3_LastName);
		Methods.clickOnAppLogoButton();
		Methods.clickOnHRTab();
		System.out.println("Creating the senior employee details with a join date before 25th");
		Methods.clickOnEmployeeButton();
		Methods.createNewEmployee(user.Employee3_FirstName, user.Employee3_LastName, user.Employee_DOJ1, user.Employee_Leave_Policy_Tech_Senior, user.Employee_Experienced);
		Methods.clickOnAppLogoButton();
		Methods.clickOnHRTab();
		Methods.verifyTotalLeaveAllocation(user.Before_Buffer_Date);
		System.out.println("Successfully created the senior employee details with a joining date before the 25th");
	}
	
	//Creating a new Employee-Senior with Joining Date After 25
	@Test(priority = 3, description ="P0: Verify the user is able to create Senior Employee", enabled = false)
	private void create_Senior_Employee_After_Buffer_Date() throws IOException, InterruptedException {
		Methods.createNewUser(user.Employee4_FirstName, user.Employee4_LastName);
		Methods.clickOnAppLogoButton();
		Methods.clickOnHRTab();
		System.out.println("reating the Experienced Employee details with Join Date After 25th");
		Methods.clickOnEmployeeButton();
		Methods.createNewEmployee(user.Employee4_FirstName, user.Employee4_LastName, user.Employee_DOJ2, user.Employee_Leave_Policy_Tech_Senior, user.Employee_Experienced);
		Methods.clickOnAppLogoButton();
		Methods.clickOnHRTab();
		Methods.verifyTotalLeaveAllocation(user.After_Buffer_Date);
		System.out.println("Successfully created the senior employee details with a joining date before the 25th");
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
//		Methods.Logout_User();
	}
	
	@AfterTest
	public void close() {
//		driver.quit();
	}
	
}