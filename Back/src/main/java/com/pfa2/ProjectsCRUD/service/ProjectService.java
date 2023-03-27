package com.pfa2.ProjectsCRUD.service;

import com.pfa2.ProjectsCRUD.model.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project);

    Project updateProject(Project project);

    void deleteProject(Long id);

    Project getProjectById(Long id);

    List<Project> getAllProjects();
}
