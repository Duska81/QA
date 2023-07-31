package Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class VerifySortingProductByName {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard-user", "secret_sauce");

        ProductsPage productPage=new ProductsPage(driver);
        productPage.sortProductByName("Name (Z to A)");
        System.out.println("sortiranje");
    }
}

