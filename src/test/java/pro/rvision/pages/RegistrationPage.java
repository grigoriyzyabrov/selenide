package pro.rvision.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import pro.rvision.pages.components.CalendarComponent;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;
import static pro.rvision.utils.RandomUtils.getRandomEmail;

public class RegistrationPage {

    Faker faker = new Faker();
    private final String FORM_TITLE = "Student Registration Form";
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable = $(".modal-content"),
            formTitle = $(".practice-form-wrapper"),
            emailField = $("#userEmail"),
            choiceGender = $("#genterWrapper").$(byText("Male")),
            phoneNumber = $("#userNumber"),
            subject = $("#subjectsInput"),
            studentHobbies = $("#hobbiesWrapper"),
            upLoadButton = $("#uploadPicture"),
            adress = $("#currentAddress"),
            choiceState = $("#state"),
            stateField = $("#stateCity-wrapper"),
            choiceCity = $("#city"),
            cityField = $("#stateCity-wrapper"),
            submitButton = $("#submit");






    public CalendarComponent calendarComponent = new CalendarComponent();
    public RegistrationPage openPage(){
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
//сценарный подход (несколько действий в одном методе)
        return this;
    }
    public RegistrationPage typeFirstName(String value){
        firstNameInput.setValue(value);
//        степовой подход (одно действие - один метод)
        return this;
    }
    public RegistrationPage typeLastname(String value){
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
    public  RegistrationPage setEmailAddress(){
        emailField.setValue(getRandomEmail());
        return this;

    }
    public RegistrationPage choiceGender(){
        choiceGender.click();
        return this;
    }
    public RegistrationPage setPhoneNumber(String number){
        phoneNumber.setValue(number);
        return this;
    }
    public RegistrationPage setSubject(String value){
        subject.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage selectHobbies(List<String> hobbies) {
        hobbies.forEach(h -> studentHobbies.$(byText(h)).click());

        return this;
    }
    public  RegistrationPage upLoadFile(String file){
        upLoadButton.uploadFromClasspath(file);
        return this;
    }
    public RegistrationPage setAdress(String value){
        adress.setValue(value);
        return this;
    }
    public RegistrationPage setStateAndCity(String state, String city){
        choiceState.scrollTo().click();
        stateField.$(byText(state)).click();
        choiceCity.click();
        cityField.$(byText(city)).click();
        return this;
    }
    public RegistrationPage submit(){
        submitButton.click();
        return this;
    }

}

