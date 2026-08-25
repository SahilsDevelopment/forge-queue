package com.syndrome.forge_queue.repository;

import com.syndrome.forge_queue.model.JobRunner;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JobRunnerRepository extends JpaRepository<JobRunner, String>{
}