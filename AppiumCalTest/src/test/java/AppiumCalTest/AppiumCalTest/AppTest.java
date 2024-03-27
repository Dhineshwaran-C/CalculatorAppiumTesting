package AppiumCalTest.AppiumCalTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	AppiumDriver<MobileElement>  driver;
	
	@Test(priority=1)
	public void openCalculator() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "sdk_gphone64_x86_64");
		cap.setCapability("udid","emulator-5554");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","14");
		cap.setCapability("automationName", "UiAutomator2");
		
		cap.setCapability("appPackage","com.google.android.calculator");
		cap.setCapability("appActivity","com.android.calculator2.Calculator");
		
		
		@SuppressWarnings("deprecation")
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		System.out.println("Application Started... ");
	}

	@Test(priority=2, dataProvider="testdata")
	public void CalculatorTesting(String cal,String expectedResult) {
		
		// s = Square root
		// p = pi
		// d = delete
		// c = clear
		for(int i=0;i<cal.length();i++) {
			clickElement(cal.charAt(i));
		}
		
		
		MobileElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
		
		
		String actualResult = result.getText();
		
		System.out.println("Ans is : "+ result.getText());
		
		Assert.assertEquals(expectedResult,actualResult);
		
	}
	
	public void clickElement(char value) {
		switch(value) {
		case '0':
			driver.findElement(By.id("com.google.android.calculator:id/digit_0")).click();
			break;
		
		case '1':
			driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
			break;
			
		case '2':
			driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
			break;
			
		case '3':
			driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
			break;
			
		case '4':
			driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
			break;
			
		case '5':
			driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
			break;
			
		case '6':
			driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
			break;
			
		case '7':
			driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
			break;
			
		case '8':
			driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
			break;
			
		case '9':
			driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
			break;
			
		case '.':
			driver.findElement(By.id("com.google.android.calculator:id/dec_point")).click();
			break;
			
		case 'd':
			driver.findElement(By.id("com.google.android.calculator:id/del")).click();
			break;
			
		case '=':
			driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
			break;
			
		case '+':
			driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
			break;
			
		case '-':
			driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
			break;
			
		case '*':
			driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
			break;
		
		case '/':
			driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
			break;
			
		case '%':
			driver.findElement(By.id("com.google.android.calculator:id/op_pct")).click();
			break;
			
		case '(':
			driver.findElement(By.id("com.google.android.calculator:id/parens")).click();
			break;
			
		case ')':
			driver.findElement(By.id("com.google.android.calculator:id/parens")).click();
			break;
			
		case 'c':
			driver.findElement(By.id("com.google.android.calculator:id/clr")).click();
			break;
			
		case 's':
			driver.findElement(By.id("com.google.android.calculator:id/op_sqrt")).click();
			break;
			
		case 'p':
			driver.findElement(By.id("com.google.android.calculator:id/const_pi")).click();
			break;
			
		case '^':
			driver.findElement(By.id("com.google.android.calculator:id/op_pow")).click();
			break;
			
		case '!':
			driver.findElement(By.id("com.google.android.calculator:id/op_fact")).click();
			break;
		}
	}
	
	@DataProvider(name = "testdata")
	public Object[][] calData(){
		return new Object[][] {
			{"9+(2*3+6)/2=","15"},
			{"s2+s5=","3.650281539872"},
			{"72.65/65.23=","1.113751341407"},
			{"s2+s5d8=","4.242640687119"},
			{"(3*p)+18=","27.42477796076"}
		};
	}
	
	

}

