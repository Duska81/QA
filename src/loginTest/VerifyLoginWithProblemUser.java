package loginTest;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class VerifyLoginWithProblemUser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("problem_user", "secret_sauce");

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("test je prosao, ulogovali smo se i dobili proizvode sa identicnim slikama");
        } else {
            System.out.println("Test je pao");
        }
    }
    }

