//Step для основной страницы

package steps;

import pages.CatalogPage;
import pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.RequestPage1;
import ru.yandex.qatools.allure.annotations.Step;


public class MainStep {

    @Step("Выбор вкладки страхования на основной странице")
    public void selectSection (String name) {
        new MainPage(BaseStep.getDriver()).selectMainMenu(name);
    }


        @Step ("Выбор Перейти в каталог")
    public void selecttravelInsurance (String name) {
        new MainPage(BaseStep.getDriver()).selectInsuranceMenu(name);
    }

    @Step ("Выбор вкладкии страхования для пушешественников ")
    public void travelInsurance (String name) {
        new MainPage(BaseStep.getDriver()).selectInsuranceMenu(name);
    }

   @Step ("Получения страхования пушешественников")
    public WebElement getTravelInsuranceElement (String name) {
        return new MainPage(BaseStep.getDriver()).getTravelInsuranceElement(name);
    }

    @Step ("Ожидание")
    public void waitElement (WebElement element) {
        new MainPage(BaseStep.getDriver()).waitElement(element);
    }
}