package test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class SberStepTest extends SberBaseSteps {
    SberMainPageSteps sberMainPageSteps = new SberMainPageSteps();
    SberInsuranceTypesPageSteps sberInsuranceTypesPageSteps = new SberInsuranceTypesPageSteps();
    SberTravelInsuranceFormPageSteps sberTravelInsuranceFormPageSteps = new SberTravelInsuranceFormPageSteps();
    SberTravelInsuranceParametersPageSteps sberTravelInsuranceParametersPageSteps = new SberTravelInsuranceParametersPageSteps();

    HashMap<String, String> testData1 = new HashMap<>();
    HashMap<String, String> testData2 = new HashMap<>();
    HashMap<String, String> testData3 = new HashMap<>();

    @Ignore
    @Title("Заведомо падающий тест")
    @Test
    public void TestFail() {
        testData1.put("Фамилия", "Ветрокрылая");
        testData1.put("Имя", "Сильвана");
        testData1.put("Дата рождения", "13.09.1999");

        testData2.put("Фамилия", "Менетил");
        testData2.put("Имя", "Артас");
        testData2.put("Отчество", "Теренасович");
        testData2.put("Дата рождения", "22.09.2000");

        testData3.put("Серия", "1234");
        testData3.put("Номер", "567890");
        testData3.put("Дата выдачи", "22.09.2015");
        testData3.put("Кем выдан", "МВД Азатот");

        // Перейти на страницу http://www.sberbank.ru/ru/person
        driver.get(TravelInsuranceUrl);

        // Нажать на – Страхование
        sberMainPageSteps.selectInsuranceBottomMenu();

        // Нажать на – Оформить Онлайн
        sberInsuranceTypesPageSteps.clickGetOnlineButtonForInsuranceType();

        // На вкладке – Выбор полиса выбрать Минимальная
        sberTravelInsuranceParametersPageSteps.choosePackageType("Минимальная");

        // Нажать Оформить
        sberTravelInsuranceParametersPageSteps.clickFormButton();

        //На вкладке Оформить заполнить поля
        sberTravelInsuranceFormPageSteps.fillInsuredFields(testData1);
        sberTravelInsuranceFormPageSteps.fillInsurerMainFields(testData2);
        sberTravelInsuranceFormPageSteps.fillInsurerPassFields(testData3);

        //  Проверить, что все поля заполнены правильно
        sberTravelInsuranceFormPageSteps.checkFillInsuredFields(testData1);
        sberTravelInsuranceFormPageSteps.checkFillInsurerFields(testData2);
        sberTravelInsuranceFormPageSteps.checkFillInsurerPassFields(testData3);

        //Нажать продолжить
        sberTravelInsuranceFormPageSteps.clickSubmitButton();

        // Проверить, что появилось сообщение - Заполнены не все обязательные поля
        sberTravelInsuranceFormPageSteps.checkIfAlertsPresent(3);
    }


    @Title("Заявка на полис страхования путешественников. Не заполнены обязательные поля формы")
    @Test
    public void Test() {
        testData1.put("Фамилия", "Ветрокрылая");
        testData1.put("Имя", "Сильвана");
        testData1.put("Дата рождения", "13.09.1999");

        testData2.put("Фамилия", "Менетил");
        testData2.put("Имя", "Артас");
        testData2.put("Отчество", "Теренасович");
        testData2.put("Дата рождения", "22.09.2000");

        testData3.put("Серия", "1234");
        testData3.put("Номер", "567890");
        testData3.put("Дата выдачи", "22.09.2015");
        testData3.put("Кем выдан", "МВД Азатот");

        // Перейти на страницу http://www.sberbank.ru/ru/person
        driver.get(TravelInsuranceUrl);

        // Нажать на – Страхование
        sberMainPageSteps.selectInsuranceBottomMenu();

        // Находим блок с названием "Страхование для путешественников"
        // Проверить наличие на странице заголовка – Страхование для путешественников
        sberInsuranceTypesPageSteps.checkPageTitle("Страхование для путешественников");

        // Нажать на – Оформить Онлайн
        sberInsuranceTypesPageSteps.clickGetOnlineButtonForInsuranceType();

        // На вкладке – Выбор полиса выбрать Минимальная
        sberTravelInsuranceParametersPageSteps.choosePackageType("Минимальная");

        // Нажать Оформить
        sberTravelInsuranceParametersPageSteps.clickFormButton();

        //На вкладке Оформить заполнить поля
        sberTravelInsuranceFormPageSteps.fillInsuredFields(testData1);
        sberTravelInsuranceFormPageSteps.fillInsurerMainFields(testData2);
        sberTravelInsuranceFormPageSteps.fillInsurerPassFields(testData3);

        //  Проверить, что все поля заполнены правильно
        sberTravelInsuranceFormPageSteps.checkFillInsuredFields(testData1);
        sberTravelInsuranceFormPageSteps.checkFillInsurerFields(testData2);
        sberTravelInsuranceFormPageSteps.checkFillInsurerPassFields(testData3);

        //Нажать продолжить
        sberTravelInsuranceFormPageSteps.clickSubmitButton();

        // Проверить, что появилось сообщение - Заполнены не все обязательные поля
        sberTravelInsuranceFormPageSteps.checkIfAlertsPresent(3);

    }
}
