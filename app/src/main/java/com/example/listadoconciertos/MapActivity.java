package com.example.listadoconciertos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Quitamos la barra superior en la activity.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.map_activity);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        //Creamos el objeto mapa.
        mMap = googleMap;

        //Posicionamos una vista inicial del mapa.
        LatLng tgnPlazaToros = new LatLng(41.11446845158823, 1.2453410953399355);
        LatLng mrcSalaREM = new LatLng(37.98995441534601, -1.1281106266892353);

        //Agregamos marcador al mapa.

        //Para agregar más de un marcador, copiamos y pegamos esta linea de abajo.
        mMap.addMarker(new MarkerOptions().position(tgnPlazaToros).title("Tarraco Arena").icon(BitmapDescriptorFactory.fromResource(R.drawable.saikomapubi))); //Personalización del marcador
        mMap.addMarker(new MarkerOptions().position(mrcSalaREM).title("Sala R.E.M").icon(BitmapDescriptorFactory.fromResource(R.drawable.saikomapubi)));

        mMap.moveCamera(CameraUpdateFactory.zoomTo(17.0f)); //Fijamos el zoom que podrá tener el mapa.
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tgnPlazaToros));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); //Tipo de mapa.
    }
}
