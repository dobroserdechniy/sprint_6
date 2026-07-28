package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Локаторы!!!

    //Верхняя кнопка заказть
    private By topOrderButton = By.className("Button_Button__ra12g");
    //Верхняя кнопка заказать
    private By underOrderButton = By.className("Button_Middle__1CSJM");
    //Куки из-за которых упал АТ
    private By cookieButton = By.id("rcc-confirm-button");

    //Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Методы!!!

    //Клик верхней кнопки
    public void clickTopOrderButton () {
        driver.findElement(topOrderButton).click();
    }
    //Клик нижней кнопки
    public void clickUnderOrderButton () {
        driver.findElement(underOrderButton).click();
    }

    //Метод клика и проверки текста
    public String getAnswerTextAfterClick(By questionLocator, By answerLocator) {
        WebElement element = driver.findElement(questionLocator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
        return driver.findElement(answerLocator).getText();
    }

    //геттер получения локатора вопроса
    public By getQuestionLocatorByNumber(int numberPage) {
        return By.xpath("(//div[@data-accordion-component='AccordionItemHeading'])[" + numberPage + "]");
    }
    //По сути убрал локаторы каждого вопроса\ответа, и теперь под каждый прогон берется своя пара вопрос-ответ
    //геттер получения локатора ответа
    public By getAnswerLocatorByNumber(int numberPage) {
        return By.xpath("(//div[@data-accordion-component='AccordionItemPanel'])[" + numberPage + "]");
    }

    //Убрать куки
    public void acceptCookies() {
        driver.findElement(cookieButton).click();
    }

























}