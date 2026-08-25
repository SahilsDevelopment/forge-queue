
-- Table for storing all the jobs.

CREATE TABLE jobs(
    id VARCHAR(255) PRIMARY KEY NOT NULL,
    job_id VARCHAR(255) UNIQUE NOT NULL,
    job_name VARCHAR(50) NOT NULL,
    job_interval VARCHAR(25) NOT NULL,
    created_at timestamp(6) NOT NULL,
    executed_at timestamp(6) NULL,
    updated_at timestamp(6) NULL,
    job_status VARCHAR(50) NOT NULL,
    job_description TEXT NULL
);