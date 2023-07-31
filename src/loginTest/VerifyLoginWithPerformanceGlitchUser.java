package loginTest;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class VerifyLoginWithPerformanceGlitchUser {

        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("performance_glitch_user", "secret_sauce");

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
                System.out.println("test je prosao, ulogovali smo se, iako sporije, i dobili inventory page");
            } else {
                System.out.println("Test je pao");
            }
        }
    }


