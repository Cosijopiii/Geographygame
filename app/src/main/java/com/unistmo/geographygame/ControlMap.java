package com.unistmo.geographygame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.SuperToast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cosijopii on 02/11/16.
 */

public class ControlMap implements OnMapReadyCallback, View.OnClickListener{

    private MapGameActivity mapGameActivity;

    private int count=0;
    private int goods=0;
    private int bads=0;
    private List<Pais> america;
    private List<Pais> africa;
    private List<Pais> europa;
    private List<Pais> asia;
    private List<Pais> australia;
    private String mode;
    private String category;
    private GoogleMap map;
    private  AlertDialog.Builder builder=null;
    MapsDatabase db;
    ArrayList<Maps> dbmap;
    public ControlMap(MapGameActivity mapGameActivity,String mode,String category) {

        db = new MapsDatabase(mapGameActivity);
        dbmap=db.getalldatamaps();
        this.mapGameActivity = mapGameActivity;
        this.mode=mode;
        this.category=category;
        america  =new ArrayList<>();
        setDataAmerica();
        africa  =new ArrayList<>();
        setDataAfrica();
        europa  =new ArrayList<>();
        setDataEuropa();
        asia  =new ArrayList<>();
        setDataAsia();
        australia  =new ArrayList<>();
        setDataAustralia();
    }

    public void setDataAmerica(){

        for (Maps m:dbmap) {
            if (m.getContinente().equals("Norteamérica") || m.getContinente().equals("Sudamérica")){
            america.add(new Pais(m.getNombre(),new LatLng(m.getLat(),m.getLog()),0));
            }
        }

    }
    public void setDataAfrica(){

        for (Maps m:dbmap) {
            if (m.getContinente().equals("África")){
                africa.add(new Pais(m.getNombre(),new LatLng(m.getLat(),m.getLog()),0));
            }
        }
    }
    public void setDataEuropa(){

        for (Maps m:dbmap) {
            if (m.getContinente().equals("Europa") ){
                europa.add(new Pais(m.getNombre(),new LatLng(m.getLat(),m.getLog()),0));
            }
        }

    }
    public void setDataAsia(){

        for (Maps m:dbmap) {
            if (m.getContinente().equals("Asia") ){
                asia.add(new Pais(m.getNombre(),new LatLng(m.getLat(),m.getLog()),0));
            }
        }

    }
    public void setDataAustralia(){

        for (Maps m:dbmap) {
            if (m.getContinente().equals("Australia") ){
                australia.add(new Pais(m.getNombre(),new LatLng(m.getLat(),m.getLog()),0));
            }
        }

    }

    public List<Pais> getListFromCategory(String category){

        List<Pais> paises=null;
        switch (category){

            case "America":

             paises=america;

                break;
            case "Africa":

                paises=africa;
                break;

            case "Europa":
                paises=europa;

                break;
            case "Asia":
                paises=asia;

                break;
            case "Australia":
                paises=australia;

                break;
        }
        return paises;
    }
    public void engineGame(){

        mapGameActivity.setMapTargets(getShuffleContruies(category));
        mapGameActivity.setTarget(mapGameActivity.getMapTargets().get(0));
        mapGameActivity.setButtonTargets(new ArrayList<>(getListFromCategory(category)));
        mapGameActivity.getButtonTargets().remove(mapGameActivity.getTarget());
        mapGameActivity.getButtonTargets().set(0,mapGameActivity.getTarget());
        mapGameActivity.setButtonTargets(new ArrayList<>(mapGameActivity.getButtonTargets().subList(0,getDiffromMode(mode))));



    }
    public void changeCoButtons(){

        mapGameActivity.getButtonTargets().clear();


        mapGameActivity.setButtonTargets(getListFromCategory(category));
        mapGameActivity.getButtonTargets().remove(mapGameActivity.getTargetMap());
        mapGameActivity.getButtonTargets().set(0,mapGameActivity.getTargetMap());
        mapGameActivity.setButtonTargets(new ArrayList<>(mapGameActivity.getButtonTargets().subList(0,getDiffromMode(mode))));

    }

