package com.bikeserver.model.dtos;

public class SystemDto {

    private Long id;
    private Long userId;
    private Boolean tamper1;
    private Boolean tamper2;
    private Boolean gercon1;
    private Boolean gercon2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getTamper1() {
        return tamper1;
    }

    public void setTamper1(Boolean tamper1) {
        this.tamper1 = tamper1;
    }

    public Boolean getTamper2() {
        return tamper2;
    }

    public void setTamper2(Boolean tamper2) {
        this.tamper2 = tamper2;
    }

    public Boolean getGercon1() {
        return gercon1;
    }

    public void setGercon1(Boolean gercon1) {
        this.gercon1 = gercon1;
    }

    public Boolean getGercon2() {
        return gercon2;
    }

    public void setGercon2(Boolean gercon2) {
        this.gercon2 = gercon2;
    }
}
