package Tests;

import data.BuzzBrandsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BuzzBrandsPage;
import pages.BuzzMainPage;
import pages.ManCornerPage;
import pages.ObucaMuskarci;


import java.util.ArrayList;
import java.util.List;


public class BuzzBrandsTest {
    private WebDriver driver;

    @BeforeClass
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void verifyAllBrandsExists() {
        // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        //ChromeDriver driver=new ChromeDriver();
        //jedan nacin je da rucno dodamo brendove
        //List<String>expectedBrands=new ArrayList<>();
        //expectedBrands.add("NIKE");
        //expectedBrands.add("Addidas");
        //drugi nacin je da kreiramo paket data i tu dodamo brendove koje onda samo pozivamo
        List<String> expectedBrands = BuzzBrandsData.returnListBrands();

        driver.get("https://www.buzzsneakers.rs/");
        driver.manage().window().maximize();

        BuzzMainPage buzzMainPage = new BuzzMainPage(driver);
        buzzMainPage.openBrands();
        BuzzBrandsPage brandsPage = new BuzzBrandsPage(driver);
        List<String> actualBrands = brandsPage.returnAllBrands();

        //poredimo dve liste, prolazimo kroz expected i proveravamo da li se elementi nalaze u actual
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < expectedBrands.size(); i++) {
            softAssert.assertTrue(actualBrands.contains(expectedBrands.get(i)), expectedBrands.get(i) + " is not found on page");
            if (!actualBrands.contains(expectedBrands.get(i))) {
                System.out.println("Brand " + expectedBrands.get(i) + " is not found on page");
            }
        }
        softAssert.assertAll();
    }

    @Test
    public void verifyOpenChild() {
        driver.get("https://www.buzzsneakers.rs/");
        driver.manage().window().maximize();
        BuzzMainPage buzzMainPage = new BuzzMainPage(driver);
        buzzMainPage.openChild();
        WebElement proizvodi = driver.findElement(By.className("product-listing-items"));
        List<WebElement> proizvodItem = proizvodi.findElements(By.className("product-item"));

            boolean isElementPresent = driver.findElements(By.xpath("//div[@class='item sel-filter' and @nb-value='kids']")).size() > 0;

            Assert.assertTrue(isElementPresent, "Element sa klasom 'item sel-filter' i atributom 'nb-value' sa vrednošću 'kids' nije pronađen na stranici.");

    }


    @Test
    public void verifyOpenZene() {
        driver.get("https://www.buzzsneakers.rs/");
        driver.manage().window().maximize();
        BuzzMainPage buzzMainPage = new BuzzMainPage(driver);
        buzzMainPage.openWomans();

        SoftAssert softAssert = new SoftAssert();
        boolean isElementPresent = driver.findElements(By.linkText("POGLEDAJ PONUDU")).size() > 0;

        softAssert.assertTrue(isElementPresent, "Element sa link tekstom 'POGLEDAJ PONUDU' nije pronađen na stranici.");

        softAssert.assertAll();

    }
    @Test
    public void verifySortNajjeftinije(){
        driver.get("https://www.buzzsneakers.rs/");
        driver.manage().window().maximize();
        BuzzMainPage buzzMainPage = new BuzzMainPage(driver);
        buzzMainPage.openMans();

        ManCornerPage manCornerPage=new ManCornerPage(driver);
        //manCornerPage.openObuca();

        ObucaMuskarci obucaMuskarci=new ObucaMuskarci(driver);
        obucaMuskarci.sortBy("Najjeftinije prvo");
        obucaMuskarci.returnAllPrices();


    }
}


