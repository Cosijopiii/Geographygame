package com.unistmo.geographygame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by COSI on 30/10/2016.
 */

public class DataMap {

    private static HashMap<String,List<String>> dataExpandible=null;
    public static HashMap<String,List<String>> getData(){
        if (dataExpandible!=null){
            return  dataExpandible;
        }
        dataExpandible=new HashMap<>();
        List<String> America=new ArrayList<>();

        America.add("America");
        America.add("Asia");
        America.add("Africa");
        America.add("Europa");


        List<String> Dificultad =new ArrayList<>();
        Dificultad.add("Facil");
        Dificultad.add("Medio");
        Dificultad.add("Dificil");

        dataExpandible.put("Categorias",America);
        dataExpandible.put("Dificultad",Dificultad);

        return dataExpandible;
    }

}
