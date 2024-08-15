package ru.netology.delivery.data;

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

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        String[] cities = {"Сыктывкар", "Екатеринбург", "Севастополь", "Ханты-Мансийск", "Махачкала", "Красногорск", "Воронеж", "Элиста", "Рязань", "Чита",
                "Майкоп", "Симферополь", "Йошкар-Ола", "Саранск", "Якутск", "Нарьян-Мар", "Казань", "Кызыл", "Ижевск", "Абакан", "Грозный",
                "Самара", "Саратов", "Южно-Сахалинск", "Белгород", "Смоленск", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Ульяновск", "Челябинск",
                "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Курган", "Курск", "Липецк", "Магадан", "Магас", "Мурманск",
                "Чебоксары", "Барнаул", "Петрозаводск", "Петропавловск-Камчатский", "Краснодар", "Красноярск", "Пермь", "Владивосток", "Ставрополь", "Хабаровск",
                "Нижний Новгород", "Великий Новгород", "Новосибирск", "Омск", "Оренбург", "Орёл", "Пенза", "Псков", "Ростов-на-Дону", "Черкесск",
                "Благовещенск", "Архангельск", "Астрахань", "Горно-Алтайск", "Брянск", "Владимир", "Волгоград", "Вологда", "Нальчик", "Иваново", "Иркутск",
                "Ярославль", "Москва", "Санкт-Петербург", "Уфа", "Биробиджан", "Владикавказ", "Улан-Удэ", "Анадырь", "Салехард"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            Faker faker = new Faker(new Locale(locale));
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
