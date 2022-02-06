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

    @Test
    @Tag("properties")
    void someTest5(){
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "91");
        String browserSize = System.getProperty("browserSize", "300x300");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);
    }
}
