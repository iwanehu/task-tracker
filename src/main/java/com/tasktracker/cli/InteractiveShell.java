package com.tasktracker.cli;

import java.util.Scanner;

public class InteractiveShell {

    private final TaskManager taskManager;
    private final ConsoleUi ui;
    private final CommandParser parser;

    public InteractiveShell(TaskManager taskManager){
        this.taskManager = taskManager;
        this.ui = new ConsoleUi();
        this.parser = new CommandParser();
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        ui.printWelcome();

        while (true){
            ui.promt();
            String line = scanner.nextLine().trim();
            if(line.equals("exit")){
                ui.exit();
                break;
            }
            String command = parser.getCommand(line);
            String args = parser.getArgs(line);

            try{
                switch (command){
                    case "add"->taskManager.addTask(args);

                    case "update"->{
                        String [] p = args.split(" ", 2);
                        if(p.length < 2){
                            ui.error("Uso: update <id> <nueva descripcion>");
                            break;
                        }
                        taskManager.updateTask(Integer.parseInt(p[0]), p[1]);
                    }

                    case "delete"->{taskManager.deleteTask(Integer.parseInt(args));}

                    case "mark-done"->taskManager.taskComplete(Integer.parseInt(args));
                    case "mark-in-progress"->taskManager.taskInProgress(Integer.parseInt(args));
                    case "mark-todo"->taskManager.taskTodo(Integer.parseInt(args));

                    case  "list" ->{
                        if(args.isEmpty())taskManager.listTasks();
                        else taskManager.listByStatus(parser.parseStatus(args));
                    }

                    default -> ui.unkownCommand(command);
                }
            }
            catch (Exception e){
                ui.error(e.getMessage());
            }
            taskManager.saveToJson("tasks");
        }
    }
}
