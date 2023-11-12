package data;

import com.github.javafaker.Faker;

import java.util.Locale;


public class TestData {
    static Faker faker = new Faker(new Locale("en-GB"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            streetAddress = faker.address().streetAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(1, 30)),
            month = faker.options().option("January", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            year = String.valueOf(faker.number().numberBetween(1980, 2000)),
            subjects = faker.options().option("Maths", "Accounting", "Arts", "Social Studies"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setRandomCity(state);
    public static String setRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return state;
        }

    }}