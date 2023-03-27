package com.pfa2.ProjectsCRUD.service;

import com.pfa2.ProjectsCRUD.exception.ProjectNotFoundException;
import com.pfa2.ProjectsCRUD.model.Project;
import com.pfa2.ProjectsCRUD.repos.ProjectRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepo projectRepo;

    //@Autowired
    public ProjectServiceImpl(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public Project createProject(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public Project updateProject(Project project) {
        Project existingProject = projectRepo.findById(project.getId())
                .orElseThrow(() -> new ProjectNotFoundException("Project with id " + project.getId() + " not found"));

        existingProject.setTitle(project.getTitle());
        existingProject.setDescription(project.getDescription());
        existingProject.setPayment(project.getPayment());
        existingProject.setActive(project.getActive());
        existingProject.setDate(project.getDate());
        existingProject.setProgress(project.getProgress());

        return projectRepo.save(existingProject);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepo.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id " + id + " not found"));
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }
}

