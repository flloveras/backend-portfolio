
package com.pagina.pagina.dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {

    @NotBlank
    private Long idEdu;
    @NotBlank
    private String institutoEdu;
    @NotBlank
    private String tituloEdu;
    @NotBlank
    private String urlfotoEdu;
    @NotBlank
    private int aniodesdeEdu;
    @NotBlank
    private int aniohastaEdu;

    public DtoEducacion() {
    }

    public DtoEducacion(String institutoEdu, String tituloEdu, String urlfotoEdu, int aniodesdeEdu, int aniohastaEdu) {
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
