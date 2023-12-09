package tests;
import data.TestData;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Tag;
import  org.junit.jupiter.api.Test;
import pages.FormStudentPage;


public class FormStudentTest extends TestBase {
    FormStudentPage formStudentPage = new FormStudentPage();
    TestData testData = new TestData();

    @Test
    @Step("Заполняем форму валидными данными")
    @Tag("positive")
    @Tag("my-tests")
    @Owner("Малышева Елена Сергеевна")
    void fillFormTest() {
        formStudentPage.openPage()
                .cleanAdvertisementOnPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setPhoneNumber(testData.userNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setUserEmail(testData.userEmail)
                .setHobbies(testData.hobbies)
                .setSubject(testData.subjects)
                .setCurrentAddress(testData.streetAddress)
                .uploadFile("my.png")
                .setState(testData.state)
                .setCity(testData.city)
                .submit();

        formStudentPage.checkResultTable("Student Name", testData.firstName + "\n" + testData.lastName)
                .checkResultTable("Student Email", testData.userEmail)
                .checkResultTable("Gender", testData.gender)
                .checkResultTable("Mobile", testData.userNumber)
                .checkResultTable("Date of Birth", testData.day + "\n" +
                        testData.month + "," +
                        testData.year)
                .checkResultTable("Subjects", testData.subjects)
                .checkResultTable("Hobbies", testData.hobbies)
                .checkResultTable("Picture", "my.png")
                .checkResultTable("Address", testData.streetAddress)
                .checkResultTable("State and City", testData.state + "\n" + testData.city);
    }

    @Test
    @Step("Заполняем форму неполностью")
    @Owner("Малышева Елена Сергеевна")
    @Tag("negative")
    void inputMinimalData() {
        formStudentPage.openPage()
                .cleanAdvertisementOnPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setPhoneNumber(testData.userNumber)
                .submit();

        formStudentPage.checkResultTable("Student Name",testData.firstName + "\n" + testData.lastName)
                .checkResultTable("Gender", testData.gender)
                .checkResultTable("Mobile", testData.userNumber);

    }

    @Test
    @Step("Вводим невалидный номер телефона")
    @Tag("my-tests")
    @Owner("Малышева Елена Сергеевна")
    @Tag("negative")

    void inputInvalidMobileNumber() {
        formStudentPage.openPage()
                .cleanAdvertisementOnPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setPhoneNumber("8987")
                .submit();

        formStudentPage.verifyMobileNumberFieldIsRed();

    }
}





