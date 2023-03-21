package week6.assignment2w6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateClass {
	ChromeDriver driver;
	@Parameters({"url","un","pw"})
@BeforeMethod
public void pre(String url,String un,String pw){
	WebDriverManager.chromedriver().setup();
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	driver=new ChromeDriver(option);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get(url);
	driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(un);
	driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(pw);
	driver.findElement(By.xpath("//button[text()='Log in']")).click();
}
@AfterMethod
public void post() {
	driver.close();
}
}
