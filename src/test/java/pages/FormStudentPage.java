package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormStudentPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    TableComponent tableComponent = new TableComponent();
    public SelenideElement calendar = $("#dateOfBirthInput"),
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            phoneNumber = $("#userNumber"),
            subject = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            currentAddress = $("#currentAddress"),
            picture = $("#uploadPicture"),
            stateCityWrapper = $("#stateCity-wrapper"),
            selectState = stateCityWrapper.$("#react-select-3-input"),
            selectCity = stateCityWrapper.$("#react-select-4-input"),
            submit = $("#submit");


    @Step("Удаляем баннер")
    public FormStudentPage cleanAdvertisementOnPage() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove");
        return this;
    }
    @Step("Открываем страницу")
    public FormStudentPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Вводим имя")
    public FormStudentPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }
    @Step("Вводим фамилию")
    public FormStudentPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    @Step("Вводим email")
    public FormStudentPage setUserEmail(String value) {
        email.setValue(value);
        return this;
    }

    @Step("Вводим хобби")
    public FormStudentPage setHobbies(String value) {
        hobbies.$(byText(value)).click();
        return this;
    }
    @Step("Вводим информацию")
    public FormStudentPage setSubject(String value) {
        subject.val(value).pressEnter();
        return this;
    }

    @Step("Вводим информацию")
    public FormStudentPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    @Step("Загружаем файл")
    public FormStudentPage uploadFile(String value) {
        picture.uploadFromClasspath(value);
        return this;
    }
    @Step("Выбираем значение в календаре")
    public FormStudentPage setDateOfBirth(String day, String month, String year) {
        calendar.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Вводим номер телефона")
    public FormStudentPage setPhoneNumber(String value) {
        phoneNumber.setValue(value);
        return this;
    }

    @Step("Вводим адрес")
    public FormStudentPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    @Step("Вводим штат")
    public FormStudentPage setState(String value) {
        selectState.val(value).pressEnter();
        return this;
    }

    @Step("Вводим город")
    public FormStudentPage setCity(String value) {
        selectCity.val(value).pressEnter();
        return this;
    }

    @Step("Нажимаем кнопку")
    public FormStudentPage submit() {
        submit.click();
        return this;
    }

    public FormStudentPage checkResultTable(String key, String value) {
        tableComponent.checkResultTableLine(key, value);
        return this;
    }

    public FormStudentPage verifyMobileNumberFieldIsRed() {
        phoneNumber.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }
}