import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillFormTest() {
        String userName = "Pavel Stoianov";
        String userEmail = "email@test.qaa";
        String currentAddress = "Lenin str. 1";
        String permanentAddress = "Pushkin str. 2";

        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text(userName));
        $("#output").$("#email").shouldHave(text(userEmail));
        $("#output").$("#currentAddress").shouldHave(text(currentAddress));
        $("#output").$("#permanentAddress").shouldHave(text(permanentAddress));
    }
}
