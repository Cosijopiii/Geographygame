package com.unistmo.geographygame;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class MapsDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "maps.db";
    private static final int DATABASE_VERSION = 1;

    public MapsDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public ArrayList<Maps> getalldatamaps(){

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"id", "Nombre","Capital","latitud","Longitud","Continente","Cp"};
        String sqlTables = "DataMaps";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
       ArrayList<Maps> data=new ArrayList<>();
       do {
           Maps m=new Maps();
           m.setId(c.getInt(c.getColumnIndex(sqlSelect[0])));
           m.setNombre(c.getString(c.getColumnIndex(sqlSelect[1])));
           m.setCapital(c.getString(c.getColumnIndex(sqlSelect[2])));
           m.setLat(c.getDouble(c.getColumnIndex(sqlSelect[3])));
           m.setLog(c.getDouble(c.getColumnIndex(sqlSelect[4])));
           m.setContinente(c.getString(c.getColumnIndex(sqlSelect[5])));
           m.setCp(c.getString(c.getColumnIndex(sqlSelect[6])));
           data.add(m);

       }while (c.moveToNext());
        db.close();
        c.close();
    return data;
    }


}