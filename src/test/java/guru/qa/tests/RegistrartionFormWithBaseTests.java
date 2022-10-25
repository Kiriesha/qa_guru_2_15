package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static guru.qa.tests.TestData.Number;
import static guru.qa.tests.TestData.*;

public class RegistrartionFormWithBaseTests extends TestBase{

    //String firstName = "Anastasiia";
    // String lastName = "Kireeva";
    //String email = "aaakireeva@yandex.ru";
    //String Number = "9295722597";
    //String day = "22";
    //String month = "October";
    //String year = "1998";

//    String firstName;
//    String lastName;
//    String email;
//    String Number;
//    String day;
//    String month;
//    String year;
//
//    @BeforeEach
//    void prepareTestData (){
//        String firstName = "Anastasiia";
//        String lastName = "Kireeva";
//        String email = "aaakireeva@yandex.ru";
//        String Number = "9295722597";
//        String day = "22";
//        String month = "October";
//        String year = "1998";
//    }

    @BeforeAll
    static void configure(){
        //Добавляем URL, чтоб не прописывать каждый раз
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        //Configuration.browser = "chrome";
    }


    File picture = new File("src/cat.jpg");

    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue(Number);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0"+ day).click();

        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(picture);
        $("#currentAddress").setValue("Ulitsa Pravdy");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();

        $("#submit").click();

        $(".table-responsive table").shouldHave(text(firstName), text(lastName),
                text(email), text(Number),
                text(day + "" + month + "," + year));
}
}
