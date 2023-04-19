package ERP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class pageLocators {

	@FindBy(xpath = "//input[@id='login_email']")
	public WebElement USERNAME_FIELD;

	@FindBy(xpath = "//input[@id='login_password']")
	public WebElement PASSWORD_FIELD;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	public WebElement LOGIN_BUTTON;

	@FindBy(xpath = "//div[@class='standard-sidebar-section']//span[contains(text(),'HR')]")
	public WebElement HR_TAB;

	@FindBy(xpath = "//span[@title='Employee']/ancestor::div[contains(@class,'shortcut-widget-box')]")
	public WebElement EMPLOYEE_BUTTON;

	@FindBy(xpath = "//span[@data-label='Add%20Employee']/ancestor::button")
	public WebElement ADD_EMPLOYEE;
	
	@FindBy(xpath = "//input[@data-fieldname='first_name' and @data-doctype='Employee']")
	public WebElement EMPLOYEE_FIRSTNAME;
	
	@FindBy(xpath = "//input[@data-fieldname='last_name' and @data-doctype='Employee']")
	public WebElement EMPLOYEE_LASTNAME;

	@FindBy(xpath = "//input[@data-fieldname='gender']")
	public WebElement EMPLOYEE_GENDER;

	@FindBy(xpath = "//input[@data-fieldname='date_of_birth']")
	public WebElement EMPLOYEE_DOB;

	@FindBy(xpath = "//input[@data-fieldname='date_of_joining']")
	public WebElement EMPLOYEE_DOJ;

	@FindBy(xpath = "//input[@data-fieldname='leave_approver']")
	public WebElement EMPLOYEE_LEAVE_APPROVER;

	@FindBy(xpath = "//input[@data-fieldname='project_manager']")
	public WebElement EMPLOYEE_PROJECT_MANAGER;

	@FindBy(xpath = "//div[contains(text(),'Attendance and Leave Detail')]")
	public WebElement ATTENDANCE_LEAVE_BUTTON;

	@FindBy(xpath = "//input[@data-fieldname='leave_policy_detail']")
	public WebElement LEAVE_POLICY_DETAIL;

	@FindBy(xpath = "//input[@data-fieldname='holiday_list']")
	public WebElement HOLIDAY_LIST;

	@FindBy(xpath = "//input[@data-fieldname='default_shift']")
	public WebElement DEFAULT_SHIFT;

	@FindBy(xpath = "//div[contains(text(),'Previous Work Experience')]")
	public WebElement PREVIOUS_WORK_EXP_BUTTON;

	@FindBy(xpath = "//select[@data-fieldname='previous_work_exp']")
	public WebElement PREVIOUS_WORK_EXP_OPTION;

	@FindBy(xpath = "//button[@data-label='Save']")
	public WebElement EMPLOYEE_SAVE;
	
	@FindBy(xpath = "//div[@id='alert-container']//div[@class='alert-message']")
	public WebElement POPUP_ALERT;

	@FindBy(xpath = "//div[@id='alert-container']//a[@class='close']")
	public WebElement CLOSE_POPUP_ALERT;

	@FindBy(xpath = "//a[@class='navbar-brand navbar-home']")
	public WebElement CLICK_APP_LOGO;

	@FindBy(xpath = "//span[text()='Leave Application']/ancestor::a")
	public WebElement LEAVE_APPLICATION_BUTTON;

	@FindBy(xpath = "//span[@data-label='Add%20Leave%20Application']/ancestor::button")
	public WebElement ADD_LEAVE_APPLICATION_BUTTON;

	@FindBy(xpath = "//div[contains(@class,'visible-section')]//input[@data-fieldname='employee']")
	public WebElement LA_EMPLOYEE_NAME;

	@FindBy(xpath = "//ul[@id='navbar-breadcrumbs']//a[contains(text(),'SS')]")
	public WebElement EMPLOYEE_ID;

	@FindBy(xpath = "(//tr/td[@class='text-right'])[1]")
	public WebElement TOTAL_ALLOCATED_LEAVE;

	@FindBy(xpath = "//input[@data-fieldname='from_date']")
	public WebElement LEAVE_FROM_DATE;

	@FindBy(xpath = "//input[@data-fieldname='to_date']")
	public WebElement LEAVE_TO_DATE;

	@FindBy(xpath = "//button[@data-label='Save']")
	public WebElement LA_SAVE_BUTTON;

	@FindBy(xpath = "(//span[text()=' Draft'])[1]/preceding::a[@data-doctype='Leave Application']")
	public WebElement CLICK_DRFT_LEAVE_APPLICATION;

	@FindBy(xpath = "(//div[@class='row form-section card-section visible-section' ][2])")
	public WebElement SCROLL_LEAVE_APPLICATION_STATUS;

	@FindBy(xpath = "//select[@data-fieldtype='Select' and @data-doctype='Leave Application']")
	public WebElement SELECT_LEAVE_APPLICATION_STATUS;

	@FindBy(xpath = "//button[@data-label='Save']")
	public WebElement SAVE_LEAVE_APPLICATION_STATUS;

	@FindBy(xpath = "(//span[text()=' Draft'])[1]")
	public WebElement LEAVE_APPLICATION_STATUS;
	
	@FindBy(xpath = "//div[@class='msgprint']//li[contains(text(),'You')]//b[1]")
	public WebElement SANDWHICH_LEAVE_APPLICATION_MESSAGE;
	
	@FindBy(xpath = "(//div[@class='msgprint'])")
	public WebElement ALERT_MESSAGE;
	
	@FindBy(xpath = "//button[@class='btn btn-modal-close btn-link']")
	public WebElement sand;

	@FindBy(xpath = "//div[@class='actions-btn-group']//span[@data-label='Actions']/ancestor::button")
	public WebElement CLICK_ACTION_BUTTON;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right show']//span[@data-label='Approve']/..")
	public WebElement CLICK_APPROVE;
	
	@FindBy(xpath = "//span[@class='menu-item-label' and text()='pprove']")
	public WebElement CLICK_ACTION;

	@FindBy(xpath = "//div[@class='msgprint']")
	public WebElement LEAVE_APPLICATION_ALERT_MESSAGE;

	@FindBy(xpath = "//input[@data-fieldname='salutation']")
	public WebElement EMPLOYEE_SALUTATION;
	
	@FindBy(xpath = "//input[@data-fieldname='annual_ctc']")
	public WebElement EMPLOYEE_ANNUAL_CTC;
	
	@FindBy(xpath = "//input[@data-fieldname='employment_type']")
	public WebElement EMPLOYMENT_TYPE;
	
	@FindBy(xpath = "//div[contains(text(),'ERPNext User')]")
	public WebElement ERPNEXT_USER_BUTTON;
	
	@FindBy(xpath = "//span[text()='Users']/ancestor::a")
	public WebElement USERS_TAB;
	
	@FindBy(xpath = "//span[@title='User']/ancestor::div[contains(@class,'widget-shadow')]")
	public WebElement USER_BUTTON;
	
	@FindBy(xpath = "//span[@data-label='Add%20User']/ancestor::button")
	public WebElement ADD_USER_BUTTON;
	
	@FindBy(xpath = "//label[text()='Email']/following::input[@data-fieldname='email']")
	public WebElement NEW_USER_EMAIL;
	
	@FindBy(xpath = "//label[text()='First Name']/following::input[@data-fieldname='first_name']")
	public WebElement NEW_USER_FIRSTNAME;
	
	@FindBy(xpath = "//button[text()='Save']")
	public WebElement NEW_USER_SAVE_BUTTON;
	
	@FindBy(xpath = "//div[@class='modal-dialog msgprint-dialog']")
	public WebElement NEW_USER_WELCOME_EMAIL_SENT_POPUP;
	
	@FindBy(xpath = "//div[@class='modal-dialog msgprint-dialog']//button[@class='btn btn-modal-close btn-link']")
	public WebElement NEW_USER_WELCOME_EMAIL_SENT_POPUP_CLOSE;
	
	@FindBy(xpath = "//input[@data-fieldname='user_id']")
	public WebElement EMPLOYEE_USER_ID;
	
	@FindBy(xpath = "//div[contains(text(),'Department and Grade')]")
	public WebElement DEPARTMENT_BUTTON;
	
	@FindBy(xpath = "//label[text()='Department']/../..//input[@data-fieldname='department']")
	public WebElement EMPLOYEE_DEPARTMENT;
	
	@FindBy(xpath = "//input[@data-fieldname='designation']")
	public WebElement EMPLOYEE_DESIGNATION;
	
	@FindBy(xpath = "//input[@data-fieldname='branch']")
	public WebElement EMPLOYEE_BRANCH;
	
	@FindBy(xpath = "//input[@data-fieldname='reports_to']")
	public WebElement EMPLOYEE_REPORTS_TO;
	
	@FindBy(xpath = "//input[@data-fieldname='attendance_device_id']")
	public WebElement ATTENDANCE_DEVICE_ID;
	
	@FindBy(xpath = "//div[contains(text(),'Salary Details')]")
	public WebElement SALARY_DETAILS_BUTTON;
	
	@FindBy(xpath = "//select[@data-fieldname='bond']")
	public WebElement EMPLOYEE_BOND;
	
	@FindBy(xpath = "//a[@href='/app/projects']")
	public WebElement PROJECTS_TAB;
	
	@FindBy(xpath = "//span[@title='Timesheet']/ancestor::div[contains(@class,'shortcut-widget-box')]")
	public WebElement TIMESHEET_BUTTON;
	
	@FindBy(xpath = "//span[@data-label='Add%20Timesheet']/ancestor::button")
	public WebElement ADD_TIMESHEET_BUTTON;
	
	@FindBy(xpath = "//input[@data-doctype='Timesheet' and @data-target='Employee']")
	public WebElement TIMESHEET_EMPLOYEE_ID;
	
	@FindBy(xpath = "//input[@data-fieldname='cus_resource_name']")
	public WebElement TIMESHEET_RESOURCE_NAMEFIELD;
	
	@FindBy(xpath = "//p[@title='Free Resource']/ancestor::li")
	public WebElement TIMESHEET_RESOUCE_NAME;
	
	@FindBy(xpath = "(//div[@class='data-row row']/div[@data-fieldname='activity_type'])[2]")
	public WebElement TIMESHEET_ACTIVITY_TYPE_BTN;
	
	@FindBy(xpath = "//input[@data-fieldname='activity_type']")
	public WebElement TIMESHEET_ACTIVITY_TYPE_FIELD;
	
	@FindBy(xpath = "//p[@title='Testing']/ancestor::li")
	public WebElement TIMESHEET_ACTIVITY_TYPE_NAME;
	
	@FindBy(xpath = "//input[@data-fieldname='from_time']")
	public WebElement TIMESHEET_DATE;
	
	@FindBy(xpath = "//input[@data-fieldname='hours']")
	public WebElement TIMESHEET_HOURS;
	
	@FindBy(xpath = "//input[@data-fieldname='project']")
	public WebElement TIMESHEET_PROJECT;
	
	@FindBy(xpath = "//button[@data-label='Save']")
	public WebElement TIMESHEET_SAVE_BUTTON;
	
	@FindBy(xpath = "//li[@class='disabled']/a[contains(@href,'/app/timesheet/')]")
	public WebElement TIMESHEET_ID;
	
	@FindBy(xpath = "//div[@class='msgprint']")
	public WebElement ALERT_TEXT_MESSAGE;
	
	@FindBy(xpath = "//label[text()='External Work History']/..//button[contains(text(),'Add Row')]")
	public WebElement EXTERNAL_WORK_HISTORY;
	
	@FindBy(xpath = "//input[@data-fieldname='company_name']")
	public WebElement WORK_EXP_COMPANY_NAME;
	
	@FindBy(xpath = "//input[@data-fieldname='designation' and @data-doctype='Employee External Work History']")
	public WebElement WORK_EXP_DESIGNATION;
	
	@FindBy(xpath = "//textarea[@data-fieldname='address' and @data-doctype='Employee External Work History']")
	public WebElement WORK_EXP_ADDRESS;
	
	@FindBy(xpath = "//input[@data-fieldname='total_experience_in_years' and @data-doctype='Employee External Work History']")
	public WebElement WORK_EXP_IN_YEARS;
	
	@FindBy(xpath = "//input[@data-fieldname='total_experience_in_months' and @data-doctype='Employee External Work History']")
	public WebElement WORK_EXP_IN_MONTHS;
	
	@FindBy(xpath = "//button[@data-fieldtype='Attach' and @data-doctype='Employee External Work History']")
	public WebElement WORK_EXP_ATTACH_CERTIFICATE_BUTTON;
	
	@FindBy(xpath = "//input[@type='file']")
	public WebElement CERTIFICATE_UPLOAD;
	
	@FindBy(xpath = "//button[@type='button' and text()='Upload']")
	public WebElement UPLOAD_BUTTON;
	
	@FindBy(xpath = "//kbd[text()='Ctrl + Up']")
	public WebElement SHORTCUT_KEY;
	
	@FindBy(xpath="//span[text()='HR']")
	public WebElement HR_Module;
	
	@FindBy(xpath="//span[@title='Attendance']/ancestor::div[contains(@class,'shortcut-widget-box')]")
	public WebElement ATTENDANCE_BUTTON;
	
	@FindBy(xpath="(//span[text()=' Draft'])[1]/preceding::a[@data-doctype='Attendance']")
	public WebElement DRAFT_ATTENDANCE;
	
	@FindBy(xpath="(//span[text()=' Draft'])[1]/preceding::a[@data-doctype='Less Hour Attendance Request']")
	public WebElement DRAFT_LESS_HOUR;
	
	@FindBy(xpath="//select[@data-fieldtype='Select' and @data-doctype='Attendance']")
	public WebElement SELECT_ATTENDANCE_STATUS;
	
	
	@FindBy(xpath="//span[text()='Attendance Request']")
	public WebElement AR_ATTENDENCE_REQUEST;
	
	@FindBy(xpath="//span[text()='dd Attendance Request ']/ancestor::button")
	public WebElement AR_ADD_ATTENDENCE_REQUEST;
	
	@FindBy(xpath="//input[@data-fieldname='employee']")
	public WebElement AR_SELECT_USER;
	
	@FindBy(xpath="//input[@data-fieldname='from_date']")
	public WebElement AR_SELECT_FROMDATE;
	
	@FindBy(xpath="//div[text()='8']")
	public WebElement AR_PICK_FROM_DATE;
	
	@FindBy(xpath="//input[@data-fieldname='to_date']")
	public WebElement AR_SELECT_TO_DATE;
	
	@FindBy(xpath="(//div[text()='8'])[2]")
	public WebElement AR_PICK_TO_DATE;
	
	@FindBy(xpath="//select[@data-fieldtype='Select']")
	public WebElement AR_DATA_SELECT;
	
	@FindBy(xpath="//textarea[@data-fieldname='explanation']")
	public WebElement AR_DATA_FIELD_NAME;
	
	@FindBy(xpath="//button[@data-fieldtype='Attach']")
	public WebElement AR_DATA_FIELD_TYPE;

	@FindBy(xpath="//div[@class='file-upload-area']//button[@class='btn btn-file-upload']/following::input")
	public WebElement AR_FILE_UPLOAD;
	
	@FindBy(xpath="//div/div/div[@class='standard-actions']/button[2]")
	public WebElement AR_STANDARD_ACTIONS;
	
	@FindBy(xpath="//div[@class='standard-actions flex']/button[@data-label='Save']")
	public WebElement AR_STANDARD_ACTIONS_FELX;
	
	@FindBy(xpath="//div[@class='modal-dialog msgprint-dialog']//div[@class='msgprint']")
	public WebElement EMAIL_SEND_TO;
	
	@FindBy(xpath="//span[text()='HR']")
	public WebElement HR_Module1;
	
	@FindBy(xpath="//span[text()='Attendance']")
	public WebElement CREATT_CLICKON_ATT;
	
	@FindBy(xpath="//span[text()='dd Attendance ']/ancestor::button")
	public WebElement CREATT_CLICKON_ADD_ATT;
	
	@FindBy(xpath="//input[@data-fieldname='attendance_date']")
	public WebElement CREATT_PICKT_DATE;
	
	@FindBy(xpath="//input[@data-fieldname='employee' and @data-doctype='Attendance']")
	public WebElement CREATT_SELECT_USER;
		
	@FindBy(xpath="(//select[@data-fieldname='status'])[2]")
	public WebElement CREATT_DATA_SELECT;
	
	@FindBy(xpath="//input[@data-fieldname='shift']")
	public WebElement CREATT_SHIFT;
	
	@FindBy(xpath="//input[@data-doctype='Attendance']")
	public WebElement CREATT_SHIFT2;
	
	@FindBy(xpath="//input[@data-fieldname='late_entry']")
	public WebElement CREATT_LATEENTRY;
	
	@FindBy(xpath="//div[@class='standard-actions flex']/button[@data-label='Save']")
	public WebElement CREATT_SAVE;
	
	@FindBy(xpath="//button[@data-label='Submit']")
	public WebElement CREATT_SUBMIT;
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	public WebElement CREATT_YES_CONFIRMATION;
	
	@FindBy(xpath="//div[@class='modal fade show']//button[contains(text(),'Yes')]")
	public WebElement CANCEL_YES_CONFIRMATION;
	
	@FindBy(xpath="//span[text()='HR Module']")
	public WebElement LESS_HR_Module2;
	
	@FindBy(xpath="//span[text()='Less Hour Attendance Request']/ancestor::a")
	public WebElement LESS_ATT_REQ;
	
	@FindBy(xpath="//span[text()='dd Less Hour Attendance Request ']/ancestor::button")
	public WebElement LESS_ADD_ATT_REQ;
		
	@FindBy(xpath="//input[@data-fieldname='employee']")
	public WebElement LESS_SELECT_EMP1;
	
	@FindBy(xpath="//input[@data-fieldname='attendance_date' and @data-doctype='Less Hour Attendance Request']")
	public WebElement LESS_DATE;
	
	@FindBy(xpath="//div[text()='31']")
	public WebElement LESS_DATE_SELECT;
	
	@FindBy(xpath="//select[@data-fieldtype='Select' and @data-fieldname='reason']")
	public WebElement LESS_REASON;
	
	@FindBy(xpath="//select[@data-fieldtype='Select' and @data-fieldname='request_to']")
	public WebElement LESS_STATUS_CHANGE_TO;
	
	@FindBy(xpath="(//select[@data-fieldtype='Select'])[2]")
	public WebElement LESS_STATUS;
	
	@FindBy(xpath="//select[@data-fieldname='status' and @data-doctype='Less Hour Attendance Request']")
	public WebElement LESS_HOUR_APPROVER_STATUS;
	
	@FindBy(xpath="//textarea[@data-fieldname='explanation']")
	public WebElement LESS_EXPLANATION;
	
	@FindBy(xpath="//button[@data-fieldtype='Attach']")
	public WebElement LESS_DATA_FIELD_TYPE;
	
	@FindBy(xpath="//div[@class='file-upload-area']//button[@class='btn btn-file-upload']/following::input")
	public WebElement LESS_FILE_UPLOAD;
	
	@FindBy(xpath="//div/div/div[@class='standard-actions']/button[2]")
	public WebElement LESS_STANDARD_ACTIONS;
	
	@FindBy(xpath="//div[@class='standard-actions flex']/button[@data-label='Save']")
	public WebElement LESS_STANDARD_ACTIONS_FELX;
	
	@FindBy(xpath="//span[@class='avatar avatar-medium']/ancestor::a")
	public WebElement AVATAR_ICON;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	public WebElement LOGOUT_BUTTON;
	
	@FindBy(xpath="//div[@class='row flex align-center page-head-content justify-between']//span[contains(text(),'Approved')]")
	public WebElement APPROVED_TEXT;
	
	@FindBy(xpath="//div[@class='row flex align-center page-head-content justify-between']//span[contains(text(),'Present')]")
	public WebElement APPROVED_PRESENT_TEXT;
	
	@FindBy(xpath="//div[@class='row flex align-center page-head-content justify-between']//span[contains(text(),'Submitted')]")
	public WebElement APPROVED_SUBMITTED_TEXT;
	
	@FindBy(xpath="//button[@data-label='Cancel']")
	public WebElement LEAVE_CANCEL;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-sm btn-modal-primary']")
	public WebElement CANCEL_ALL;
	
	@FindBy(xpath="//div[@class='btn-open-row']")
	public WebElement TIMESHEET_EDIT_BUTTON;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-sm pull-right grid-delete-row']")
	public WebElement TIMESHEET_DELETE_BUTTON;
	
	@FindBy(xpath="//div[@class='grid-empty text-center']")
	public WebElement VERIFY_NO_DATA;
	
	@FindBy(xpath="(//span[text()=' Draft'])[1]/preceding::a[@data-doctype='Timesheet']")
	public WebElement DRAFT_TIMESHEET;
	
	@FindBy(xpath="(//span[text()=' Submitted'])[1]/preceding::a[@data-doctype='Timesheet']")
	public WebElement SUBMITTED_TIMESHEET;
	
	@FindBy(xpath="//button[@data-label='Submit']")
	public WebElement SUBMIT_BUTTON;
}
