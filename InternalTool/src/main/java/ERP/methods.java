package ERP;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;
import basePackage.UserInformation;

public class methods extends BaseClass{
	
	

	pageLocators locators;
	 
	 UserInformation user = new UserInformation();
	 
	 String EmployeeID = "" ;

		public methods(WebDriver driver) {

			locators = PageFactory.initElements(driver, pageLocators.class);
		}
	 
	 //Click on HRTab
	public void clickOnHRTab() {
		waitForElementClickable(locators.HR_TAB);
		locators.HR_TAB.click();
		System.out.println("The 'HR' tab has been clicked");
		
	}
	
	public void clickOnEmployeeButton() {
		waitForElementClickable(locators.EMPLOYEE_BUTTON);
		locators.EMPLOYEE_BUTTON.click();
		System.out.println("The 'Employee' button has been clicked");
	}
	
	public void createNewEmployee(String Fname,String Lname,String DOJ,String LeavePolicy,String WorkExp) throws InterruptedException {
		locators.ADD_EMPLOYEE.click();
		System.out.println("Clicked on 'Add New Employee'");
		locators.EMPLOYEE_FIRSTNAME.sendKeys(Fname);
		locators.EMPLOYEE_LASTNAME.sendKeys(Lname);
		locators.EMPLOYEE_GENDER.sendKeys(user.Employee_Gender);
		locators.EMPLOYEE_DOB.sendKeys(user.Employee_DOB);
		locators.EMPLOYEE_DOJ.sendKeys(DOJ);
		System.out.println("Entered the employee details for '"+Fname+" "+Lname+"' with a joining date of " + DOJ);
		locators.EMPLOYEE_LEAVE_APPROVER.sendKeys(user.Employee_Leave_Approver);
		System.out.println("Selected '"+user.Employee_Leave_Approver+"' as the employee leave approver");
		locators.EMPLOYEE_PROJECT_MANAGER.sendKeys(user.Employee_Project_Manager);
		System.out.println("Selected '"+user.Employee_Project_Manager+"' as the employee project manager");
		waitForElement(locators.ATTENDANCE_LEAVE_BUTTON);
		locators.ATTENDANCE_LEAVE_BUTTON.click();
		locators.LEAVE_POLICY_DETAIL.sendKeys(LeavePolicy);
		System.out.println("Selected '"+LeavePolicy+"' as the employee leave policy");
		locators.HOLIDAY_LIST.sendKeys(user.Employee_Holiday_List);
		locators.DEFAULT_SHIFT.sendKeys(user.Employee_Shift);
		System.out.println("Selected '"+user.Employee_Shift+"' as the employee shift time.");
		waitForElement(locators.PREVIOUS_WORK_EXP_BUTTON);
		locators.PREVIOUS_WORK_EXP_BUTTON.click();
		selectByVisibletext(locators.PREVIOUS_WORK_EXP_OPTION,WorkExp);
		waitForElement(locators.EMPLOYEE_SAVE);
		locators.EMPLOYEE_SAVE.click();
		waitForElement(locators.POPUP_ALERT);
		VerifyTextValidation(locators.POPUP_ALERT, constants.Success_Text);
		waitForElement(locators.CLOSE_POPUP_ALERT);
		locators.CLOSE_POPUP_ALERT.click();
		Thread.sleep(3000);
		EmployeeID = locators.EMPLOYEE_ID.getText();
		System.out.println("The new employee has been created with an employee ID of '"+EmployeeID+"'");
	}
	
	
	public void clickOnAppLogoButton() {
		waitForElement(locators.CLICK_APP_LOGO);
		locators.CLICK_APP_LOGO.click();
		System.out.println("Clicked on the 'ERP App logo'");

	}
	
	/**
	 * Verifying the total leaves allocated for the employee
	 * @param date
	 * @throws InterruptedException
	 */
	public void verifyTotalLeaveAllocation(String Total_Allocated_Leaves) throws InterruptedException {
		System.out.println("Validating Total Allocated Leaves for an Employee");
		waitForElement(locators.LEAVE_APPLICATION_BUTTON);
		locators.LEAVE_APPLICATION_BUTTON.click();
		locators.ADD_LEAVE_APPLICATION_BUTTON.click();
		waitForElementClickable(locators.LA_EMPLOYEE_NAME);
		locators.LA_EMPLOYEE_NAME.sendKeys(EmployeeID+Keys.ENTER);
		mouseoveractions(locators.TOTAL_ALLOCATED_LEAVE);
		VerifyTestResult(locators.TOTAL_ALLOCATED_LEAVE, Total_Allocated_Leaves);
		System.out.println("Verified the Total Leave allocation for an employee.");
	}
	
	public void HR()
	{
		locators.HR_Module.click();
	}
	
	/**
	 * Creating Attendance Request for the employee.
	 * @param emp name,date
	 * @throws InterruptedException
	 */
	
