package week6.assignment1w6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class UpdateIncident {
@Test
public void updateInci() {
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
	String incident = driver.findElement(By.xpath("//table[@id='incident_table']/tbody/tr/td[3]")).getText();
	driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incident,Keys.ENTER);
	driver.findElement(By.xpath("//table[@id='incident_table']/tbody/tr/td[3]/a")).click();
	WebElement priority = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
	Select dd=new Select(priority);
	dd.selectByVisibleText("1 - High");
	WebElement state = driver.findElement(By.xpath("//select[@id='incident.state']"));
	Select options =new Select(state);
	options.selectByVisibleText("In Progress");
	driver.findElement(By.xpath("//button[@id='sysverb_update']")).click();
	driver.findElement(By.xpath("//table[@id='incident_table']/tbody/tr/td[3]/a")).click();
	String prior= driver.findElement(By.xpath("//select[@id='incident.urgency']/option")).getText();
	System.out.println(prior);
	String stat = driver.findElement(By.xpath("//select[@id='incident.state']/option[2]")).getText();
	System.out.println(stat);
	driver.close();
	
}
}
