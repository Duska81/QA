package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFb {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");

        WebElement inputEmail = driver.findElement(By.id("email"));

        inputEmail.sendKeys("duska981@yahoo.com");

        WebElement inputPassword = driver.findElement(By.id("pass"));
        inputPassword.sendKeys("telefon00");

        WebElement buttonLogin = driver.findElement(By.name("login"));
        buttonLogin.click();



        driver.quit();
    }
}