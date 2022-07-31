
package com.pagina.pagina.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "proyecto")
public class Proyecto implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "idProye")
    private long idProye;
    
    @Column(name = "nombreProye")
    private String nombreProye;
    
    @Column(name = "urlProye")
    private String urlProye;
    
    @Column(name = "descripcionProye")
    private String descripcionProye;
    
    @Column(name = "anioProye")
    private int anioProye;

    public Proyecto() {
    }

    public Proyecto(String nombreProye, String urlProye, String descripcionProye, int anioProye) {
        this.nombreProye = nombreProye;
        this.urlProye = urlProye;
        this.descripcionProye = descripcionProye;
        this.anioProye = anioProye;
    }

    public long getIdProye() {
        return idProye;
    }

    public void setIdProye(long idProye) {
        this.idProye = idProye;
    }

    public String getNombreProye() {
        return nombreProye;
    }

    public void setNombreProye(String nombreProye) {
        this.nombreProye = nombreProye;
    }

    public String getUrlProye() {
        return urlProye;
    }

    public void setUrlProye(String urlProye) {
        this.urlProye = urlProye;
    }

    public String getDescripcionProye() {
        return descripcionProye;
    }

    public void setDescripcionProye(String descripcionProye) {
        this.descripcionProye = descripcionProye;
    }

    public int getAnioProye() {
        return anioProye;
    }

    public void setAnioProye(int anioProye) {
        this.anioProye = anioProye;
    }

    
}
