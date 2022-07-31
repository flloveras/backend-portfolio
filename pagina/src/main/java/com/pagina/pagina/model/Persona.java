
package com.pagina.pagina.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpersona")
    private long idPersona;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "apellido")
    private String apellido;

    @NotNull
    @Column(name = "titulo")
    private String titulo;

    @NotNull
    @Column(name = "infopersonal")
    private String infopersonal;

    @NotNull
    @Column(name = "urlfotoperfil")
    private String urlfotoperfil;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String titulo, String infopersonal, String urlfotoperfil) {
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