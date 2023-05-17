package ERP;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;
import basePackage.InvoiceReportInfor;
import basePackage.UserInformation;

public class methods extends BaseClass{
	
	

	private static final WebElement APPROVED_TEXT = null;

	pageLocators locators;
	salesInvoicePL PL;
	 
	 UserInformation user = new UserInformation();
	 InvoiceReportInfor Invoiceinfo = new InvoiceReportInfor();
	 
	 String EmployeeID = "" ;
	 String UserEmail = "";
	 String UniqueID = "";
	 String TimesheetID = "";

	public methods(WebDriver driver) {

		locators = PageFactory.initElements(driver, pageLocators.class);
		PL = PageFactory.initElements(driver, salesInvoicePL.class);


	}

	// Click on HRTab
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
		System.out.println("'Add New Employee' button has been clicked");
		Thread.sleep(2000);
		
		//Employee Details
		waitForElement(locators.EMPLOYEE_FIRSTNAME);
		locators.EMPLOYEE_FIRSTNAME.sendKeys(Fname);
		waitForElement(locators.EMPLOYEE_LASTNAME);
		locators.EMPLOYEE_LASTNAME.sendKeys(Lname);
		locators.EMPLOYEE_GENDER.sendKeys(user.Employee_Gender+ Keys.ENTER);
		locators.EMPLOYEE_DOB.sendKeys(user.Employee_DOB+ Keys.ENTER);
		locators.EMPLOYEE_DOJ.sendKeys(DOJ+ Keys.ENTER);
		locators.EMPLOYEE_SALUTATION.sendKeys(user.Employee_Salutation+ Keys.ENTER);
		locators.EMPLOYEE_ANNUAL_CTC.sendKeys(user.Employee_Annual_Ctc+ Keys.ENTER);
		locators.EMPLOYMENT_TYPE.sendKeys(user.Employment_Type+ Keys.ENTER);
		
