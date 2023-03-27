package com.pfa2.ProjectsCRUD.controllers;

import com.pfa2.ProjectsCRUD.model.Project;
import com.pfa2.ProjectsCRUD.service.ProjectServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin({"http://localhost:4200", "http://localhost:8080"})
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectServiceImpl projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
        return ResponseEntity.ok().body(project);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok().body(projects);
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createdProject = projectService.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
    }

    @PutMapping
    public ResponseEntity<Project> updateProject(@RequestBody Project project) {
        Project updatedProject = projectService.updateProject(project);
        return ResponseEntity.ok().body(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
