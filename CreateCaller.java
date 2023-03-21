package week6.assignment2w6;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.github.sukgu.Shadow;

public class CreateCaller extends CreateClass{
	@Test
	public void createCall() throws InterruptedException {
		
		Shadow dom=new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//div[@class='sn-polaris-tab can-animate polaris-enabled']").click();
		dom.setImplicitWait(10);
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Caller");
		dom.findElementByXPath("//mark[@class='filter-match']").click();
		WebElement frames = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frames);
		driver.findElement(By.xpath("//button[@value='sysverb_new']")).click();
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("Narmadha");
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("Mahesh");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Mahesh",Keys.ENTER);
		String value = driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody/tr/td[3]")).getText();
		if(value.contains("Mahesh")) {
			System.out.println("Caller created");
		}else {
			System.out.println("Caller not created");
		}
		
}
}