package com.example.listadoconciertos;

public class ShowsInfo {
    // Clase destinada a guardar información de la listView para tener los datos separados de la inteligencia del programa.

    private String[] cityList = new String[]{
            "Tarragona", "Múrcia", "Sevilla", "Jaén",
    };

    private String[] cityAddresses = new String[] {
            "C/ de Mallorca, 18, 43001 Tarragona.",
            "C/ Puerta Nueva, 33, 30008 Murcia.",
            "C/ Herramientas, 35, 41006 Sevilla.",
            "Carr. de Madrid, km. 333 s/n, 23009 Jaén",
    };

    private String[] showTime = new String[] {
            "23:00h", "22:00h", "22:00h", "00:30h"
    };


    private String[] discoList = new String[]{
            "Tarraco Arena Plaza", "Sala R.E.M", "Sala Fanatic", "Sala Kharma",
    };

    private int[] logoList = new int[]{
            R.drawable.saikoshowtarragona, R.drawable.saikoshowmurcia, R.drawable.saikoshowsevilla, R.drawable.saikoshowjaen,
    };

    public String[] getCityList() {
        return cityList;
    }

    public String[] getDiscoList() {
        return discoList;
    }

    public int[] getLogoList() {
        return logoList;
    }

    public String[] getCityAddresses() {
        return cityAddresses;
    }

    public String[] getShowTime() { return showTime; }

}
