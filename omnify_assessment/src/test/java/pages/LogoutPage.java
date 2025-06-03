package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {
    WebDriver driver;

    By userDropdown = By.xpath("//p[@class='oxd-userdropdown-name']");
    By logoutLink = By.xpath("//a[text()='Logout']");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        WebElement dropdown = driver.findElement(userDropdown);
        dropdown.click();
        driver.findElement(logoutLink).click();
    }
}
