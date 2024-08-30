package com.adminportal.adminportal.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name="orgdata")
public class OrgData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "org_name")
    private String orgName;
    @Column(name = "reg_date")
    private LocalDate regDate;
    @Column(name = "exp_date")
    private LocalDate expDate;
    @Column
    private Boolean enabled;

    private OrgData(){}

    public OrgData(String orgName,LocalDate regDate,LocalDate expDate,Boolean enabled){
        this.orgName = orgName;
        this.regDate = regDate;
        this.expDate = expDate;
        this.enabled = enabled;
    }

    public long getId() {return id;}
    public String getOrgName() {return orgName;}
    public LocalDate getRegDate() {return regDate;}
    public LocalDate getExpDate() {return expDate;}
    public Boolean getEnabled() {return enabled;}

    public void setOrgName(String orgName){ this.orgName = orgName;}
    public void setRegDate(LocalDate regDate){ this.regDate = regDate;}
    public void setExpDate(LocalDate expDate){ this.expDate = expDate;}
    public void setEnabled(Boolean enabled){ this.enabled = enabled;}
}
