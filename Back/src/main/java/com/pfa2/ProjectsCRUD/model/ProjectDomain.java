package com.pfa2.ProjectsCRUD.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "project_domain")
@Getter
@Setter
public class ProjectDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "domain_name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectDomain")
    @JsonManagedReference
    private List<Project> projects = new ArrayList<>();
}