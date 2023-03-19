package week4.assignment1w4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*1.Load the URL https://www.amazon.in/
2.search as oneplus 9 pro 
3.Get the price of the first product
4. Print the number of customer ratings for the first displayed product
5. Click the first text link of the first image
6. Take a screen shot of the product displayed
7. Click 'Add to Cart' button
8. Get the cart subtotal and verify if it is correct.
9.close the browser*/
public class AmazonWindowHandle {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		String value = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println(value);
		WebElement rating = driver.findElement(By.xpath("//span[@class='a-size-base']"));
		System.out.println("The rating of customer is "+rating.getText());
		driver.findElement(By.xpath("//a[@class='a-link-normal s-no-outline']//img")).click();
		Set<String> wH = driver.getWindowHandles();
		List<String> win = new ArrayList<String>(wH);
		driver.switchTo().window(win.get(1));
		File ss = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/shot.png");
		FileUtils.copyFile(ss, dest);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		//driver.findElement(By.xpath("//a[@class='a-link-normal close-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("nav-cart-count")).click();
		String subTotal = driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color-base')])[3]")).getText();
		System.out.println(subTotal);
		driver.quit();
		subTotal=subTotal.replace(".00", "");
		subTotal=subTotal.replace(" ", "");
		if(value.equals(subTotal)) {
			System.out.println("same price");
		}else {
			System.out.println("different price");
		}
	}

}
