package com.backengtest.demo.repository;

import com.backengtest.demo.model.ProjectDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@Repository
public interface ProjectDomainRepo extends JpaRepository<ProjectDomain, Long> {
}
