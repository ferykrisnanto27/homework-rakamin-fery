package sauceDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OpenCartSD {
    @Test
    public void success_open_cart(){
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

        //Assert label products di homepage
        String labelProducts = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(labelProducts, "Products");

        //klik icon cart di pojok kanan atas
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();
        //redirect ke halaman keranjang, cek ada tulisan "Your Cart"
        String checkCartPage = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(checkCartPage,"Your Cart");

        driver.quit();
    }

}
