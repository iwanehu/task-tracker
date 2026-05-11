package com.tasktracker.modelo;

import java.time.Instant;

public class Task {
    private int id;
    private String description;
    private Status status;
    private Instant  createdAt;
    private Instant updatedAt;

    public Task(){

    }

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = Instant.now();
        this.updatedAt = this.createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        this.updatedAt = Instant.now();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = Instant.now();
    }

    public Status getStatus() {
        return  status;
    }

    public void setStatus(Status status) {
        this.status = status;
        this.updatedAt = Instant.now();
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status.toUpperCase().replace("-", "_"));
    }


    public Instant getCreatedAt() {
        return createdAt;
    }



    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return """
        Task {
          id=%d,
          description='%s',
          status=%s,
          createdAt=%s,
          updatedAt=%s
        }
        """.formatted(id, description, status, createdAt, updatedAt);
    }

}
