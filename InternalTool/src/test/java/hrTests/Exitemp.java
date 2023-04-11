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
//	UserInformation user = new UserInformation();


	
	@BeforeMethod
	private void open() throws IOException, InterruptedException {
		browserOpen();
		Login=new Login(driver);
		Methods = new methods(driver);
	
}
	
	@Test
	public void exit() throws IOException, InterruptedException
	{
		Login.loginUser("adminqa@softsuave.com","softsuave");
	    Methods.exitEmp();

	}
	
}