import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class AutomationPracticeFormPageObjectsFakerAllure extends TestBase {
    @DisplayName("Registration form tests with fake data")

    @Test

    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST"), @Tag("FAKER"), @Tag("PRACTICE")})

    public void fillFormsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open registration form page", () -> {
            practiceFormPage.openPage();
        });

        step("Fill the form fields", () -> {
            practiceFormPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setNumber(phone)
                    .setAddress(address)
                    .setSubject(subject)
                    .setGender("1")
                    .setBirthDate("09", "July", "1994")
                    .setHobbies("1", "2", "3")
                    .uploadImage()
                    .setStateCity("Rajasthan", "Jaipur");
        });

        step("Verify filled form table", () -> {
            practiceFormPage.verifyResultsModal()
                    .verifyResult("Student Name", firstName + " " + lastName)
                    .verifyResult("Student Email", email)
                    .verifyResult("Gender", "Male")
                    .verifyResult("Mobile", phone)
                    .verifyResult("Date of Birth", "09 July,1994")
                    .verifyResult("Subjects", subject)
                    .verifyResult("Hobbies", "Reading, Music")
                    .verifyResult("Address", address)
                    .verifyResult("State and City", "Rajasthan Jaipur");
        });


    }
}
