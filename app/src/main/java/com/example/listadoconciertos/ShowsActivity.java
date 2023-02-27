package com.example.listadoconciertos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShowsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private MediaPlayer btnMusic; // Obtenemos el objeto MediaPlayer con la canción que queremos que se reproduzca en la activity.
    private int volume = 0; // Si 0, la música se escucha, 1, no se escucha.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Quitamos la barra superior en la activity.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.shows_activity);

        btnMusic = MediaPlayer.create(ShowsActivity.this, R.raw.saikoshowlistsong); // Obtenemos el objeto MediaPlayer con la canción que queremos que se reproduzca en la activity.
        btnMusic.start();


        ShowsInfo sI = new ShowsInfo();
        String[] cityList = sI.getCityList();
        String[] discoList = sI.getDiscoList();
        int[] logoList = sI.getLogoList();
        String[] cityAddresses = sI.getCityAddresses();
        String[] showTime = sI.getShowTime();

        List<HashMap<String, String>> hashList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < cityList.length; i++) {
            HashMap<String, String> hm = new HashMap<String, String>(); // Agregamos elementos al HashMap.
            hm.put("listView_city", cityList[i]);
            hm.put("listView_disco", discoList[i]);
            hm.put("listView_logo", Integer.toString(logoList[i]));
            hm.put("listView_addresses", cityAddresses[i]);
            hm.put("listView_showTime", showTime[i]);
            hm.put("listView_saikoUbi", Integer.toString(R.drawable.saikoshowlocationlogo));
            hm.put("listView_saikoTime", Integer.toString(R.drawable.saikoshowclocklogo));
            hm.put("listView_saikoDisco", Integer.toString(R.drawable.saikoshowdiscologo));
            hashList.add(hm); // Add the HashMap to the list created before.
        }

        // Ponemos EN ORDEN qué lista pertenecerá a qué objeto.
        String[] from = {"listView_logo", "listView_addresses", "listView_disco", "listView_showTime", "listView_saikoUbi", "listView_saikoTime", "listView_saikoDisco"};
        int[] to = {R.id.imgDisco, R.id.txtUbi, R.id.txtLocal, R.id.txtHora, R.id.imgUbi, R.id.imgHora, R.id.imgLocal};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), hashList, R.layout.shows_activity, from, to);
        ListView androidListView = (ListView) findViewById(R.id.listView);
        androidListView.setAdapter(simpleAdapter);

        androidListView.setOnItemClickListener(this::onItemClick);
    }

    public void webUrl(String url) {
        Intent viewIntent = new Intent(new Intent("android.intent.action.VIEW",
                Uri.parse(url)));
        startActivity(viewIntent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            btnMusic.pause();
            webUrl("https://proticketing.com/ticketplus/ca_ES/entradas/evento/28021"); // Llamamos al método que habilitará la navegación a la página web de las entradas.
        } else if (position == 1) {
            btnMusic.pause();
            webUrl("https://www.enterticket.es/eventos/saiko-526832");
        } else if (position == 2) {
            btnMusic.pause();
            webUrl("https://salafanatic.com/evento/saiko/");
        } else if (position == 3) {
            btnMusic.pause();
            webUrl("https://bangtickets.es/evento/62");
        }
    }
}
