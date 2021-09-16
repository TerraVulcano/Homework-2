import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

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
        File pic = new File("src/test/resourses/vulcano.jpg");

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(myMonth);
        $(".react-datepicker__year-select").selectOptionByValue(myYear);
        $(".react-datepicker__day--014").doubleClick();
        $("#subjectsInput").setValue("art");
        $("#subjectsInput").pressEnter();
        $("#subjectsInput").setValue("ma");
        $("#subjectsInput").pressEnter();

        $("[for='hobbies-checkbox-3']").click();

        $("#uploadPicture").uploadFile(pic);

        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue("Utt");
        $("#react-select-3-input").pressEnter();
        $("#react-select-4-input").setValue("Agr");
        $("#react-select-4-input").pressEnter();


        $("#submit").click();




    //    $("#output").shouldHave(text(firstName), text("aa@aa.aa"), text("My Current Address 1234"), text("y Permanent Address 4321"));
    }
}
