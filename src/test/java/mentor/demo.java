package mentor;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo {
	
	WebDriver driver;
	//public String URL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
	
	@BeforeTest
	public void BT() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get(URL);
		//String pTab = driver.getWindowHandle();		
	}
	
	@Test
	public void testcase1() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		String parent = driver.getWindowHandle();
		System.out.println("parent window is"+parent);
		
		driver.close();
		
		driver.findElement(By.id("newWindowsBtn")).click();
		
		Set<String> allwindow = driver.getWindowHandles();
		
	int count = allwindow.size();
	System.out.println("total window is"+count);
		for(String child:allwindow)
		{
		driver.switchTo().window(child);
		
		System.out.println(driver.getTitle());
		driver.switchTo().window(parent);
		
		
		driver.switchTo().window(child);
		//driver.quit();
		}


		
		//driver.close();
		
	}
	

}
