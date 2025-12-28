package utils;

import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDataUtils {

    private static final Faker faker = new Faker(new Locale("pl"));

    private RandomDataUtils() {
    }

    public static String randomFirstName() {
        return faker.name().firstName();
    }

    public static String randomLastName() {
        return faker.name().lastName();
    }

    public static String randomFullName() {
        return faker.name().fullName();
    }

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomUniqueEmail() {
        String uuidPart = faker.internet().uuid().substring(0, 8);
        return "test_" + uuidPart + "@example.com";
    }

    public static String randomPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public static String randomAddress() {
        String street = faker.address().streetName();
        String buildingNumber = faker.address().buildingNumber();
        String city = faker.address().city();
        String postalCode = faker.address().zipCode(); // np. 00-123
        return String.format("%s %s, %s %s", street, buildingNumber, postalCode, city);
    }

    public static String randomPostalCode() {
        return faker.address().zipCode();
    }

    public static String randomCity() {
        return faker.address().city();
    }

    public static String randomUsername() {
        return faker.name().username();
    }

    public static String randomSentence() {
        return faker.lorem().sentence();
    }

    public static String randomParagraph() {
        return faker.lorem().paragraph();
    }

    public static LocalDate randomDateBetween(LocalDate start, LocalDate end) {
        long startEpochDay = start.toEpochDay();
        long endEpochDay = end.toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1);
        return LocalDate.ofEpochDay(randomDay);
    }

    public static LocalDate randomDateLastDays(int daysBack) {
        LocalDate now = LocalDate.now();
        LocalDate start = now.minusDays(daysBack);
        return randomDateBetween(start, now);
    }
}
