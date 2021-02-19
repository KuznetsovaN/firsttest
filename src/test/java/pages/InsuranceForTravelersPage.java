package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuranceForTravelersPage extends BasePage {



    @FindBy(xpath = "//h3[contains(text(), 'Страхование для путешественников')]")
     WebElement header;

    @FindBy(xpath = "//B[@class='kit-button__text'][text()='Оформить онлайн'][text()='Оформить онлайн']")
     WebElement button;

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