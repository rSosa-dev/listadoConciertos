package com.example.listadoconciertos;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ShowsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Quitamos la barra superior en la activity.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.shows_activity);


    }

}
