package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class RemoveProductFromCart {


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


        ProductList productList = new ProductList();
        List<String> lista = new ArrayList<>();
        lista.add("Sauce Labs Bolt T-Shirt");
        lista.add("Sauce Labs Backpack");
        lista.add("Sauce Labs Bike Light");
        lista.add("Sauce Labs Onesie");

        RemoveProductFromCart removeProductFromCart = new RemoveProductFromCart();
        String productToRemove = "Sauce Labs Bolt T-Shirt";

        AddProduct addProduct = new AddProduct();
        Integer before = addProduct.returnItemNumber(driver);
        productList.addProductToCartByList(driver, lista);
        Integer after = addProduct.returnItemNumber(driver);

        if (after == before + lista.size()) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        removeProductFromCart.removeProductFromCart(driver, productToRemove);
        Integer afterRemove = addProduct.returnItemNumber(driver);
        if (afterRemove == after - 1) {
            System.out.println("prosao");
        } else {
            System.out.println("pao");
        }

            //driver.quit(); zakomentarisala sam da mi se ne bi automatski zatvorila stranica u chromu

        }



        //pomocu 2 for petlje uporedjujemo proizvode na stranici sa proizvodima na listi


    public void removeProductFromCart(ChromeDriver driver, String productName) {
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));
        for (int i = 0; i < inventoryItems.size(); i++) {
            WebElement inventoryItem = inventoryItems.get(i);
            WebElement inventoryItemName = inventoryItem.findElement(By.className("inventory_item_name"));
            String itemName = inventoryItemName.getText();
            if (itemName.equals(productName)) {
                WebElement removeButton = inventoryItem.findElement(By.xpath(".//button"));
                removeButton.click();
                break;
                }
            }
    }
}


