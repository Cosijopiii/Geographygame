package com.unistmo.geographygame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
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
    RadioButton rbtnAmerica;
    RadioButton rbtnAsia;
    RadioButton rbtnEuropa;
    RadioButton rbtAfrica;
    Button btnstart;
    CharSequence data[] = new CharSequence[] {"Facil", "Medio", "Dificil"};
    AlertDialog.Builder builder=null;
    public ControlActivity(ScrollingActivity scrollingActivity) {
        this.scrollingActivity = scrollingActivity;
        btnstart= (Button) scrollingActivity.findViewById(R.id.btnStarGame);
        radioGroup= (RadioGroup) scrollingActivity.findViewById(R.id.radioGroup);
        rbtAfrica= (RadioButton) scrollingActivity.findViewById(R.id.rbtnAfrica);
        rbtnAmerica= (RadioButton) scrollingActivity.findViewById(R.id.rbtnAmerica);
        rbtnAsia= (RadioButton) scrollingActivity.findViewById(R.id.rbtnAsia);
        rbtnEuropa= (RadioButton) scrollingActivity.findViewById(R.id.rbtnEurope);
        rButtons();
        makeAlert();
        create();
    }
    public void rButtons(){

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i==R.id.rbtnAmerica){
                    Toast.makeText(scrollingActivity.getBaseContext(),"A",Toast.LENGTH_SHORT).show();

                }else if (i==R.id.rbtnEurope){
                    Toast.makeText(scrollingActivity.getBaseContext(),"B",Toast.LENGTH_SHORT).show();

                }else if(i==R.id.rbtnAfrica){
                    Toast.makeText(scrollingActivity.getBaseContext(),"C",Toast.LENGTH_SHORT).show();

                }else if(i==R.id.rbtnAsia){
                    Toast.makeText(scrollingActivity.getBaseContext(),"D",Toast.LENGTH_SHORT).show();


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
                Intent intent=new Intent(scrollingActivity.getBaseContext(),MapGame.class);
                intent.putExtra("mode",which);
                scrollingActivity.startActivity(intent);
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


