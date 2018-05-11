package com.example.jorge.controlalumnos.Modelo;

import java.util.ArrayList;

public class infoAlumno {



    public String getNombre() {
        return Nombre;
    }

    public infoAlumno() {
    }

    public infoAlumno(String nombre, String identificacion) {
        Nombre = nombre;
        Identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String identificacion) {
        Identificacion = identificacion;
    }

    String Nombre;
  String Identificacion;
}
