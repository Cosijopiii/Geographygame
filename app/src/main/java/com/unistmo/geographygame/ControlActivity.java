package com.unistmo.geographygame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by COSI on 30/10/2016.
 */

public class ControlActivity {

    ScrollingActivity scrollingActivity;
    ExpandableListView expandableListView;
    RadioGroup radioGroup;
    Button btnstart;
    CharSequence data[] = new CharSequence[] {"Facil", "Medio", "Dificil"};
    AlertDialog.Builder builder=null;
    public ControlActivity(ScrollingActivity scrollingActivity) {
        this.scrollingActivity = scrollingActivity;
        btnstart= (Button) scrollingActivity.findViewById(R.id.btnStarGame);
        radioGroup= (RadioGroup) scrollingActivity.findViewById(R.id.radioGroup);
        rButtons();
        makeAlert();
        create();
    }
    public void rButtons(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i==R.id.rbtnAmerica){

                }else if (i==R.id.rbtnEurope){

                }else if(i==R.id.rbtnAfrica){

                }else if(i==R.id.rbtnAsia){


                }
            }
        });
    }


    public AlertDialog.Builder makeAlert(){
        if(builder!=null){
            return builder;
        }
        builder=new AlertDialog.Builder(scrollingActivity);
        builder.setTitle("Escoja la dificultad");
        builder.setItems(data, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // the user clicked on colors[which]
            }
        });

        return builder;
    }

    public void create(){
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            builder.show();

            }
        });

    }



}


