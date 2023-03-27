package com.pfa2.ProjectsCRUD.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="project")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "domain_id", nullable = false)
    @JsonBackReference
    private ProjectDomain projectDomain;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "payment")
    private double payment;
    @Column(name = "active")
    private boolean active;
    @Column(name = "date")
    @UpdateTimestamp
    private Date date;
    @Column(name = "progress")
    private String progress;

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active){
        this.active = active;
    }
}
