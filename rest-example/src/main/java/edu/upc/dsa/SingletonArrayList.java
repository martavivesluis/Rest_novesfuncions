package edu.upc.dsa;

import java.util.ArrayList;
import java.util.HashMap;

public class SingletonArrayList {
    public ArrayList<Track> array;
    public HashMap<String, Track> map;
    static private SingletonArrayList instancia_unica;

    private SingletonArrayList(){
        array = new ArrayList();
        map = new HashMap<String,Track>();
    }

    static SingletonArrayList getInstance(){
       if(instancia_unica == null){
           instancia_unica = new SingletonArrayList();
       }
        return instancia_unica;
    }

}
