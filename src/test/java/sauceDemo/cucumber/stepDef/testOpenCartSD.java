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

public class testOpenCartSD {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com";


    @Given("User open the website")
    public void user_open_the_website() {
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

    @And("User login with registered username and password")
    public void user_login_with_registered_username_and_password() {
        //Assert label products di homepage
        String labelProducts = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(labelProducts, "Products");
    }

    @When("User click cart button")
    public void user_click_cart_button() {
        //klik icon cart di pojok kanan atas
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();
    }


    @Then("User redirected to cart page")
    public void user_redirected_to_cart_page() {
        //redirect ke halaman keranjang, cek ada tulisan "Your Cart"
        String checkCartPage = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(checkCartPage,"Your Cart");

        driver.quit();
    }
}
