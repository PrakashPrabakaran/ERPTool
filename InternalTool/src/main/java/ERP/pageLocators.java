package ERP;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//input[@data-fieldname='first_name']")
	public WebElement EMPLOYEE_FIRSTNAME;
	
	@FindBy(xpath = "//input[@data-fieldname='last_name']")
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
	
	@FindBy(xpath = "//div[@id='alert-container']//../div[@class='alert-message']")
	public WebElement POPUP_ALERT;
	
	@FindBy(xpath = "//a[@class='close']")
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
	
	@FindBy(xpath="//span[text()='HR']")
	public WebElement HR_Module;
	
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
	
	
	
	
	
	@FindBy(xpath="//span[text()='HR']")
	public WebElement HR_Module1;
	
	@FindBy(xpath="//span[text()='Attendance']")
	public WebElement CREATT_CLICKON_ATT;
	
	
	@FindBy(xpath="//span[text()='dd Attendance ']/ancestor::button")
	public WebElement CREATT_CLICKON_ADD_ATT;
	
	@FindBy(xpath="//input[@data-fieldname='attendance_date']")
	public WebElement CREATT_PICKT_DATE;
	
	
	@FindBy(xpath="//input[@data-fieldname='employee']")
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
	
	
	
	
	@FindBy(xpath="//span[text()='HR Module']")
	public WebElement LESS_HR_Module2;
	
	@FindBy(xpath="//span[text()='Less Hour Attendance Request']")
	public WebElement LESS_ATT_REQ;
	
	@FindBy(xpath="//span[text()='dd Less Hour Attendance Request ']/ancestor::button")
	public WebElement LESS_ADD_ATT_REQ;
		
	
	@FindBy(xpath="//input[@data-fieldname='employee']")
	public WebElement LESS_SELECT_EMP1;
	
	
	@FindBy(xpath="//input[@data-fieldtype='Date']")
	public WebElement LESS_DATE;
	
	@FindBy(xpath="//div[text()='31']")
	public WebElement LESS_DATE_SELECT;
	
	@FindBy(xpath="//select[@data-fieldtype='Select']")
	public WebElement LESS_REASON;
	
	@FindBy(xpath="(//select[@data-fieldtype='Select'])[2]")
	public WebElement LESS_STATUS;
	
	@FindBy(xpath="//textarea[@data-fieldname='explanation']")
	public WebElement LESS_EXPLANATION;
	
	@FindBy(xpath="//button[@data-fieldtype='Attach']")
	public WebElement LESS_DATA_FIELD_TYPE;
	
	@FindBy(xpath="@class='file-upload-area']//button[@class='btn btn-file-upload']/following::input")
	public WebElement LESS_FILE_UPLOAD;
	
	@FindBy(xpath="//div/div/div[@class='standard-actions']/button[2]")
	public WebElement LESS_STANDARD_ACTIONS;
	
	@FindBy(xpath="//div[@class='standard-actions flex']/button[@data-label='Save']")
	public WebElement LESS_STANDARD_ACTIONS_FELX;
	
    
	@FindBy(xpath="//span[text()='HR']")
	public WebElement EXIT_CLICKON_HR;
	
	@FindBy(xpath="//div[@class='widget-group-body grid-col-3']/div/div/div/div/span[text()='Employee']")
	public WebElement EXIT_CLICKON_EMP;
	
	@FindBy(xpath="//div[@class='filter-selector']")
	public WebElement EXIT_CLICKON_FILTER;
	
	
	@FindBy(xpath="//div//button[@class='btn btn-secondary btn-xs clear-filters']")
	public WebElement EXIT_CLICKON_CLEAR_FILTERS;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-xs apply-filters']")
	public WebElement EXIT_CLICKON_APPLY_FILTERS;
	
	
	@FindBy(xpath="//a[contains(text(),'Senior Afterdate')]")
	public WebElement EXIT_CLICKON_EMPNAME;
	

	
	
	
	
	
	
	@FindBy(xpath="//div[@class='control-input-wrapper']/div/select[@data-fieldname='status']")
	public WebElement EXIT_CLICKON_STATUS;
	
	@FindBy(xpath="//div[@class='row form-section card-section visible-section']//div[contains(text(),'Exit')]")
	public WebElement EXIT_CLICKON_EXIT;
	
	
	@FindBy(xpath="//select[@data-fieldname='exit_type']")
	public WebElement EXIT_CLICKON_EXIT_TYPE;
	
	@FindBy(xpath="//input[@data-fieldname='resignation_letter_date']")
	public WebElement EXIT_CLICKON_RESIGNATION_LETTER_DATE;
	
	@FindBy(xpath="//input[@data-fieldname='resignation_letter_date']")
	public WebElement EXIT_CLICKON_RESIGNATION_LETTER_DATE2;
	
	
	@FindBy(xpath="//input[@data-fieldname='relieving_date']")
	public WebElement EXIT_CLICKON_RELIVING_LETTER_DATE;
	
	@FindBy(xpath="//input[@data-fieldname='relieving_date']")
	public WebElement EXIT_CLICKON_RELIVING_LETTER_DATE2;
	
	@FindBy(xpath="//div[@class='control-input']//textarea[@data-fieldname='reason_for_leaving']")
	public WebElement EXIT_CLEAR_REASONFOR_RELIVING;
	
	@FindBy(xpath="//div[@class='control-input']//textarea[@data-fieldname='reason_for_leaving']")
	public WebElement EXIT_TEXT_REASONFOR_RELIVING;
	
	@FindBy(xpath="//button[text()='S']")
	public WebElement EXIT_CLICKON_SAVE;
	
	@FindBy(xpath="//div[@class='row form-section card-section visible-section']//div[contains(text(),'ERPNext User')]")
	public WebElement EXIT_CLICKON__EXIT_DROPDOWN;
	
	
	@FindBy(xpath="//input[@data-fieldname='user_id']")
	public WebElement EXIT_CLICKON__EXIT_FIELD;

	@FindBy(xpath="//span[contains(@style,'display:')]//a[@title='Open Link']")
	public WebElement EXIT_CLICKON__EXIT_ARROW;
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
