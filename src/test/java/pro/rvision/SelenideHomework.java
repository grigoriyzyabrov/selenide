package pro.rvision;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideHomework {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }


    @Test
    void wikiTest (){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
//        $(".wiki-rightbar").shouldHave(Condition.text("SoftAssertions"));
        $$(".js-wiki-sidebar-toggle-display ul li").findBy(text("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
