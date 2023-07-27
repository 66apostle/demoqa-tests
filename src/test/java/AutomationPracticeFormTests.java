import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class AutomationPracticeFormTests {
   @BeforeAll
   static void beforeAll () {
       Configuration.browserSize = "1920x1080";
       Configuration.baseUrl = "https://demoqa.com";
   }
    @Test
    void fillFormsTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Pavel");
        $("#lastName").setValue("Stoianov");
        $("#userEmail").setValue("mail@test.qa");
        $("#userNumber").setValue("0123456789");
        $("#currentAddress").setValue("Lenina str.1");
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("[for=gender-radio-1]").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day--009").click();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFromClasspath("img/AutomationPracticeFormImg.jpg");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();

        $(".modal-dialog").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Pavel"), text("Stoianov"));
    }
}
