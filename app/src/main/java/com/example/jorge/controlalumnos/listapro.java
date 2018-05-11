package com.example.jorge.controlalumnos;

import java.util.ArrayList;

/**
 * Created by Jorge Urueta on 6/05/2018.
 */

public class listapro {


    ArrayList<profesores> lista=new ArrayList<profesores>();

    public listapro(){

    }
    public  void  agregar(profesores pr){

        lista.add(pr);

    }

    public   profesores getPersona(int Pos){

        return lista.get(Pos);
    }
    public   void setPersona(int Pos,profesores Per){

        lista.set(Pos,Per);
    }

    public   int  Cantida(){

        return lista.size();
    }
}
