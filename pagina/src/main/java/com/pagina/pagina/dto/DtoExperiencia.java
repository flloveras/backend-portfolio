
package com.pagina.pagina.dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {

    @NotBlank
    private Long idExp;

    @NotBlank
    private String puestoExp;

    @NotBlank
    private String descripcionExp;

    @NotBlank
    private String empresaExp;

    @NotBlank
    private int aniodesdeExp;

    @NotBlank
    private int aniohastaExp;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String puestoExp, String descripcionExp, String empresaExp, int aniodesdeExp, int aniohastaExp) {
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
