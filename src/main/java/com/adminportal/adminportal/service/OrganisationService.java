package com.adminportal.adminportal.service;

import com.adminportal.adminportal.db.EmployeeRepository;
import com.adminportal.adminportal.db.OrgRepository;
import com.adminportal.adminportal.exceptions.DataNotFoundException;
import com.adminportal.adminportal.entities.OrgData;
import com.adminportal.adminportal.model.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganisationService {

    @Autowired
    private OrgRepository orgRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public void createOrgData(Organisation organisation){
        // sanitize inputs here
        OrgData newOrgData = new OrgData(
                organisation.getOrgName(),
                organisation.getRegDate(),
                organisation.getExpDate(),
                organisation.getEnabled());

        orgRepository.save(newOrgData);
    }

    public OrgData getOrgData(long orgId) throws DataNotFoundException {
        Optional<OrgData> orgData = orgRepository.findById(orgId);
        if (orgData.isPresent()){
            return orgData.get();
        } else {
            throw new DataNotFoundException("No organization found with ID: " + orgId);
        }
    }

    public List<OrgData> getAllOrgData(){
        return orgRepository.findAll();
    }

    public void updateOrgData(long orgId, Organisation organisation) throws DataNotFoundException {
        OrgData currentOrgData = getOrgData(orgId);

        currentOrgData.setOrgName(organisation.getOrgName());
        currentOrgData.setRegDate(organisation.getRegDate());
        currentOrgData.setExpDate(organisation.getExpDate());
        currentOrgData.setEnabled(organisation.getEnabled());

        orgRepository.save(currentOrgData);
    }

    public void deleteOrgData(long orgId){
        orgRepository.deleteById(orgId);
    }
}
