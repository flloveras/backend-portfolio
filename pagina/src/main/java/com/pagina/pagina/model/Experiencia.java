
package com.pagina.pagina.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "experiencia")
public class Experiencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idExp")
	private long idExp;
    
    @Column(name = "puestoExp")
        private String puestoExp;
        
        @Column(name = "descripcionExp")
        private String descripcionExp;
        
        @Column(name = "empresaExp")
        private String empresaExp;
        
        @Column(name = "aniodesdeExp")
        private int aniodesdeExp;
        
        @Column(name = "aniohastaExp")
        private int aniohastaExp;

    public Experiencia() {
    }

    public Experiencia(String puestoExp, String descripcionExp, String empresaExp, int aniodesdeExp, int aniohastaExp) {
        this.puestoExp = puestoExp;
        this.descripcionExp = descripcionExp;
        this.empresaExp = empresaExp;
        this.aniodesdeExp = aniodesdeExp;
        this.aniohastaExp = aniohastaExp;
    }

    public Long getIdExp() {
        return idExp;
    }

    public void setIdExp(Long idExp) {
        this.idExp = idExp;
    }

    public String getPuestoExp() {
        return puestoExp;
    }

    public void setPuestoExp(String puestoExp) {
        this.puestoExp = puestoExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

    public String getEmpresaExp() {
        return empresaExp;
    }

    public void setEmpresaExp(String empresaExp) {
        this.empresaExp = empresaExp;
    }

    public int getAniodesdeExp() {
        return aniodesdeExp;
    }

    public void setAniodesdeExp(int aniodesdeExp) {
        this.aniodesdeExp = aniodesdeExp;
    }

    public int getAniohastaExp() {
        return aniohastaExp;
    }

    public void setAniohastaExp(int aniohastaExp) {
        this.aniohastaExp = aniohastaExp;
    }

    
}
