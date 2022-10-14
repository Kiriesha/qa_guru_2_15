package guru.qa.pages;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class RegistrationFormWIthPageObject {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        //Добавляем URL, чтоб не прописывать каждый раз
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

        @Test
        void fillFormTest(){
            registrationFormPage.openPage()
                .setFirstName("Anastasia")
                .setLastName("Kireeva")
                .setEmail("aaakireeva@yandex.ru")
                .setgenderWrapper("Female")
                .setNumber("0123456789")
                .setBirthDate("30", "October", "1998")
                .setSubject("Maths")
                .sethobbiesWrapper("Sports")
                .setUploadPicture("src/cat.jpg")
                .setcurrentAddress("Ulitsa Pravdy")
                .setState("NCR")
                .setCity("Delphi")
                .submit();

          registrationFormPage.checkResultsVisible()
                    .checkResult("Student Name","Kireeva Anastasia")
                    .checkResult("Student Email","aaakireeva@yandex.ru")
                    .checkResult("Gender","Female")
                    .checkResult("Mobile","0123456789")
                    .checkResult("Date of Birth", "30 October,1998")
                    .checkResult("Subjects", "Maths")
                    .checkResult("Hobbies", "Sports")
                    .checkResult("Address", "Ulitsa Pravdy")
                    .checkResult("State and City", "NCR Delhi");
    }
}