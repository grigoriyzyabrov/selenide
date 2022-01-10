package pro.rvision;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstHomeworkTest {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void firstTest(){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivan@Ivanov.com");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("8000111222");
//
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $("[aria-label$='July 30th, 2008']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1.png");

        $("#currentAddress").setValue("Some address 1");

        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").click();

        $("td:nth-child(2)").shouldHave(Condition.text("Ivan Ivanov"));
        $("tr:nth-child(2) > td:nth-child(2)").shouldHave(Condition.text("Ivan@Ivanov.com"));
        $("tr:nth-child(3) > td:nth-child(2)").shouldHave(Condition.text("Male"));
        $("tr:nth-child(4) > td:nth-child(2)").shouldHave(Condition.text("8000111222"));
        $("tr:nth-child(5) > td:nth-child(2)").shouldHave(Condition.text("30 July,2008"));
        $("tr:nth-child(6) > td:nth-child(2)").shouldHave(Condition.text("Maths"));
        $("tr:nth-child(7) > td:nth-child(2)").shouldHave(Condition.text("Sports"));
        $("tr:nth-child(8) > td:nth-child(2)").shouldHave(Condition.text("1.png"));
        $("tr:nth-child(9) > td:nth-child(2)").shouldHave(Condition.text("Some address 1"));
        $("tr:nth-child(10) > td:nth-child(2)").shouldHave(Condition.text("NCR Noida"));
//        firstName
//        lastName
//        userEmail
//        gender-radio-1
//        userNumber
//        dateOfBirthInput
//        subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3
//         hobbies-checkbox-1
//        uploadPicture
//          currentAddress
//         css-1wa3eu0-placeholder
//        react-select-3-option-0

//
    }
}
