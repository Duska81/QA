package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCartByName(String product) {
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));
        for (int i = 0; i < inventoryItems.size(); i++) {
            WebElement inventoryItemName = inventoryItems.get(i).findElement(By.className("inventory_item_name"));
            if (inventoryItemName.getText().equals(product)) {
                WebElement addToCartButton = inventoryItems.get(i).findElement(By.xpath(".//button"));
                addToCartButton.click();
                break;
            }
        }
    }

    public void addProductsToCart(List<String> products) {
        for (int i = 0; i < products.size(); i++) {
            WebElement inventoryList = driver.findElement(By.className("inventory_list"));
            List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));
            for (int j = 0; j < inventoryItems.size(); j++) {
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

    public Integer returnItemNumber(ChromeDriver driver) {
        Integer toReturn = null;
        WebElement linkShoppingCart = driver.findElement(By.className("shopping_cart_link"));
        List<WebElement> spanItemNumber = linkShoppingCart.findElements(By.className("shopping_cart_badge"));
        if (spanItemNumber.size() == 0) {
            toReturn = 0;

        } else {
            toReturn = Integer.parseInt(spanItemNumber.get(0).getText());

        }
        return toReturn;

    }

    public void removeProductFromCart(String product) {

    }

    public void removeProductsFromCart(List<String> product) {

    }

    public void sortProductByName(String sorting) {
        WebElement productSortContainer = driver.findElement(By.className("product_sort_container"));
        productSortContainer.click();

        if (sorting.equals("Name (A to Z)")) {
            productSortContainer.findElements(By.xpath(".//option")).get(0).click();
        } else if (sorting.equals("Name (Z to A)")) {
            productSortContainer.findElements(By.xpath(".//option")).get(1).click();
        }


    }

    public void sortProductByPrice(String price) {


        WebElement productSortContainer = driver.findElement(By.className("product_sort_container"));
        productSortContainer.click();

        if (price.equals("Price (low to high)")) {
            productSortContainer.findElements(By.xpath(".//option")).get(2).click();
        } else if (price.equals("Price (high to low)")) {
            productSortContainer.findElements(By.xpath(".//option")).get(3).click();
        }
    }

    //metoda koja vraca imena produkata sa stranice
    public List<String> returnProductsName() {
        List<String> lista = new ArrayList<>();
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));
        for (int i = 0; i < inventoryItems.size(); i++) {
            lista.add(inventoryItems.get(i).findElement(By.className("inventory_item_name")).getText());
        }
        return lista;
    }


    //posto na vise mesta kosristimo izvlacimo u posebnu klasu metodu koja vraca web element
    public WebElement returnItemList() {

        return driver.findElement(By.className("inventory_list"));
    }

    //posto nam se cesto ponavla find elements za InventoryItem mozemo i to posebno izvuci u metodu
    public List<WebElement> returnInventoryItems() {
        WebElement inventoryList = returnItemList();
        return inventoryList.findElements(By.className("inventory_item"));
    }

    public List<Double> returnProductsPrice() {
        List<Double> list = new ArrayList<>();

        // izvukli smo metodu koja se ceto ponavla pa je pozivamo

        //WebElement inventoryList=returnItemList();
        //List<WebElement> inventoryItem = driver.findElements(By.className("inventory_item"));
        //gere dve linije koda mozemo zameniti sa sledecim
        List<WebElement> inventoryItems = returnInventoryItems();


        for (int i = 0; i < inventoryItems.size(); i++) {
            WebElement itemPrice = inventoryItems.get(i).findElement(By.className("inventory_item_price"));
            String price = itemPrice.getText();
            list.add(Double.parseDouble(price.substring(1)));//stavlamo substring posto ne moze da prevede string
            //u doble zbog znak dolar, ovo znaci da krecemo od 1 elementa

        }

        return list;
    }

    public String priceSortingFromLowToHigh(List<Double> prices) {
        String message = null;
        for (int i = 0; i < prices.size() - 1; i++) {


            int j = i + 1;
            if (prices.get(i) <= prices.get(j)) {
                message = "Redosled je OK";


            } else {
                message = "Redosled nije dobar";
                break;
            }

        }
        return message;
    }


    public String priceSortingFromHighToLow(List<Double> prices) {
        String message = null;
        for (int i = 0; i < prices.size() - 1; i++) {


            int j = i + 1;
            if (prices.get(i) >= prices.get(j)) {
                message = "Redosled je kako smo i ocekivali";


            } else {
                message = "Redosled nije dobar";
                break;
            }

        }
        return message;
    }
    public boolean priceSortingFromHighToLowBoolean(List<Double> pricesBoolean){
        boolean message = true;
        for (int i = 0; i < pricesBoolean.size() - 1; i++) {


            int j = i + 1;
            if (pricesBoolean.get(i) < pricesBoolean.get(j)) {
                message = false;
                break;
            }
        }
        return message;
    }
    public void openCart(){
        WebElement cart= driver.findElement(By.className("shopping_cart_link"));
        cart.click();

    }
    //pravimo metodu gde vracamo proizvode i cenu u jednom


    public List<Product> returnProducts() {
        List<Product> lista = new ArrayList<>();

        WebElement inventoryList = returnItemList();

        List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));

        for (int i = 0; i < inventoryItems.size(); i++) {

            WebElement itemName = inventoryItems.get(i).findElement(By.className("inventory_item_name"));
            String name = itemName.getText();

            WebElement itemPrice = inventoryItems.get(i).findElement(By.className("inventory_item_price"));
            double price = Double.parseDouble(itemPrice.getText().substring(1));

            Product product = new Product(name,price);
            lista.add(product);
        }

        return lista;
    }

    }


