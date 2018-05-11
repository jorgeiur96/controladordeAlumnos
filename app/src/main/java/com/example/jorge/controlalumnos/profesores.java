package com.example.jorge.controlalumnos;

/**
 * Created by Jorge Urueta on 6/05/2018.
 */

public class profesores {



    String nombre;
    String  primerapellido;
    String  SegundoApellido;
    String  CedulaProfesor;
    String  correo;
    String contrasenia;

    public profesores(String nombre, String primerapellido, String segundoApellido, String cedulaProfesor, String correo, String contrasenia) {
        this.nombre = nombre;
        this.primerapellido = primerapellido;
        SegundoApellido = segundoApellido;
        CedulaProfesor = cedulaProfesor;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }



    public profesores() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        SegundoApellido = segundoApellido;
    }

    public String getCedulaProfesor() {
        return CedulaProfesor;
    }

    public void setCedulaProfesor(String cedulaProfesor) {
        CedulaProfesor = cedulaProfesor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


}
