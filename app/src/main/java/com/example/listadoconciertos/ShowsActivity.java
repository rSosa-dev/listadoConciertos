package com.example.listadoconciertos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShowsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Quitamos la barra superior en la activity.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.shows_activity);

        ShowsInfo sI = new ShowsInfo();
        String[] cityList = sI.getCityList();
        String[] discoList = sI.getDiscoList();
        int[] logoList = sI.getLogoList();
        String[] cityAddresses = sI.getCityAddresses();
        String[] showTime = sI.getShowTime();

        List<HashMap<String, String>> hashList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < cityList.length; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listView_city", cityList[i]);
            hm.put("listView_disco", discoList[i]);
            hm.put("listView_logo", Integer.toString(logoList[i]));
            hm.put("listView_addresses", cityAddresses[i]);
            hm.put("listView_showTime", showTime[i]);
            hm.put("listView_saikoUbi", Integer.toString(R.drawable.saikoshowlocationlogo));
            hm.put("listView_saikoTime", Integer.toString(R.drawable.saikoshowclocklogo));
            hm.put("listView_saikoDisco", Integer.toString(R.drawable.saikoshowdiscologo));
            hashList.add(hm);
        }

        String[] from = {"listView_logo", "listView_addresses", "listView_disco", "listView_showTime", "listView_saikoUbi", "listView_saikoTime", "listView_saikoDisco"};
        int[] to = {R.id.imgDisco, R.id.txtUbi, R.id.txtLocal, R.id.txtHora, R.id.imgUbi, R.id.imgHora, R.id.imgLocal};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), hashList, R.layout.shows_activity, from, to);
        ListView androidListView = (ListView) findViewById(R.id.showsListView);
        androidListView.setAdapter(simpleAdapter);

        androidListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            webUrl("https://proticketing.com/ticketplus/ca_ES/entradas/evento/28021");
        } else if (position == 1) {
            webUrl("https://www.enterticket.es/eventos/saiko-526832");
        } else if (position == 2) {
            webUrl("https://salafanatic.com/evento/saiko/");
        } else if (position == 3) {
            webUrl("https://bangtickets.es/evento/62");
        }
    }

    public void webUrl(String url) {
        Intent viewIntent = new Intent(new Intent("android.intent.action.VIEW",
                Uri.parse(url)));
        startActivity(viewIntent);
    }

}
