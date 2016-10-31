package com.unistmo.geographygame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by COSI on 30/10/2016.
 */

public class DataExpandible {

    private static HashMap<String,List<String>> dataExpandible=null;
    public static HashMap<String,List<String>> getData(){
        if (dataExpandible!=null){
            return  dataExpandible;
        }
        dataExpandible=new HashMap<>();
        List<String> categories=new ArrayList<>();
        categories.add("America");
        categories.add("Asia");
        categories.add("Africa");
        categories.add("Europa");
        List<String> Dificultad =new ArrayList<>();
        Dificultad.add("Facil");
        Dificultad.add("Medio");
        Dificultad.add("Dificil");

        dataExpandible.put("Categorias",categories);
        dataExpandible.put("Dificultad",Dificultad);

        return dataExpandible;
    }

}
