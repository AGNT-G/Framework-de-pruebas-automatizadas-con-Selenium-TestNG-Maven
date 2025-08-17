package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Login_Page;

public class Login_Test {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        Login_Page loginPage = new Login_Page(driver);
        loginPage.enterUsername("hola123");
        loginPage.enterPassword("onemoretime");
        loginPage.clickLoginButton();


        WebElement Succes_Login = driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String Valid_Login = Succes_Login.getText();
        if (Valid_Login.contains("Your username is invalid!")) {
            System.out.println("El mensaje se mostró correctamente");
        } else {
            System.out.println("El mensaje NO es el esperado" + Valid_Login);
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
        driver.quit();
    }



}
