package Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class VerifyAddProductToCart {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard-user", "secret_sauce");

        ProductsPage productPage=new ProductsPage(driver);
        Integer beforeAdd=productPage.returnItemNumber(driver);
        productPage.addProductToCartByName("Sauce Labs Bolt T-Shirt");

        Integer afterAdd=productPage.returnItemNumber(driver);

        if(afterAdd==beforeAdd+1){
            System.out.println("test passed");



        }else{
            System.out.println("test failed");
        }
    }
}
