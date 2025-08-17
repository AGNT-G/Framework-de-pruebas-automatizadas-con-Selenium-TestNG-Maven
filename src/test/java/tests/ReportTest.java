package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Dashboard_Page;
import pages.My_infoPage;
import pages.New_Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Utils.Data_Reader;
import java.time.Duration;

public class ReportTest {

    WebDriver driver;
    New_Login loginPage;
    @DataProvider(name = "Login_Data")
    public Object[][] getLogin_Data() {
        String filePath = "testData/Login_Data.xlsx";
        String sheetName = "Hoja1";
        return Data_Reader.readExcelData(filePath, sheetName);
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new New_Login(driver); // tu clase POM
    }

    @Test
    public void testLogin() {
        loginPage.testLogin("Admin", "admin123");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean dashboardDisplayed = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h6"), "Dashboard"));
        if (dashboardDisplayed) {
            System.out.println("Dashboard Displayed");
        } else {
            System.out.println("Dashboard Not Displayed");
        }

    }

    @Test
    public void invalid_Login() {
        loginPage.testLogin("Admon", "admin123");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String ErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Invalid credentials']"))).getText();
        System.out.println("Mensaje capturado: " + ErrorMessage);
        Assert.assertEquals(ErrorMessage, "Invalid credentials");
    }
    @Test(dataProvider = "Login_Data")
    public void LoginTestWithExcel(String username, String password, String expected_result) {
        loginPage.testLogin(username, password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (expected_result.equalsIgnoreCase("Success")) {
            boolean dashboardDisplayed = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h6"), "Dashboard"));
       Assert.assertTrue(dashboardDisplayed, "Dashboard should be displayed for successful login");
       System.out.println("✅ Login successful as expected");
        } else if (expected_result.equalsIgnoreCase("error")) {
            String errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Invalid credentials']"))).getText();
            Assert.assertEquals(errorMessage, "Invalid credentials");
            System.out.println("Login failed as expected with error message: " + errorMessage);


        } else {
            Assert.fail("Unexpected error" + expected_result);
        }

    }

    @Test
        public void ValidateUsernameDisplayed() {
        loginPage.testLogin("Admin", "admin123");
        Dashboard_Page dashboard = new Dashboard_Page(driver);
        String userName = dashboard.getUserprofile();
        System.out.println("✅ Nombre mostrado en perfil: " + userName);

    }
    @Test
    public void CheckMyInfoSection() {
        loginPage.testLogin("Admin", "admin123");
        My_infoPage  my_info = new My_infoPage(driver);
        my_info.goToMyInfo();
        boolean visible = my_info.VerifyPersonalDetails();
        Assert.assertTrue(visible, "My Info Section is not visible");
        System.out.println("✔ My Info Section was visible and test passed!");
    }
    @Test
    public void VerifyOrangeLogo() {
        boolean visible = loginPage.isLogoDisplayed();
        Assert.assertTrue(visible, "Logo is displayed");
        System.out.println("Logo Displayed successfully as expected");
        loginPage.testLogin("Admin", "admin123");

    }
    @Test
    public void Myinfo_Edit() {
        loginPage.testLogin("Admin", "admin123");
        My_infoPage  my_info = new My_infoPage(driver);
        my_info.goToMyInfo();
        my_info.setEmployeName();

    }



    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
