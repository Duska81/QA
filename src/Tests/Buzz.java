package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class Buzz {


    @Test
    public void verifyFilterByBrand() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.buzzsneakers.rs/");
        WebElement brendovi = driver.findElement(By.xpath("//a[@title = 'Brendovi']"));
        brendovi.click();
        WebElement puma = driver.findElement(By.xpath("//a[@title = 'PUMA']"));
        puma.click();
        WebElement proizvodi = driver.findElement(By.className("product-listing-items"));
        List<WebElement> proizvodItem = proizvodi.findElements(By.className("product-item"));
        for (int i = 0; i < proizvodItem.size(); i++) {
            if (!proizvodItem.get(i).getAttribute("data-productbrand").equals("PUMA")) {
                System.out.println("Brend nije dobar");

                driver.quit();
            }
        }
    }

    @Test
    public void verifyFilterByMensShoes() {

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.buzzsneakers.rs/");
        //prvi nacin nalazenja
        WebElement muskarci = driver.findElement(By.xpath("//a[@title='Muškarci']"));
        muskarci.click();


        List<WebElement> muskaObuca = driver.findElements(By.xpath(".//a[@title='OBUĆA']"));
        muskaObuca.get(4).click();//element obuca koji nam treba se nalazi na 5 mestu, i pristupamo mu preko indeksa


        WebElement proizvodi = driver.findElement(By.className("product-listing-items"));
        List<WebElement> proizvodItem = proizvodi.findElements(By.className("product-item"));


        for (int i = 0; i < proizvodItem.size(); i++) {
            if (!proizvodItem.get(i).getAttribute("data-productcat").equals("Patikeeeeeeee")) {
                System.out.println("Nije izabrana muska obuca");


            }
        }
        driver.quit();


    }

    @Test
    public void verifyFilterByWomenShoes() {

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.buzzsneakers.rs/");
        //prvi nacin nalazenja
        WebElement zene = driver.findElement(By.xpath("//a[@title='Žene']"));
        zene.click();


        List<WebElement> zenskaObuca = driver.findElements(By.xpath(".//a[@title='OBUĆA']"));
        zenskaObuca.get(4).click();//element obuca koji nam treba se nalazi na 5 mestu, i pristupamo mu preko indeksa


        WebElement proizvodi = driver.findElement(By.className("product-listing-items"));
        List<WebElement> proizvodItem = proizvodi.findElements(By.className("product-item"));
        SoftAssert softAssert=new SoftAssert();


        for (int i = 0; i < proizvodItem.size(); i++) {


            WebElement title = proizvodItem.get(i).findElement(By.xpath(".//div[@class='title']"));

            WebElement link=title.findElement(By.xpath(".//a"));

                System.out.println(link.getText());
               softAssert.assertEquals(proizvodItem.get(i).getAttribute("data-productcat"),"Patike",link.getText()+" nije pronadjena zenska obuca");


            softAssert.assertAll();

            }
        driver.quit();
        }



    }