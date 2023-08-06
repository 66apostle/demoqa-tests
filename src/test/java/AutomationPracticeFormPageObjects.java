import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class AutomationPracticeFormPageObjects extends TestBase {
    @CsvFileSource(resources = "/TestData.csv")

    @CsvSource({
            "Pavel, Stoianov, mail@test.qa, 0123456789, Lenina str.1, Arts",
            "Ivan, Ivanov, fake@mail.qa, 9876543210, Pushkina str.2, Math",
            "Petr, Petrov, another@mail.qa, 0321654987, Maiakovskii str.3, Computer Science"
    })
    @ParameterizedTest(name = "Fill form parametrized test")

    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST"), @Tag("PRACTICE")})

    void fillFormsTest
            (String firstName,
             String lastName,
             String email,
             String phone,
             String address,
             String subject) {
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

    }
}
