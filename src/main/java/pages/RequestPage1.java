package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.*;
import static org.junit.Assert.assertEquals;


public class RequestPage1 {
    WebDriver driver;


    public void insuranceSum(String value) {
        firstPage.findElement(By.xpath("//h3[contains(text(),'"
                + value + "')]")).click();
    }


    public void issueButton(String buttonName) {
        WebDriverWait wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'" + buttonName + "')]"))).click();
    }

    // Инициализация кнопок и параметров ввода
    @FindBy(xpath = "//section[@class='b-form-section']//div[contains(@class,'b-form-box-block')]")
    WebElement minS;
    @FindBy(xpath = "//form//div[@class='container']")
    WebElement firstPage;
    @FindBy (xpath = "//*[contains(text(),\"Продолжить\")]")
    WebElement endRequest;

    //Застрахованные находим на форме
    @FindBy(xpath = "//INPUT[@id='surname_vzr_ins_0']")
    WebElement surname_s;
    @FindBy(xpath = "//INPUT[@id='name_vzr_ins_0']")
    WebElement name_s;
    @FindBy(xpath = "//INPUT[@id='birthDate_vzr_ins_0']")
    WebElement birthday_s;


    //Страхователь находим
    @FindBy(xpath = "//INPUT[@id='person_lastName']" )
    WebElement surname;
    @FindBy(xpath = "//INPUT[@id='person_firstName']")
    WebElement name;
    @FindBy(xpath = "//INPUT[@id='person_birthDate']")
    WebElement birthDate;
    @FindBy(xpath = "//INPUT[@id='person_birthDate']")
    WebElement personBirthDate;

    @FindBy(xpath = "//INPUT[@id='person_middleName']")
    WebElement middlename;

    @FindBy(xpath = "//div[contains(@class, 'btn-group')]")
    WebElement gender;

    //Паспорт находим на форме

    @FindBy(xpath = "//INPUT[@id='passportSeries']")
    WebElement passport_series;
    @FindBy(xpath = "//INPUT[@id='passportNumber']")
    WebElement passport_number;
    @FindBy(xpath = "//INPUT[@id='documentDate']")
    WebElement issueDate;

    @FindBy(xpath = "//INPUT[@id='documentIssue']")
    WebElement issuePlace;

    public RequestPage1(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void minrequest (String sum) {
        minS.findElement(By.xpath(".//*[contains(text(),'" + sum + "')]")).click();
    }

    public void PressMin () {
        driver.findElement(By.xpath("//span[@class=\"b-button-block-center\"]//*[contains(text(),\"Оформить\")]")).click();
    }


    public void fillField(String fieldName, String value) throws InterruptedException {
        switch (fieldName){
            case "фамилия застрахованного":
                fillField(surname_s, value);
                break;
            case "имя застрахованного":
                fillField(name_s, value);
                break;
            case "дата рождения застрахованного":
                fillField(birthday_s, value);
                break;
            case "фамилия":
                surname.click();
                fillField(surname, value);
                break;
            case "имя":
                fillField(name, value);
                break;
            case "день рождения":
                fillField(birthDate, value);
                break;
            case "отчество":
                middlename.click();
                fillField(middlename, value);
                break;
            case "серия паспорта":
                passport_series.click();
                fillField(passport_series, value);
                break;
            case "номер паспорта":
                fillField(passport_number, value);
                break;
            case "дата выдачи":
                fillField(issueDate, value);
                middlename.click();
                break;

            case "кем выдан":
                middlename.click();
                issuePlace.click();
                fillField(issuePlace, value);
                break;
            case "Пол":
                gender.findElement(By.xpath("//label[contains(text(),'" + value + "')]")).click();
                break;
            default:
                throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }




    public void checkFields (String field, String expected){
        switch (field){
            case "фамилия застрахованного":
                Assert.assertEquals(expected, surname_s.getAttribute("value"));
                break;
            case "имя застрахованного":
                Assert.assertEquals(expected, name_s.getAttribute("value"));
                break;
            case "дата рождения застрахованного":
                Assert.assertEquals(expected, birthday_s.getAttribute("value"));
                break;
            case "фамилия":
                Assert.assertEquals(expected, surname.getAttribute("value"));
                break;
            case "имя":
                Assert.assertEquals(expected, name.getAttribute("value"));
                break;
            case "день рождения":
                Assert.assertEquals(expected, birthDate.getAttribute("value"));
                break;
            case "отчество":
                Assert.assertEquals(expected, middlename.getAttribute("value"));
                break;
            case "серия паспорта":
                Assert.assertEquals(expected, passport_series.getAttribute("value"));
                break;
            case "номер паспорта":
                Assert.assertEquals(expected, passport_number.getAttribute("value"));
                break;
            case "дата выдачи":
                Assert.assertEquals(expected, issueDate.getAttribute("value"));
                break;
            case "кем выдан":
                Assert.assertEquals(expected, issuePlace.getAttribute("value"));
                break;
            default:
                throw new AssertionError("Поле '"+field+"' не объявлено на странице");
        }

    }
    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void EndRequest (){
        endRequest.click();
    }

    public void checkZP(){
        assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(By.cssSelector("div.alert-form-error")).getText());;
    }
}