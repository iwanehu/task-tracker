package com.tasktracker.cli;

public class ConsoleUi {
    public void printWelcome(){
        System.out.println("Welcome to TaskTracker");
        System.out.println("=== Task CLI (Interactive mode) ===");
        System.out.println("available commands:");
        System.out.println("add <descripcion>");
        System.out.println("update <id> <new description>");
        System.out.println("delete <id>");
        System.out.println("mark-done <id>");
        System.out.println("mark-in-progress <id>");
        System.out.println("mark-todo <id>");
        System.out.println("list");
        System.out.println("list <status>");
        System.out.println("exit");
    }

    public void promt(){
        System.out.println("> ");
    }

    public void unkownCommand(String cmd){
        System.out.println("Unknown command" + cmd);
    }

    public void error(String msg){
        System.out.println("Error: " + msg);
    }

    public void exit(){
        System.out.println("Exiting TaskTracker");
    }

}
