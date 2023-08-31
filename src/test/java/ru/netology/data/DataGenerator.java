package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    private String generateDate(int addDay) {
        return LocalDate.now().plusDays(addDay).format(DateTimeFormatter.ofPattern("dd.MM.yyyyy"));
    }

    public static String generateCity() {
        var city = new String[]{
                "Москва", "Санкт-Петербург", "Волгоград",
                "Воронеж", "Екатеринбург", "Казань", "Краснодар",
                "Нижний Новгород", "Новосибирск", "Пермь", "Ростов-на-Дону", "Самара" };
        return city[new Random().nextInt(city.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generatorUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }
    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}

