package com.unistmo.geographygame;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.maps.MapView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class MapGameActivity extends AppCompatActivity {

    /**
     * MAP KEY
     */
    private static final String MAPVIEW_BUNDLE_KEY = String.valueOf(R.string.google_android_map_api_key);

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private ControlMap controlMap;
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };

    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    private MapView mapView;



    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private String mode;
    private String category;



    private Pais target;

    private TextView contador;
    private Pais targetMap;
    private List<Pais> mapTargets;


    private List<Pais> buttonTargets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullgamemap);
        hide();
        mapView= (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);

          b1= (Button) findViewById(R.id.btnr1);
          b2= (Button) findViewById(R.id.btnr2);
          b3= (Button) findViewById(R.id.btnr3);
          b4= (Button) findViewById(R.id.btnr4);
          b5= (Button) findViewById(R.id.btnr5);
          b6= (Button) findViewById(R.id.btnr6);
          b7= (Button) findViewById(R.id.btnr7);
          b8= (Button) findViewById(R.id.btnr8);
         contador= (TextView) findViewById(R.id.nContador);
        mode=getIntent().getStringExtra("mode");
        category=getIntent().getStringExtra("category");

        controlMap =new ControlMap(this,mode,category);
        if(mapView!=null){
            mapView.getMapAsync(controlMap);
        }
        b1.setOnClickListener(controlMap);
        b2.setOnClickListener(controlMap);
        b3.setOnClickListener(controlMap);
        b4.setOnClickListener(controlMap);
        b5.setOnClickListener(controlMap);
        b6.setOnClickListener(controlMap);
        b7.setOnClickListener(controlMap);
        b8.setOnClickListener(controlMap);
        controlMap.engineGame();
        controlMap.configureButtons();


        for (Pais p: mapTargets) {
            Log.d("TEST", "onCreate: POTATO"+p);
        }

        for (Pais p: buttonTargets) {
            Log.d("TEST", "onCreate: CARROT"+p);
        }


    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }


    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }
        mapView.onSaveInstanceState(mapViewBundle);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }
    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
    public Button getB1() {
        return b1;
    }

    public void setB1(Button b1) {
        this.b1 = b1;
    }

    public Button getB2() {
        return b2;
    }

    public void setB2(Button b2) {
        this.b2 = b2;
    }

    public Button getB3() {
        return b3;
    }

    public void setB3(Button b3) {
        this.b3 = b3;
    }

    public Button getB4() {
        return b4;
    }

    public void setB4(Button b4) {
        this.b4 = b4;
    }

    public Button getB5() {
        return b5;
    }

    public void setB5(Button b5) {
        this.b5 = b5;
    }

    public Button getB6() {
        return b6;
    }

    public void setB6(Button b6) {
        this.b6 = b6;
    }

    public Button getB7() {
        return b7;
    }

    public void setB7(Button b7) {
        this.b7 = b7;
    }

    public Button getB8() {
        return b8;
    }

    public void setB8(Button b8) {
        this.b8 = b8;
    }
    public Pais getTarget() {
        return target;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTarget(Pais target) {
        this.target = new Pais(target);
    }

    public List<Pais> getMapTargets() {
        return mapTargets;
    }

    public void setMapTargets(List<Pais> mapTargets) {
        this.mapTargets = mapTargets;
    }

    public Pais getTargetMap() {
        return targetMap;
    }

    public void setTargetMap(Pais targetMap) {
        this.targetMap = targetMap;
    }
    public List<Pais> getButtonTargets() {
        return buttonTargets;
    }

    public void setButtonTargets(List<Pais> buttonTargets) {
        this.buttonTargets = buttonTargets;
    }

    public TextView getContador() {
        return contador;
    }

    public void setContador(TextView contador) {
        this.contador = contador;
    }
}
