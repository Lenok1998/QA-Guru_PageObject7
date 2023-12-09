package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


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



    public FormStudentPage cleanAdvertisementOnPage() {
        step("Удаляем баннер", () -> {
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
        return this;
    }

    public FormStudentPage openPage() {
        step("Открываем форму", () -> {
            open("/automation-practice-form");
        });
        return this;
    }


    public FormStudentPage setFirstName(String value) {
        step("Вводим имя", () -> {
            firstName.setValue(value);
        });
        return this;
    }

    public FormStudentPage setLastName(String value) {
        step("Вводим фамилию", () -> {
            lastName.setValue(value);
        });
        return this;
    }


    public FormStudentPage setUserEmail(String value) {
        step("Вводим email", () -> {
        email.setValue(value);
    });
        return this;
    }


    public FormStudentPage setHobbies(String value) {
        step("Вводим хобби", () -> {
            hobbies.$(byText(value)).click();
        });
        return this;
    }

    public FormStudentPage setSubject(String value) {
        step("Вводим информацию", () -> {
            subject.val(value).pressEnter();
        });
        return this;
    }


    public FormStudentPage setGender(String value) {
        step("Выбираем пол", () -> {
            genderWrapper.$(byText(value)).click();
        });
        return this;
    }
    public FormStudentPage uploadFile(String value) {
        step("Загружаем фото", () -> {
            picture.uploadFromClasspath(value);
        });
        return this;
    }

    public FormStudentPage setDateOfBirth(String day, String month, String year) {
        step("Выбираем дату рождения в календаре", () -> {
            calendar.click();
            calendarComponent.setDate(day, month, year);
        });
        return this;
    }


    public FormStudentPage setPhoneNumber(String value) {
        step("Вводим номер телефона", () -> {
            phoneNumber.setValue(value);
        });
        return this;
    }


    public FormStudentPage setCurrentAddress(String value) {
        step("Вводим адрес", () -> {
            currentAddress.setValue(value);
        });
        return this;
    }


    public FormStudentPage setState(String value) {
        step("Вводим штат", () -> {
            selectState.val(value).pressEnter();
        });
        return this;
    }


    public FormStudentPage setCity(String value) {
        step("Вводим горол", () -> {
            selectCity.val(value).pressEnter();
        });
        return this;
    }


    public FormStudentPage submit() {
        step("Нажимаем кнопку", () -> {
            submit.click();
        });
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