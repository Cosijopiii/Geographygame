package com.unistmo.geographygame;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by COSI on 30/10/2016.
 */

public class DataMap extends Service {

    public static HashMap<String,List<Pais>> map =null;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */

    public final String[] americaConuntries=
            {"México","Canadá","Estados Unidos","Brasil"
            ,"Haití","Argentina","Montserrat","Cuba","Groenlandia","Colombia","Chile","Ecuador","Surinam","Uruguay"
            ,"Perú","Venezuela","Costa Rica","Honduras","Guatemala","Puerto Rico"};


    public  HashMap<String,List<Pais>> getData(){
        if (map !=null){
            return map;
        }
        map =new HashMap<>();
        List<Pais> america =new ArrayList<>();

        for (int i = 0; i <20 ; i++) {
            america.add(new Pais(americaConuntries[i],getLatfromString(getBaseContext(),americaConuntries[i]),i));
        }


       /* america.add(new Pais("México",new LatLng(23.634501,-102.55278399999997),1));
        america.add(new Pais("Canadá",new LatLng(56.130366,-106.34677099999999),2));
        america.add(new Pais("Estados unidos",new LatLng(37.09024,-95.71289100000001),1));
        america.add(new Pais("Brasil",new LatLng(-14.235004,-51.92527999999999),1));
        america.add(new Pais("Haití",new LatLng(18.971187,-72.285215),1));
        america.add(new Pais("Argentina",new LatLng(-38.416097,-63.616671999999994),1));
        america.add(new Pais("Montserrat",new LatLng(16.742498,-62.187366),1));
        america.add(new Pais("Cuba",new LatLng(21.521757,-77.78116699999998),1));
        america.add(new Pais("Groenlandia",new LatLng(71.706936,-42.604303000000016),1));
        america.add(new Pais("Colombia",new LatLng(4.570868,-74.29733299999998),1));
        america.add(new Pais("Chile",new LatLng(-35.675147,-71.54296899999997),1));
        america.add(new Pais("Ecuador",new LatLng(-1.831239,-78.18340599999999),1));
        america.add(new Pais("Surinam",new LatLng(3.919305,-56.027783),1));
        america.add(new Pais("Uruguay",new LatLng(-32.522779,-55.76583500000004),1));
        america.add(new Pais("Perú",new LatLng(-9.189967,-75.015152),1));
        america.add(new Pais("Venezuela",new LatLng(6.42375,-66.58973000000003),1));
        america.add(new Pais("Costa Rica",new LatLng(9.748916999999999,-83.75342799999999),1));
        america.add(new Pais("Honduras",new LatLng(15.199999,-86.24190499999997),1));
        america.add(new Pais("Guatemala",new LatLng(15.783471,-90.23075899999998),1));
        america.add(new Pais("Puerto Rico",new LatLng(18.220833,-66.590149),1));*/
        map.put("America",america);





        return map;
    }

    public LatLng getLatfromString(Context context,String address){

        Geocoder geocoder=new Geocoder(context);
        List<Address> addresses;
        LatLng result =null;
        try {
            addresses=geocoder.getFromLocationName(address,5);
            if (addresses==null){
                return null;
            }
            Address loc= addresses.get(0);
            result=new LatLng(loc.getLatitude(),loc.getLongitude());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        getData();

        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
