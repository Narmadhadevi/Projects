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

public class AssignIncident {
@Test
public void assignInci() {
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
	driver.findElement(By.xpath("//table[@id='incident_table']/tbody/tr/td[3]/a")).click();
	driver.findElement(By.xpath("//span[@class='section_view']")).click();
	driver.findElement(By.xpath("//div[text()='Default view']")).click();
	driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']")).sendKeys("software",Keys.ENTER);
	driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Assign to software");
	driver.findElement(By.xpath("//button[@id='sysverb_update']")).click();
	String verify = driver.findElement(By.xpath("//li[@class='h-card h-card_md h-card_comments']")).getText();
	System.out.println(verify);
	driver.close();
}
}
