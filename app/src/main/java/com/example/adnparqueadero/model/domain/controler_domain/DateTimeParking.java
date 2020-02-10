package com.example.adnparqueadero.model.domain.controler_domain;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class DateTimeParking {
    private static final String GMT="GMT-5";
    private static final String FORMAT_DATE =("yyyy/MM/dd HH:mm");
    private SimpleDateFormat simpleDateFormat;

    @SuppressLint("SimpleDateFormat")
    public DateTimeParking() {
        this.simpleDateFormat = new SimpleDateFormat(FORMAT_DATE);
    }

    private String time(){

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

    private String date(){
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

    private String diaSemana (String fecha)
    {
        int dia= Integer.parseInt(fecha.split("/")[2]);
        int mes= Integer.parseInt(fecha.split("/")[1]);
        int ano= Integer.parseInt(fecha.split("/")[0]);
        TimeZone timeZone = TimeZone.getTimeZone(DateTimeParking.getGMT());
        String letraDia;
        Calendar calendar = new GregorianCalendar(timeZone);
        calendar.set(ano, mes-1, dia);
        int nD=calendar.get(Calendar.DAY_OF_WEEK);
        if (nD == 2) {
            letraDia = "Lunes";
        } else if (nD == 3) {
            letraDia = "Martes";
        } else if (nD == 4) {
            letraDia = "Miercoles";
        } else if (nD == 5) {
            letraDia = "Jueves";
        } else if (nD == 6) {
            letraDia = "Viernes";
        } else if (nD == 7) {
            letraDia = "Sabado";
        } else if (nD == 1) {
            letraDia = "Domingo";
        } else{
            letraDia="";
        }
        return letraDia;
    }

    public static String getGMT() {
        return GMT;
    }

    public String getDiaSemana(String fecha) {
        return diaSemana(fecha);
    }

    public String getTime() {
        return time();
    }

    public String getDate() {
        return date();
    }
    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }


    public double getDifferenceBetwenDatesMinutes(String fechaInicio, String fechaFinal) throws ParseException {
        Date dateInicio= getSimpleDateFormat().parse(fechaInicio);
        Date dateFinal=  getSimpleDateFormat().parse(fechaFinal);
        long milliseconds = dateFinal.getTime() - dateInicio.getTime();
        //long seconds =  (milliseconds / 1000) % 60;
        // long minutes =  ((milliseconds / (1000 * 60)) % 60);
        //int hours = (int) (milliseconds / (1000 * 60 * 60));
        //return (minutes+(hours*60));
        // return ((int) (milliseconds / (1000 * 60 * 60))+(minutes>0?1:0));
        return (milliseconds / (1000 * 60 * 60));
    }

}
