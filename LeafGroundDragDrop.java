package week4.assignment2w4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LeafGroundDragDrop {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement first = driver.findElement(By.xpath("//span[text()='Drag me around']"));
		Actions act=new Actions(driver);
		act.dragAndDropBy(first, 200, 300).perform();
		WebElement three = driver.findElement(By.xpath("//tr[@role='row']//th"));
		WebElement four = driver.findElement(By.xpath("(//tr[@role='row']//th)[3]"));
		act.dragAndDrop(three, four).perform();
		WebElement two = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));
		WebElement two2 = driver.findElement(By.xpath("//div[@class='ui-wrapper']"));
		act.dragAndDrop(two, two2).perform();
		WebElement five = driver.findElement(By.xpath("//p[text()='Drag to target']"));
		WebElement five5 = driver.findElement(By.xpath("//p[text()='Drop here']"));
		act.dragAndDrop(five, five5).perform();
		WebElement six = driver.findElement(By.xpath("(//td[text()='Black Watch'])[2]"));
		WebElement six6 = driver.findElement(By.xpath("(//td[text()='Chakra Bracelet'])[2]"));
		act.dragAndDrop(six, six6).perform();
		WebElement seven = driver.findElement(By.xpath("//span[text()='Start']"));
		act.doubleClick(seven).perform();
		WebElement eight = driver.findElement(By.xpath("//div[contains(@class,'ui-slider ui-corner-all')]"));
		WebElement nine = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle ui-corner-all')]"));
	
		int x = eight.getLocation().getX();
		act.clickAndHold(nine).dragAndDropBy(eight, x, 0).perform();
		
		
		
		//driver.close();

	}

}
