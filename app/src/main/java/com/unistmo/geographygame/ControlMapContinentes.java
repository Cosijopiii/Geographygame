package com.unistmo.geographygame;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cosijopii on 14/02/17.
 */

public class ControlMapContinentes extends ControlMapCapitales {
    public ControlMapContinentes(MapGameActivity mapGameActivity, String mode, String category, int code) {

        super(mapGameActivity,"Medio", category, code);

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


        List<Pais> paises=new ArrayList<>();

        for (Maps m:db.getalldatamaps()) {
            paises.add(new Pais(m.getNombre(),new LatLng(m.getLat(),m.getLog()),0,m.getCapital(),m.getContinente()));
        }

        return paises;
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
    public void configureButtons() {
        Collections.shuffle(mapGameActivity.getButtonTargets());
        if(mode.equals("Medio")){
            Collections.shuffle(mapGameActivity.getButtonTargets());
            mapGameActivity.getB2().setText(Categories.COUNTRIES[0]);
            mapGameActivity.getB3().setText(Categories.COUNTRIES[1]);
            mapGameActivity.getB1().setText(Categories.COUNTRIES[2]);
            mapGameActivity.getB4().setText(Categories.COUNTRIES[3]);
            mapGameActivity.getB5().setText(Categories.COUNTRIES[4]);
            mapGameActivity.getB6().setVisibility(View.INVISIBLE);
            mapGameActivity.getB7().setVisibility(View.INVISIBLE);
            mapGameActivity.getB8().setVisibility(View.INVISIBLE);
        }



    }

    @Override
    public int getDiffromMode(String mode) {
        return 5;
    }

    @Override
    public void makeAlert(int id) {
        super.makeAlert(id);
    }

    @Override
    public void checkB(Button b) {
        String bt=b.getText().toString();
        String mpc=mapGameActivity.getTarget().getContinente();
        if (mpc.equals("Norteamérica") ||mpc.equals("Sudamérica")){
            mpc="America";
        }
        boolean tr=bt.equals(mpc);
        if(tr){
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
        Pais target;

        List<Pais> paises=new ArrayList<>();
        List<Pais> paisest;
        paisest=getListFromCategory(category);
        Collections.shuffle(paisest);
        target=paisest.get(0);
        paises.add(target);
        for (int i = 1; i <5 ; i++) {
            paises.add(paisest.get(i));
        }


        return paises;
    }

    @Override
    public void moveToAnotherCountry() {
        if(count>=5){

            Intent i=new Intent(mapGameActivity,Final.class);

            i.putExtra("ok",goods);
            i.putExtra("code",code);
            i.putExtra("final",25);
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
            mapGameActivity.getTitleQ().setText("¿En que continente se encuentra  "+mapGameActivity.getTarget().getNombrePais()+"?");
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
