//Step для страницы с выбором страхования путешественников
//*
package steps;

import org.openqa.selenium.WebDriver;
import pages.InsuranceForTravelersPage;
import ru.yandex.qatools.allure.annotations.Step;


public class InsuranceTravelStep {
    WebDriver driver;


    //Открытие нового окна и переход указателя к новой вкладке
   @Step("Переход на новую вкладку")
    public void changeWindow () {
        new InsuranceForTravelersPage(BaseStep.getDriver()).assertAndClick();
    }

}
