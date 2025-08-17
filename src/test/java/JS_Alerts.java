import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class JS_Alerts {
    public static void main(String[] args) {
        // Configurar automáticamente el driver de Chrome
        WebDriverManager.chromedriver().setup();

        // Crear una instancia del navegador
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
        driver.switchTo().alert().accept();
        WebElement Valid_Alert = driver.findElement(By.xpath("//*[@id=\"result\"]"));
        String Succes_Alert = Valid_Alert.getText();
        if (Succes_Alert.contains("You successfully clicked an alert")) {
            System.out.println("You successfully clicked an alert");
        } else {
            System.out.println("You failed to click an alert" + Succes_Alert);
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
        driver.quit();








    }
}