
package com.pagina.pagina.dto;

import javax.validation.constraints.NotBlank;


public class DtoProyecto {
    @NotBlank
    private long idProye;
    
    @NotBlank
    private String nombreProye;
    
    @NotBlank
    private String urlProye;
    
    @NotBlank
    private String descripcionProye;
    
    @NotBlank
    private int anioProye;

    public DtoProyecto() {
    }

    public DtoProyecto(String nombreProye, String urlProye, String descripcionProye, int anioProye) {
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
