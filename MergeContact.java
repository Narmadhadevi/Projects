package week4.assignment1w4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*1. Launch URL "http://leaftaps.com/opentaps/control/login"
* 
* 2. Enter UserName and Password Using Id Locator
* 
* 3. Click on Login Button using Class Locator
* 
* 4. Click on CRM/SFA Link
* 
* 5. Click on contacts Button
* 	
* 6. Click on Merge Contacts using Xpath Locator
* 
* 7. Click on Widget of From Contact
* 
* 8. Click on First Resulting Contact
* 
* 9. Click on Widget of To Contact
* 
* 10. Click on Second Resulting Contact
* 
* 11. Click on Merge button using Xpath Locator
* 
* 12. Accept the Alert
* 
* 13. Verify the title of the page*/
public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("(//a[contains(text(),CRM)])[2]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> wind = driver.getWindowHandles();
		List<String> win = new ArrayList<String>(wind);
		System.out.println(win.size());
		driver.switchTo().window(win.get(1));
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		driver.switchTo().window(win.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> wind2 = driver.getWindowHandles();
		List<String> wi = new ArrayList<String>(wind2);
		System.out.println(wi.size());
		driver.switchTo().window(wi.get(1));
		driver.findElement(By.xpath("(//a[@class='linktext'])[5]")).click();
		driver.switchTo().window(wi.get(0));
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.getTitle());
		driver.close();
	}

}
