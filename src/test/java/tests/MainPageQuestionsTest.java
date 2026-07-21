package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class MainPageQuestionsTest extends BaseTest {

    @Test
    public void testCheckAllQuestionsAndAnswersEquels() {
        driver.get("https://qa-scooter.education-services.ru");

        MainPage mainPage = new MainPage(driver);

        String actualText1 = mainPage.getAnswerTextAfterClick(mainPage.getQuestion1(), mainPage.getAnswer1());
        Assertions.assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", actualText1);

        String actualText2 = mainPage.getAnswerTextAfterClick(mainPage.getQuestion2(), mainPage.getAnswer2());
        Assertions.assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", actualText2);

        String actualText3 = mainPage.getAnswerTextAfterClick(mainPage.getQuestion3(), mainPage.getAnswer3());
        Assertions.assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", actualText3);

        String actualText4 = mainPage.getAnswerTextAfterClick(mainPage.getQuestion4(), mainPage.getAnswer4());
        Assertions.assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", actualText4);

        String actualText5 = mainPage.getAnswerTextAfterClick(mainPage.getQuestion5(), mainPage.getAnswer5());
        Assertions.assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", actualText5);

        String actualText6 = mainPage.getAnswerTextAfterClick(mainPage.getQuestion6(), mainPage.getAnswer6());
        Assertions.assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", actualText6);

        String actualText7 = mainPage.getAnswerTextAfterClick(mainPage.getQuestion7(), mainPage.getAnswer7());
        Assertions.assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", actualText7);

        String actualText8 = mainPage.getAnswerTextAfterClick(mainPage.getQuestion8(), mainPage.getAnswer8());
        Assertions.assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", actualText8);
    }
}
