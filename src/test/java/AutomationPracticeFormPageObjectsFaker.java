import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class AutomationPracticeFormPageObjectsFaker extends TestBase {
    @DisplayName("Registration form tests with fake data")

    @Test

    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST"), @Tag("FAKER"), @Tag("PRACTICE")})

    public void fillFormsTest() {

        step("Open and fill the registration form page", () -> {
            practiceFormPage.openPage()
                    .setFirstName(firstName)
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

        step("Verify table", () -> {
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
