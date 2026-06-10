package com.medjobs.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "application")
public class Application{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private User appliedBy;


    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime appliedOn;

    @PrePersist
    public void prePersist(){
        this.appliedOn = LocalDateTime.now();
        this.status = "Pending";
    }

}

