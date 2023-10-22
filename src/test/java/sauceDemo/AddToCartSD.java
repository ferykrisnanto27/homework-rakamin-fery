package sauceDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddToCartSD {
    @Test
    public void success_add_to_cart(){
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

        //cari salah satu produk lalu klik add to cart
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
        //cari ikon keranjang, cek angka di ikon
        String numberOfProducts = driver.findElement(By.className("shopping_cart_badge")).getText();
        //jika klik satu kali, maka harusnya muncul angka satu
        Assert.assertEquals(numberOfProducts,"1");

        driver.quit();
    }

}
