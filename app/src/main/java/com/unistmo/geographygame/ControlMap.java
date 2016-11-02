package com.unistmo.geographygame;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by cosijopii on 02/11/16.
 */

public class ControlMap implements OnMapReadyCallback{

    MapGameActivity mapGameActivity;


    public ControlMap(MapGameActivity mapGameActivity) {
        this.mapGameActivity = mapGameActivity;
    }


    @Override
    public void onMapReady(GoogleMap map) {
        map.setMapStyle( MapStyleOptions.loadRawResourceStyle(mapGameActivity, R.raw.styleold));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(42.935066, 12.367178),4));
        map.addMarker(new MarkerOptions().position(new LatLng(42.935066, 12.367178)));
        map.getUiSettings().setMapToolbarEnabled(false);

    }


}
