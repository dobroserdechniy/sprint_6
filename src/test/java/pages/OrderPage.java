package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Локаторы

    //Страница 1

    //Текст страницы 1 заказа
    private By orderPageText1 = By.xpath(".//div[@class='Order_Header__BZXOb' and text()='Для кого самокат']");

    //Поле Имя
    private By firstNameInput = By.xpath(".//input[@placeholder='* Имя']");

    //Поле Фамилия
    private By lastNameInput = By.xpath(".//input[@placeholder='* Фамилия']");

    //Поле адрес
    private By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Поле метро
    private By metroStationInput = By.xpath(".//input[@placeholder='* Станция метро']");

    //Поле телефон
    private By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Локатор для метро Сокольники
    private By metroStationSokolniki = By.xpath(".//div[@class='Order_Text__2broi' and text()='Сокольники']");

    //Кнопка далее
    private By nextButton = By.xpath(".//button[text()='Далее']");

    //Страница 2

    //Текст страницв 2 заказа
    private By orderPageText2 = By.xpath(".//div[@class='Order_Header__BZXOb' and text()='Про аренду']");

    //Поле дата доставки
    private By deliveryDateInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Поле завтрашнего дня. Тут пришлось гуглить как правильно выбирать след.день
    private By tomorrowCalendarDay = By.xpath(".//div[contains(@class, 'react-datepicker__day--today')]/following-sibling::div[1]");

    //Поле список дней аренды
    private By rentalPeriodDropdown = By.className("Dropdown-control");

    //Поле срок аренды
    private By rentalPeriodDay = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");

    //Чекбокс для черного цвета
    private By blackColorCheckbox = By.id("black");

    //Поле комментарий
    private By courierCommentInput = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Кнопка заказать
    private By finalOrderButton = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']");


    //Страница подтверждение

    //Текст окна подтверждения
    private By confirmPageText = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(), 'Хотите оформить заказ?')]");

    //Кнопка Да
    private By confirmYesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    //Страница успешного заказа

    //Текст успешного заказа
    private By successOrderText = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(), 'Заказ оформлен')]");




    //Конструктор
    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Методы

    //Проверка текста страницы 1
    public String getOrderPageText1() {
        return driver.findElement(orderPageText1).getText();
    }

    //Ввод имени
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    //Ввод фамилии
    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    //Ввод адреса
    public void enterAddress(String address) {
        driver.findElement(addressInput).clear();
        driver.findElement(addressInput).sendKeys(address);
    }

    //Ввод станции метро
    public void selectStationSokolniki() {
        driver.findElement(metroStationInput).click();
        driver.findElement(metroStationSokolniki).click();
    }

    //Ввод телефона
    public void enterPhone(String phone) {
        driver.findElement(phoneInput).clear();
        driver.findElement(phoneInput).sendKeys(phone);
    }

    //Тык кнопки далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    //Проверка текста страницы 2
    public String getOrderPageText2() {
        return driver.findElement(orderPageText2).getText();
    }

    //Выбор дня в календаре
    public void selectTomorrowDate() {
        driver.findElement(deliveryDateInput).click();
        driver.findElement(tomorrowCalendarDay).click();
    }

    //Выбор срока аренды
    public void selectRentalPeriodOneDay() {
        driver.findElement(rentalPeriodDropdown).click();
        driver.findElement(rentalPeriodDay).click();
    }

    //ВЫбор цвета
    public void clickBlackColor() {
        driver.findElement(blackColorCheckbox).click();
    }

    //Ввод комментария
    public void enterCourierComment(String comment) {
        driver.findElement(courierCommentInput).clear();
        driver.findElement(courierCommentInput).sendKeys(comment);
    }

    //Тык кнопки заказать
    public void clickFinalOrderButton() {
        WebElement element = driver.findElement(finalOrderButton);
        ((org.openqa.selenium.JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    //Проверка текста доп страницы 3
    public String getConfirmPageText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPageText));
        return driver.findElement(confirmPageText).getText();
    }

    //Тык кнопки да
    public void clickConfirmButton() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
        driver.findElement(confirmYesButton).click();
    }

    //Проверка текста страницы успеха
    public String getSuccessOrderHeaderText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successOrderText));
        return driver.findElement(successOrderText).getText();
    }
}
