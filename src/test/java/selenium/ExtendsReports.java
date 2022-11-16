package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendsReports {
	ExtentReports extent;
   @BeforeMethod
   public void config()
   {
	String  path =System.getProperty("user.dir")+"//reports//index.html";
	  ExtentSparkReporter reporter = new  ExtentSparkReporter(path);
	  reporter.config().setReportName("webAutomation Results"); 
	  reporter.config().setDocumentTitle("test Results");
	   extent = new ExtentReports();
	  extent.attachReporter(reporter);
	  extent.setSystemInfo("tester", "aswini");
       
   }
	@Test
	public void intialDemo()
	{
		ExtentTest Test=extent.createTest("intialDemo");
		WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      driver.get("https://rahulshettyacademy.com");
         System.out.println( driver.getTitle());
         driver.close();
         extent.flush();
	}

}
