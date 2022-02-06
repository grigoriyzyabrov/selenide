package pro.rvision.tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {
    @Test
    void someTest1(){
        String somevalue = System.getProperty("somekey");
        System.out.println(somevalue);
    }

    @Test
    void someTest2(){
        System.setProperty("somekey", "red value");
        String somevalue = System.getProperty("somekey");
        System.out.println(somevalue);
    }
    @Test
    void someTest3(){
        String somevalue = System.getProperty("somekey", "blue value");
        System.out.println(somevalue);
    }

    @Test
    @Tag("properties")
    void someTest4(){
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }
}
