package week4.day1.classroomactivity;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindow {

	public static void main(String[] args) throws InterruptedException {
		// call webdriver manager
		WebDriverManager.chromedriver().setup();
		//Launch chrome browser
		ChromeDriver driver=new ChromeDriver();
		//Open URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		//Maximize
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
		//Click Create lead link
		driver.findElement(By.linkText("Create Lead")).click();
		//Click Merge Leads Link
		driver.findElement(By.linkText("Merge Leads")).click();
		//Click the icon following the from lead 
		driver.findElement(By.xpath("//td/span[text()='From Lead']//following::a")).click();
		//navigate to second window
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		List<String> listWindows=new ArrayList<String>(windowHandles);
		//get sceond window
		String string = listWindows.get(1);
		driver.switchTo().window(string);
		//Enter the first name 
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Babu");
	//Click Find Leads Button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		//click first lead
		driver.findElement(By.xpath("//div[@class='linktext'][1]")).click();
		//get title
		String title = driver.getTitle();
		System.out.println(title);
		

	}

}
