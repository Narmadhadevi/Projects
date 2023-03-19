package week4.assignment2w4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*https://jqueryui.com/draggable
https://jqueryui.com/droppable
https://jqueryui.com/resizable
https://jqueryui.com/selectable
*/
public class JQuery {

	public static void main(String[] args) throws InterruptedException {
	
		  ChromeDriver driver=new ChromeDriver(); 
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get("https://jqueryui.com/draggable"); 
		  driver.switchTo().frame(0);
		  WebElement drag = driver.findElement(By.xpath("//div[contains(@class,'ui-widget-content ui-draggable')]"));
		  Actions act=new Actions(driver); 
		  act.dragAndDropBy(drag,300,0).perform();
		  driver.close();
		  Thread.sleep(4000);
		  ChromeDriver driver2=new ChromeDriver(); 
		  driver2.manage().window().maximize();
		  driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver2.get("https://jqueryui.com/droppable/"); 
		  driver2.switchTo().frame(0);
		  WebElement drags =driver2.findElement(By.xpath("//div[@id='draggable']"));
		  WebElement drop = driver2.findElement(By.xpath("//div[@id='droppable']"));
		  Actions acts=new Actions(driver2);
		  acts.dragAndDrop(drags, drop).perform();
		  driver2.close();
		  Thread.sleep(4000);
		  ChromeDriver driver3=new ChromeDriver(); 
		  driver3.manage().window().maximize();
		  driver3.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver3.get("https://jqueryui.com/resizable/"); 
		  driver3.switchTo().frame(0);
		  WebElement y = driver3.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));
		  WebElement diagonal = driver3.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		  WebElement x = driver3.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-s']"));
		  WebElement move = driver3.findElement(By.xpath("//div[@class='ui-widget-content ui-resizable']"));
		  Actions obj=new Actions(driver3);
		  obj.dragAndDrop(x, move).perform();
		  obj.dragAndDrop(y, move).perform();
		  obj.dragAndDrop(diagonal, move).perform();
		  driver3.close();
		  Thread.sleep(4000);
		  ChromeDriver driver4=new ChromeDriver(); 
		  driver4.manage().window().maximize();
		  driver4.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver4.get("https://jqueryui.com/selectable/"); 
		  driver4.switchTo().frame(0);
		  WebElement item1 = driver4.findElement(By.xpath("//li[text()='Item 1']"));
		  WebElement item3 = driver4.findElement(By.xpath("//li[text()='Item 3']"));
		  WebElement item5 = driver4.findElement(By.xpath("//li[text()='Item 5']"));
		  Actions clic=new Actions(driver4);
		  clic.keyDown(Keys.CONTROL)
		  .click(item1)
		  .click(item3)
		  .click(item5)
		  .keyUp(Keys.CONTROL)
		  .perform();
		  driver4.close();
		  
	}

}