	public void AttendenceRequest(String name,String status) throws InterruptedException
	{
		waitForElement(locators.AR_ATTENDENCE_REQUEST);
		locators.AR_ATTENDENCE_REQUEST.click();
		locators.AR_ADD_ATTENDENCE_REQUEST.click();
		locators.AR_SELECT_FROMDATE.click();
		locators.AR_PICK_FROM_DATE.click();
		locators.AR_SELECT_TO_DATE.click();
		locators.AR_PICK_TO_DATE.click();
		selectByVisibletext(locators.AR_DATA_SELECT,status);
		locators.AR_DATA_FIELD_NAME.sendKeys(user.AR_Explanation);
		locators.AR_DATA_FIELD_TYPE.click();
		locators.AR_FILE_UPLOAD.sendKeys(user.AR_Attach);
		Thread.sleep(3000);
		waitForElement(locators.AR_STANDARD_ACTIONS);
		locators.AR_STANDARD_ACTIONS.click();
		Thread.sleep(3000);
		locators.AR_STANDARD_ACTIONS_FELX.click();
	
	}
	
	public void HR1()
	{
		locators.HR_Module1.click();
	}
	
	/**
	 * Creating Attendance for the employee
	 * @param emp name, date status
	 * @throws InterruptedException
	 */
	public void addAttendence(String status) throws InterruptedException
	{
		locators.CREATT_CLICKON_ATT.click();
		locators.CREATT_CLICKON_ADD_ATT.click();
		Thread.sleep(3000);
		waitForElementClickable(locators.CREATT_PICKT_DATE);
		locators.CREATT_PICKT_DATE.clear();
		locators.CREATT_PICKT_DATE.sendKeys("03-04-2023" + Keys.ENTER);
		selectByVisibletext(locators.CREATT_DATA_SELECT,status);
		locators.CREATT_SHIFT.sendKeys(user.CREATT_Shift);
		locators.CREATT_SHIFT2.click();
		locators.CREATT_LATEENTRY.click();
		Thread.sleep(3000);
		locators.CREATT_SAVE.click();
		
		
	}
	
	public void HR2()
	{
		locators.LESS_HR_Module2.click();
	}
	
	/**
	 * Applying lessHourAttendenceRequest for the employee
     * @param emp name, date
	 * @throws InterruptedException
	 */
	
	public void lessHourAttendenceRequest() throws InterruptedException
	{
		locators.LESS_ATT_REQ.click();
		waitForElementClickable(locators.LESS_ADD_ATT_REQ);
		locators.LESS_ADD_ATT_REQ.click();
		locators.LESS_DATE.click();
		locators.LESS_DATE_SELECT.click();
		locators.LESS_REASON.click();
		selectByVisibletext(locators.LESS_REASON,user.LESS_REASON);
		selectByVisibletext(locators.LESS_STATUS,user.LESS_STATUS);
		locators.LESS_EXPLANATION.sendKeys(user.LESS_EXPLANATION);
		locators.LESS_DATA_FIELD_TYPE.click();
		locators.LESS_FILE_UPLOAD.sendKeys(user.LESS_Attach);
	    Thread.sleep(3000);
		locators.LESS_STANDARD_ACTIONS.click();
		Thread.sleep(3000);
		locators.LESS_STANDARD_ACTIONS_FELX.click();		
		
	}
	
	public void exitEmp() throws InterruptedException 
	{
		locators.EXIT_CLICKON_HR.click();
		locators.EXIT_CLICKON_EMP.click();
		locators.EXIT_CLICKON_FILTER.click();
		Thread.sleep(3000);
		locators.EXIT_CLICKON_CLEAR_FILTERS.click();
		locators.EXIT_CLICKON_APPLY_FILTERS.click();
		Thread.sleep(3000);
		locators.EXIT_CLICKON_EMPNAME.click();
		
		
		selectByVisibletext(locators.EXIT_CLICKON_STATUS,user.EXIT_CLICKON_STATUS);
		locators.EXIT_CLICKON_EXIT.click();
		selectByVisibletext(locators.EXIT_CLICKON_EXIT_TYPE,user.EXIT_CLICKON_EXIT_TYPE);
		
		//locators.EXIT_CLICKON_RESIGNATION_LETTER_DATE.clear();
		locators.EXIT_CLICKON_RESIGNATION_LETTER_DATE2.sendKeys(user.REGISTRATION_LETTER_DATE);
		
		Thread.sleep(3000);
		//locators.EXIT_CLICKON_RELIVING_LETTER_DATE.clear();
		locators.EXIT_CLICKON_RELIVING_LETTER_DATE2.sendKeys(user.RELIVING_LETTER_DATE);
		
		locators.EXIT_CLEAR_REASONFOR_RELIVING.clear();
		locators.EXIT_TEXT_REASONFOR_RELIVING.sendKeys(user.EXIT_TEXT_REASONFOR_RELIVING);
		
		locators.EXIT_CLICKON_SAVE.click();
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,1500)");
		Thread.sleep(3000);
		locators.EXIT_CLICKON__EXIT_DROPDOWN.click();
		locators.EXIT_CLICKON__EXIT_FIELD.click();
		Thread.sleep(3000);
		locators.EXIT_CLICKON__EXIT_ARROW.click();
		
		
	}
	
	
}