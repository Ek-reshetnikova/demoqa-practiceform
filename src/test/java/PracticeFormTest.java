import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Kate");
        $("#lastName").setValue("Reshetnikova");
        $("#userEmail").setValue("ek.karzaeva@yandex.ru");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("79854497301");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--002:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").val("English").pressEnter();
        $("#subjectsInput").val("Arts").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("cat.png");
        $("#currentAddress").setValue("Some street 1");
        $("#react-select-3-input").val("NCR").pressEnter();
        $("#react-select-4-input").val("Delhi").pressEnter();
        $("#submit").pressEnter();


        $(".table-responsive").shouldHave(
                text("Kate Reshetnikova"),
                text("ek.karzaeva@yandex.ru"),
                text("Female"),
                text("7985449730"),
                text("02 August,1994"),
                text("English, Arts"),
                text("Sports"),
                text("cat.png"),
                text("Some street 1"),
                text("NCR Delhi"));

    }
}