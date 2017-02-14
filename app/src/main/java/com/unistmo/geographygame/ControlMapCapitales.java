package com.unistmo.geographygame;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Collections;
import java.util.List;

/**
 * Created by cosijopii on 13/02/17.
 */

public class ControlMapCapitales extends ControlMap {

    public ControlMapCapitales(MapGameActivity mapGameActivity, String mode, String category, int code) {
        super(mapGameActivity, mode, category, code);
    }

    @Override
    public void setDataAmerica() {
        super.setDataAmerica();
    }

    @Override
    public void setDataAfrica() {
        super.setDataAfrica();
    }

    @Override
    public void setDataEuropa() {
        super.setDataEuropa();
    }

    @Override
    public void setDataAsia() {
        super.setDataAsia();
    }

    @Override
    public void setDataAustralia() {
        super.setDataAustralia();
    }

    @Override
    public List<Pais> getListFromCategory(String category) {
        return super.getListFromCategory(category);
    }

    @Override
    public void engineGame() {
        super.engineGame();
    }

    @Override
    public void changeCoButtons() {
        super.changeCoButtons();
    }

    @Override
    public void configureButtons() { // porque los botones seran las capitales
        Collections.shuffle(mapGameActivity.getButtonTargets());
        if(mode.equals("Facil")){
            mapGameActivity.getB2().setText(mapGameActivity.getButtonTargets().get(0).getCapital());
            mapGameActivity.getB3().setText(mapGameActivity.getButtonTargets().get(1).getCapital());
            mapGameActivity.getB1().setVisibility(View.INVISIBLE);
            mapGameActivity.getB4().setVisibility(View.INVISIBLE);
            mapGameActivity.getB5().setVisibility(View.INVISIBLE);
            mapGameActivity.getB6().setVisibility(View.INVISIBLE);
            mapGameActivity.getB7().setVisibility(View.INVISIBLE);
            mapGameActivity.getB8().setVisibility(View.INVISIBLE);
        }
        if(mode.equals("Medio")){
            mapGameActivity.getB2().setText(mapGameActivity.getButtonTargets().get(0).getCapital());
            mapGameActivity.getB3().setText(mapGameActivity.getButtonTargets().get(1).getCapital());
            mapGameActivity.getB1().setText(mapGameActivity.getButtonTargets().get(2).getCapital());
            mapGameActivity.getB4().setText(mapGameActivity.getButtonTargets().get(3).getCapital());
            mapGameActivity.getB5().setVisibility(View.INVISIBLE);
            mapGameActivity.getB6().setVisibility(View.INVISIBLE);
            mapGameActivity.getB7().setVisibility(View.INVISIBLE);
            mapGameActivity.getB8().setVisibility(View.INVISIBLE);
        }  if(mode.equals("Dificil")){
            mapGameActivity.getB2().setText(mapGameActivity.getButtonTargets().get(0).getCapital());
            mapGameActivity.getB3().setText(mapGameActivity.getButtonTargets().get(1).getCapital());
            mapGameActivity.getB1().setText(mapGameActivity.getButtonTargets().get(2).getCapital());
            mapGameActivity.getB4().setText(mapGameActivity.getButtonTargets().get(3).getCapital());
            mapGameActivity.getB5().setText(mapGameActivity.getButtonTargets().get(4).getCapital());
            mapGameActivity.getB6().setText(mapGameActivity.getButtonTargets().get(5).getCapital());
            mapGameActivity.getB7().setText(mapGameActivity.getButtonTargets().get(6).getCapital());
            mapGameActivity.getB8().setText(mapGameActivity.getButtonTargets().get(7).getCapital());
        }


    }

    @Override
    public int getDiffromMode(String mode) {
        return super.getDiffromMode(mode);
    }

    @Override
    public void makeAlert(int id) {
        super.makeAlert(id);
    }

    @Override
    public void checkB(Button b) { // se cambiara por capital

        Log.d("COUNT", "moveToAnotherCountry: "+b.getText().toString()+" "+mapGameActivity.getTarget().toString());
        if( b.getText().toString().equals(mapGameActivity.getTarget().getCapital())){
            makeAlert(R.drawable.ic_check_green_700_48dp);
            goods++;
            moveToAnotherCountry();

        }else{
            makeAlert(R.drawable.ic_close_red_900_48dp);
            bads++;
            moveToAnotherCountry();

        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    public List<Pais> getShuffleContruies(String category) {
        return super.getShuffleContruies(category);
    }

    @Override
    public void moveToAnotherCountry() {

        if(count>=5){

            Intent i=new Intent(mapGameActivity,Final.class);

            i.putExtra("ok",goods);
            i.putExtra("code",code);
            mapGameActivity.startActivity(i);


        }else {

            mapGameActivity.getContador().setText(count+1+" de 5");
            map.clear();
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(mapGameActivity.getMapTargets().get(count).getLatLng(), 4));
            map.addMarker(new MarkerOptions().position(mapGameActivity.getMapTargets().get(count).getLatLng()));
            mapGameActivity.setTargetMap(mapGameActivity.getMapTargets().get(count));
            mapGameActivity.setTarget(mapGameActivity.getMapTargets().get(count));

            changeCoButtons();
            configureButtons();
            for (Pais p: mapGameActivity.getButtonTargets()) {
                Log.d("TEST", "onCreate: CARROT"+p);
            }
            mapGameActivity.getTitleQ().setText("¿Cuál es la capital de "+mapGameActivity.getTarget().getNombrePais()+"?");
        }
        Log.d("COUNT", "moveToAnotherCountry: "+goods+" "+bads);
        count++;
        Log.d("COUNT", "moveToAnotherCountry: "+count);


    }

    @Override
    public void onMapReady(GoogleMap map) {
        super.onMapReady(map);
    }

    @Override
    public List<Pais> getAmerica() {
        return super.getAmerica();
    }
}

