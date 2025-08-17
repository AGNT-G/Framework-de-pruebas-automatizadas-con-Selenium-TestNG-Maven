package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard_Page {
    WebDriver driver;
    By Userprofile = By.xpath("//p[@class='oxd-userdropdown-name']");
    public Dashboard_Page(WebDriver driver) {
        this.driver = driver;
    }
        public String getUserprofile() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(Userprofile)).getText();

        }
    }

