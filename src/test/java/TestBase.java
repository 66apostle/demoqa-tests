import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.PracticeFormPage;
import pages.helpers.Attach;

public class TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phone = faker.number().digits(10);
    String address = faker.address().fullAddress();
    String subject = "Arts";

    @AfterEach
    public void addAttachments() {
        Attach.screenshotAs("lastScreenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
    }
}


