package guru.qa.pages;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public CalendarComponent setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--022" + day).click();
        return this;
    }
}