package marathon.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*01) Launch Chome  add  implicitlyWait
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
02) Load https://www.amazon.in/
03) Type "Bags" in the Search box
04) Choose the 	 item in the result (bags for boys)
05) Print the total number of results (like 40000)
1-48 of over 40,000 results for "bags for boys"
06) Select the first 2 brands in the left menu
(like American Tourister, Generic)
07) Choose New Arrivals (Sort)
08) Print the first resulting bag info (name, discounted price)
09) Get the page title and close the browser(driver.close()*/
public class AmazonBag {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags");
		driver.findElement(By.xpath("//span[text()=' for boys']")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();
		driver.findElement(By.xpath("//span[text()='American Tourister']")).click();
		driver.findElement(By.className("a-dropdown-label")).click();
		driver.findElement(By.linkText("Newest Arrivals")).click();
		String text2 = driver.findElement(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).getText();
		System.out.println(text2);
		String text3 = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println(text3);
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		
	}

}
