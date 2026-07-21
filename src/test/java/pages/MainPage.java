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

    //Ниже пойдет список "Вопросов о важном"
    //Кнопка Вопрос 1
    private By question1 = By.xpath("(//div[@data-accordion-component='AccordionItemHeading'])[1]");
    //Кнопка Вопрос 2
    private By question2 = By.xpath("(//div[@data-accordion-component='AccordionItemHeading'])[2]");
    //Кнопка Вопрос 3
    private By question3 = By.xpath("(//div[@data-accordion-component='AccordionItemHeading'])[3]");
    //Кнопка Вопрос 4
    private By question4 = By.xpath("(//div[@data-accordion-component='AccordionItemHeading'])[4]");
    //Кнопка Вопрос 5
    private By question5 = By.xpath("(//div[@data-accordion-component='AccordionItemHeading'])[5]");
    //Кнопка Вопрос 6
    private By question6 = By.xpath("(//div[@data-accordion-component='AccordionItemHeading'])[6]");
    //Кнопка Вопрос 7
    private By question7 = By.xpath("(//div[@data-accordion-component='AccordionItemHeading'])[7]");
    //Кнопка Вопрос 8
    private By question8 = By.xpath("(//div[@data-accordion-component='AccordionItemHeading'])[8]");
    //Ответ 1
    private By answer1 = By.xpath("(//div[@data-accordion-component='AccordionItemPanel'])[1]");
    //Ответ 2
    private By answer2 = By.xpath("(//div[@data-accordion-component='AccordionItemPanel'])[2]");
    //Ответ 3
    private By answer3 = By.xpath("(//div[@data-accordion-component='AccordionItemPanel'])[3]");
    //Ответ 4
    private By answer4 = By.xpath("(//div[@data-accordion-component='AccordionItemPanel'])[4]");
    //Ответ 5
    private By answer5 = By.xpath("(//div[@data-accordion-component='AccordionItemPanel'])[5]");
    //Ответ 6
    private By answer6 = By.xpath("(//div[@data-accordion-component='AccordionItemPanel'])[6]");
    //Ответ 7
    private By answer7 = By.xpath("(//div[@data-accordion-component='AccordionItemPanel'])[7]");
    //Ответ 8
    private By answer8 = By.xpath("(//div[@data-accordion-component='AccordionItemPanel'])[8]");


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

    //Убрать куки
    public void acceptCookies() {
        driver.findElement(cookieButton).click();
    }


    public By getQuestion1() { return question1; }
    public By getQuestion2() { return question2; }
    public By getQuestion3() { return question3; }
    public By getQuestion4() { return question4; }
    public By getQuestion5() { return question5; }
    public By getQuestion6() { return question6; }
    public By getQuestion7() { return question7; }
    public By getQuestion8() { return question8; }

    public By getAnswer1() { return answer1; }
    public By getAnswer2() { return answer2; }
    public By getAnswer3() { return answer3; }
    public By getAnswer4() { return answer4; }
    public By getAnswer5() { return answer5; }
    public By getAnswer6() { return answer6; }
    public By getAnswer7() { return answer7; }
    public By getAnswer8() { return answer8; }

























}