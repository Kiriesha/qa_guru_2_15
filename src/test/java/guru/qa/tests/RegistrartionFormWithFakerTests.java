package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrartionFormWithFakerTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = faker.demographic().sex();
    String Number = faker.phoneNumber().subscriberNumber(10);
    String day = String.valueOf(faker.number().numberBetween(1, 31));
    String month = String.valueOf(faker.number().numberBetween(1, 12));
    String year = String.valueOf(faker.number().numberBetween(1980, 1995));
    String address = faker.address().fullAddress();
    String picture = "src/cat.jpg";
    String hobby = "Sports";
    String subject = "Maths";
    String state = "NCR";
    String city = "Delphi";

    @BeforeAll
    static void configure() {
        //Добавляем URL, чтоб не прописывать каждый раз
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        //Configuration.browser = "chrome";
    }


    @Test
    void fillTests() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setgenderWrapper(gender)
                .setNumber(Number)
                .setBirthDate(day, month, year)
                .sethobbiesWrapper(hobby)
                .setSubject(subject)
                .setUploadPicture(picture)
                .setcurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

       registrationFormPage.checkResultsVisible()
                .checkResult("Student Name", (firstName + " " + lastName))
                .checkResult("Student Email", email)
               .checkResult("Gender",gender)
               .checkResult("Mobile",Number)
                .checkResult("Date of Birth", ((day + " " + month + "," + year)))
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", "src/cat.jpg")
                .checkResult("Address", address)
                .checkResult("State and City", "NCR Delhi");
    }
}


