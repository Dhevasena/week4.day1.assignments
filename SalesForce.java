package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) throws InterruptedException {
		            // call webdriver manager
					WebDriverManager.chromedriver().setup();
					//Disable browser notification
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-notifications");
					//Launch chrome browser
					ChromeDriver driver=new ChromeDriver(options);
					//Open URL
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					driver.get("https://login.salesforce.com/");
					//Maximize
					driver.manage().window().maximize();
					//Username
					driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
					//password
					driver.findElement(By.id("password")).sendKeys("Password$123");
					//Click Login
					driver.findElement(By.id("Login")).click();
					//click on the learn more option in the Mobile publisher
					Thread.sleep(6000);
					driver.findElement(By.xpath("//span[text()='Learn More']")).click();
					//Switch to second window
					Set<String> windowHandles1 = driver.getWindowHandles();
					List<String> listWindows1 = new ArrayList<String>(windowHandles1);
					//index of first window
					String firstWindow1=listWindows1.get(0);
					//index of second window
					String secondWindow1 = listWindows1.get(1);
					driver.switchTo().window(secondWindow1);
					//Maximize secondwindow
					driver.manage().window().maximize();
					//click on the confirm button in the redirecting page
					driver.findElement(By.xpath("//button[text()='Confirm']")).click();
					//get title
					String title1 = driver.getTitle();
					System.out.println(title1);
					//Get back to the parent window
					driver.switchTo().window(firstWindow1);
	                //close the browser
					driver.quit();
					
					
					
	}

}
