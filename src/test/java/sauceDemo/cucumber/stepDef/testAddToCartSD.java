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

import java.util.concurrent.TimeUnit;

public class testAddToCartSD {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com";

    @Given("User login with valid credentials")
    public void user_login_with_valid_credentials() {
        WebDriverManager.chromedriver().setup();

        // apply chrome driver set up
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseurl);
        //Assertion
        Assert.assertEquals("Swag Labs", driver.getTitle());

        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //buka halaman login
        //input email
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click login
        driver.findElement(By.id("login-button")).click();
    }

    @And("User redirected in the main page")
    public void user_redirected_in_the_main_page() {
        //Assert label products di homepage
        String labelProducts = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(labelProducts, "Products");
    }

    @When("User click add to cart button")
    public void user_click_add_to_cart_button() {
        //cari salah satu produk lalu klik add to cart
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @Then("The cart badge popped up icon number")
    public void the_cart_badge_popped_up_icon_number() {
        //cari ikon keranjang, cek angka di ikon
        String numberOfProducts = driver.findElement(By.className("shopping_cart_badge")).getText();
        //jika klik satu kali, maka harusnya muncul angka satu
        Assert.assertEquals(numberOfProducts,"1");
        driver.quit();
    }
}
