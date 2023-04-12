package basePackage;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

import ERP.methods;
import ERP.pageLocators;

	public class Login extends BaseClass {
		
		private pageLocators locators;

		public Login(WebDriver driver) {

			locators = PageFactory.initElements(driver, pageLocators.class);
		}
		
		
		
		public void loginUser(String employeeMail, String password) throws IOException {
			try {
				locators.USERNAME_FIELD.sendKeys(employeeMail);
		        locators.PASSWORD_FIELD.sendKeys(password);
		        locators.LOGIN_BUTTON.click();
				
			} catch (Exception e) {
				takesScreenShotfull();
				
			}
		
		
		
		}
	}

	

	
