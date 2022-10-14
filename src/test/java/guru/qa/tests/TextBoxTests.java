package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

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
        $("#firstName").setValue("Anastasia");
        $("#lastName").setValue("Kireeva");
        $("#userEmail").setValue("aaakireeva@yandex.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("0123456789");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--022").click();

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

        $(".table-responsive").shouldHave(text("Anastasia Kireeva"));
        $(".table-responsive").shouldHave(text("aaakireeva@yandex.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("0123456789"));
        $(".table-responsive").shouldHave(text("22 October,1998"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("Ulitsa Pravdy"));
        $(".table-responsive").shouldHave(text("NCR"));
        $(".table-responsive").shouldHave(text("Delhi"));
    }
}
