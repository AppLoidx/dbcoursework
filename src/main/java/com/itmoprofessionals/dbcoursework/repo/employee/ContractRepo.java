package com.itmoprofessionals.dbcoursework.repo.employee;

import com.itmoprofessionals.dbcoursework.domain.employee.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;
import java.util.UUID;

public interface ContractRepo extends JpaRepository<Contract, UUID> {

    @Query(value = "select * from active_cameraman()", nativeQuery = true)
    List<Contract> activeCameraman();
}
