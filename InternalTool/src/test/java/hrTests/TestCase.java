package hrTests;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ERP.constants;
import ERP.methods;
import ERP.pageLocators;
import basePackage.BaseClass;
import basePackage.Login;
import basePackage.UserInformation;

public class TestCase extends BaseClass {

	methods Methods;
	UserInformation user = new UserInformation();
	Login Login;
	pageLocators locators = new pageLocators();
	constants Constants = new constants();

	@BeforeMethod
	private void open() throws IOException, InterruptedException {
		browserOpen();
		Login = new Login(driver);
		Methods = new methods(driver);
	}

	// Creating a new Employee-Fresher with Joining Date Before
	@Test(priority = 0, description = "Verify the user is able to create Junior Employee", enabled = false)
	public void Create_Employee_Before_Buffer_Date() throws IOException, InterruptedException {
		Login.loginUser(user.Admin, user.Password);
		Methods.createNewUser(user.Employee1_FirstName, user.Employee1_LastName);
		Methods.clickOnAppLogoButton();
		Methods.clickOnHRTab();
		System.out.println("Creating the junior employee details with a joining date before 25th");
		Methods.clickOnEmployeeButton();
		Methods.createNewEmployee(user.Employee1_FirstName, user.Employee1_LastName, user.Employee_DOJ1,
				user.Employee_Leave_Policy_Tech_Junior, user.Employee_Fresher);
		Methods.clickOnAppLogoButton();
		Methods.clickOnHRTab();
		Methods.verifyTotalLeaveAllocation(user.Before_Buffer_Date);
		System.out.println("Successfully created the junior employee details with a joining date before the 25th");
	}

	@Test(priority = 1, description = "Verify an employee/approver can create an attendance, approval and cancel the attendace.", enabled = false)
	public void ADD_Attendence() throws InterruptedException, IOException {
		Login.loginUser(user.Admin, user.Password);
		Methods.hR_Module_Tab();
		Methods.add_Attendence(user.Employee_ID_Junior1, user.Attendance_Date, "Less Hour");
		Methods.clickOnAppLogoButton();
		Methods.logout_User();
		Login.loginUser(user.Junior_Before_Date, user.Password);
		Methods.HR2();
		Methods.less_Hour_Attendance_Request(user.Attendance_Date);
		Methods.logout_User();
		Login.loginUser(user.Admin, user.Password);
		Methods.HR2();
		Methods.approve_Less_Hour_Request("Approved");
		Methods.cancel_Less_Hour_Attendance();
	}

	@Test(priority = 2, description = "Verify the employee/approver is able to create Leave Application,approval and cancel the leave", enabled = false)
	private void Create_Leave_Application() throws InterruptedException, IOException {
		Login.loginUser(user.Junior_Before_Date, user.Password);
		Methods.clickOnHRTab();
		Methods.createNewLeaveApplication(user.From_Date, user.To_Date);
		Methods.logout_User();
		Login.loginUser(user.Admin, user.Password);
		Methods.clickOnHRTab();
		Methods.approve_Leave_Application("Approved");
		Methods.cancel_Leave();
	}

	@Test(priority = 3, description = "Verify the user is able to create and delete the timesheet", enabled = false)
	public void Create_Timesheet() throws InterruptedException, IOException {
		Login.loginUser(user.Junior_Before_Date, user.Password);
		Methods.clickOnHRTab();
		Methods.clickOnProjectTab();
		Methods.create_TimeSheet(user.Employee_ID_Junior1);
		Methods.logout_User();
		Login.loginUser(user.Admin, user.Password);
		Methods.clickOnHRTab();
		Methods.clickOnProjectTab();
		Methods.approve_Timesheet();
		Methods.timesheet_cancel();
	}

	@Test(priority = 3, description = "Verify the employee/approver is able to create Leave Application,approval and cancel the leave", enabled = false)
	private void Create_Sandwhich_Leave_Application() throws InterruptedException, IOException, AWTException {
		Login.loginUser(user.Junior_Before_Date, user.Password);
		Methods.clickOnHRTab();
		Methods.createNewLeaveApplication(user.From_Date, user.To_Date);
		Methods.refreshpage();
		// driver.switchTo().alert().accept();
		Methods.clickOnAppLogoButton();
		Methods.clickOnHRTab();
		Thread.sleep(2000);
		Methods.createNewLeaveApplication(user.Sandwich_From_Date, user.Sandwich_To_Date);
		Methods.messageprint();
		Assert.assertEquals(Methods.messageprint(), Constants.Sandwich_Alert_Message);
		System.out.println("Sandwich alert message verified");
		Methods.logout_User();
		Alert alert = driver.switchTo().alert();
		driver.switchTo().alert().accept();
		Login.loginUser(user.Admin, user.Password);
		Methods.clickOnHRTab();
		Methods.approve_Leave_Application("Approved");
		Methods.cancel_Leave();

	}

	@Test(priority = 4, description = "Verify the user is unable to create Junior Employee without fill mandatory fields", enabled = false)
	public void Create_Employee_Before_without_fill_mandatory_fieldse() throws IOException, InterruptedException {
		Login.loginUser(user.Admin, user.Password);
		Methods.createNewUser(user.Employee1_FirstName, user.Employee1_LastName);
		Methods.clickOnAppLogoButton();
		Methods.clickOnHRTab();
		Methods.clickOnEmployeeButton();
		Methods.createNewEmployeewithoutfillmandatoryfields(user.Employee1_FirstName, user.Employee1_LastName,
        user.Employee_DOJ1, user.Employee_Leave_Policy_Tech_Junior, user.Employee_Fresher);
		Methods.messageprint();
		Assert.assertEquals(Methods.messageprint(), Constants.Employee_without_fill__mandatory_fields_Message);
		System.out.println("Employee without fill mandatory fields Message verified");

	}
	@Test(priority = 5, description = "Verify the user is able to create and delete the timesheet", enabled = true)
	public void Create_Timesheet_Future_Date() throws InterruptedException, IOException {
		Login.loginUser(user.Junior_Before_Date, user.Password);
		Methods.clickOnHRTab();
		Methods.clickOnProjectTab();
		Methods.Create_Timesheet_Future_Date("Junior Beforedate");
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
