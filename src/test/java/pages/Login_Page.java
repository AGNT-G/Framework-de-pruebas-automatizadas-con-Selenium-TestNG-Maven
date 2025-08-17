package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page {
    WebDriver driver;

    // Constructor
    public Login_Page(WebDriver driver) {
        this.driver = driver;}

        public void enterUsername(String username){
            driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
        }
        public void enterPassword(String password){
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        }
        public void clickLoginButton(){
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
        }

}
