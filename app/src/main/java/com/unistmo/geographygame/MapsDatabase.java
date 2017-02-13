package com.unistmo.geographygame;

import android.content.Context;
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

        String [] sqlSelect = {"id", "Nombre","Capital","latitud","Longitud","Continente"};
        String sqlTables = "DataMaps";

        qb.setTables(sqlTables);


    }


}