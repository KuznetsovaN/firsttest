package test;//Задание 3

import org.openqa.selenium.WebDriver;
import pages.CatalogPage;
import pages.RequestPage1;
import steps.BaseStep;
import steps.MainStep;
import steps.RequestStep;
import steps.InsuranceTravelStep;
import org.junit.Test;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static test.BaseTest.baseUrl;


public class Task3 extends BaseStep {

    MainStep mainStep = new MainStep();
    InsuranceTravelStep insuranceTravelStep = new InsuranceTravelStep();
    RequestStep requestStep = new RequestStep();
    HashMap <String, String> testData = new HashMap<>();


    @Test
    public void task3(){

        //Переход к вкладке Застраховать себя и имущество-выбор страхования путешественников
        mainStep.selectSection("Страхование");
        mainStep.selecttravelInsurance("Перейти в каталог");
        // Каталог страхования


      mainStep.waitElement(mainStep.getTravelInsuranceElement("Страхование для путешественников"));
       mainStep.selecttravelInsurance2("Страхование для путешественников");

        // Каталог страхования





        //Переход к вкладке Страхования путешественников, проверка на наличие соответствующего окна и переход
        //к новому окну
        //insuranceTravelStep.waitElement(insuranceTravelStep.getTitle());

        insuranceTravelStep.changeWindow();


        //Поиск и выбор минимального пакета для заявки страхования
        requestStep.minrequest("Минимальная");
        requestStep.PressMin();


        //Ввод данных в заявку по застрахованным
        testData.put("фамилия застрахованного", "Ветрокрылая");
        testData.put("имя застрахованного", "Сильвана");
        testData.put("дата рождения застрахованного", "13.09.1999");

        //Ввод данных в заявку по страхователю
        testData.put("фамилия", "Менетил");
        testData.put("имя", "Артас");
        testData.put("отчество", "Теренасович");
        testData.put("день рождения", "22.09.2000");

        //Ввод данных паспорта
        testData.put("серия паспорта", "1234");
        testData.put("номер паспорта", "567890");
        testData.put("дата выдачи", "22.09.2015");
        testData.put("место выдачи", "МВД Азатот"); //проблемное место


        //Ввод в поля по тестовым данным
        requestStep.fillFields(testData);

        //Проверка полей на соответствие тестовым данным
        requestStep.checkFields(testData);

        //Завершение заявки
        requestStep.EndRequest();

        //Ппроверка оповещения, что заполнены не все поля
        requestStep.checkZP();
    }

}