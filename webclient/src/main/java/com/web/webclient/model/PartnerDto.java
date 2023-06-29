package com.web.webclient.model;

public class PartnerDto {

    private long id;

    private String name;

    private String email;

    private String phone;

    private boolean isPortal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isPortal() {
        return isPortal;
    }

    public void setPortal(boolean portal) {
        isPortal = portal;
    }

    public PartnerDto(){}

    public PartnerDto(String name, String email, String phone, boolean isPortal) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.isPortal = isPortal;
    }
    public PartnerDto(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PartnerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isPortal=" + isPortal +
                '}';
    }
}
