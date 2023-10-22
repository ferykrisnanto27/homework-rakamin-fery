package sauceDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginSD {
    @Test
    public void success_login_case(){
        WebDriver driver;
        String baseurl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        // apply chrome driver set up
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseurl);

        //assertion cek berhasil ke baseurl
        Assert.assertEquals("Swag Labs", driver.getTitle());

        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //buka halaman login
        //input email
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click login
        driver.findElement(By.id("login-button")).click();

        //Assert label products di homapage
        //String labelProducts = driver.findElement(By.xpath("//*[@id='header_container']")).getText();
        String labelProducts = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(labelProducts, "Products");



    }

    @Test
    public void failed_login_case(){
        WebDriver driver;
        String baseurl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        // apply chrome driver set up
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseurl);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //buka halaman login
        //input email
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input password
        driver.findElement(By.id("password")).sendKeys("1234qwerty");
        //click login
        driver.findElement(By.id("login-button")).click();

        //assertion cek error login
        String errorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");


    }

}
