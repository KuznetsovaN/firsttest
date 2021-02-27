package test;

import org.junit.Ignore;
import org.junit.Test;
import pages.CatalogPage;
import pages.HomePage;
import pages.RequestPage1;
import steps.SberBaseSteps;

import static org.junit.Assert.assertEquals;


public class SberRefactoringTest extends SberBaseSteps {
    @Ignore
    @Test
    public void newInsuranceTest() throws InterruptedException {
        driver.get(sberUrl);
        HomePage mainPage = new HomePage(driver);
        mainPage.buttonCookieClose.click();                                                             // Закрытие cookie
        // Главная
        mainPage.selectMainMenu("Страхование");
        mainPage.selectInsuranceMenu("Перейти в каталог");
        // Каталог страхования
        CatalogPage insuranceCatalogPage = new CatalogPage(driver);
        assertEquals("Страхование для путешественников", insuranceCatalogPage.titleTravel.getText());
        insuranceCatalogPage.sendButton.click();
        RequestPage1 RequestPage = new RequestPage1(driver);

        /** Страница "Выбор полиса" */
        RequestPage.insuranceSum("Минимальная");
        RequestPage.issueButton("Оформить");

        //Ввод данных в заявку по застрахованным
        RequestPage.fillField("фамилия застрахованного", "Ветрокрылая");
        RequestPage.fillField("имя застрахованного", "Сильвана");
        RequestPage.fillField("дата рождения застрахованного", "13.09.1999");

        //Ввод данных в заявку по страхователю
        RequestPage.fillField("фамилия", "Менетил");
        RequestPage.fillField("имя", "Артас");
        RequestPage.fillField("отчество", "Теренасович");
        RequestPage.fillField("день рождения", "22.09.2000");

        //Ввод данных паспорта
        RequestPage.fillField("серия паспорта", "1234");
        RequestPage.fillField("номер паспорта", "567890");
        RequestPage.fillField("дата выдачи", "22.09.2015");
        RequestPage.fillField("кем выдан", "МВД Азатот");


        //Проверка ввода данных в заявку по застрахованным
        RequestPage.checkFields("фамилия застрахованного","Ветрокрылая");
        RequestPage.checkFields("имя застрахованного","Сильвана");
        RequestPage.checkFields("дата рождения застрахованного", "13.09.1999");

        //Проверка ввода данных в заявку по страхователю
        RequestPage.checkFields("фамилия", "Менетил");
        RequestPage.checkFields("имя", "Артас");
        RequestPage.checkFields("отчество", "Теренасович");
        RequestPage.checkFields("день рождения", "22.09.2000");

        //Проверка ввода данных паспорта
        RequestPage.checkFields("серия паспорта", "1234");
        RequestPage.checkFields("номер паспорта", "567890");
        RequestPage.checkFields("дата выдачи", "22.09.2015");
        RequestPage.checkFields("кем выдан", "МВД Азатот");

        //Утверждение данных
        RequestPage.EndRequest();

        //Проверка заполненных полей
        RequestPage.checkZP();

    }

}
