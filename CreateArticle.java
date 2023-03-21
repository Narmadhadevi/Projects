package week6.assignment2w6;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.github.sukgu.Shadow;

public class CreateArticle extends CreateClass{
	@Test
	public void createArti() throws InterruptedException {
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
		
	}		
}
