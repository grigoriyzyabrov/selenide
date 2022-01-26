package pro.rvision.tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.List;


public class FiveHomeworkTest extends TestBase {

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String number = faker.number().digits(11);
    String file = ("1.png");
    String address = faker.address().fullAddress();
    String state = "NCR";
    String city = "Noida";

    @Test
    void firstTest() {

        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastname(lastName)
                .setEmailAddress()
                .choiceGender()
                .setPhoneNumber(number)
                .calendarComponent.setDate("30", "July", "2008");
        registrationPage
                .selectHobbies((List.of("Music", "Sports", "Reading")))
                .upLoadFile(file)
                .setAdress(address)
                .setStateAndCity(state, city)
                .submit();
        registrationPage.checkResultsValue("Student Name", firstName + " " + lastName);

    }
}
