package Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.List;


public class VerifySortingProductByPriceHighToLow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");


        ProductsPage productPage = new ProductsPage(driver);
        productPage.sortProductByPrice("Price (high to low)");

        List<Double> productsPrice=productPage.returnProductsPrice();
        System.out.println(productPage.priceSortingFromHighToLow(productsPrice));

        List<Double> productsPriceBoolean=productPage.returnProductsPrice();
        System.out.println(productPage.priceSortingFromHighToLowBoolean(productsPriceBoolean));
        Assert.assertTrue(productPage.priceSortingFromHighToLowBoolean(productsPriceBoolean), "redosled nije ocekivan");

        //driver.quit();
    }
}


