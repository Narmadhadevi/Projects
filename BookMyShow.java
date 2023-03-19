package marathon.day1;

/*01) Launch Edge / Chrome  add  implicitlyWait
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
02) Load https://in.bookmyshow.com/
03) Type the city as "Hyderabad"" in Select City
04) Confirm the URL has got loaded with Hyderabad 
05) Search for your favorite movie 
06) Click on movie
07) Print the name of the theater displayed first
08) Click on the info of the theater
09) Confirm if there is a parking facility in the theater
10) Close the theater popup
11) Click on the first green (available) timing
12) Click Accept
13) Choose 1 Seat and Click Select Seats
14) Choose any available ticket and Click Pay
15) Print the sub total*/
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		
		driver.get("https://in.bookmyshow.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("(//li[@class='sc-hizQCF dSgOQo'])[4]")).click();
		driver.findElement(By.id("4")).click();
		driver.getCurrentUrl();
		driver.findElement(By.tagName("input")).sendKeys("Pathaan");
		driver.findElement(By.tagName("strong")).click();
		driver.findElement(By.xpath("//span[text()='Book tickets']")).click();
		driver.findElement(By.xpath("//span[text()='2D']")).click();
		String text = driver.findElement(By.xpath("//div[@class='__title']//a")).getText();
        System.out.println(text);
       driver.findElement(By.xpath("//div[text()='INFO']")).click();
       String text2 = driver.findElement(By.xpath("//div[text()='            Parking Facility        ']")).getText();
       System.out.println(text2);
       Thread.sleep(2000);
       if(text2.contains("Parking")) {
    	   System.out.println("Parking slot available");
       }
     
       Thread.sleep(2000);
       driver.findElement(By.xpath("//div[@class='cross-container']")).click();
       driver.findElement(By.xpath("(//div[@class='__text'])[3]")).click();
       driver.findElement(By.id("btnPopupAccept")).click();
       driver.findElement(By.id("pop_1")).click();
       driver.findElement(By.id("proceed-Qty")).click();
       driver.findElement(By.xpath("//div[@id='B_8_029']/a[1]")).click();
       driver.findElement(By.xpath("//a[@id='btmcntbook']")).click();
       Thread.sleep(2000);
       String text3 = driver.findElement(By.xpath("(//li[@class='_total-section']/div)[2]")).getText();
       System.out.println("The subtotal is "+text3);
       
       driver.close();
	}

}
