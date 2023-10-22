package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testClickCheckoutButtonSD {

    WebDriver driver;
    String baseurl = "https://www.saucedemo.com";

    @Given("User already in main page")
    public void user_already_in_main_page() {
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
    }

    @And("User add items")
    public void user_add_items() {
        //cari salah satu produk lalu klik add to cart
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @And("User go to cart page")
    public void user_go_to_cart_page() {
        //klik icon cart di pojok kanan atas
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();

    }

    @And("User check items")
    public void user_check_items() {
        //redirect ke halaman keranjang, cek apakah item ada di keranjang
        String productsInCart = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(productsInCart,"Sauce Labs Backpack");
    }

    @When("User click checkout button")
    public void user_click_checkout_button() {
        //jika sudah dicek bahwa ada item di keranjang, klik button checkout
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
    }

    @Then("User redirected to fill information page")
    public void user_redirected_to_fill_information_page() {
        //redirect ke halaman input informasi, flow sudah benar
        String inputInformation = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(inputInformation, "Checkout: Your Information");

        driver.quit();
    }

    @Then("Error message in checkout page showed up")
    public void error_message_in_checkout_page_showed_up() {
        //SEHARUSNYA muncul warning message "gagal" namun di saucedemo belum dilengkapi respons ini
        String errorLoginCheckout = driver.findElement(By.xpath("//*[@id='header_container']")).getText();
        Assert.assertEquals(errorLoginCheckout, "Epic sadface: You can not checkout without items!");

        driver.quit();
    }

}
