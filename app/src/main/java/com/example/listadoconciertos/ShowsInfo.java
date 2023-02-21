package com.example.listadoconciertos;

public class ShowsInfo {

    private String[] cityList = new String[]{
            "Tarragona", "Múrcia", "Sevilla", "Jaén",
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
}
