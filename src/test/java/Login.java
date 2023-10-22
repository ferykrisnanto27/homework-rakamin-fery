import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login {
    @Test
    public void signIn(){
        WebDriver driver;
        String baseurl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

    // apply chrome driver set up
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseurl);
     //   String title = driver.getTitle();
        //   System.out.println(title);

    // input email
      driver.findElement(By.id("Username")).sendKeys("standard_user");
    // input password
        driver.findElement(By.id("Password")).sendKeys("secret_sauce");
    // click login
        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }
}
