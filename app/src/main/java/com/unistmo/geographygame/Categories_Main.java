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
                startC();
            }
        });

    }

    public void startC(){
        Intent i=new Intent(this,Categories.class);
        startActivity(i);
    }

}
