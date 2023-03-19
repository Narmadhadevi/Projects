package week4.assignment2w4;
/*1) Go to  https://www.nykaa.com/
2) Mouseover on Brands and Search L'Oreal Paris
3) Click L'Oreal Paris
4) Check the title contains L'Oreal Paris(Hint-GetTitle)
5) Click sort By and select customer top rated
6) Click Category and click Hair->Click haircare->Shampoo
7) Click->Concern->Color Protection
8)check whether the Filter is applied with Shampoo
9) Click on L'Oreal Paris Colour Protect Shampoo
10) GO to the new window and select size as 175ml
11) Print the MRP of the product
12) Click on ADD to BAG
13) Go to Shopping Bag
14) Print the Grand Total amount
15) Click Proceed
16) Click on Continue as Guest
17) Check if this grand total is the same in step 14
18) Close all windows*/

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NykaaFrame {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions act=new Actions(driver);
		act.moveToElement(brand).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='css-ov2o3v']//a")).click();
		System.out.println(driver.getTitle());
		WebElement hair = driver.findElement(By.xpath("//a[text()='hair']"));
		act.moveToElement(hair).perform();
		driver.findElement(By.xpath("//a[text()='Shampoo']")).click();
		Set<String> handle = driver.getWindowHandles();
		List<String> window1 = new	ArrayList<String>(handle);
		driver.switchTo().window(window1.get(1));
		driver.findElement(By.xpath("//button[@class=' css-n0ptfk']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='productWrapper css-xin9gt'])[19]")).click();
		Set<String> handles = driver.getWindowHandles();
		List<String> window2 = new	ArrayList<String>(handles);
		System.out.println("The noOf windows "+window2.size());
		driver.switchTo().window(window2.get(2));
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		String mRP = driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
		System.out.println(mRP);
		driver.findElement(By.xpath("//button[@class=' css-1qvy369']")).click();
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		driver.switchTo().frame(0);
		String grandTot = driver.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']")).getText();
		System.out.println(grandTot);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		if(!mRP.equals(grandTot)) {
			System.out.println("grand total varies");
		}else {
			System.out.println("both same");
		}
		driver.quit();
	
	}

}
