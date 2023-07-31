package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.AddProduct;
import selenium.ProductList;

import java.util.ArrayList;
import java.util.List;

public class Products {
    public static void main(String[] args) {
        //dodavanje liste proizvoda u korpu
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.clear();
        inputUserName.sendKeys("standard_user");
        inputUserName.clear();

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        ProductList productList = new ProductList();
        List<String> products = new ArrayList<>();
        products.add("Sauce Labs Bolt T-Shirt");
        products.add("Sauce Labs Backpack");


        AddProduct product = new AddProduct();

        productList.addProductToCartByList(driver, products);

    }


    public void addProductsToCart(ChromeDriver driver, List<String> products) {
        for (int i = 0; i < products.size(); i++) {//prolazimo kroz listu, ponavlja se onoliko puta koliko ima elemenata,spoljasnja petlja
            WebElement inventoryList = driver.findElement(By.className("inventory_list"));
            List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));
            for (int j = 0; j < inventoryItems.size(); j++) {//ova petlja prolazi kroz elemente na stranici,
                // vrti se min.jednom ako nadje
                //element na prvom mestu, a max 6 puta posto toliko ima proizvoda na stranici tj.web elemenata
                WebElement inventoryItemName = inventoryItems.get(j).findElement(By.className("inventory_item_name"));
                String inventoryName = inventoryItemName.getText();
                if (inventoryName.equals(products.get(i))) {
                    // dodajemo element
                    inventoryItems.get(j).findElement(By.xpath(".//button")).click();

                    break;
                }
            }
        }
    }
}


