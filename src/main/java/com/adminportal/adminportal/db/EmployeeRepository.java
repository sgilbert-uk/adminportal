package com.adminportal.adminportal.db;

import com.adminportal.adminportal.entities.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeData,Long> {

    void deleteById(long id);

    @Query(value = "SELECT * FROM employeedata WHERE org_id = ?1",nativeQuery = true)
    List<EmployeeData> findAllByOrgId(long orgId);
}
