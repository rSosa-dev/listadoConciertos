package com.example.listadoconciertos;

import androidx.annotation.NonNull;
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
        LatLng institut = new LatLng(41.289558967903304, 1.2459889876953898);   //Posicio de l'institut

        //Agregamos marcador al mapa (buscar uno.)

        //Para agregar más de un marcador, copiamos y pegamos esta linea de abajo.
        //mMap.addMarker(new MarkerOptions().position(institut).title("Jaume Huguet").icon(BitmapDescriptorFactory.fromResource(R.drawable.icona_mapa2))); //Personalitzacio del marcador

        mMap.moveCamera(CameraUpdateFactory.zoomTo(17.0f)); //Fijamos el zoom que podrá tener el mapa.
        mMap.moveCamera(CameraUpdateFactory.newLatLng(institut));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); //Tipo de mapa.
    }
}
