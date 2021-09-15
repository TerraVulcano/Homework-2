import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void SimpleFillTest() {
        String firstName = "Max";
        String lastName = "Maximovich";
        String userEmail = "Max99@mmail.com";
        String userNumber = "1234567890";
        String currentAddress = "My Current Address 1234";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue(userNumber);
        $("#currentAddress").setValue(currentAddress);
        $("#submit").click();

        $("#output").shouldHave(text(firstName), text("aa@aa.aa"), text("My Current Address 1234"), text("y Permanent Address 4321"));
    }
}
