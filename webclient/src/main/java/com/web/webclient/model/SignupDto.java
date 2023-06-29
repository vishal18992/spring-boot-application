package com.web.webclient.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SignupDto {

    public SignupDto(){}
    private long id;

    @NotBlank(message = "Name can not be empty !!")
    private String name;

    @NotBlank(message = "User name can not be empty !!")
    @Size(min = 4, max = 25, message = "User name must be between 4 to 25 character !!")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email !!")
    private String login;


    @NotBlank(message = "Password can not be empty !!")
    @Size(min = 4, max = 16, message = "Password must be between 4 to 16 character !!")
    private String password;


    @NotBlank(message = "Confirm Password can not be empty !!")
    private String confirm_password;

    private boolean active;

    private String role;

    public boolean getActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

}
