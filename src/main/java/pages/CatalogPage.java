package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.BasePage.driver;

public class CatalogPage {

    @FindBy(xpath = "//H3[@class='uc-full__header'][text()='Страхование для путешественников']")
    public WebElement titleTravel;

    @FindBy(xpath = "//h3[contains(text(),'Страхование для путешественников')]/../../..//*[contains(text(),'Оформить онлайн')]")
    public WebElement sendButton;

    public void selecttravelInsurance(String name) {
        titleTravel.findElement(By.xpath("//H3[@class='uc-full__header'][text()='Страхование для путешественников']")).click();
    }


    public CatalogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(sendButton));
    }



}