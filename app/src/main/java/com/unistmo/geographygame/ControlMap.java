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
        africa  =new ArrayList<>();
        setDataAfrica();
        europa  =new ArrayList<>();
        setDataEuropa();
        asia  =new ArrayList<>();
        setDataAsia();
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
    public void setDataAfrica(){


        africa.add(new Pais("Angola",new LatLng(-11.202692,17.873886999999968),1));
        africa.add(new Pais("Argelia",new LatLng(28.033886,1.659626000000003),2));
        africa.add(new Pais("Congo",new LatLng(-0.228021,15.82765900000004),3));
        africa.add(new Pais("Egipto",new LatLng(26.820553,30.802498000000014),4));
        africa.add(new Pais("Libia",new LatLng(27.039556602163195,17.60009765625),5));
        africa.add(new Pais("Chad",new LatLng(14.966013251567164,18.74267578125),6));
        africa.add(new Pais("Camerun",new LatLng(5.61598581915534,12.63427734375),7));
        africa.add(new Pais("Guinea Ecuatorial",new LatLng(1.5598658653430082,10.34912109375),8));
        africa.add(new Pais("Angola",new LatLng(-12.683214911818654,17.51220703125),9));
        africa.add(new Pais("Botsuana",new LatLng(-22.14670778001262,23.4228515625),10));
        africa.add(new Pais("Mozambique",new LatLng(-17.5602465032949,35.61767578125),11));
        africa.add(new Pais("Ghana",new LatLng(7.946527,-1.0231939999999895),12));
        africa.add(new Pais("Costa de marfil",new LatLng(7.5803277913301415,-5.69091796875),13));
        africa.add(new Pais("Liberia",new LatLng(6.118707747190845,-9.47021484375),14));
        africa.add(new Pais("Togo",new LatLng(8.624472107633936,1.0546875),15));
        africa.add(new Pais("Sudafrica",new LatLng(-31.109388560814963,23.13720703125),16));
        africa.add(new Pais("Madagascar",new LatLng(-21.145992164957892,46.07666015625),17));
        africa.add(new Pais("Marruecos",new LatLng(31.791702,-7.092620000000011),18));
        africa.add(new Pais("Sierra Leona",new LatLng(8.460555,-11.779889000000026),19));
        africa.add(new Pais("Senegal",new LatLng(14.370833973406821,-14.47998046875),20));


    }
    public void setDataEuropa(){


        europa.add(new Pais("Albania",new LatLng(41.153332,20.168331),1));
        europa.add(new Pais("Armenia",new LatLng(40.069099,	45.038189),2));
        europa.add(new Pais("Austria",new LatLng(47.516231,14.550072),3));
        europa.add(new Pais("Azerbaiyán",new LatLng(40.143105,47.576927),4));
        europa.add(new Pais("Bulgaria",new LatLng(42.733883,25.48583),5));
        europa.add(new Pais("Belgica",new LatLng(50.503887,4.469936),6));
        europa.add(new Pais("Suiza",new LatLng(460.128161,18.643501	),7));
        europa.add(new Pais("Ucrania",new LatLng(	48.379433,31.16558),8));
        europa.add(new Pais("Suecia",new LatLng(46.818188,8.227512),9));
        europa.add(new Pais("España",new LatLng(40.463667,-3.74922),10));
        europa.add(new Pais("Francia",new LatLng(46.227638,2.213749),11));
        europa.add(new Pais("Reino Unido",new LatLng(55.378051,-3.435973),12));
        europa.add(new Pais("Islandia",new LatLng(64.963051,	-19.020835),13));
        europa.add(new Pais("Italia",new LatLng(41.87194,12.56738),14));
        europa.add(new Pais("Lituania",new LatLng(55.169438,23.881275),15));
        europa.add(new Pais("Polonia",new LatLng(51.919438,19.145136),16));
        europa.add(new Pais("Portugal",new LatLng(	39.399872,-8.224454),17));
        europa.add(new Pais("Serbia",new LatLng(44.016521	,21.005859),18));
        europa.add(new Pais("San Marino",new LatLng(43.94236,12.457777),19));
        europa.add(new Pais("Noruega",new LatLng(	60.472024,8.468946),20));


    }
    public void setDataAsia(){


        asia.add(new Pais("Japon",new LatLng(36.204824,138.252924),1));
        asia.add(new Pais("Afganistán",new LatLng(33.93911,67.70995300000004),2));
        asia.add(new Pais("Pakistan",new LatLng(29.726222319395507,68.5546875),3));
        asia.add(new Pais("India",new LatLng(22.796439320919493,79.43115234375),4));
        asia.add(new Pais("Nepal",new LatLng(27.761329874505233,84.74853515625),5));
        asia.add(new Pais("Butan",new LatLng(27.274161117374682,90.4833984375),6));
        asia.add(new Pais("Birmania",new LatLng(21.002471054356725,96.52587890625),7));
        asia.add(new Pais("Laos",new LatLng(19.746024239625427,102.48046875),8));
        asia.add(new Pais("Tailandia",new LatLng(15.114552871944102,101.14013671875),9));
        asia.add(new Pais("Camboya",new LatLng(12.768946439455956,105.205078125),10));
        asia.add(new Pais("Vietnam",new LatLng(14.349547837185362,108.21533203125),11));
        asia.add(new Pais("Rusia",new LatLng(61.52401,105.31875600000001),12));
        asia.add(new Pais("China",new LatLng(34.41597338448186,103.3154296875),13));
        asia.add(new Pais("Taiwan",new LatLng(23.96617587126503,120.9814453125),14));
        asia.add(new Pais("Filipinas",new LatLng(12.16822567739012,122.87109375),15));
        asia.add(new Pais("Indonesia",new LatLng(-4.214943141390639,121.640625),16));
        asia.add(new Pais("Corea del norte",new LatLng(40.17887331434696,127.1337890625),17));
        asia.add(new Pais("Corea del sur",new LatLng(36.38591277287654,128.056640625),18));
        asia.add(new Pais("Mongolia",new LatLng(46.46813299215553,102.9638671875),19));
        asia.add(new Pais("Iran",new LatLng(31.80289258670676,54.5361328125),20));


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
