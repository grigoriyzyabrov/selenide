package pro.rvision.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }
//    метод для генерации чисел небольшой длины
    public static int getRandomInt(int min, int max) {
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }
//   метод для генерации чисел большой длины
    public static Long getRandomLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }
//    метод для генерации телефонных номеров
    public static String getRandomPhone() {
        return getRandomLong(11111111111111111L, 99999999999999999L) + "";
    }
//    метод для генерации номера телефон с кодом (не будет работать без метода выше)
    public static String getRandomPhone(String code) {
        return code + getRandomPhone();
    }
//    аналог методов выше
    public static String getDifficultRandomPhone(String code) {
        return code + " (" + getRandomLong(111L, 999L) + ") " + getRandomLong(11111L, 999999L) + "-" + getRandomLong(111L, 999999L);
    }
//    метод для рандомного емэйла
    public static String getRandomEmail() {
        String emailDomain = "@qa.guru";

        return getRandomString(10) + emailDomain;
    }

}
