package week4.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	private static List<String> listWindows1;

	public static void main(String[] args) throws InterruptedException {
		// call webdriver manager
		WebDriverManager.chromedriver().setup();
		//Launch chrome browser
		ChromeDriver driver=new ChromeDriver();
		//Open URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		//Maximize
		driver.manage().window().maximize();
		//find and Enter Username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		//find and Enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click on Login
		driver.findElement(By.className("decorativeSubmit")).click();
		//Check Correct Page
		WebElement webElemen = driver.findElement(By.className("decorativeSubmit"));
		//get attribute and print it
		String attribute = webElemen.getAttribute("value");
		//Print the attribute
		System.out.println(attribute);
		if(attribute.equalsIgnoreCase("logout"));
		//print if it is successful login
		System.out.println("Logged in successfully");
		//Click on CRM/SFS
		driver.findElement(By.linkText("CRM/SFA")).click();
		 //5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		 //6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.linkText("Merge Contacts")).click();
		 // 7. Click on Widget of From Contact
		driver.findElement(By.xpath("//td/span[text()='From Contact']//following::a")).click();
		      //navigate to second window
				Set<String> windowHandles = driver.getWindowHandles();
				System.out.println(windowHandles.size());
				List<String> listWindows=new ArrayList<String>(windowHandles);
				//get windows index
				String firstWindow=listWindows.get(0);
				String secondWindow = listWindows.get(1);
				driver.switchTo().window(secondWindow);
				driver.manage().window().maximize();
		        // 8. Click on First Resulting Contact
				driver.findElement(By.xpath("//td/div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
				Thread.sleep(3000);
				driver.switchTo().window(firstWindow);
				// 9. Click on Widget of To Contact
				driver.findElement(By.xpath("//td/span[text()='To Contact']//following::a")).click();
				Set<String> windowHandles1 = driver.getWindowHandles();
				List<String> listWindows1 = new ArrayList<String>(windowHandles1);
				String firstWindow1=listWindows1.get(0);
				String secondWindow1 = listWindows1.get(1);
				driver.switchTo().window(secondWindow1);
				driver.manage().window().maximize();
		        // 10. Click on Second Resulting Contact
				driver.findElement(By.xpath("//td/div[@class='x-grid3-cell-inner x-grid3-col-partyId']//following::a[4]")).click();
		       //11. Click on Merge button using Xpath Locator
				driver.switchTo().window(firstWindow1);
				driver.manage().window().maximize();
				driver.findElement(By.linkText("Merge")).click();
		 // 12. Accept the Alert
				Alert alert = driver.switchTo().alert();
				//get text
				String txt=alert.getText();
				System.out.println(txt);
				//click ok
				alert.accept();
		 // 13. Verify the title of the page
				String title1 = driver.getTitle();
				System.out.println(title1);


	}

}
