package com.tasktracker.cli;

import java.time.Instant;
import java.util.Scanner;

public class Taskcli {

    TaskManager taskManager = new TaskManager();
    Scanner scanner = new Scanner(System.in);

    public void createTask() {


        System.out.println("Ingrese la descripcion del task");
        String description = scanner.nextLine();
        taskManager.addTask(description);
    }

    public void listTasks() {
        taskManager.listTasks();
    }

    public void updateTask() {
        System.out.println("Ingrese un Id del task");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la descripcion del task");

        String description = scanner.nextLine();

        taskManager.updateTask(id, description);

    }

    public void deleteTask() {
        System.out.println("Ingrese el Id del task");
        int id = scanner.nextInt();
        scanner.nextLine();
        taskManager.deleteTask(id);
    }


    public void markedTodo() {
        System.out.println("Ingrese un Id del task");
        int id = scanner.nextInt();
        scanner.nextLine();

        taskManager.taskTodo(id);
    }

    public void markCompleteTask() {
        System.out.println("Ingrese el Id del task");
        int id = scanner.nextInt();
        scanner.nextLine();

        taskManager.taskComplete(id);
    }

    public void markedInProgressTask() {
        System.out.println("Ingrese el Id del task");
        int id = scanner.nextInt();
        taskManager.taskInProgress(id);
    }


    //SAVEJSON

    public void saveJson() {

        taskManager.saveToJson("tasks");

    }

    //LOADJSON
    public void loadJson() {


        taskManager.loadFromJson("tasks");
    }

}
