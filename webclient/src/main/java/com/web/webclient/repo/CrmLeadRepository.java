package com.web.webclient.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CrmLeadRepository extends CrudRepository<CrmLead, Long> {
    Optional<CrmLead> findByName(String name);
 }
