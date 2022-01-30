package pro.rvision.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;

public class ParameterizedWEbTest {
    @BeforeEach
    void beforeEcach() {
        open("https://rasp.yandex.ru");
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "Chrome";
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }

    static Stream<Arguments> findTicketSource() {
        return Stream.of(
                Arguments.of("Москва", "Санкт-Петербург", "сегодня"),
                Arguments.of("Минск", "Москва", "завтра")
        );
    }

    @MethodSource("findTicketSource")
    @ParameterizedTest(name = "Тестирование поиска билетов:{0}")
    void findTicket(String from, String to, String date) {

        $("#from").setValue(from);
        $("#to").setValue(to);
        $("#when").click();
        $("#when").setValue(date);
        $(".Button.SearchForm__submit").click();
        $(".LinkBackward__title").shouldHave(Condition.text(from), Condition.text(to));

    }

//    @CsvSource(value = {
//            "Москва", "Санкт-Петербург", "сегодня",
//            "Минск", "Москва", "завтра"
//    })
//    @ParameterizedTest(name = "Тестирование поиска билетов:{0}")
//    void findTicket1(String from, String to, String date) {
//
//        $("#from").setValue(from);
//        $("#to").setValue(to);
//        $("#when").click();
//        $("#when").setValue(date);
//        $(".Button.SearchForm__submit").click();
//        $(".LinkBackward__title").shouldHave(Condition.text(from), Condition.text(to));
//    }

    @ValueSource(strings = {"Москва"})
    @ParameterizedTest(name = "Тестирование поиска билетов:{0}")
    void findTicket2(String from) {
        $("#from").setValue(from);
        $("#to").setValue("Санкт-Петербург");
        $("#when").click();
        $("#when").setValue("сегодня");
        $(".Button.SearchForm__submit").click();
        $(".LinkBackward__title").shouldHave(Condition.text(from), Condition.text("Санкт-Петербург"));
    }
}
