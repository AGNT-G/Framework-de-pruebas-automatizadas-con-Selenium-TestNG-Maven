package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Utils.Data_Reader;
import java.time.Duration;
import java.util.Objects;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import pages.New_Login;
import pages.saucedemo_login;
public class New_Login_Cases {
    WebDriver driver;
    saucedemo_login newlogin;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        newlogin = new saucedemo_login(driver); // tu clase POM
    }
    @Test
    public void Valid_Login() {
        newlogin.saucedemo_Login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "La URL actual no contiene 'inventory.html'. URL obtenida: " + driver.getCurrentUrl());
    }
    @Test
    public void Invalid_Login(){
        newlogin.saucedemo_Login("pepito123", "hieveryone");
        String ErrorMessage = newlogin.getErrorMessage();
        System.out.println("Mensaje capturado: " + ErrorMessage);
        Assert.assertEquals(ErrorMessage, "Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void Empty_Login(){ newlogin.saucedemo_Login("", "");
        String ErrorMessage = newlogin.getErrorMessage();
        System.out.println("Mensaje capturado: " + ErrorMessage);
        Assert.assertEquals(ErrorMessage, "Epic sadface: Username is required");

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }












}