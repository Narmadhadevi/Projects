package marathon.day1;

/*01) Launch Firefox / Chrome and add  implicitlyWait
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
02) Load https://www.redbus.in/
03) Type ""Chennai"" in the FROM text box
04) Click the first option from the pop up box
05) Type ""Bangalore"" in the TO text box
06) Click the first option from the pop up box
07) Select tomorrow's date in the Date field
08) Click Search Buses
09) Print the number of buses shown as results (104 Buses found) (use .getText())
10) Choose SLEEPER in the left menu 
11) Print the name of the second resulting bus (use .getText())
12) Get the Title of the page(use .getTitle())*/
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("src")).sendKeys("Chennai");
		driver.findElement(By.xpath("//li[@class='selected']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("dest")).sendKeys("Banglore");
		driver.findElement(By.xpath("//li[@class='selected']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[text()='25']")).click();
		driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		String text = driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']")).getText();
		System.out.println(text);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='bt_SLEEPER']")).click();
		String text2 = driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']")).getText();
		System.out.println(text2);
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
	}

}
