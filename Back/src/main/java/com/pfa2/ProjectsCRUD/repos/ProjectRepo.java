package com.pfa2.ProjectsCRUD.repos;

import com.pfa2.ProjectsCRUD.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

//import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {
}
