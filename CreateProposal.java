package week6.assignment2w6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.github.sukgu.Shadow;

public class CreateProposal extends CreateClass {
@Test
public void createProp() throws InterruptedException {
	Shadow dom=new Shadow(driver);
	dom.setImplicitWait(30);
	dom.findElementByXPath("//div[text()='All']").click();
	dom.setImplicitWait(10);
	dom.findElementByXPath("//input[@id='filter']").sendKeys("Proposal");
	dom.findElementByXPath("//mark[@class='filter-match']").click();
	WebElement frames = dom.findElementByXPath("//iframe[@id='gsft_main']");
	driver.switchTo().frame(frames);
	driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
	driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Sample Proposal");
	Thread.sleep(2000);
	String number = driver.getTitle();
	number=number.replaceAll("\\D", "");
	driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
	System.out.println(number);
	driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(number,Keys.ENTER);
	String value = driver.findElement(By.xpath("//table[@id='std_change_proposal_table']/tbody/tr/td[3]")).getText();
	if(value.contains(number)) {
		System.out.println("Proposal created");
	}else {
		System.out.println("Proposal not created");
	}
}

}
