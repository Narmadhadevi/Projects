package marathon2.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

/*1. Launch Salesforce application https://login.salesforce.com/
2. Login with Provided Credentials
3. Click on Learn More link in Mobile Publisher
4. Click  On Learning
5. And mouse hover on Learning On Trailhead
6. Click on Salesforce Certifications
7. Choose Your Role as Salesforce Architect
8. Get the Text(Summary) of Salesforce Architect 
9. Get the List of Salesforce Architect Certifications Available
10.Click on Application Architect 
11.Get the List of Certifications available*/
public class ArchitectCertifications {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeOptions ch = new EdgeOptions();
		ch.addArguments("--disable-notifications");
		EdgeDriver driver = new EdgeDriver(ch);
		
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("Leaf@123");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Shadow dom=new Shadow(driver);
		dom.findElementByXPath("//span[text()='Learning']").click();
		WebElement trail = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		WebElement sales = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(trail).perform();
		act.scrollToElement(sales).click(sales).perform();
		driver.findElement(By.xpath("//div[text()='Architect']")).click();
		String summary = driver.findElement(By.xpath("//div[contains(@class,'cert-site_text slds-text-align--center ')]")).getText();
		System.out.println(summary);
		Thread.sleep(3000);
		List<WebElement> certificate = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for(WebElement i:certificate) {
			String text = i.getText();
			System.out.println(text);
		}Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='credentials-card_title']")).click();
		Thread.sleep(2000);
		List<WebElement> certificate2 = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for(WebElement j:certificate2) {
			String text2 = j.getText();
			System.out.println(text2);
		}
		driver.quit();
	
	
	
	}

}
