package pro.rvision.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParameterizedTest{
    @Test
    void debugTest(){
        Configuration.holdBrowserOpen = true;
        open("https://rasp.yandex.ru");
        $("#from").setValue("Москва");
        $("#to").setValue("Минск");
        $("#when").click();
        $("#when").setValue("сегодня");
        $(".Button.SearchForm__submit").click();
    }
}
