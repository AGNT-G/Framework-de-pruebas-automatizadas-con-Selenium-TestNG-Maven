import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_Valid_Login {
    public static void main(String[] args) {

        // Configurar automáticamente el driver de Chrome
        WebDriverManager.chromedriver().setup();

        // Crear una instancia del navegador
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();
        String UrlActual = driver.getCurrentUrl();
        assert UrlActual != null;
        if (UrlActual.equals("https://the-internet.herokuapp.com/secure")) {
            System.out.println("Expected Url");
        } else {
            System.out.println("Not Expected Url" + UrlActual);
        }
       boolean presentLogout = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i")).isDisplayed();
        if   (presentLogout) {
            System.out.println("Expected Logout");
        } else {
            System.out.println("Not Logout");
        }






        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
        driver.quit();
    }
}