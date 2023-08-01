package pages;


import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsComponent registrationResultsComponent = new RegistrationResultsComponent();
    private final String titleText = "Practice Form";
    private final SelenideElement
                firstNameInput = $("#firstName"),
                lastNameInput = $("#lastName"),
                emailInput = $("#userEmail"),
                numberInput = $("#userNumber"),
                addressInput = $("#currentAddress"),
                subjectInput = $("#subjectsInput");


    public PracticeFormPage openPage () {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text(titleText));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName (String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setEmail (String value) {
        emailInput.setValue(value);
        return this;
    }

    public PracticeFormPage setNumber (String value) {
        numberInput.setValue(value);
        return this;
    }

    public PracticeFormPage setAddress (String value) {
        addressInput.setValue(value);
        return this;
    }

    public PracticeFormPage setSubject (String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setGender (String value) {
        $("[for=gender-radio-" + value + "]").click();
        return this;
    }

    public PracticeFormPage setBirthDate (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setHobbies (String sports, String reading, String music) {
        $("[for=hobbies-checkbox-" + sports + "]").click();
        $("[for=hobbies-checkbox-" + reading + "]").click();
        $("[for=hobbies-checkbox-" + music +"]").click();
        return this;
    }

    public PracticeFormPage uploadImage () {
        $("#uploadPicture").uploadFromClasspath("img/AutomationPracticeFormImg.jpg");
        $("#state").click();
        return this;
    }

    public PracticeFormPage setStateCity (String state, String city) {
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();
        return this;
    }

    public PracticeFormPage verifyResultsModal () {
        registrationResultsComponent.verifyModalAppears();
        return this;
    }

    public PracticeFormPage verifyResult (String key, String value) {
        registrationResultsComponent.verifyResult(key, value);
        return this;
    }
}
