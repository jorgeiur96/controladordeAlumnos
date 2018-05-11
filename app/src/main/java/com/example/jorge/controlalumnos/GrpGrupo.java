package com.example.jorge.controlalumnos;

public class GrpGrupo {

    String Codigo;

    public GrpGrupo(String codigo, String nombre) {
        Codigo = codigo;
        this.nombre = nombre;
    }

    public GrpGrupo() {
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    String nombre;
}
