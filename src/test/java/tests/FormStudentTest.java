package tests;

import  org.junit.jupiter.api.Test;
import pages.FormStudentPage;

public class FormStudentTest extends TestBase {
    FormStudentPage formStudentPage = new FormStudentPage();

    @Test
    void fillFormTest() {
        formStudentPage.openPage()
                .cleanAdvertisementOnPage()
                .setFirstName("Elena")
                .setLastName("Malysheva")
                .setGender("Female")
                .setPhoneNumber("9873058652")
                .setDateOfBirth("13", "July", "1998")
                .setUserEmail("lena.malicheva@mail.ru")
                .setHobbies("Reading")
                .setSubject("Math")
                .setCurrentAddress("Lunnaya 43B str. ")
                .uploadFile("my.png")
                .setState("Uttar Pradesh")
                .setCity("Lucknow")
                .submit();

        formStudentPage.checkResultTable("Student Name", "Elena Malysheva")
                .checkResultTable("Student Email", "lena.malicheva@mail.ru")
                .checkResultTable("Gender", "Female")
                .checkResultTable("Mobile", "9873058652")
                .checkResultTable("Date of Birth", "13 July,1998")
                .checkResultTable("Subjects", "Maths")
                .checkResultTable("Hobbies", "Reading")
                .checkResultTable("Picture", "my.png")
                .checkResultTable("Address", "Lunnaya 43B str. ")
                .checkResultTable("State and City", "Uttar Pradesh Lucknow");
    }

    @Test
    void inputMinimalData() {
        formStudentPage.openPage()
                .cleanAdvertisementOnPage()
                .setFirstName("Elena")
                .setLastName("Malysheva")
                .setGender("Female")
                .setPhoneNumber("9873058652")
                .submit();

        formStudentPage.checkResultTable("Student Name", "Elena Malysheva")
                .checkResultTable("Gender", "Female")
                .checkResultTable("Mobile", "9873058652");

    }

    @Test
    void inputInvalidMobileNumber() {
        formStudentPage.openPage()
                .cleanAdvertisementOnPage()
                .setFirstName("Elena")
                .setLastName("Malysheva")
                .setGender("Female")
                .setPhoneNumber("8987")
                .submit();

        formStudentPage.verifyMobileNumberFieldIsRed();

    }
}





