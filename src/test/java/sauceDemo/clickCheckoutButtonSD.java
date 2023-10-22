package sauceDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class clickCheckoutButtonSD {
    @Test
    public void positive_test_checkout_with_items(){
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
        //klik icon cart di pojok kanan atas
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();
        //redirect ke halaman keranjang, cek apakah item ada di keranjang
        String productsInCart = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(productsInCart,"Sauce Labs Backpack");

        //jika sudah dicek bahwa ada item di keranjang, klik button checkout
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
        //redirect ke halaman input informasi, flow sudah benar
        String inputInformation = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(inputInformation, "Checkout: Your Information");

        driver.quit();
    }

    @Test
    public void negative_test_checkout_without_items(){
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

        //tanpa pilih produk, klik icon cart di pojok kanan atas
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();
        //dalam kondisi keranjang kosong, langsung klik checkout
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
        //SEHARUSNYA muncul warning message "gagal" namun di saucedemo belum dilengkapi respons ini
        String errorLoginCheckout = driver.findElement(By.xpath("//*[@id='header_container']")).getText();
        Assert.assertEquals(errorLoginCheckout, "Epic sadface: You can not checkout without items!");

        driver.quit();
    }

}
