package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;
import pages.OrderPage;

public class OrderTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "top, Иван, Иванов, 'г.Москва, ул.Ленина, д.5', 89991112233, позвонить",
            "under, Анна, Петрова, 'г.Москва, ул.Мира, д.12, кв.4', 88005553535, ''"
    })
    public void testScooterOrderFlow(String buttonType, String firstName, String lastName, String address, String phone, String comment) {
        driver.get("https://qa-scooter.education-services.ru/");
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.acceptCookies(); //Я долго мучился, пока не зашел в режим инкогнито

        if ("top".equalsIgnoreCase(buttonType)) {
            mainPage.clickTopOrderButton();
        } else {
            mainPage.clickUnderOrderButton();
        }

        Assertions.assertEquals("Для кого самокат", orderPage.getOrderPageText1(), "Страница 1 не появилась");

        orderPage.enterFirstName(firstName);
        orderPage.enterLastName(lastName);
        orderPage.enterAddress(address);
        orderPage.selectStationSokolniki();
        orderPage.enterPhone(phone);
        orderPage.clickNextButton();

        Assertions.assertEquals("Про аренду", orderPage.getOrderPageText2(), "Страница 2 не появилась");

        orderPage.selectTomorrowDate();
        orderPage.selectRentalPeriodOneDay();
        orderPage.clickBlackColor();
        orderPage.enterCourierComment(comment);
        orderPage.clickFinalOrderButton();

        Assertions.assertEquals("Хотите оформить заказ?", orderPage.getConfirmPageText().trim(), "Окно подтверждения не появилось");

        orderPage.clickConfirmButton();

        Assertions.assertTrue(orderPage.getSuccessOrderHeaderText().contains("Заказ оформлен"), "Окно успеха не появилось");
    }
}
