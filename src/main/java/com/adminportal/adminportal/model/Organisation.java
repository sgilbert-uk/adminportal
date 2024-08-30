package com.adminportal.adminportal.model;

import java.time.LocalDate;

public class Organisation {
    private String orgName;
    private LocalDate regDate;
    private LocalDate expDate;
    private Boolean enabled;

    public String getOrgName() {return orgName;}
    public LocalDate getRegDate() {return regDate;}
    public LocalDate getExpDate() {return expDate;}
    public Boolean getEnabled() {return enabled;}
}
