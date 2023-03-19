package week6.assignment2w6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateArticle {
	@Test
	public void createArti() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev57841.service-now.com/");
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Srivatsan@12");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Shadow dom=new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//div[text()='All']").click();
		dom.setImplicitWait(10);
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Knowledge");
		dom.findElementByXPath("//mark[@class='filter-match']").click();
		WebElement frames = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frames);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//input[@class='form-control element_reference_input']")).sendKeys("IT");
		driver.findElement(By.xpath("(//input[contains(@class,'form-control element_reference_input')])[2]")).sendKeys("Java");
		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("New Article");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		driver.close();
		
	}		
}
