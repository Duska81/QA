package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumVezba {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement inputUserName = driver.findElement(By.xpath("//input[@data-test='username']"));
        inputUserName.clear();
        inputUserName.sendKeys("locked_out_user");
        inputUserName.clear();

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        WebElement h3 = driver.findElement(By.xpath("//h3[@data-test='error']"));
        //ovde proveravamo 2 uslova


        List<WebElement> cartList = driver.findElements(By.id(("shopping_cart_container")));
        if (cartList.size() == 0 && h3.getText().equals("Epic sadface: Sorry, this user has been locked out.")) {
            System.out.println("test je prosao");

        }else if(cartList.size()>0){

            System.out.println("test failed, prosli smo login stranu");
        } else if (!h3.getText().equals("Epic sadface: Sorry, this user has been locked out.")) {
            System.out.println("test failes, nije ista poruka");
            
        }

        driver.quit();
    }
}