    public void configureButtons(){
        Collections.shuffle(mapGameActivity.getButtonTargets());
       if(mode.equals("Facil")){
           mapGameActivity.getB2().setText(mapGameActivity.getButtonTargets().get(0).getNombrePais());
           mapGameActivity.getB3().setText(mapGameActivity.getButtonTargets().get(1).getNombrePais());
           mapGameActivity.getB1().setVisibility(View.INVISIBLE);
           mapGameActivity.getB4().setVisibility(View.INVISIBLE);
           mapGameActivity.getB5().setVisibility(View.INVISIBLE);
           mapGameActivity.getB6().setVisibility(View.INVISIBLE);
           mapGameActivity.getB7().setVisibility(View.INVISIBLE);
           mapGameActivity.getB8().setVisibility(View.INVISIBLE);
       }
        if(mode.equals("Medio")){
            mapGameActivity.getB2().setText(mapGameActivity.getButtonTargets().get(0).getNombrePais());
            mapGameActivity.getB3().setText(mapGameActivity.getButtonTargets().get(1).getNombrePais());
            mapGameActivity.getB1().setText(mapGameActivity.getButtonTargets().get(2).getNombrePais());
            mapGameActivity.getB4().setText(mapGameActivity.getButtonTargets().get(3).getNombrePais());
            mapGameActivity.getB5().setVisibility(View.INVISIBLE);
            mapGameActivity.getB6().setVisibility(View.INVISIBLE);
            mapGameActivity.getB7().setVisibility(View.INVISIBLE);
            mapGameActivity.getB8().setVisibility(View.INVISIBLE);
        }  if(mode.equals("Dificil")){
            mapGameActivity.getB2().setText(mapGameActivity.getButtonTargets().get(0).getNombrePais());
            mapGameActivity.getB3().setText(mapGameActivity.getButtonTargets().get(1).getNombrePais());
            mapGameActivity.getB1().setText(mapGameActivity.getButtonTargets().get(2).getNombrePais());
            mapGameActivity.getB4().setText(mapGameActivity.getButtonTargets().get(3).getNombrePais());
            mapGameActivity.getB5().setText(mapGameActivity.getButtonTargets().get(4).getNombrePais());
            mapGameActivity.getB6().setText(mapGameActivity.getButtonTargets().get(5).getNombrePais());
            mapGameActivity.getB7().setText(mapGameActivity.getButtonTargets().get(6).getNombrePais());
            mapGameActivity.getB8().setText(mapGameActivity.getButtonTargets().get(7).getNombrePais());
        }


    }


    public int getDiffromMode(String mode){

        int op=0;
        switch (mode){
            case "Facil":

                op= 2;

                break;
           case "Medio":
                op=  4;

            break;
            case "Dificil":
                op= 8;

            break;
        }
        return op;
    }

    public void makeAlert(int id){



        new SuperActivityToast(mapGameActivity, Style.amber(), Style.TYPE_STANDARD)
                .setText("")
                .setDuration(500)
                .setFrame(Style.FRAME_STANDARD)
                .setIconResource(id)
                .setGravity(Gravity.CENTER, 0, 0)
                .show();
    }

    public void checkB(Button b){

        if( b.getText().toString().equalsIgnoreCase(mapGameActivity.getTarget().getNombrePais())){
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




        if (v.getId()==mapGameActivity.findViewById(R.id.btnr1).getId()){
           checkB(mapGameActivity.getB1());
        }
        if (v.getId()==mapGameActivity.findViewById(R.id.btnr2).getId()){
            checkB(mapGameActivity.getB2());
        }
        if (v.getId()==mapGameActivity.findViewById(R.id.btnr3).getId()){
            checkB(mapGameActivity.getB3());
        }
        if (v.getId()==mapGameActivity.findViewById(R.id.btnr4).getId()){
            checkB(mapGameActivity.getB4());
        }
        if (v.getId()==mapGameActivity.findViewById(R.id.btnr5).getId()){
            checkB(mapGameActivity.getB5());
        }
        if (v.getId()==mapGameActivity.findViewById(R.id.btnr6).getId()){
            checkB(mapGameActivity.getB6());
        }
        if (v.getId()==mapGameActivity.findViewById(R.id.btnr7).getId()){
            checkB(mapGameActivity.getB7());
        }
        if (v.getId()==mapGameActivity.findViewById(R.id.btnr8).getId()){
            checkB(mapGameActivity.getB8());
        }




    }


    public List<Pais> getShuffleContruies(String category){

        Pais target;

        List<Pais> paises=new ArrayList<>();

        Collections.shuffle(getListFromCategory(category));
        target=getListFromCategory(category).get(0);
        paises.add(target);
        for (int i = 1; i <5 ; i++) {
            paises.add(getListFromCategory(category).get(i));
        }


       return paises;
    }


    public void moveToAnotherCountry(){


        if(count>=5){

        Intent i=new Intent(mapGameActivity,Final.class);

            i.putExtra("ok",goods);

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

        }
        Log.d("COUNT", "moveToAnotherCountry: "+goods+" "+bads);
        count++;
        Log.d("COUNT", "moveToAnotherCountry: "+count);


    }

    @Override
    public void onMapReady(GoogleMap map) {
        this.map=map;
        map.setMapStyle( MapStyleOptions.loadRawResourceStyle(mapGameActivity, R.raw.styleold));
        map.getUiSettings().setMapToolbarEnabled(false);

        moveToAnotherCountry();


    }
    public List<Pais> getAmerica() {
        return america;
    }


}
