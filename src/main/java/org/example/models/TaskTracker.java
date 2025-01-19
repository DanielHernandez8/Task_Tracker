package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TaskTracker {
    private List<Task> tasks = new ArrayList<>();

    private void addTask(Task task){
       tasks.add(task);
        System.out.println("Task added: " + task);
    }
    public List<Task> getTasks(){
        return tasks;
    }
    public void updateTask(int taskId, String title, String description, String status, LocalDate updatedAt){
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setStatus(status);
                task.setUpdatedAt(updatedAt);
                System.out.println("Task updated: " + task);
                return;
            }
        }
        System.out.println("Task not found." + taskId);
    }

    public void deleteTask(int taskId){
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                tasks.remove(task);
                System.out.println("Task deleted");
                return;
            }
        }
        System.out.println("Task not found." + taskId);
    }

    public void add(Task newTask) {
        tasks.add(newTask);
    }
}
