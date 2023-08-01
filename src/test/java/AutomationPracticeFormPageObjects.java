import org.junit.jupiter.api.Test;
public class AutomationPracticeFormPageObjects extends TestBase {
    @Test
    void fillFormsTest() {

       String firstName = "Pavel";
       String lastName = "Stoianov";

        practiceFormPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail("mail@test.qa")
                        .setNumber("0123456789")
                        .setAddress("Lenina str.1")
                        .setSubject("Computer Science")
                        .setGender("1")
                        .setBirthDate("09","July", "1994")
                        .setHobbies("1", "2", "3")
                        .uploadImage()
                        .setStateCity("Rajasthan","Jaipur");

        practiceFormPage.verifyResultsModal()
                        .verifyResult("Student Name", firstName + " " + lastName)
                        .verifyResult("Student Email", "mail@test.qa")
                        .verifyResult("Gender", "Male")
                        .verifyResult("Mobile", "0123456789")
                        .verifyResult("Date of Birth", "09 July,1994")
                        .verifyResult("Subjects", "Computer Science")
                        .verifyResult("Hobbies", "Reading, Music")
                        .verifyResult("Address", "Lenina str.1")
                        .verifyResult("State and City", "Rajasthan Jaipur");

    }
}
