package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


import static  org.junit.jupiter.api.Assertions.assertEquals ;



public class task1 {
    WebDriver driver;
    String baseURL;

    @Before
    public void befoTest() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();//инициализируем переменную driver

//1. Перейти на страницу http://www.sberbank.ru/ru/person
        baseURL="http://www.sberbank.ru/ru/person";

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();//разворачивает окно на весь экран
        driver.get(baseURL);
    }

    @Test
    public void autoTestInsurance() throws InterruptedException {


        Actions actions = new Actions(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver,10,1000);

//2. Нажать на – Страхование
        driver.findElement(By.xpath("(//A[@role='button'])[11]//DIV[@class='kitt-top-menu__icon-img']")).click();

//3. Выбрать – Перейти в каталог
        driver.findElement(By.xpath("//A[@class='kitt-top-menu__link kitt-top-menu__link_second'][text()='Перейти в каталог']")).click();
//4. Скролим до    Страхование для путешественников
        // This  will scroll page 400 pixel vertical
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
//5.Нажать на - Страхование для путешественников
        driver.findElement(By.xpath("//H3[@class='uc-full__header'][text()='Страхование для путешественников']"));
        Thread.sleep(5000);

        driver.findElement(By.xpath("//H3[@class='uc-full__header'][text()='Страхование для путешественников']")).click();
//6. Проверить наличие на странице заголовка – Страхование путешественников
        Thread.sleep(5000);
        WebElement TravellersInsuranceBlock =driver.findElement(By.xpath("//H1[@class='kitt-heading  page-teaser-dict__header kitt-heading_size_l'][text()='Страхование путешественников']/self::H1"));
        String TravellersInsuranceBlockHeader = TravellersInsuranceBlock.getText();
        Assert.assertEquals("Страхование путешественников", TravellersInsuranceBlockHeader);


//7. Нажать на – Оформить Онлайн
        driver.findElement(By.xpath("//*[@id=\"page-main\"]/div[1]/div/div/div/div/div/div[1]/div[2]/a/span")).click();
// Wait for 5 second
        Thread.sleep(5000);

// 8.На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная  -- Уже минимальна, не кликабельно

        //9. Нажать оформить
        driver.findElement(By.xpath("//BUTTON[@class='btn btn-primary btn-large'][text()='Оформить']")).click();

        Thread.sleep(5000);


//10. На вкладке Оформить заполнить поля
        //   Фамилию и Имя, Дату рождения застрахованных
        //   Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол
        //   Паспортные данные
        //   Контактные данные не заполняем

       // Застрахованные определяем значения
        String lastName = "Ветрокрылая";
        String firstName = "Сильвана";
        String birthDate = "13.09.1999";

        //Застрахованные находим на форме

        WebElement lastNameElement = driver.findElement(By.xpath("//INPUT[@id='surname_vzr_ins_0']"));
        WebElement firstNameElement = driver.findElement(By.xpath("//INPUT[@id='name_vzr_ins_0']"));
        WebElement birthDateElement = driver.findElement(By.xpath("//INPUT[@id='birthDate_vzr_ins_0']"));

        //Застрахованные заполняем
        lastNameElement.sendKeys(lastName);
        firstNameElement.sendKeys(firstName);
        birthDateElement.sendKeys(birthDate);

        Thread.sleep(5000);

        // Страхователь определяем значения

        String StlastName = "Менетил";
        String StfirstName = "Артас";
        String StmiddleName ="Теренасович";
        String StbirthDate = "22.09.2000";

        //Страхователь находим на форме
        driver.findElement(By.xpath("//INPUT[@id='person_lastName']/self::INPUT")).click(); //фигня какая-то, без нее пропускал поле
        WebElement StlastNameElement = driver.findElement(By.xpath("//INPUT[@id='person_lastName']/self::INPUT"));
        WebElement StfirstNameElement = driver.findElement(By.xpath("//INPUT[@id='person_firstName']/self::INPUT"));
        WebElement StmiddleNameElement = driver.findElement(By.xpath("//INPUT[@id='person_middleName']/self::INPUT"));
        WebElement StbirthDateElement = driver.findElement(By.xpath("//INPUT[@id='person_birthDate']/self::INPUT"));
        driver.findElement(By.xpath("//LABEL[@class='btn ng-untouched ng-pristine ng-valid active'][text()='Мужской']/self::LABEL"));

        //Страхователь заполняем
        StlastNameElement.sendKeys(StlastName);
        StfirstNameElement.sendKeys(StfirstName);
        StmiddleNameElement.sendKeys(StmiddleName);
        StbirthDateElement.sendKeys(StbirthDate);


        Thread.sleep(5000);

        // Паспорт определяем значения
        String passportSeries = "1234";
        String passportNumber = "567890";
        String documentDate = "22.09.2015";
        //String documentIssue = "МВД Азатот";

        //Паспорт находим на форме
        driver.findElement(By.xpath("//INPUT[@id='passportSeries']/self::INPUT")).click(); //фигня какая-то, без нее пропускал поле
        WebElement passportSeriesElement = driver.findElement(By.xpath("//INPUT[@id='passportSeries']/self::INPUT"));
        WebElement passportNumberElement = driver.findElement(By.xpath("//INPUT[@id='passportNumber']/self::INPUT"));
        WebElement documentDateElement = driver.findElement(By.xpath("//INPUT[@id='documentDate']/self::INPUT"));
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)"); // не срабатывает на форме, почему?

        Thread.sleep(5000);
        //тут происходит что-то странное, конкретное поле не заполнялось и дело не в скролинге , прописывала, чтоб кликала на поле контактов и обзор смещался
       // driver.findElement(By.xpath("//INPUT[@id='documentIssue']/self::INPUT")).click(); //фигня какая-то, без нее пропускал поле
       // WebElement documentIssueElement = driver.findElement(By.xpath("//INPUT[@id='documentIssue']/self::INPUT"));

        //переписала так поле кем выдан
        WebElement passWhoIssueField = driver.findElement(By.cssSelector("input#documentIssue"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", passportSeriesElement
        );
        passWhoIssueField.sendKeys("МВД Азатот");


        //Паспорт заполняем
        passportSeriesElement.sendKeys(passportSeries);
        passportNumberElement.sendKeys(passportNumber);
        documentDateElement.sendKeys(documentDate);
        //documentIssueElement.sendKeys(documentIssue);

        Thread.sleep(5000);


//11. Проверить, что все поля заполнены правильно
        Assert.assertEquals("Ветрокрылая", lastNameElement.getAttribute("value"));
        Assert.assertEquals("Сильвана", firstNameElement.getAttribute("value"));
        Assert.assertEquals("13.09.1999", birthDateElement.getAttribute("value"));

        Assert.assertEquals("Менетил", StlastNameElement.getAttribute("value"));
        Assert.assertEquals("Артас", StfirstNameElement.getAttribute("value"));
        Assert.assertEquals("Теренасович", StmiddleNameElement.getAttribute("value"));
        Assert.assertEquals("22.09.2000", StbirthDateElement.getAttribute("value"));

        Assert.assertEquals("1234", passportSeriesElement.getAttribute("value"));
        Assert.assertEquals("567890", passportNumberElement.getAttribute("value"));
        Assert.assertEquals("22.09.2015", documentDateElement.getAttribute("value"));
        Assert.assertEquals("МВД Азатот", passWhoIssueField.getAttribute("value"));

        //12. Нажать продолжить
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.visibilityOf(submitButton)).click();

        //13. Проверить, что появилось сообщение - Заполнены не все обязательные поля
        WebElement alerBlock = driver.findElement(By.cssSelector("div.alert-form-error"));
        Assert.assertEquals("При заполнении данных произошла ошибка", alerBlock.getText());
    }


    @After
    public void afterTest() {
        driver.quit();//закрываем браузер
    }

}