		//ERPNext User
		waitForElementClickable(locators.ERPNEXT_USER_BUTTON);
		locators.ERPNEXT_USER_BUTTON.click();
		locators.EMPLOYEE_USER_ID.sendKeys(UserEmail);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@title='"+UserEmail+"']/ancestor::li")).click();
		System.out.println("Entered the employee details for '"+Fname+" "+Lname+"' with a joining date of " + DOJ);
		
		//Department and Grade
		waitForElementClickable(locators.DEPARTMENT_BUTTON);
		locators.DEPARTMENT_BUTTON.click();
		locators.EMPLOYEE_DEPARTMENT.sendKeys(user.Employment_Department);
		locators.EMPLOYEE_DESIGNATION.sendKeys(user.Employment_Designation);
		locators.EMPLOYEE_BRANCH.sendKeys(user.Employment_Branch);
		locators.EMPLOYEE_REPORTS_TO.sendKeys(user.Employment_Reports_To);
		System.out.println("'Department and Grade' has been entered");
		
		
		//Approvers
		locators.EMPLOYEE_LEAVE_APPROVER.sendKeys(user.Employee_Leave_Approver);
		locators.EMPLOYEE_PROJECT_MANAGER.sendKeys(user.Employee_Project_Manager);
		System.out.println("'Approvers' has been entered");
		
		//Attendance and Leave Details 
		waitForElement(locators.ATTENDANCE_LEAVE_BUTTON);
		locators.ATTENDANCE_LEAVE_BUTTON.click();
		locators.ATTENDANCE_DEVICE_ID.sendKeys(UniqueID);
		locators.LEAVE_POLICY_DETAIL.sendKeys(LeavePolicy);
		locators.HOLIDAY_LIST.sendKeys(user.Employee_Holiday_List);
		locators.DEFAULT_SHIFT.sendKeys(user.Employee_Shift);
		System.out.println("'Attendance and Leave Details' has been entered");
		
		//Salary Details
		waitForElement(locators.SALARY_DETAILS_BUTTON);
		locators.SALARY_DETAILS_BUTTON.click();
		waitForElement(locators.EMPLOYEE_BOND);
		selectByVisibletext(locators.EMPLOYEE_BOND, user.Employee_Bond);
		System.out.println("'Salary Details' has been entered");
		
		//Previous Work Experience
		waitForElement(locators.PREVIOUS_WORK_EXP_BUTTON);
		locators.PREVIOUS_WORK_EXP_BUTTON.click();
		selectByVisibletext(locators.PREVIOUS_WORK_EXP_OPTION,WorkExp);
		Thread.sleep(2000);
		if(locators.EXTERNAL_WORK_HISTORY.isDisplayed()) {
			locators.EXTERNAL_WORK_HISTORY.click();
			locators.WORK_EXP_COMPANY_NAME.sendKeys(user.Previous_Company_Name);
			locators.WORK_EXP_DESIGNATION.sendKeys(user.Previous_Company_Designation);
			locators.WORK_EXP_ADDRESS.sendKeys(user.Previous_Company_Address);
			locators.WORK_EXP_IN_YEARS.sendKeys(user.Work_Exp_Years);
			locators.WORK_EXP_IN_MONTHS.sendKeys(user.Work_Exp_Months);
			waitForElement(locators.WORK_EXP_ATTACH_CERTIFICATE_BUTTON);
			Scrolljavascriptexecutor("down", locators.WORK_EXP_ATTACH_CERTIFICATE_BUTTON);
			waitForElementClickable(locators.WORK_EXP_ATTACH_CERTIFICATE_BUTTON);
			locators.WORK_EXP_ATTACH_CERTIFICATE_BUTTON.click();
			String projectFolderPath = System.getProperty("user.dir");
			File file = new File(projectFolderPath + "/Attachments/file.jpg");
			locators.CERTIFICATE_UPLOAD.sendKeys(file.getAbsolutePath());
			waitForElement(locators.UPLOAD_BUTTON);
			locators.UPLOAD_BUTTON.click();
			Thread.sleep(3000);
			
			if(locators.CLOSE_DIALOG_BOX.isDisplayed()) {
				waitForElement(locators.CLOSE_DIALOG_BOX);
				javascriptExecutorForceClick(locators.CLOSE_DIALOG_BOX);
			}
//			mouseoveractions(locators.SHORTCUT_KEY);
			javascriptExecutorForceClick(locators.SHORTCUT_KEY);
		}
		
		System.out.println("'Previous Work Experience' has been entered");
		
		//Save
		waitForElement(locators.EMPLOYEE_SAVE);
		locators.EMPLOYEE_SAVE.click();
		waitForElement(locators.POPUP_ALERT);
		VerifyTextValidation(locators.POPUP_ALERT, constants.Success_Text);
		waitForElement(locators.CLOSE_POPUP_ALERT);
		locators.CLOSE_POPUP_ALERT.click();
		Thread.sleep(3000);
		
		//Grabing Employee ID
		EmployeeID = locators.EMPLOYEE_ID.getText();
		System.out.println("The new employee has been created with an employee ID of '"+EmployeeID+"'");
	}
	
	
	public void clickOnAppLogoButton() {
		waitForElement(locators.CLICK_APP_LOGO);
		locators.CLICK_APP_LOGO.click();
		System.out.println("Clicked on the 'ERP App logo'");
	}
	  
	 // Verifying the total leaves allocated for the employee
	 // @param data
	 // @throws InterruptedException
	  
	  public void verifyTotalLeaveAllocation(String Total_Allocated_Leaves) throws
	  InterruptedException {
			System.out.println("Validating Total Allocated Leaves for an Employee");
			waitForElement(locators.LEAVE_APPLICATION_BUTTON);
			locators.LEAVE_APPLICATION_BUTTON.click();
			locators.ADD_LEAVE_APPLICATION_BUTTON.click();
			waitForElementClickable(locators.LA_EMPLOYEE_NAME);
			locators.LA_EMPLOYEE_NAME.sendKeys(EmployeeID + Keys.ENTER);
			mouseoveractions(locators.TOTAL_ALLOCATED_LEAVE);
			VerifyTestResult(locators.TOTAL_ALLOCATED_LEAVE, Total_Allocated_Leaves);
			System.out.println("Verified the Total Leave allocation for an employee.");
	  }

	public void createNewLeaveApplication(String fromDate, String toDate) throws InterruptedException {
		locators.LEAVE_APPLICATION_BUTTON.click();
		System.out.println("Clicked on Leave Application Button");
		locators.ADD_LEAVE_APPLICATION_BUTTON.click();
		System.out.println("Clicked on Add Leave Application Button");
		waitForElementClickable(locators.LA_EMPLOYEE_NAME);
//		locators.LA_EMPLOYEE_NAME.sendKeys(user.Leave_Employee_Name + Keys.ENTER);
		Scrolljavascriptexecutor("down", locators.LEAVE_FROM_DATE);
		locators.LEAVE_FROM_DATE.sendKeys(fromDate+ Keys.ENTER);
		locators.LEAVE_TO_DATE.sendKeys(toDate + Keys.ENTER);
		Thread.sleep(2000);
		locators.LA_SAVE_BUTTON.click();
		Thread.sleep(3000);
		System.out.println("Created leave application for "+fromDate+" and "+toDate+" .");
//		locators.HR_TAB.click();

	}
	
	/**
	 * This method will create a new userid for the employee by first name and last name
	 * @param Fname
	 * @param Lname
	 * @throws InterruptedException
	 */
	public void createNewUser(String Fname,String Lname) throws InterruptedException {
		waitForElement(locators.USERS_TAB);
		Scrolljavascriptexecutor("down", locators.USERS_TAB);
		locators.USERS_TAB.click();
		waitForElementClickable(locators.USER_BUTTON);
		locators.USER_BUTTON.click();
		waitForElementClickable(locators.ADD_USER_BUTTON);
		locators.ADD_USER_BUTTON.click();
		waitForElement(locators.NEW_USER_EMAIL);
		Random rand = new Random();
		int randomNumber = rand.nextInt(90000) + 10000;
        UniqueID = Integer.toString(randomNumber);
		String Email = Fname+Lname+randomNumber+"@softsuave.com";
		UserEmail = Email.toLowerCase();
		locators.NEW_USER_EMAIL.sendKeys(UserEmail);
		waitForElement(locators.NEW_USER_FIRSTNAME);
		locators.NEW_USER_FIRSTNAME.sendKeys(Fname);
		waitForElementClickable(locators.NEW_USER_SAVE_BUTTON);
		locators.NEW_USER_SAVE_BUTTON.click();
		Thread.sleep(3000);
		if(locators.NEW_USER_WELCOME_EMAIL_SENT_POPUP.isDisplayed()) {
			waitForElementClickable(locators.NEW_USER_WELCOME_EMAIL_SENT_POPUP_CLOSE);
//			locators.NEW_USER_WELCOME_EMAIL_SENT_POPUP_CLOSE.click();
			javascriptExecutorForceClick(locators.NEW_USER_WELCOME_EMAIL_SENT_POPUP_CLOSE);
		}
		System.out.println("User mail has been created : "+UserEmail);		
	}
	
	//Click on HRTab
		public void clickOnProjectTab()throws IOException  {
			waitForElementClickable(locators.PROJECTS_TAB);
			locators.PROJECTS_TAB.click();
			System.out.println("The 'Project' tab has been clicked");
			
		}	
	
	public void create_TimeSheet(String employeeName) throws InterruptedException {
		waitForElement(locators.TIMESHEET_BUTTON);
		locators.TIMESHEET_BUTTON.click();
		System.out.println("Clicked on Timesheet Button");
		
		waitForElement(locators.ADD_TIMESHEET_BUTTON);
		locators.ADD_TIMESHEET_BUTTON.click();
		System.out.println("Clicked on Add Timesheet Button");
		
		waitForElement(locators.TIMESHEET_EMPLOYEE_ID);
		locators.TIMESHEET_EMPLOYEE_ID.click();
		locators.TIMESHEET_EMPLOYEE_ID.clear();
		Thread.sleep(2000);
//		locators.TIMESHEET_EMPLOYEE_ID.sendKeys(user.Timesheet_Employee_ID);
		locators.TIMESHEET_EMPLOYEE_ID.sendKeys(employeeName);
		WebElement empName = driver.findElement(By.xpath("//p[@title='"+employeeName+"']/ancestor::li"));
		waitForElement(empName);
		empName.click();
		Thread.sleep(2000);
		locators.TIMESHEET_RESOURCE_NAMEFIELD.clear();
		locators.TIMESHEET_RESOURCE_NAMEFIELD.sendKeys(user.Timesheet_Resource_Name);
		locators.TIMESHEET_RESOUCE_NAME.click();
		Thread.sleep(2000);
		
		waitForElementClickable(locators.TIMESHEET_ACTIVITY_TYPE_BTN);
		locators.TIMESHEET_ACTIVITY_TYPE_BTN.click();
		Thread.sleep(2000);
		waitForElementClickable(locators.TIMESHEET_ACTIVITY_TYPE_FIELD);
		locators.TIMESHEET_ACTIVITY_TYPE_FIELD.sendKeys("Testing");
		Thread.sleep(2000);
		waitForElementClickable(locators.TIMESHEET_ACTIVITY_TYPE_NAME);
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date currentDate = new Date();
		String formattedDate = format.format(currentDate);
		locators.TIMESHEET_DATE.sendKeys(formattedDate+" 10:00");
		locators.TIMESHEET_HOURS.sendKeys("8");
		Thread.sleep(2000);
		waitForElementClickable(locators.TIMESHEET_PROJECT);
		locators.TIMESHEET_PROJECT.sendKeys(user.Timesheet_Project_Name);
		WebElement projectName = driver.findElement(By.xpath("//p[@title='"+user.Timesheet_Project_Name+"']/ancestor::li"));
		waitForElementClickable(projectName);
		projectName.click();
		Thread.sleep(2000);
		waitForElementClickable(locators.TIMESHEET_SAVE_BUTTON);
		locators.TIMESHEET_SAVE_BUTTON.click();
		Thread.sleep(3000);
		boolean SavedPopupIsDisplayed = false;
		try {
		    SavedPopupIsDisplayed = locators.POPUP_ALERT.isDisplayed();
		} catch (NoSuchElementException e) {
		    SavedPopupIsDisplayed = false;
		}
		if(SavedPopupIsDisplayed==true) {
			VerifyTextValidation(locators.POPUP_ALERT, "Saved");
			Thread.sleep(2000);
			TimesheetID = locators.TIMESHEET_ID.getText();
			System.out.println("Timesheet ID : "+TimesheetID);
			locators.CLOSE_POPUP_ALERT.click();
		}else if(locators.ALERT_TEXT_MESSAGE.isDisplayed())
		{
			String alerttext = locators.ALERT_TEXT_MESSAGE.getText();
			VerifyTextValidation(locators.ALERT_TEXT_MESSAGE, "Saved");
			waitForElementClickable(locators.NEW_USER_WELCOME_EMAIL_SENT_POPUP_CLOSE);
			javascriptExecutorForceClick(locators.NEW_USER_WELCOME_EMAIL_SENT_POPUP_CLOSE);
		}
		
	}
	
	public void create_Projects() {
		PL.PROJECT_TITLE.click();
		
		
	}
	
	public void approve_Timesheet() throws InterruptedException {
		waitForElement(locators.TIMESHEET_BUTTON);
		locators.TIMESHEET_BUTTON.click();
		System.out.println("Clicked on Timesheet Button");
		waitForElementClickable(locators.DRAFT_TIMESHEET);
		locators.DRAFT_TIMESHEET.click();
		waitForElementClickable(locators.SUBMIT_BUTTON);
		locators.SUBMIT_BUTTON.click();
		Thread.sleep(2000);
		waitForElementClickable(locators.CREATT_YES_CONFIRMATION);
		locators.CREATT_YES_CONFIRMATION.click();
		waitForElement(locators.POPUP_ALERT);
		VerifyTextValidation(locators.POPUP_ALERT, constants.Success_Text);
		Thread.sleep(3000);
		VerifyTestResult(locators.APPROVED_SUBMITTED_TEXT, constants.Approved_Submitted_Text);
		Thread.sleep(4000);
	}
	
	public void hR_Module_Tab()
	{
		waitForElementClickable(locators.HR_Module);
		locators.HR_Module.click();
		System.out.println("The 'HR Module' tab has been clicked");
	}
	
	/**
	 * Creating Attendance Request for the employee.
	 * @param emp name,date
	 * @throws InterruptedException
	 */
	
	public void attendance_Request(String fromDate, String toDate, String status) throws InterruptedException
	{
		waitForElement(locators.AR_ATTENDENCE_REQUEST);
		locators.AR_ATTENDENCE_REQUEST.click();
		System.out.println("Clicked on Attendance Request Button");
		locators.AR_ADD_ATTENDENCE_REQUEST.click();
		locators.AR_SELECT_FROMDATE.clear();
		locators.AR_SELECT_FROMDATE.sendKeys(fromDate);
//		locators.AR_PICK_FROM_DATE.click();
		locators.AR_SELECT_TO_DATE.clear();
		locators.AR_SELECT_TO_DATE.sendKeys(toDate);
//		locators.AR_PICK_TO_DATE.click();
		selectByVisibletext(locators.AR_DATA_SELECT,status);
		locators.AR_DATA_FIELD_NAME.sendKeys(user.AR_Explanation);
		locators.AR_DATA_FIELD_TYPE.click();
		String projectFolderPath = System.getProperty("user.dir");
		File file = new File(projectFolderPath + "/Attachments/file.jpg");
		locators.AR_FILE_UPLOAD.sendKeys(file.getAbsolutePath());
		Thread.sleep(3000);
		waitForElement(locators.AR_STANDARD_ACTIONS);
		locators.AR_STANDARD_ACTIONS.click();
		Thread.sleep(3000);
		locators.AR_STANDARD_ACTIONS_FELX.click();
		waitForElement(locators.POPUP_ALERT);
		VerifyTextValidation(locators.POPUP_ALERT, constants.Success_Text);
		System.out.println(gettext(locators.EMAIL_SEND_TO));	
	}
	
	public void HR1()
	{
		locators.HR_Module.click();
	}
	
	/**
	 * Creating Attendance for the employee
	 * @param emp name, date status
	 * @throws InterruptedException
	 */
	public void add_Attendence(String employeeId, String attendanceDate,String status) throws InterruptedException
	{
		locators.CREATT_CLICKON_ATT.click();
		System.out.println("Clicked on Attendance Button");
		locators.CREATT_CLICKON_ADD_ATT.click();
		System.out.println("Clicked on Add Attendance Button");
		Thread.sleep(3000);
		waitForElement(locators.CREATT_SELECT_USER);
		locators.CREATT_SELECT_USER.sendKeys(employeeId + Keys.ENTER);
		waitForElementClickable(locators.CREATT_PICKT_DATE);
		locators.CREATT_PICKT_DATE.clear();
		locators.CREATT_PICKT_DATE.sendKeys(attendanceDate + Keys.ENTER);
		System.out.println("Selected Attendance Date as "+attendanceDate);
		selectByVisibletext(locators.CREATT_DATA_SELECT,status);
		System.out.println("Selected Attendance status as "+status);
		locators.CREATT_SHIFT.sendKeys(user.CREATT_Shift);
		locators.CREATT_SHIFT2.click();
		locators.CREATT_LATEENTRY.click();
		Thread.sleep(3000);
		locators.CREATT_SAVE.click();
		Thread.sleep(2000);
		locators.CLOSE_POPUP_ALERT.click();
		locators.CREATT_SUBMIT.click();
		Thread.sleep(2000);
		waitForElementClickable(locators.CREATT_YES_CONFIRMATION);
		locators.CREATT_YES_CONFIRMATION.click();
		Thread.sleep(2000);
		locators.CLOSE_POPUP_ALERT.click();
		VerifyTextValidation(locators.POPUP_ALERT, constants.Success_Text);
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
	
	public void less_Hour_Attendance_Request(String LessHourDate) throws InterruptedException
	{
		locators.LESS_ATT_REQ.click();
		waitForElementClickable(locators.LESS_ADD_ATT_REQ);
		locators.LESS_ADD_ATT_REQ.click();
		locators.LESS_DATE.clear();
		locators.LESS_DATE.sendKeys(LessHourDate);
//		locators.LESS_DATE_SELECT.click();
		locators.LESS_REASON.click();
		selectByVisibletext(locators.LESS_REASON,user.LESS_REASON);
		selectByVisibletext(locators.LESS_STATUS_CHANGE_TO,user.LESS_STATUS);
		locators.LESS_EXPLANATION.sendKeys(user.LESS_EXPLANATION);
		locators.LESS_DATA_FIELD_TYPE.click();
		String projectFolderPath = System.getProperty("user.dir");
		File file = new File(projectFolderPath + "/Attachments/file.jpg");
		locators.LESS_FILE_UPLOAD.sendKeys(file.getAbsolutePath());
	    Thread.sleep(3000);
		locators.LESS_STANDARD_ACTIONS.click();
		Thread.sleep(3000);
		locators.LESS_STANDARD_ACTIONS_FELX.click();	
		waitForElement(locators.POPUP_ALERT);
		VerifyTextValidation(locators.POPUP_ALERT, constants.Success_Text);
		Thread.sleep(2000);
		javascriptExecutorForceClick(locators.CLOSE_POPUP_ALERT);
		System.out.println(gettext(locators.EMAIL_SEND_TO));
		Thread.sleep(2000);
		waitForElementClickable(locators.NEW_USER_WELCOME_EMAIL_SENT_POPUP_CLOSE);
		javascriptExecutorForceClick(locators.NEW_USER_WELCOME_EMAIL_SENT_POPUP_CLOSE);
	}
	
	public void approve_Less_Hour_Request(String status) throws InterruptedException {
//		locators.LEAVE_APPLICATION_BUTTON.click();
		waitForElementClickable(locators.LESS_ATT_REQ);
		locators.LESS_ATT_REQ.click();
		System.out.println("Clicked on Less Hour Attendance Request Button");
		locators.DRAFT_LESS_HOUR.click();
		
		selectByVisibletext(locators.LESS_HOUR_APPROVER_STATUS, status);
		waitForElementClickable(locators.SAVE_LEAVE_APPLICATION_STATUS);
		locators.SAVE_LEAVE_APPLICATION_STATUS.click();
		Thread.sleep(2000);
		locators.CLOSE_POPUP_ALERT.click();
		waitForElementClickable(locators.CREATT_SUBMIT);
		locators.CREATT_SUBMIT.click();
		Thread.sleep(2000);
//		locators.CLOSE_POPUP_ALERT.click();
		waitForElementClickable(locators.CREATT_YES_CONFIRMATION);
		locators.CREATT_YES_CONFIRMATION.click();
		Thread.sleep(2000);
		waitForElementClickable(locators.NEW_USER_WELCOME_EMAIL_SENT_POPUP_CLOSE);
		javascriptExecutorForceClick(locators.NEW_USER_WELCOME_EMAIL_SENT_POPUP_CLOSE);
		VerifyTextValidation(locators.APPROVED_SUBMITTED_TEXT, constants.Approved_Submitted_Text);
		Thread.sleep(2000);
	}

	public void create_Leave_Application_On_Already_CreatedDate(String fromDate, String toDate) throws InterruptedException {
		locators.LEAVE_APPLICATION_BUTTON.click();
		locators.ADD_LEAVE_APPLICATION_BUTTON.click();
		waitForElementClickable(locators.LA_EMPLOYEE_NAME);
//		locators.LA_EMPLOYEE_NAME.sendKeys(user.Leave_Employee_Name + Keys.ENTER);
		Scrolljavascriptexecutor("down", locators.LEAVE_FROM_DATE);
		locators.LEAVE_FROM_DATE.sendKeys(fromDate + Keys.ENTER);
		locators.LEAVE_TO_DATE.sendKeys(toDate + Keys.ENTER);
		Thread.sleep(20);
		locators.LA_SAVE_BUTTON.click();
		System.out.println(gettext(locators.LEAVE_APPLICATION_ALERT_MESSAGE));

	}

	public void approve_Leave_Application(String status) {
		locators.LEAVE_APPLICATION_BUTTON.click();
		System.out.println("Clicked on Leave Application Button");
		locators.CLICK_DRFT_LEAVE_APPLICATION.click();
		Scrolljavascriptexecutor("down", locators.SCROLL_LEAVE_APPLICATION_STATUS);
		
		selectByVisibletext(locators.SELECT_LEAVE_APPLICATION_STATUS, status);
		waitForElementClickable(locators.SAVE_LEAVE_APPLICATION_STATUS);
		locators.SAVE_LEAVE_APPLICATION_STATUS.click();
		waitForElementClickable(locators.CLICK_ACTION_BUTTON);
		locators.CLICK_ACTION_BUTTON.click();
		waitForElementClickable(locators.CLICK_ACTION);
		locators.CLICK_ACTION.click();
		VerifyTextValidation(locators.APPROVED_TEXT, constants.Approved_Text);
		//assert steps need to be included
//		waitForElement(locators.CLICK_APPROVE);
//		waitForElementClickable(locators.CLICK_APPROVE);
//		locators.CLICK_APPROVE.click();

	}
	
	public void logout_User() throws InterruptedException {
		Thread.sleep(5000);
		waitForElementClickable(locators.AVATAR_ICON);
		javascriptExecutorForceClick(locators.AVATAR_ICON);
		waitForElementClickable(locators.LOGOUT_BUTTON);
		javascriptExecutorForceClick(locators.LOGOUT_BUTTON);
		Thread.sleep(3000);
	}
	
	public void cancel_Less_Hour_Attendance()throws InterruptedException {
		Thread.sleep(4000);
		locators.LEAVE_CANCEL.click();
		Thread.sleep(4000);
		waitForElementClickable(locators.CANCEL_YES_CONFIRMATION);
		javascriptExecutorForceClick(locators.CANCEL_YES_CONFIRMATION);
		Thread.sleep(3000);
		VerifyTextValidation(locators.POPUP_ALERT, constants.Cancelled_Text);
		waitForElement(locators.ALERT_TEXT_MESSAGE);
		System.out.println(gettext(locators.ALERT_TEXT_MESSAGE));
		Thread.sleep(4000);
		waitForElementClickable(locators.NEW_USER_WELCOME_EMAIL_SENT_POPUP_CLOSE);
		javascriptExecutorForceClick(locators.NEW_USER_WELCOME_EMAIL_SENT_POPUP_CLOSE);
		Thread.sleep(2000);
		if(locators.NEW_USER_WELCOME_EMAIL_SENT_POPUP_CLOSE.isDisplayed()) {
			javascriptExecutorForceClick(locators.NEW_USER_WELCOME_EMAIL_SENT_POPUP_CLOSE);
		}
	}
	
	public void cancel_Leave()throws InterruptedException {
		Thread.sleep(4000);
		locators.LEAVE_CANCEL.click();
		Thread.sleep(4000);
		locators.CANCEL_ALL.click();
		waitForElement(locators.POPUP_ALERT);
		VerifyTextValidation(locators.POPUP_ALERT, constants.Cancelled_Text);
	}
	
	public void timesheet_Delete() {
		waitForElementClickable(locators.TIMESHEET_EDIT_BUTTON);
		locators.TIMESHEET_EDIT_BUTTON.click();
		waitForElementClickable(locators.TIMESHEET_DELETE_BUTTON);
		locators.TIMESHEET_DELETE_BUTTON.click();
		VerifyTextValidation(locators.VERIFY_NO_DATA, "No Data");
	}
	
	public void timesheet_cancel() throws InterruptedException {
		Thread.sleep(4000);
		locators.LEAVE_CANCEL.click();
		Thread.sleep(4000);
		waitForElementClickable(locators.CANCEL_YES_CONFIRMATION);
		javascriptExecutorForceClick(locators.CANCEL_YES_CONFIRMATION);
		waitForElement(locators.POPUP_ALERT);
		VerifyTextValidation(locators.POPUP_ALERT, constants.Cancelled_Text);

	}
	public void exitEmp() throws InterruptedException 
	{
		System.out.println("The employee resigning the job.");
		Thread.sleep(3000);
		selectByVisibletext(locators.EXIT_CLICKON_STATUS,user.EXIT_CLICKON_STATUS);
		locators.EXIT_CLICKON_EXIT.click();
		selectByVisibletext(locators.EXIT_CLICKON_EXIT_TYPE,user.EXIT_CLICKON_EXIT_TYPE);
		locators.EXIT_CLICKON_RESIGNATION_LETTER_DATE2.sendKeys(user.REGISTRATION_LETTER_DATE);
		Thread.sleep(3000);
		locators.EXIT_CLICKON_RELIVING_LETTER_DATE2.sendKeys(user.RELIVING_LETTER_DATE);
		locators.EXIT_CLEAR_REASONFOR_RELIVING.clear();
		locators.EXIT_TEXT_REASONFOR_RELIVING.sendKeys(user.EXIT_TEXT_REASONFOR_RELIVING);
		locators.EXIT_CLICKON_SAVE.click();
		((JavascriptExecutor)driver).executeScript("window.scrollTo(document.body.scrollHeight,1500)");
		Thread.sleep(3000);
		locators.EXIT_CLICKON_EXIT_DROPDOWN.click();
		locators.EXIT_CLICKON_EXIT_FIELD.click();
		Thread.sleep(3000);
		waitForElement(locators.EXIT_CLICKON_EXIT_ARROW);
		locators.EXIT_CLICKON_EXIT_ARROW.click();
	}
		
	public void create_New_Item()throws InterruptedException  {

		System.out.println("Adding New Item");
		PL.STOCK_TITLE.click();
		PL.ITEM.click();
		PL.ADD.click();
		for (int i = 0; i < 2; i++) {
			PL.EDIT_FULLFORM.click();		}	
		PL.ITEM_CODE.sendKeys("Test Project");
		PL.ITEM_GROUP.sendKeys("Services"+ Keys.ENTER);
		PL.CUSTOMER_NAME.sendKeys("Test Customer"+Keys.ENTER);
		PL.DEFAULT_UOM.sendKeys("Hour"+Keys.ENTER);
		PL.CURRENCY.clear();
		PL.CURRENCY.sendKeys("USD"+Keys.ENTER);
		
	}	

		
}