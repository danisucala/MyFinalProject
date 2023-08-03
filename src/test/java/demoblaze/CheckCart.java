package demoblaze;
import org.openqa.selenium.Alert;
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
public class CheckCart {
    @Test
    public void checkCartTest(){
        
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.demoblaze.com/index.html";
        driver.get(url);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement phoneButton = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a"));
        phoneButton.click();

        WebElement phoneSelected = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2"));
        String phoneSelectedText = phoneSelected.getText();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"));
        addToCartButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        Assert.assertEquals(text,"Product added");
        alert.accept();

        WebElement cart = driver.findElement(By.id("cartur"));
        cart.click();

        WebElement phoneInCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tbodyid']/tr/td[2]")));
        String phoneInCartText = phoneInCart.getText();

        Assert.assertEquals(phoneSelectedText,phoneInCartText);

    }
}