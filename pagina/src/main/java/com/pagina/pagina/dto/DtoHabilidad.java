
package com.pagina.pagina.dto;

import javax.validation.constraints.NotBlank;


public class DtoHabilidad {
     @NotBlank
    private long idHab;
    
     @NotBlank
    private String nombreHab;
    
     @NotBlank
    private int nivelHab;
    
     @NotBlank
    private String logoHab;

    public DtoHabilidad() {
    }

    public DtoHabilidad(String nombreHab, int nivelHab, String logoHab) {
        this.nombreHab = nombreHab;
        this.nivelHab = nivelHab;
        this.logoHab = logoHab;
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

    public String getLogoHab() {
        return logoHab;
    }

    public void setLogoHab(String logoHab) {
        this.logoHab = logoHab;
    }
     
     
}