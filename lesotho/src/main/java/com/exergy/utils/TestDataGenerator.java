package com.exergy.utils;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestDataGenerator {

    private static final SecureRandom RANDOM = new SecureRandom();
    public static final String ALPHA_LOWER = "abcdefghijklmnopqrstuvwxyz";
    public static final String ALPHA_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String DIGITS = "0123456789";
    public static final String ALPHANUMERIC = ALPHA_LOWER + ALPHA_UPPER + DIGITS;
    public static final String URL_SAFE = ALPHA_LOWER + ALPHA_UPPER + DIGITS + "-_";
    private static final DateTimeFormatter DD_MM_YYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String IndiaMobileNumberGenerator() {
        final char[] START_DIGITS = {'6', '7', '8', '9'};
        StringBuilder sb = new StringBuilder(10);
        sb.append(START_DIGITS[RANDOM.nextInt(START_DIGITS.length)]);
        for (int i = 1; i < 10; i++) {
            sb.append(RANDOM.nextInt(10));
        }
        return sb.toString();
    }

    private static String generate(int length, String allowedChars) {
        if (length <= 0) throw new IllegalArgumentException("length must be > 0");
        if (allowedChars == null || allowedChars.isEmpty()) throw new IllegalArgumentException("allowedChars must be non-empty");

        StringBuilder sb = new StringBuilder(length);
        int bound = allowedChars.length();
        for (int i = 0; i < length; i++) {
            int idx = RANDOM.nextInt(bound);
            sb.append(allowedChars.charAt(idx));
        }
        return sb.toString();
    }

    public static String generateRandomValue(int length) {
        return generate(length, ALPHA_LOWER);
    }

    public static String generateRandomNumber(int length) {
        return generate(length, DIGITS);
    }

    public int getTodaysDay() {
        return LocalDate.now().getDayOfMonth();
    }

    public static String generateRandomEmail() {
        return generateRandomValue(8) + "@" + generateRandomValue(5) + ".com";
    }

    public static String generateRandomName() {
        int length = RANDOM.nextInt(6) + 5; // Random length between 5 and 10
        StringBuilder sb = new StringBuilder();
        sb.append(ALPHA_UPPER.charAt(RANDOM.nextInt(ALPHA_UPPER.length())));
        for (int i = 1; i < length; i++) {
            sb.append(ALPHA_LOWER.charAt(RANDOM.nextInt(ALPHA_LOWER.length())));
        }
        return sb.toString();
    }

    public static String firstDayOfMonth(int monthsBack) {
        LocalDate now = LocalDate.now();
        LocalDate firstOfTarget = now.withDayOfMonth(1).minusMonths(monthsBack);
        return firstOfTarget.toString(); // yyyy-MM-dd
    }

    public static String firstDayOfMonth() {
        return firstDayOfMonth(0);
    }

    public static String todayDdMmYyyy() {
        return LocalDate.now().format(DD_MM_YYYY);
    }

    public static String dateAfterDays(int daysFromNow) {
        return LocalDate.now().plusDays(daysFromNow).format(DD_MM_YYYY);
    }

    public static String dateYearsBack(int yearsBack) {
        if (yearsBack < 0) throw new IllegalArgumentException("yearsBack must be >= 0");
        return LocalDate.now().minusYears(yearsBack).format(DD_MM_YYYY);
    }

    /**
     * Returns the date that is `yearsBack` years before today formatted as yyyy-MM-dd suitable for input[type=date].
     * yearsBack must be >= 0. Use 0 to get today's date.
     */
    public static String dateYearsBackIso(int yearsBack) {
        if (yearsBack < 0) throw new IllegalArgumentException("yearsBack must be >= 0");
        return LocalDate.now().minusYears(yearsBack).toString(); // ISO_LOCAL_DATE (yyyy-MM-dd)
    }

    public static String formatDate(LocalDate date) {
        if (date == null) throw new IllegalArgumentException("date must not be null");
        return date.format(DD_MM_YYYY);
    }

    public static boolean isReallyBlank(String str) {
        if (str == null) return true;
        return str.replace("\u00A0", "")
                .trim()
                .isEmpty();
    }
}
