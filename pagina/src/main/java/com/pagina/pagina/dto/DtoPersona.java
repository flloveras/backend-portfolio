
package com.pagina.pagina.dto;

import javax.validation.constraints.NotBlank;


public class DtoPersona {
    @NotBlank
    private long idPersona;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String titulo;
    @NotBlank
    private String infopersonal;
    @NotBlank
    private String urlfotoperfil;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String titulo, String infopersonal, String urlfotoperfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.infopersonal = infopersonal;
        this.urlfotoperfil = urlfotoperfil;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInfopersonal() {
        return infopersonal;
    }

    public void setInfopersonal(String infopersonal) {
        this.infopersonal = infopersonal;
    }

    public String getUrlfotoperfil() {
        return urlfotoperfil;
    }

    public void setUrlfotoperfil(String urlfotoperfil) {
        this.urlfotoperfil = urlfotoperfil;
    }
    
    
    
    
}
