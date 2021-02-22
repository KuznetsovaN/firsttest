//Страница 1: Главная страница

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    WebDriver driver;

    @FindBy(xpath = "//div[contains(@class,'bp-area header-container')]")
    WebElement menu;

    @FindBy(xpath = "//*[contains(@class, 'kitt-top-menu__list')]")
    WebElement mainMenu;

    @FindBy(xpath = "//li/*[(text()='Страхование')]/..//ul")
    WebElement insuranceMenu;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitElement (WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30, 1000);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void selectMainMenu(String name) {
        mainMenu.findElement(By.xpath(".//*[contains(text(), '" + name + "')]//span")).click();
    }

    public void selectInsuranceMenu(String name) {
        insuranceMenu.findElement(By.xpath(".//*[contains(text(),'" + name + "')]")).click();
    }

    public WebElement getTravelInsuranceElement (String name) {
        return insuranceMenu.findElement(By.xpath(".//*[contains(text(),'" + name + "')]"));
    }


}