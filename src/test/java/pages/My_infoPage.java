package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class My_infoPage {
    WebDriver driver;
    By EmployeName = By.xpath("//input[@name='firstName']");
    By Myinfomenu = By.xpath("//span[text()='My Info']");
    By Personaldetails = By.xpath("//h6[text()='Personal Details']");
    public My_infoPage(WebDriver driver) {
        this.driver = driver;


    }
    public void goToMyInfo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Myinfomenu)).click();
    }
    public boolean VerifyPersonalDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       return wait.until(ExpectedConditions.visibilityOfElementLocated(Personaldetails)).isDisplayed();
    }

    public void setEmployeName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(EmployeName));
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys("Gabriel");

    }
}
