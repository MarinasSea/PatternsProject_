import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    @BeforeClass
    public void initBrowser() {

        WebDriverManager.chromedriver().arch64().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("start-maximized");
        opt.addArguments("incognito");
        opt.addArguments("disable-notifications");

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void close(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

    public void openRztka(){

        driver.get("https://rozetka.com.ua/ua/");
    }
}
