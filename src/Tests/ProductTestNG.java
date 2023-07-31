package Tests;

import models.Product;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.ArrayList;
import java.util.List;

public class ProductTestNG extends BaseTest {
    @BeforeClass
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        super.driver = new ChromeDriver();

    }

    @AfterClass
    public void driverClose() {
        super.driver.quit();
    }

    @Test
    public void verifyAddProductToCart() {
        // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productPage = new ProductsPage(driver);
        Integer beforeAdd = productPage.returnItemNumber(driver);
        productPage.addProductToCartByName("Sauce Labs Bolt T-Shirt");

        Integer afterAdd = productPage.returnItemNumber(driver);
        //pomocu assert vrsimo poredjenje,


        Assert.assertEquals(afterAdd, beforeAdd + 1, "Product number is not equals");
        //assert umesto redova dole

        /*if(afterAdd==beforeAdd+1){
            System.out.println("test passed");



        }else{
            System.out.println("test failed");
            driver.quit();
        }*/

        driver.quit();
    }


    @Test
    public void verifySortingProductByPriceHighToLow() {

        //System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");


        ProductsPage productPage = new ProductsPage(driver);
        productPage.sortProductByPrice("Price (high to low)");

        List<Double> productsPrice = productPage.returnProductsPrice();
        Assert.assertEquals(productPage.priceSortingFromHighToLow(productsPrice), "Redosled je kako smo i ocekivali", "Redosled nije dobar");
        //System.out.println(productPage.priceSortingFromHighToLow(productsPrice));

        List<Double> productsPriceBoolean = productPage.returnProductsPrice();
        // Assert.assertEquals(productPage.priceSortingFromHighToLowBoolean(productsPriceBoolean), true, "redosled nie dobar");


        System.out.println(productPage.priceSortingFromHighToLowBoolean(productsPriceBoolean));

        driver.quit();

    }

    @Test
    public void verifySortingProductByPriceLowToHigh() {
        // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");


        ProductsPage productPage = new ProductsPage(driver);
        productPage.sortProductByPrice("Price (low to high)");

        List<Double> productsPrice = productPage.returnProductsPrice();
        Assert.assertEquals(productPage.priceSortingFromLowToHigh(productsPrice), "Redosled je OK", "Redosled nije dobar");
        //System.out.println(productPage.priceSortingFromLowToHigh(productsPrice));


        driver.quit();

    }

    @Test
    public void verifyProductInCart() {
        // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        //ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        List<String> itemsToBeAdded = new ArrayList<>();//lista elemenata koje dodajemo
        itemsToBeAdded.add("Sauce Labs Backpack");
        itemsToBeAdded.add("Sauce Labs Bike Light");

        ProductsPage productsPage = new ProductsPage(driver);
        for (int i = 0; i < itemsToBeAdded.size(); i++) {
            productsPage.addProductToCartByName(itemsToBeAdded.get(i));
        }
        //poredimo listu koju smo napravili i listu koja je na sajtu


        productsPage.openCart();
        CartPage cartPage = new CartPage(driver);
        List<String> cartItems = cartPage.itemsInCart();

        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.contains(itemsToBeAdded.get(i))) {
                System.out.println("item " + itemsToBeAdded.get(i) + " is  added to cart");

            } else {

                System.out.println("item " + itemsToBeAdded.get(i) + " is not added to cart");
            }
        }
    }
    //prethodni primer sa vestacki napravljenom listom, necemo citati sa stranice

    @Test
    public void verifyProductInCart1() {
        // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        List<String> itemsToBeAdded1 = new ArrayList<>();//lista elemenata koje dodajemo
        itemsToBeAdded1.add("Sauce Labs Backpack");
        itemsToBeAdded1.add("Sauce Labs Bike Light");

        ProductsPage productsPage = new ProductsPage(driver);
        for (int i = 0; i < itemsToBeAdded1.size(); i++) {
            productsPage.addProductToCartByName(itemsToBeAdded1.get(i));
        }


        productsPage.openCart();
        CartPage cartPage = new CartPage(driver);
        List<String> cartItems = new ArrayList<>();
        //prvi element je dodat a drugog nema u listi

        // ako ovo ispod zakontarisemo, vidimo kako je kad, treba da loguje da oba elementa nisu dodata
        cartItems.add("Sauce Labs Backpack");

        for (int i = 0; i < itemsToBeAdded1.size(); i++) {
            String itemToBeAdded = itemsToBeAdded1.get(i);
            if (cartItems.contains(itemToBeAdded)) {
                System.out.println("Item " + itemToBeAdded + " is added to cart");
            } else {
                System.out.println("Item " + itemToBeAdded + " is not added to cart");

            }
        }
    }

    // proveravamo da li moze da se doda isti element doda 2 puta to proveravamo u drugoj for petlji
    @Test
    public void verifyProductInCart2() {
        // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        List<String> itemsToBeAdded2 = new ArrayList<>();//lista elemenata koje dodajemo
        itemsToBeAdded2.add("Sauce Labs Backpack");
        itemsToBeAdded2.add("Sauce Labs Bike Light");

        ProductsPage productsPage = new ProductsPage(driver);
        for (int i = 0; i < itemsToBeAdded2.size(); i++) {
            productsPage.addProductToCartByName(itemsToBeAdded2.get(i));
        }
        //moramo proveriti duzinu liste sa 196 i 209, ukoliko nisu iste postoji bug


        productsPage.openCart();
        CartPage cartPage = new CartPage(driver);
        List<String> cartItems = new ArrayList<>();
        //ukoliko duzina ove dve liste nije ista ovaj test pada
        //Assert.assertEquals(cartItems.size(),itemsToBeAdded2.size(),"Some items is not added or add more then once");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cartItems.size(), itemsToBeAdded2.size(), "Some items is not added or add more then once");

        //ukoliko su te dve liste iste mi nismo sigurni da su pravi itemi dodati
        //umesto dole zakomntarisanog if-a koristimo asertaciju

        for (int i = 0; i < itemsToBeAdded2.size(); i++) {
            softAssert.assertEquals(cartItems.contains(itemsToBeAdded2.get(i)), true, itemsToBeAdded2 + " is not added to cart");

            //posto je prvi assert pao on nie proveravao dalje, pa koristimo soft assert
            /*if (cartItems.contains(itemToBeAdded)) {
                System.out.println("Item " + itemsToBeAdded2 + " is added to cart");
            } else {
                System.out.println("Item " + itemsToBeAdded2 + " is not added to cart");

            }*/
        }
        softAssert.assertAll();


        // ako ovo ispod zakontarisemo, vidimo kako je kad, treba da loguje da oba elementa nisu dodata
        // cartItems.add("Sauce Labs Backpack");
        if (cartItems.size() == itemsToBeAdded2.size()) {// ovde se proverava

            for (int i = 0; i < itemsToBeAdded2.size(); i++) {
                String itemToBeAdded = itemsToBeAdded2.get(i);
                if (cartItems.contains(itemToBeAdded)) {
                    System.out.println("Item " + itemsToBeAdded2 + " is added to cart");
                } else {
                    System.out.println("Item " + itemsToBeAdded2 + " is not added to cart");

                }
            }

        } else {
            System.out.println("Some items is not added or add more then once");
        }
    }

    @Test
    public void returnProduct() {
        // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        List<String> products = new ArrayList<>();//lista elemenata koje dodajemo

        ProductsPage productsPage = new ProductsPage(driver);

        for (int i = 0; i < products.size(); i++) {
            productsPage.addProductToCartByName(products.get(i));
        }

        List<Product> productList = productsPage.returnProducts();
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            System.out.println("Product: " + product.getName() + ", Price: $" + product.getPrice());
        }
    }

    @Test
    public void duplicate() {
        // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        List<String> itemsToBeAdded = new ArrayList<>();//lista elemenata koje dodajemo

        ProductsPage productsPage = new ProductsPage(driver);
        itemsToBeAdded.add("Sauce Labs Bike Light");
        itemsToBeAdded.add("Sauce Labs Backpack");

        for (int i = 0; i < itemsToBeAdded.size(); i++) {
            productsPage.addProductToCartByName(itemsToBeAdded.get(i));
        }

       /* List<Product> productList = productsPage.returnProducts();
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            System.out.println("Product: " + product.getName() + ", Price: $" + product.getPrice());

        }*/
        productsPage.returnProducts();
        productsPage.openCart();
        CartPage cartPage = new CartPage();
        List<String> cartItems = new ArrayList<>();
        cartItems.add("Sauce Labs Backpack");
        cartItems.add("Sauce Labs Backpack");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cartItems.size(), itemsToBeAdded.size(), "Some items are not add or more then once add");
        int count=0;
        for (int i = 0; i < itemsToBeAdded.size(); i++) {
            for (int j = 0; j < cartItems.size(); j++) {
                if(itemsToBeAdded.get(i).equals(cartItems.get(j))){
                    count++;
                    if(count>1){
                        System.out.println("duplikat");

                    }

                }
                break;
                    //mozemo koristiti if i break ili ih zakomentarisemo i da dole izmenimo soft.assert na 328 u
                   // softAssert.assertEquals(count, 1, "error " + itemsToBeAdded.get(i) + " je duplikat");



            }
                softAssert.assertEquals(cartItems.get(i), itemsToBeAdded.get(i), "error " + cartItems.get(i) + " je duplikat");
            }
            softAssert.assertAll();

    }



}





