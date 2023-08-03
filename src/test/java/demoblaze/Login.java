package demoblaze;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class Login {
    @Test
    public void loginTest(){

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.demoblaze.com/index.html";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement loginInput = driver.findElement(By.id("login2"));
        loginInput.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement usernameInput = driver.findElement(By.id("loginusername"));
        usernameInput.sendKeys("admin");

        WebElement passwordInput = driver.findElement(By.id("loginpassword"));
        passwordInput.sendKeys("admin");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement welcomeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nameofuser")));
        Assert.assertTrue(welcomeButton.isDisplayed());


    }
}