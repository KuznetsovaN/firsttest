package steps;

import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseStep {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    //Стартовый пакет для начала сценария. Указание пути, драйвера, браузера и раскрытие окна на максимум
    @Before
    public void startScenario(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.sberbank.ru/ru/person/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //Скриншот для отчета Allure
    public static byte[] AllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    //Завершение работы
    @AfterClass
    public static void afterMethod(){
        driver .quit();
    }
}