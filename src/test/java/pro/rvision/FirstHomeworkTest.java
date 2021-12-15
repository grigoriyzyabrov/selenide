package pro.rvision;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class FirstHomeworkTest {
    @Test
    void firstTest(){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivan@Ivanov.com");
        $("#gender-radio-1").isSelected();
        $("#userNumber").setValue("80001112221");
//        $("#dateOfBirthInput").setValue("06 Dec 1921");
        $("#subjectsContainer > div > div.subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi.css-1hwfws3").setValue("m");
        $("#react-select-2-option-0").click();
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
