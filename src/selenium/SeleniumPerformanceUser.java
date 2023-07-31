package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumPerformanceUser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.clear();
        inputUserName.sendKeys("performance_glitch_user");
        inputUserName.clear();

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();
        //implicitni wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       // WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
       // wait.until(ExpectedConditions.titleIs("Swag Labs"));


        List<WebElement> menu = driver.findElements(By.id("shopping_cart_container"));
        //posto je duration 1 sekunda, on odmah presao da da trazi
        //na sladecoj stranici korpu, a je zato test pao
        //ako povecamo time na 30 sekundi( linija 29) test je prosao

        if (menu.size() == 1) {
            System.out.println("nadjena korpa na stranici, test je prosao");
        } else {
            System.out.println("test je pao");


            driver.quit();
    }
}
    }
