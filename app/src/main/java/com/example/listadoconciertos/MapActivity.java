package com.example.listadoconciertos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
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
        LatLng mapStartingPoint = new LatLng(40.39695796877172, -3.7104109291736824);
        LatLng tgnPlazaToros = new LatLng(41.11446845158823, 1.2453410953399355);
        LatLng mrcSalaREM = new LatLng(37.98995441534601, -1.1281106266892353);
        LatLng svSalaFanatic = new LatLng(37.36657169343572, -5.959556598731479);
        LatLng jnSalaKharma = new LatLng(37.7839056176647, -3.784421447082449);


        //Agregamos marcador al mapa.
        mMap.addMarker(new MarkerOptions().position(tgnPlazaToros).title("Tarraco Arena").icon(BitmapDescriptorFactory.fromResource(R.drawable.saikomapubi))); //Personalización del marcador
        mMap.addMarker(new MarkerOptions().position(mrcSalaREM).title("Sala R.E.M").icon(BitmapDescriptorFactory.fromResource(R.drawable.saikomapubi)));
        mMap.addMarker(new MarkerOptions().position(svSalaFanatic).title("Sala fanatic").icon(BitmapDescriptorFactory.fromResource(R.drawable.saikomapubi)));
        mMap.addMarker(new MarkerOptions().position(jnSalaKharma).title("Sala Kharma").icon(BitmapDescriptorFactory.fromResource(R.drawable.saikomapubi)));

        mMap.moveCamera(CameraUpdateFactory.zoomTo(6.3f)); //Fijamos el zoom que podrá tener el mapa.
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mapStartingPoint));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); //Tipo de mapa.
    }

    public Bitmap resizeMapIcons(String icon, int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(icon, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }


}
