package marathon2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

/*1. Launch ServiceNow application
2. Login with valid credentials username as admin and password 
3. Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
4. Click on  mobiles
5. Select Apple iphone6s
6. Update color field to gold and storage field to 128GB
7. Select  Order now option
8. Verify order is placed and copy the request number"
*/
public class OrderingMobile {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions ch = new EdgeOptions();
		ch.addArguments("--disable-notifications");
		EdgeDriver driver = new EdgeDriver(ch);
		driver.get("https://dev57841.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Srivatsan@12");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		Shadow dom=new Shadow(driver);
		dom.setImplicitWait(20);
		dom.findElementByXPath("//div[text()='All']").click();
		dom.setImplicitWait(10);
		dom.findElementByXPath("//span[text()='Service Catalog']").click();
		WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		dom.setImplicitWait(20);
		dom.findElementByXPath("//h2[contains(text(),'Mobiles')]").click();
		dom.setImplicitWait(10);
		dom.findElementByXPath("//strong[text()='Apple iPhone 6s']").click();		
		WebElement select = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));
		Select dd=new Select(select);
		dd.selectByVisibleText("Gold");
		WebElement select1 = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[3]"));
		Select dd1=new Select(select1);
		dd1.selectByValue("onetwentyeight");
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		//String order = driver.findElement(By.xpath("//dl[@class='dl-horizontal sc-dl-horizontal/dt']")).getText();
		String title = driver.getTitle();
		System.out.println(title);
		
		String reqNum = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println(reqNum);
	}

}
