package org.example;

import org.example.models.Task;
import org.example.models.TaskTracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        TaskTracker taskTracker = new TaskTracker();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Tasks:");
            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Update task");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");
            System.out.println("Select option");
            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter task title: ");
                    String title = br.readLine();
                    System.out.println("Enter task description: ");
                    String description = br.readLine();
                    System.out.println("Enter task status: ");
                    String status = br.readLine();

                    LocalDate createdAtDate = null;
                    boolean validDate = false;

                    while (!validDate) {
                        System.out.println("Enter task created at(yyyy-MM-dd): ");
                        String createdAt = br.readLine();

                    try {
                        createdAtDate = LocalDate.parse(createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        validDate = true;
                    } catch (Exception e) {
                        System.out.println("Invalid date format, plasea try again (yyyy-MM-dd).");
                        break;
                    }
                    }

                    Task newTask = new Task();
                    newTask.setName(title);
                    newTask.setDescription(description);
                    newTask.setStatus(status);
                    newTask.setCreatedAt(createdAtDate);
                    newTask.setUpdatedAt(createdAtDate);
                    taskTracker.add(newTask);
                    System.out.println("Task added: " + newTask);
                    break;
                case 2:
                   if (taskTracker.getTasks().isEmpty()) {
                       System.out.println("No tasks found.");
                   }else {
                       taskTracker.getTasks().forEach(task -> System.out.println("TASKS: " + "\ncreated at: " + task.getCreatedAt() + "\nid: " + task.getId() + "\ntitle: " + task.getName() + "\ndescription: " + task.getDescription() + "\nstatus: " + task.getStatus()  + "\nupdated at: " + task.getUpdatedAt()));
                   }
                    break;
                case 3:
                    taskTracker.getTasks().forEach(task -> System.out.println("id: " + task.getId() + " Name: " + task.getName()));
                    System.out.println("Enter task id to update: ");
                    int update = Integer.parseInt(br.readLine());
                    Iterator<Task> it = taskTracker.getTasks().iterator();
                    while (it.hasNext()) {
                        Task task = it.next();
                        if (task.getId() == update) {
                            System.out.println("Enter new task title:");
                            String newTitle = br.readLine();
                            System.out.println("Enter new task description:");
                            String newDescription = br.readLine();
                            System.out.println("Enter new task status:");
                            String newStatus = br.readLine();
                            task.setName(newTitle);
                            task.setDescription(newDescription);
                            task.setStatus(newStatus);
                            System.out.println("Task updated: " + task);
                            break;
                        }
                        break;
                    }
                case 4:
                    taskTracker.getTasks().forEach(task -> System.out.println("Id: " + task.getId() + " Name: " + task.getName()));
                    System.out.println("Enter task id to remove:");
                    int deleteTaskId = Integer.parseInt(br.readLine());
                    taskTracker.deleteTask(deleteTaskId);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
            }
}
