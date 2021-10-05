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
        String userEmail = "Max88@mmail.com";
        String userNumber = "1234567890";
        String currentAddress = "My Current Address 1234";
        String myMonth = "4";
        String myYear = "1988";
        String subject = "Chemistry";
        String picture = "vulcano.jpg";
        String state = "Rajasthan";
        String city = "Jaipur";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(myMonth);
        $(".react-datepicker__year-select").selectOptionByValue(myYear);
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                        text(userEmail),
                        text("Male"),
                        text(userNumber),
                        text("14 May,1988"),
                        text(subject),
                        text("Music"),
                        text(picture),
                        text(currentAddress),
                        text(state + " " + city));
    }
}
