package com.example.listadoconciertos;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnUbi;
    private ImageButton btnTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Quitamos la barra superior en la activity.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_main);

        btnUbi = (ImageButton) findViewById(R.id.btnUbi);
        btnUbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivities(MapActivity.class);
                //Toast.makeText(MainActivity.this, "Pulsado", Toast.LENGTH_LONG).show();
            }
        });

        btnTicket = (ImageButton) findViewById(R.id.btnTickets);
        btnTicket.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switchActivities(ShowsActivity.class);
            }
        });

    }

    private void switchActivities(Class activityClass) {
        Intent switchIntent = new Intent(MainActivity.this, activityClass);
        startActivity(switchIntent);
    }

}