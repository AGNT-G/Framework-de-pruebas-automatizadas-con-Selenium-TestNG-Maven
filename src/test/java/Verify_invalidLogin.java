import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_invalidLogin {
    public static void main(String[] args) {

        // Configurar automáticamente el driver de Chrome
        WebDriverManager.chromedriver().setup();

        // Crear una instancia del navegador
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();
        WebElement mensajeError =  driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String TextoError = mensajeError.getText();
        if (TextoError.contains("Your password is invalid!")) {
            System.out.println("El mensaje de error se mostró correctamente");
        } else {
            System.out.println("El mensaje de error NO es el esperado");
        }






        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
        driver.quit();
    }
}