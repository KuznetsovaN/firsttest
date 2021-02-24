package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.SberBaseSteps;


public class SberTravelInsuranceParametersPage extends SberBasePage {

    @FindBy(xpath = "//div[contains(@class,'product-title-wrapper')]//h2")
    WebElement title;

    @FindBy(xpath = "//DIV[@_ngcontent-c11='']")
    WebElement minPackage;

    @FindBy(xpath = "//button[(text()='Оформить')]")
    WebElement formButton;

    public SberTravelInsuranceParametersPage() {
        PageFactory.initElements(SberBaseSteps.getDriver(), this);
        this.driver = SberBaseSteps.getDriver();
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOf(title));
    }

    /**
     * выбрать тип пакета страхования путешественников
     *
     * @param packageType
     */
    public void choosePackageType(String packageType) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 20, 1000);
        switch (packageType) {
            case "Минимальная":
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView(true);", minPackage
                );
                wait.until(ExpectedConditions.visibilityOf(minPackage)).click();
                break;
                       default:
                throw new AssertionError("Пакет с названием '" + packageType + "' не объявлен на странице");
        }
    }

    /**
     * нажать на кнопку "Оформить"
     */
    public void clickFormButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", formButton
        );
        formButton.click();
    }
}
