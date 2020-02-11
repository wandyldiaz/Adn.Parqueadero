package com.example.adnparqueadero.model.domain.controler_domain;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class DateTimeParking {
    private static final String GMT="GMT-5";

    private String currentTime(){

        String time;
        String hour;
        String minute;
        TimeZone timeZone = TimeZone.getTimeZone(GMT);
        Calendar actualDateTime = Calendar.getInstance(timeZone);
        hour= String.valueOf(actualDateTime.get(Calendar.HOUR_OF_DAY));
        minute= String.valueOf(actualDateTime.get(Calendar.MINUTE));
        if(Integer.parseInt(hour) < 10)
            hour= "0" + hour ;
        if(Integer.parseInt(minute) < 10)
            minute= "0" + minute ;
        time = hour + ":" + minute;
        return time;
    }

    private String currentDate(){
        String day;
        String month;
        String year;
        TimeZone timeZone = TimeZone.getTimeZone(GMT);
        Calendar actualDateTime = Calendar.getInstance(timeZone);
        year= String.valueOf(actualDateTime.get(YEAR));
        month= String.valueOf(actualDateTime.get(MONTH) + 1);
        day= String.valueOf(actualDateTime.get(DAY_OF_MONTH));
        if(Integer.parseInt(month)< 10)
            month= "0" + month ;
        if(Integer.parseInt(day) < 10)
            day= "0" + day ;
        return (year + "/" + month + "/" + day);
    }

    private String dayOfWeek(String date)
    {
        int day= Integer.parseInt(date.split("/")[2]);
        int month= Integer.parseInt(date.split("/")[1]);
        int year= Integer.parseInt(date.split("/")[0]);
        TimeZone timeZone = TimeZone.getTimeZone(GMT);
        String dayString;
        Calendar calendar = new GregorianCalendar(timeZone);
        calendar.set(year, month-1, day);
        int nD=calendar.get(Calendar.DAY_OF_WEEK);
        if (nD == 2) {
            dayString = "Lunes";
        } else if (nD == 3) {
            dayString = "Martes";
        } else if (nD == 4) {
            dayString = "Miercoles";
        } else if (nD == 5) {
            dayString = "Jueves";
        } else if (nD == 6) {
            dayString = "Viernes";
        } else if (nD == 7) {
            dayString = "Sabado";
        } else if (nD == 1) {
            dayString = "Domingo";
        } else{
            dayString="";
        }
        return dayString;
    }


    public String getDayWeek(String date) {
        return dayOfWeek(date);
    }

    public String getCurrentTime() {
        return currentTime();
    }

    public String getCurrentDate() {
        return currentDate();
    }




}
