
package com.pagina.pagina.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "educacion")
public class Educacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEdu")
    private long idEdu;

    @Column(name = "institutoEdu")
    private String institutoEdu;

    @Column(name = "tituloEdu")
    private String tituloEdu;

    @Column(name = "urlfotoEdu")
    private String urlfotoEdu;

    @Column(name = "aniodesdeEdu")
    private int aniodesdeEdu;

    @Column(name = "aniohastaEdu")
    private int aniohastaEdu;

    public Educacion() {
    }

    public Educacion(String institutoEdu, String tituloEdu, String urlfotoEdu, int aniodesdeEdu, int aniohastaEdu) {
        this.institutoEdu = institutoEdu;
        this.tituloEdu = tituloEdu;
        this.urlfotoEdu = urlfotoEdu;
        this.aniodesdeEdu = aniodesdeEdu;
        this.aniohastaEdu = aniohastaEdu;
    }

    public Long getIdEdu() {
        return idEdu;
    }

    public void setIdEdu(Long idEdu) {
        this.idEdu = idEdu;
    }

    public String getInstitutoEdu() {
        return institutoEdu;
    }

    public void setInstitutoEdu(String institutoEdu) {
        this.institutoEdu = institutoEdu;
    }

    public String getTituloEdu() {
        return tituloEdu;
    }

    public void setTituloEdu(String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public String getUrlfotoEdu() {
        return urlfotoEdu;
    }

    public void setUrlfotoEdu(String urlfotoEdu) {
        this.urlfotoEdu = urlfotoEdu;
    }

    public int getAniodesdeEdu() {
        return aniodesdeEdu;
    }

    public void setAniodesdeEdu(int aniodesdeEdu) {
        this.aniodesdeEdu = aniodesdeEdu;
    }

    public int getAniohastaEdu() {
        return aniohastaEdu;
    }

    public void setAniohastaEdu(int aniohastaEdu) {
        this.aniohastaEdu = aniohastaEdu;
    }

}
