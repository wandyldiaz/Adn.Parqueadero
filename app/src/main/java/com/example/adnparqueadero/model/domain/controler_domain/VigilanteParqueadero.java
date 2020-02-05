package com.example.adnparqueadero.model.domain.controler_domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class VigilanteParqueadero {
    protected static final String GMT="GMT-5";
    protected static final SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");



    public String getTime(){

        String time;
        String hour;
        String minute;
        TimeZone timeZone = TimeZone.getTimeZone(GMT);
        Calendar actualDateTime = Calendar.getInstance(timeZone);

        hour= String.valueOf(actualDateTime.get(actualDateTime.HOUR_OF_DAY));
        minute= String.valueOf(actualDateTime.get(actualDateTime.MINUTE));


        if(actualDateTime.get(actualDateTime.HOUR_OF_DAY) < 10)
            hour= "0" + hour ;
        if(actualDateTime.get(actualDateTime.MINUTE) < 10)
            minute= "0" + minute ;

        time = hour + ":" + minute;

        return time;
    }

    public String getDate(){
        String day;
        String month;
        String year;
        TimeZone timeZone = TimeZone.getTimeZone(GMT);
        Calendar actualDateTime = Calendar.getInstance(timeZone);

        year= String.valueOf(actualDateTime.get(actualDateTime.YEAR));
        month= String.valueOf(actualDateTime.get(actualDateTime.MONTH) + 1);
        day= String.valueOf(actualDateTime.get(actualDateTime.DAY_OF_MONTH));

        if((actualDateTime.get(actualDateTime.MONTH) + 1) < 10)
            month= "0" + month ;
        if(actualDateTime.get(actualDateTime.DAY_OF_MONTH) < 10)
            day= "0" + day ;


        String dateTime = year + "/" + month + "/" + day;
        return dateTime;
    }

}
