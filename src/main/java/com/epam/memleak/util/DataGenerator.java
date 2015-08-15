package com.epam.memleak.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.epam.memleak.weather.model.City;
import com.epam.memleak2.model.Address;

public class DataGenerator {

    private static final int CITY_ABBREVIATION_SIZE = 2;
    private static final int ADDRESS_ABBREVIATION_SIZE = 2;
    private static final int TEMP_RANGE = 40;
    private static final int TEMP_OFFSET = 15;
    private static final int PRESSURE_RANGE = 70;
    private static final int PRESSURE_OFFSET = 980;
    private static final int HUMIDITY_RANGE = 54;
    private static final int HUMIDITY_OFFSET = 45;
    private static final int DATE_FROM = 2014;
    private static final int DATE_TO = 2015;
    private static final int ID_RANGE = 10000; 

    private static final Random random = new Random();
    private static final char[] capitalLetters = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();

    public static City generateCity() {
        char[] result = new char[CITY_ABBREVIATION_SIZE];
        for (int i = 0; i < CITY_ABBREVIATION_SIZE; i++) {
            int randomInt = random.nextInt(capitalLetters.length);
            result[i] = capitalLetters[randomInt];
        }
        City city = new City();
        city.setCityAbbreviation(new String(result));
        return city;
    }

    // used in v2
    public static Address generateAddress() {
        char[] result = new char[ADDRESS_ABBREVIATION_SIZE];
        for (int i = 0; i < ADDRESS_ABBREVIATION_SIZE; i++) {
            int randomInt = random.nextInt(capitalLetters.length);
            result[i] = capitalLetters[randomInt];
        }
        Address addr = new Address();
        addr.setAddress(new String(result));
        return addr;
    }

    public static int geterateRandomId() {
        return random.nextInt(ID_RANGE);
    }

    public static int generateTemp() {
        return random.nextInt(TEMP_RANGE) - TEMP_OFFSET;
    }

    public static double generateTemperature() {
        return random.nextDouble();
    }

    public static int generatePressure() {
        return random.nextInt(PRESSURE_RANGE) + PRESSURE_OFFSET;
    }

    public static int generateHumidity() {
        return random.nextInt(HUMIDITY_RANGE) + HUMIDITY_OFFSET;
    }

    // used in v2
    /*
    public static Date generateDate() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(0);
        int year = randBetween(DATE_FROM, DATE_TO);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return gc.getTime();
    }
    */
    public static Date generateDate() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(0);
        gc.set(gc.YEAR, 2015);
        int dayOfYear = randBetween(1, 7);
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return gc.getTime();
    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    public static void main(String[] args) {
        Set<Date> ds = new HashSet<Date>();
        for (int i = 0; i < 50; i++) {
            Date d = generateDate();
            ds.add(d);
        }
        System.out.println(ds.size());

    }
}
