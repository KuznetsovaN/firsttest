package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.BasePage.driver;

public class InsuranceForTravelersPage extends  BasePage   {


    private final WebDriver driver;

    @FindBy(xpath = "//h3[contains(text(),'Страхование для путешественников')]/../../..//*[contains(text(),'Оформить онлайн')]")
    public WebElement button;


    public InsuranceForTravelersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void assertAndClick() {
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(button)).click();


    }


}