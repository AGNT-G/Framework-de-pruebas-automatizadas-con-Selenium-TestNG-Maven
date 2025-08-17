import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Advanced_Case {
    public static void main(String[] args) {

        // Configurar automáticamente el driver de Chrome
        WebDriverManager.chromedriver().setup();

        // Crear una instancia del navegador
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/forgot_password");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("emaildeprueba@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"form_submit\"]/i")).click();
        String UrlActual = driver.getCurrentUrl();
        assert UrlActual != null;
        if (UrlActual.equals("https://the-internet.herokuapp.com/email_sent")) {
            System.out.println("Expected Url");
        } else {
            System.out.println("Not Expected Url" + UrlActual);
        }
        if (driver.getCurrentUrl().contains("/email_sent")) {
            // Validación mensaje
        } else {
            System.out.println("❌ Error: No hubo redirección");
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
        driver.quit();
    }


}