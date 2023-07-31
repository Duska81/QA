package Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductsTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        //umesto da pisemo
        // WebElement inputUserName = driver.findElement(By.id("user-name"));
        //        inputUserName.clear();
        //        inputUserName.sendKeys("standard_user");
        //        inputUserName.clear();
        //
        //        WebElement inputPassword = driver.findElement(By.id("password"));
        //        inputPassword.sendKeys("secret_sauce");
        //
        //        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        //        buttonLogin.click();

        LoginPage loginPage=new LoginPage(driver);//kreiramo objekat
        //ovde konstruktor ne moze biti prazan, i nakon toga zovemo metodu
        //driver u zagradi: interakcija sa html
        loginPage.login("standard-user", "secret_sauce");

        Products productsPage=new Products();







        List<String> products = new ArrayList<>();
        products.add("Sauce Labs Bolt T-Shirt");
        products.add("Sauce Labs Backpack");
        productsPage.addProductsToCart(driver, products);


    }
}