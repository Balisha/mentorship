package mentor;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class naukri {
	WebDriver driver;
	
	
	@BeforeTest
	public void BT() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
				
	}
	@Test
	public void testcase1() {
		driver.get("https://demoqa.com/browser-windows");

	    // Opening all the child window
	    driver.findElement(By.id("windowButton")).click();
	    driver.findElement(By.id("messageWindowButton")).click();
	    
	    String MainWindow = driver.getWindowHandle();
	    System.out.println("Main window handle is " + MainWindow);

	    // To handle all new opened window
	    Set<String> s1 = driver.getWindowHandles();
	    System.out.println("Child window handle is" + s1);
	    Iterator<String> i1 = s1.iterator();

	    // Here we will check if child window has other child windows and when child window
	    //is the main window it will come out of loop.
	      while (i1.hasNext()) {
	          String ChildWindow = i1.next();
	          if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
	              driver.switchTo().window(ChildWindow);
	              //driver.close();
	              //System.out.println("Child window closed");
	              driver.switchTo().window(MainWindow);
	           }
	       }
	    }
		
	}



