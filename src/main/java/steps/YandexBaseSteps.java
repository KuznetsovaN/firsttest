package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class YandexBaseSteps {

    public static WebDriver getDriver() {
        return driver;
    }

    protected static WebDriver driver;
    protected static String yandexUrl;

    // переменная для считывания properties
    public static Properties properties = TestProperties.getInstance().getProperties();

    //@BeforeClass заменяем аннотацию Junit на аннотацию CUCUMBER, потому что с аннотацией Junit CUCUMBER не может работать
    @Before("@2,@3")
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
        yandexUrl = properties.getProperty("yandex.url");
        System.out.println("Ссылка на Яндекс" + yandexUrl);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(yandexUrl);
    }

    //@AfterClass заменяем аннотацию Junit на аннотацию CUCUMBER, потому что с аннотацией Junit CUCUMBER не может работать
    @After("@2,@3")
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
