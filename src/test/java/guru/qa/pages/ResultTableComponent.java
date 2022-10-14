package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    private final static String TITLE_TEXT = "Thanks for submitting the form";
    private final SelenideElement
            resultTable = $(".table"),
            modalHeader = $(".modal-header");

    public ResultTableComponent checkResult(String key, String value) {
        $(resultTable).$(byText(key)).parent().lastChild().shouldHave(text(value));
        return this;
    }

    public ResultTableComponent checkVisible() {
        $(modalHeader).shouldHave(text(TITLE_TEXT));
        return this;
}}
