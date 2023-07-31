package selenium;

import org.checkerframework.framework.qual.DefaultQualifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
//treba da ostaenemo na login page i da dobijrmo poruku

public class SeleniumLockOutUser {
    //ocekivano ponasanje je da ostanemo na login stranici, ocekujemo login url i poruka error
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.clear();
        inputUserName.sendKeys("locked_out_user");
        inputUserName.clear();

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();
        //String currentUrl = driver.getCurrentUrl();

        List<WebElement>cartList=driver.findElements(By.id(("shopping_cart_container")));
        if(cartList.size()==0){//ovde proveravamo da li smo prosli dalje od login page
        WebElement h3 = driver.findElement(By.xpath("//h3[@data-test='error']"));

       System.out.println(h3.getText());
        if (h3.getText().equals("Epic sadface: Sorry, this user has been locked out.")) {
            System.out.println("Test je prosao, error message");

        }else{
            System.out.println("test je pao, poruka koju smo dobili nije ocekivana");
        }
            } else {
                System.out.println("Test je pao, prosli smo login page");
            }

            driver.quit();
        }
    }

