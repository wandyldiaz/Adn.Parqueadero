package com.example.adnparqueadero.model.domain.controler_domain;

import java.util.Date;

public class VigilanteParqueaderoSalida extends VigilanteParqueadero {



    public static long getDifferenceBetwenDates(Date dateInicio, Date dateFinal) {



        long milliseconds = dateFinal.getTime() - dateInicio.getTime();
        int seconds = (int) (milliseconds / 1000) % 60;
        int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
        int hours =(int) milliseconds / (1000 * 60 * 60);

        return (minutes+(hours*60));
    }
}
