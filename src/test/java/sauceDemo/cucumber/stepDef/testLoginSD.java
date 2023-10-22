package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class testLoginSD {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("User launch the website")
    public void user_launch_the_website() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseurl);
        //Assertion
        Assert.assertEquals("Swag Labs", driver.getTitle());
    }

    @And("User input registered username")
    public void user_input_registered_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User input valid password")
    public void user_input_valid_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("User click login button")
    public void user_click_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("Screen redirected to main page")
    public void screen_redirected_to_main_page() {
        String labelProducts = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(labelProducts, "Products");
        driver.quit();
    }

    @And("User input wrong password")
    public void user_input_wrong_password() {
        driver.findElement(By.id("password")).sendKeys("1234qwerty");
    }

    @Then("Error message showed up")
    public void error_message_showed_up() {
        String errorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.quit();
    }
}
