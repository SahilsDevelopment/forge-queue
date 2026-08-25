package com.syndrome.forge_queue.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.text.DateFormat;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "jobs")
public class JobRunner {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    private String jobId;
    private String jobName;
    private String jobInterval;
    private String jobDescription;
    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp executedAt;
}
