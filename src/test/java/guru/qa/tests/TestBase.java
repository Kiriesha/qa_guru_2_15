package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    static String firstName = "Anastasiia",
            lastName = "Kireeva",
            email = "aaakireeva@yandex.ru",
            Number = "9295722597",
            day = "22",
            month = "October",
            year = "1998";

    @BeforeAll
    static void configure(){
        //Добавляем URL, чтоб не прописывать каждый раз
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        //Configuration.browser = "chrome";
    }
}
