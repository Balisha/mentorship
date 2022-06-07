package mentor;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo2 {
WebDriver driver;
WebDriver driver2;
	public String URL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	@BeforeTest
	public void BT() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 driver2 = new ChromeDriver();
		 driver.get(URL);
		 driver2.get(URL);
		
	}
	
	@Test
	public void TC1() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.findElement(By.partialLinkText("Ad")).click();
    	driver.findElement(By.xpath("//*[@id='ohrmList_chkSelectRecord_10']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.id("btnDelete")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.id("dialogDeleteBtn")).click();
		 String MainWindow = driver.getWindowHandle();
		    System.out.println("Main window handle is " + MainWindow);
		    
		    
		    
		     driver2.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
				driver2.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
				driver2.findElement(By.xpath("//input[@id='btnLogin']")).click();
				driver2.findElement(By.partialLinkText("Ad")).click();
				Thread.sleep(3000);
				driver2.navigate().refresh();
				Set<String> s1 = driver2.getWindowHandles();
			    System.out.println("Child window handle is" + s1);
			    
			  
			   

			       }
	
	
	}

