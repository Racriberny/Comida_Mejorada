package com.cristobalbernal.perfil_usuari.ui.main;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nif;
    private String nombre;
    private String apellidos;
    private String fecha_nacimiento;
    private String direcion;
    private String raoSocial;
    private String CIF;
    private String paginaWeb;
    private String correuElectronic;
    private String contrasena;

    public Persona(String nif, String nombre, String apellidos, String fecha_nacimiento, String direcion, String raoSocial, String CIF, String paginaWeb, String correuElectronic,String contrasena) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direcion = direcion;
        this.raoSocial = raoSocial;
        this.CIF = CIF;
        this.paginaWeb = paginaWeb;
        this.correuElectronic = correuElectronic;
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getRaoSocial() {
        return raoSocial;
    }

    public void setRaoSocial(String raoSocial) {
        this.raoSocial = raoSocial;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getCorreuElectronic() {
        return correuElectronic;
    }

    public void setCorreuElectronic(String correuElectronic) {
        this.correuElectronic = correuElectronic;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", direcion='" + direcion + '\'' +
                ", raoSocial='" + raoSocial + '\'' +
                ", CIF='" + CIF + '\'' +
                ", paginaWeb='" + paginaWeb + '\'' +
                ", correuElectronic='" + correuElectronic + '\'' +
                "contraseña " + contrasena+
                '}';
    }
}
