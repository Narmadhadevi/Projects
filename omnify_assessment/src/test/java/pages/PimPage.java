package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


public class PimPage {
    WebDriver driver;

    // Locator
    By pimMenu = By.xpath("//a[@class='oxd-main-menu-item']//span[text()='PIM']"); // Replace with your actual locator
    By addEmployeeButton = By.xpath("//a[text()='Add Employee']");

    public PimPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPIM() {
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement pim = wait.until(ExpectedConditions.visibilityOfElementLocated(pimMenu));
        action.moveToElement(pim).click().perform();
        System.out.println("Navigated to PIM section.");
    }

public void clickAddEmployee() {
        driver.findElement(addEmployeeButton).click();
    }
}