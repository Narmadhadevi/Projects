package week4.assignment2w4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundFrame {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/frame.xhtml;jsessionid=node05us3gij8ed091h38fieurov685953.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(0);
		WebElement firstF = driver.findElement(By.id("Click"));
		firstF.click();
		System.out.println(firstF.getText());
		driver.switchTo().defaultContent();
		List<WebElement> noOfFrame = driver.findElements(By.tagName("iframe"));
		System.out.println(noOfFrame.size());
		driver.switchTo().frame(2);
		WebElement fourF = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(fourF);
		WebElement four = driver.findElement(By.id("Click"));
		four.click();
		System.out.println(four.getText());
		driver.close();
	}

}
