package guru.qa.pages;

import com.codeborne.selenide.Conditional;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            NumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit")
                    ;

    public RegistrationFormPage openPage(){
        open("/automation-practice-form");
        $(".practise-form-wrapper").shouldHave(text("Student"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    return this;
    }
    public RegistrationFormPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setgenderWrapper(String value){
        genderWrapperInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setNumber(String value){
       NumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year){
        dateOfBirthInput.click();
        new CalendarComponent().setDate("30", "October", "1998");
        return this;
    }
    public RegistrationFormPage setSubject(String value){
        subjectsInput.setValue(value);
        return this;
    }
    public RegistrationFormPage sethobbiesWrapper(String value){
        hobbiesWrapper.$(byText(value));
        return this;
    }

    public RegistrationFormPage setUploadPicture(String value) {
        uploadPicture.setValue(value);
        return this;
    }
    public RegistrationFormPage setcurrentAddress(String value){
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationFormPage setState(String state) {
       stateInput.setValue(state).pressTab();
        return this;
    }

    public RegistrationFormPage setCity(String city) {
        cityInput.setValue(city).pressTab();
        return this;
    }
    public RegistrationFormPage submit() {
        submitButton.click();
        return this;
    }
    public RegistrationFormPage checkResultsVisible(){
        resultTableComponent.checkVisible();
        return this;
    }
    public RegistrationFormPage checkResult(String key, String value){
        resultTableComponent.checkResult(key, value);
        return this;
    }

}
