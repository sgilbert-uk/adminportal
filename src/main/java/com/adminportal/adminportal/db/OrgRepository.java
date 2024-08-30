package com.adminportal.adminportal.db;

import com.adminportal.adminportal.entities.OrgData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgRepository extends JpaRepository<OrgData,Long> {

    void deleteById(long id);

}
