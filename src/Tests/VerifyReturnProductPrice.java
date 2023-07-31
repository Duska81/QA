package Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.List;

public class VerifyReturnProductPrice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productPage = new ProductsPage(driver);
        List<Double> productsPrice = productPage.returnProductsPrice();
        System.out.println(productsPrice);
    }

    }

