package com.unistmo.geographygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Categories_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories__main);

        Button btnPais= (Button) findViewById(R.id.btnPaises);
        btnPais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startpaises();
            }
        });
        Button btncapt= (Button) findViewById(R.id.btnCaptitales);
        btncapt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCapital();
            }
        });

        Button btncont= (Button) findViewById(R.id.btnContinentes);
        btncont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startContinente();
            }
        });

        Button btnbanderas= (Button) findViewById(R.id.btnBanderas);
        btnbanderas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBanderas();
            }
        });


    }

    public void startpaises(){
        Intent i=new Intent(this,Categories.class);
        i.putExtra("code",1);
        startActivity(i);
    }
    public void startCapital(){
        Intent i=new Intent(this,Categories.class);
        i.putExtra("code",2);
        startActivity(i);
    }
    public void startContinente(){
        Intent i=new Intent(this,MapGameActivity.class);
        i.putExtra("code",3);
        i.putExtra("mode", "medio");
        i.putExtra("category", "none");

        startActivity(i);
    }
    public void startBanderas(){
        Intent i=new Intent(this,Categories.class);
        i.putExtra("code",4);
        startActivity(i);
    }


}
