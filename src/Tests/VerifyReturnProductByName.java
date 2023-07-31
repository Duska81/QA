package Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.List;

public class VerifyReturnProductByName {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productPage = new ProductsPage(driver);
        List<String> listaProizvoda = productPage.returnProductsName();
        for (int i = 0; i < listaProizvoda.size(); i++) {
            String proizvod = listaProizvoda.get(i);
            System.out.println(proizvod);
        }





        productPage.returnProductsName();
        //driver.quit();

    }
    }

