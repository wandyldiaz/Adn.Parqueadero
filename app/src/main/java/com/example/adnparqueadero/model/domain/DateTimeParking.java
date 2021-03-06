package com.example.adnparqueadero.model.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class DateTimeParking implements DateTimeInterface{

    private static final String GMT = "GMT-5";
    private static final String [] dayString={"Domingo", "Lunes", "Martes", "Miercoles",
            "Jueves","Viernes", "Sabado"};

    private String currentTime() {
        String time;
        String hour;
        String minute;
        TimeZone timeZone = TimeZone.getTimeZone(GMT);
        Calendar actualDateTime = Calendar.getInstance(timeZone);
        hour = formatZero(actualDateTime.get(Calendar.HOUR_OF_DAY));
        minute = formatZero(actualDateTime.get(Calendar.MINUTE));
        time = hour + ":" + minute;
        return time;
    }

    private String formatZero(int num) {
        if (num < 10)
            return "0" + num;
        return "" + num;
    }

    private String currentDate() {
        String day;
        String month;
        String year;
        TimeZone timeZone = TimeZone.getTimeZone(GMT);
        Calendar actualDateTime = Calendar.getInstance(timeZone);
        year = String.valueOf(actualDateTime.get(YEAR));
        month = formatZero(actualDateTime.get(MONTH) + 1);
        day = formatZero(actualDateTime.get(DAY_OF_MONTH));
        return (year + "/" + month + "/" + day);
    }

    private String dayOfWeek(String date) {
        int day = Integer.parseInt(date.split("/")[2]);
        int month = Integer.parseInt(date.split("/")[1]);
        int year = Integer.parseInt(date.split("/")[0]);
        TimeZone timeZone = TimeZone.getTimeZone(GMT);
        Calendar calendar = new GregorianCalendar(timeZone);
        calendar.set(year, month - 1, day);
        int numDay = calendar.get(Calendar.DAY_OF_WEEK);
        return dayString[numDay-1];
    }

    @Override
    public String getDayWeek(String date) {
        return dayOfWeek(date);
    }

    @Override
    public String getCurrentTime() {
        return currentTime();
    }

    @Override
    public String getCurrentDate() {
        return currentDate();
    }
}
