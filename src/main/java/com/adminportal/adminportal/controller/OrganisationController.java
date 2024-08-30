package com.adminportal.adminportal.controller;

import com.adminportal.adminportal.exceptions.DataNotFoundException;
import com.adminportal.adminportal.entities.OrgData;
import com.adminportal.adminportal.model.Organisation;
import com.adminportal.adminportal.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganisationController {

    @Autowired
    public OrganisationService organisationService;

    @PostMapping("/org/create")
    @CrossOrigin
    public void createOrgData(@RequestBody Organisation organisation){
        organisationService.createOrgData(organisation);
    }

    @GetMapping("/org/get/{id}")
    @CrossOrigin
    public OrgData getOrgData(@PathVariable("id") long orgId) throws DataNotFoundException {
        return organisationService.getOrgData(orgId);
    }

    @GetMapping("/org/get/all")
    @CrossOrigin
    public List<OrgData> getAllOrgData(){
        return organisationService.getAllOrgData();
    }

    @PutMapping("/org/update/{id}")
    @CrossOrigin
    public void updateOrgData(@PathVariable("id") long orgId,@RequestBody Organisation orgData) throws DataNotFoundException {
        organisationService.updateOrgData(orgId,orgData);
    }

    @DeleteMapping("/org/delete/{id}")
    @CrossOrigin
    public void deleteOrgData(@PathVariable("id") long orgId){
        organisationService.deleteOrgData(orgId);
    }
}
