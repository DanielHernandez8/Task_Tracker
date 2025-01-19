package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private int id;
    private String name;

    public Task(LocalDate createdAt, String description, int id, String name, String status, LocalDate updatedAt) {
        this.createdAt = createdAt;
        this.description = description;
        this.id = id;
        this.name = name;
        this.status = status;
        this.updatedAt = updatedAt;
    }

    private String description;
    private String status;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Task(String title, String description, String status, LocalDate updatedAt) {
    }

    @Override
    public String toString() {
        return "Task{" +
                "\ncreatedAt: " + createdAt +
                "\nid: " + id +
                "\nname: " + name + '\'' +
                "\ndescription: " + description + '\'' +
                "\nstatus: " + status + '\'' +
                "\nupdatedAt: " + updatedAt +
                '}';
    }
}
