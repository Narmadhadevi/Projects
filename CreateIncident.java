package week6.assignment1w6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateIncident {
	@Test
	public void createInci() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev62925.service-now.com/");
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("GAhMak34tH-^");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Shadow dom=new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//div[@class='sn-polaris-tab can-animate polaris-enabled']").click();
		dom.setImplicitWait(10);
		dom.findElementByXPath("//span[text()='Incidents']").click();
		WebElement frames = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frames);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Sample Incident");
		Thread.sleep(2000);
		String number = driver.getTitle();
		number=number.replaceAll("[\\D]", "");
		System.out.println(number);
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(number,Keys.ENTER);
		String value =  driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		System.out.println(number +" number"); 
		System.out.println(value +" value");
		if(value.contains(number)) {
		System.out.println("created"); 
		}else {
		System.out.println("not created"); 
		}
		
		driver.close();


	}
}
