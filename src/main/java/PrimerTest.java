import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PrimerTest {
    public static void main(String[] args) {

        // Configurar automáticamente el driver de Chrome
        WebDriverManager.chromedriver().setup();

        // Crear una instancia del navegador
        WebDriver driver = new ChromeDriver();

        // Abrir Google
        driver.get("https://www.google.com");

        // Aceptar cookies si aparecen (opcional, depende de la región)
        try {
            WebElement aceptar = driver.findElement(By.xpath("//div[text()='Acepto todo' or text()='Aceptar todo' or text()='Accept all']"));
            aceptar.click();
        } catch (Exception e) {
            System.out.println("No se mostraron cookies.");
        }

        // Buscar algo
        WebElement barraBusqueda = driver.findElement(By.name("q"));
        barraBusqueda.sendKeys("Selenium WebDriver");
        barraBusqueda.submit();

        // Esperar unos segundos para ver el resultado (no recomendado en producción)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println("El sleep fue interrumpido: " + e.getMessage());
        }

        // Cerrar el navegador
        driver.quit();
    }
}