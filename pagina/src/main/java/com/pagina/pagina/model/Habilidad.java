
package com.pagina.pagina.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "habilidad")
public class Habilidad implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "idHab")
    private long idHab;
    
    @Column(name = "nombreHab")
    private String nombreHab;
    
    @Column(name = "nivelHab")
    private int nivelHab;
    
    

    public Habilidad() {
    }

    public Habilidad(String nombreHab, int nivelHab) {
        this.nombreHab = nombreHab;
        this.nivelHab = nivelHab;
    }

    public long getIdHab() {
        return idHab;
    }

    public void setIdHab(long idHab) {
        this.idHab = idHab;
    }

    public String getNombreHab() {
        return nombreHab;
    }

    public void setNombreHab(String nombreHab) {
        this.nombreHab = nombreHab;
    }

    public int getNivelHab() {
        return nivelHab;
    }

    public void setNivelHab(int nivelHab) {
        this.nivelHab = nivelHab;
    }

    

    
}
