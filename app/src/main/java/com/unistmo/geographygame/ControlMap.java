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
    private String mode;
    private String category;
    private GoogleMap map;
    private  AlertDialog.Builder builder=null;

    public ControlMap(MapGameActivity mapGameActivity,String mode,String category) {
        this.mapGameActivity = mapGameActivity;
        this.mode=mode;
        this.category=category;
        america  =new ArrayList<>();
        setDataAmerica();
    }

    public void setDataAmerica(){


        america.add(new Pais("México",new LatLng(23.634501,-102.55278399999997),1));
        america.add(new Pais("Canadá",new LatLng(56.130366,-106.34677099999999),2));
        america.add(new Pais("Estados unidos",new LatLng(37.09024,-95.71289100000001),3));
        america.add(new Pais("Brasil",new LatLng(-14.235004,-51.92527999999999),4));
        america.add(new Pais("Argentina",new LatLng(-38.416097,-63.616671999999994),5));
        america.add(new Pais("Montserrat",new LatLng(16.742498,-62.187366),6));
        america.add(new Pais("Cuba",new LatLng(21.521757,-77.78116699999998),7));
        america.add(new Pais("Groenlandia",new LatLng(71.706936,-42.604303000000016),8));
        america.add(new Pais("Colombia",new LatLng(4.570868,-74.29733299999998),9));
        america.add(new Pais("Chile",new LatLng(-35.675147,-71.54296899999997),10));
        america.add(new Pais("Ecuador",new LatLng(-1.831239,-78.18340599999999),11));
        america.add(new Pais("Surinam",new LatLng(3.919305,-56.027783),12));
        america.add(new Pais("Uruguay",new LatLng(-32.522779,-55.76583500000004),13));
        america.add(new Pais("Perú",new LatLng(-9.189967,-75.015152),14));
        america.add(new Pais("Venezuela",new LatLng(6.42375,-66.58973000000003),15));
        america.add(new Pais("Costa Rica",new LatLng(9.748916999999999,-83.75342799999999),16));
        america.add(new Pais("Honduras",new LatLng(15.199999,-86.24190499999997),17));
        america.add(new Pais("Guatemala",new LatLng(15.783471,-90.23075899999998),18));
        america.add(new Pais("Puerto Rico",new LatLng(18.220833,-66.590149),19));
        america.add(new Pais("Haití",new LatLng(18.971187,-72.285215),20));


    }

    public List<Pais> getListFromCategory(String category){

        List<Pais> paises=null;
        switch (category){

            case "America":

            paises=america;

                break;
            case "Africa":


                break;
            case "Europa":


                break;
            case "Asia":


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
                .setDuration(Style.DURATION_SHORT)
                .setFrame(Style.FRAME_STANDARD)
                .setIconResource(id)
                .setGravity(Gravity.CENTER, 0, 0)
                .show();




    }

    public void checkB(Button b){

        if( b.getText().toString().equalsIgnoreCase(mapGameActivity.getTarget().getNombrePais())){
            makeAlert(R.drawable.ic_check_green_700_48dp);
            moveToAnotherCountry();
            goods++;
        }else{
            makeAlert(R.drawable.ic_close_red_900_48dp);
            moveToAnotherCountry();
            bads++;
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
        target=america.get(0);
        paises.add(target);
        for (int i = 1; i <5 ; i++) {
            paises.add(america.get(i));
        }


       return paises;
    }


    public void moveToAnotherCountry(){


        if(count>=5){

            Toast.makeText(mapGameActivity,goods+" "+bads,Toast.LENGTH_SHORT).show();


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
        Log.d("COUNT", "moveToAnotherCountry: "+count);
        count++;



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
