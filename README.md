# ForgeQueue

ForgeQueue is a distributed job processing system built with **Java and Spring Boot**.

The project is being developed incrementally to understand how production-grade job processing systems work, starting from a simple database-backed worker and evolving into a distributed architecture using **Kafka and multiple workers**.

## Current Goal

The initial version focuses on three core capabilities:

1. **Job Creation** — Accept and persist jobs through a REST API.
2. **Job Execution** — A worker picks up pending jobs and executes them.
3. **Distributed Processing** — Use Kafka to distribute jobs across multiple workers.

## Initial Architecture

```text
Client
  │
  │ POST /api/v1/jobs
  ▼
ForgeQueue API
  │
  ▼
PostgreSQL
  │
  ▼
Kafka
  │
  ├── Worker 1
  ├── Worker 2
  └── Worker 3
```

## Job Lifecycle

```text
CREATED
   │
   ▼
RUNNING
   │
   ├──► COMPLETED
   │
   └──► FAILED
```

## Example

### Create a Job

```http
POST /api/v1/jobs
Content-Type: application/json
```

```json
{
  "type": "EMAIL",
  "payload": {
    "to": "sahil@example.com",
    "subject": "Welcome"
  }
}
```

### Response

```json
{
  "jobId": "job_123",
  "status": "CREATED"
}
```

## Technology Stack

* Java
* Spring Boot
* PostgreSQL
* Apache Kafka
* Docker

## Development Roadmap

* [x] Project initialization
* [ ] Job creation API
* [ ] Job persistence
* [ ] Basic job worker
* [ ] Job execution
* [ ] Kafka integration
* [ ] Multiple workers
* [ ] Idempotency
* [ ] Retry & failure handling
* [ ] Dead Letter Queue
* [ ] Scheduling
* [ ] Observability
* [ ] Load testing
* [ ] Kubernetes deployment

> The roadmap will be implemented incrementally. Each stage is designed to introduce and solve a specific distributed-systems problem.
