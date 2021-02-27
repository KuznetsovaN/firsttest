package steps;
import java.util.Properties;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestProperties;

import java.util.concurrent.TimeUnit;

public class SberBaseSteps {

    public static WebDriver getDriver(){
        return driver;
    }
    protected static WebDriver driver;
    protected static String sberUrl;
    // переменная для считывания properties
    public static Properties properties = TestProperties.getInstance().getProperties();


    //@BeforeClass заменяем аннотацию Junit на аннотацию CUCUMBER, потому что с аннотацией Junit CUCUMBER не может работать
    @Before("@1")
    public static void SetUp() throws Exception {
        // из файла properties считываем переменную browser для уточнения, какой использовать браузер
        switch (properties.getProperty("browser")) {
            case "firefox":
                // устанавливаем путь к драйверу в системных свойствах и определяем переменную драйвера
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                // устанавливаем путь к драйверу в системных свойствах и определяем переменную драйвера
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                // устанавливаем путь к драйверу в системных свойствах и определяем переменную драйвера
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }

        // записываем значения в переменные ссылок
        sberUrl = properties.getProperty("sber.url");
        System.out.println("Ссылка на вебстраницу для тестов СберСтрах " + sberUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(sberUrl);
    }

    //@AfterClass заменяем аннотацию Junit на аннотацию CUCUMBER, потому что с аннотацией Junit CUCUMBER не может работать
    @After("@1")
    public static void tearDown() throws Exception {
        driver.quit();
    }

}
