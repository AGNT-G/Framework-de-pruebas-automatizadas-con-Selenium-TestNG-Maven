package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class saucedemo_login {
    WebDriver driver;
    By usernameField = By.xpath("//*[@id=\"user-name\"]");
    By passwordField = By.xpath("//*[@id=\"password\"]");
    By loginButton = By.xpath("//*[@id=\"login-button\"]");
    By errorMessage = By.xpath("//h3[@data-test='error']");
  // Constructor
public saucedemo_login(WebDriver driver) {this.driver = driver; }


public void saucedemo_Login(String username, String password) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

}

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
}


}
