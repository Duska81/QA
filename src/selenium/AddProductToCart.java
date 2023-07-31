package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class AddProductToCart {
    public static void main(String[] args) {
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
        AddProductToCart addProductToCart = new AddProductToCart();
        List<String> lista = new ArrayList<>();
        lista.add("Sauce Labs Bolt T-Shirt");
        lista.add("Sauce Labs Backpack");
        lista.add("Sauce Labs Bike Light");
        lista.add("Sauce Labs Onesie");

        AddProduct addProduct = new AddProduct();
        Integer before = addProduct.returnItemNumber(driver);
        addProductToCart.addProductToCartByList(driver, lista);
        Integer after = addProduct.returnItemNumber(driver);

        if (after == before + lista.size()) {
            System.out.println("passed");

        } else {
            System.out.println("failed");
        }
        //  driver.quit();
    }

    public void addProductToCartByList(ChromeDriver driver, List<String> lista) {
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));
        for (int i = 0; i < inventoryItems.size(); i++) {
            WebElement inventoryItem = inventoryItems.get(i);
            WebElement inventoryItemName = inventoryItem.findElement(By.className("inventory_item_name"));
            String itemName = inventoryItemName.getText();
            for (int j = 0; j < lista.size(); j++) {
                String productName = lista.get(j);
                if (itemName.equals(productName)) {
                    WebElement addToCartButton = inventoryItem.findElement(By.xpath(".//button"));
                    addToCartButton.click();

                    //System.out.println(itemName.equals(productName)+" = "+productName);

                    break;
                }

            }
        }
    }
}
