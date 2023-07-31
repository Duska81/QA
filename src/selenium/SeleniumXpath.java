package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumXpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement inputUserName =driver.findElement(By.xpath("//input[@id='user-name']"));
        inputUserName.clear();

        inputUserName.sendKeys("standard_user");
        inputUserName.clear();

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        inputPassword.clear();
        inputPassword.sendKeys("secret_sauce");


        WebElement buttonLogin = driver.findElement(By.xpath("//input[@id='login-button']"));
        buttonLogin.click();

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("ulogovali smo se, test je prosao");
        } else {
            System.out.println("Test je pao");
        }
        driver.quit();
    }
}