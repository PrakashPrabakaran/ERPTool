package basePackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void browserOpen() throws IOException {
		Reporter.log("Chrome is launched");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized"); // Maximize window on start-up
		options.addArguments("--disable-extensions"); // Disable browser extensions
		options.addArguments("--disable-popup-blocking"); // Disable pop-up blocking
		options.addArguments("no-sandbox");
		options.addArguments("disable-dev-shm-usage");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		Reporter.log("Website is launching");
		driver.get("https://appointry.com/login#login");
		Reporter.log("User name is entered");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public static void browserClose() throws IOException {
		driver.close();

	}

	public static void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void selectByVisibletext(WebElement locator, String data) {
		Select s = new Select(locator);
		s.selectByValue(data);
	}

	public static void takesScreenShot(WebElement element) throws IOException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime ldt = LocalDateTime.now();
		String TimeStamp = dtf.format(ldt);

		File srcFile = element.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\softsuave\\Documents\\ERP\\Logs\\ScreenShots\\" + TimeStamp + ".png");
		FileUtils.copyFile(srcFile, destFile);
	}

	public static void takesScreenShotfull() throws IOException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime ldt = LocalDateTime.now();
		String TimeStamp = dtf.format(ldt);
		TakesScreenshot element = (TakesScreenshot) driver;
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\softsuave\\Documents\\ERP\\Logs\\ScreenShots\\" + TimeStamp + ".png");
		FileUtils.copyFile(srcFile, destFile);
	}

	public static void FailedMethodTakesscreenshot(ITestResult result) throws Exception {


		TakesScreenshot scr = (TakesScreenshot) driver;
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
	    LocalDateTime ldt = LocalDateTime.now();
	    String TimeStamp = dtf.format(ldt);
	    File srcFile = scr.getScreenshotAs(OutputType.FILE);

	    if (result.FAILURE == result.getStatus()) {
	        String directory = System.getProperty("user.dir") + "/FailureScreenShots/";
	        File dir = new File(directory);
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }
	        String destination = directory + TimeStamp + "-" + result.getName() + ".png";
	        File destFile = new File(destination);
	        FileUtils.copyFile(srcFile, destFile);
	    } else if (result.SKIP == result.getStatus()) {
	    } else if (result.SUCCESS == result.getStatus()) {

	    }

	}

	public static void mouseoveractions(WebElement target) {
		try {
			Actions a = new Actions(driver);
			a.click(target).perform();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void newTabhandle() {
		Set<String> par = driver.getWindowHandles();
		Set<String> newwindow = driver.getWindowHandles();
		for (String x : newwindow) {
			if (!par.equals(x)) {
				driver.switchTo().window(x);
			}
		}
	}

	public static void parentTabhandle() {
		driver.close();
		Set<String> par = driver.getWindowHandles();
		for (String x : par) {
			driver.switchTo().window(x);
		}

	}

	public static void newWindowhandle() {

//		Set<String> par = driver.getWindowHandles();
//		System.out.println(par);
//		Set<String> newwindow = driver.getWindowHandles();
//		System.out.println(newwindow);
//		for (String x : newwindow) {
//			if (!par.equals(x)) {
//				driver.switchTo().window(x);
//			}
//
//		}

	}

	public static void Scrolljavascriptexecutor(String scroll, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		if ("up".equalsIgnoreCase(scroll)) {
			js.executeScript("arguments[0].scrollIntoView(false)", element);

		}
		if ("down".equalsIgnoreCase(scroll)) {
			js.executeScript("arguments[0].scrollIntoView(true)", element);

		}

	}

	public static void Javascriptexecutor(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object executeScript = js.executeScript("return arguments[0].getAtteibute('value')", "textusename");

	}
	
	public static void VerifyTextValidation(WebElement element,String Text) {
		String actualText = (element.getText()).trim();
		try {
	        Assert.assertEquals(actualText,Text);
	        System.out.println("The expected '"+Text+"' popup message is verified.");
	    } catch (AssertionError e) {
	        System.out.println("The Expected success message is "+Text+" but the Actual message is "+actualText+"");
	        throw e;
	    }
	}
	
	public void VerifyTestResult(WebElement element,String Text) {
		String actualText = (element.getText()).trim();
		try {
	        Assert.assertEquals(actualText,Text);
	        System.out.println("The Expected value "+Text+" and Actual value "+actualText+" are equal.");
	    } catch (AssertionError e) {
	        System.out.println("The Expected value is "+Text+" but the Actual value is "+actualText+"");
	        throw e;
	    }
	}
	
	public static String GrabEmployeeId() {
		WebElement employeeID = driver.findElement(By.xpath("//ul[@id='navbar-breadcrumbs']//a[contains(text(),'SS')]"));
		String employeeIDText = employeeID.getText();
		return employeeIDText;
	}
	
	public static void javascriptExecutorForceClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public String gettext(WebElement element) {
	String text=element.getText();	
	return text;
	}
	
	
}