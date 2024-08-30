package com.adminportal.adminportal.entities;

import jakarta.persistence.*;

@Entity(name="employeedata")
public class EmployeeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "org_id")
    private long orgId;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String userName;
    @Column
    private String password;
    @Column
    private String email;
    @Column(name = "tel_no")
    private long telNo;

    private EmployeeData(){}

    public EmployeeData(long orgId,String firstName,String lastName,String userName,String password,String email,long telNo){
        this.orgId = orgId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.telNo = telNo;
    }

    public long getId(){ return id;}
    public long getOrgId(){ return orgId;}
    public String getFirstName(){ return firstName;}
    public String getLastName(){ return lastName;}
    public String getUserName(){ return userName;}
    public String getPassword(){ return password;}
    public String getEmail(){ return email;}
    public long getTelNo(){ return telNo;}

    public void setFirstName(String firstName){ this.firstName = firstName;}
    public void setLastName(String lastName){ this.lastName = lastName;}
    public void setUserName(String userName){ this.userName = userName;}
    public void setPassword(String password){ this.password = password;}
    public void setEmail(String email){ this.email = email;}
    public void setTelNo(long telNo){ this.telNo = telNo;}

}
