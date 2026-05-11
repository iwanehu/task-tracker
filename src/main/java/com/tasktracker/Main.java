package com.tasktracker;


import com.tasktracker.cli.InteractiveShell;
import com.tasktracker.cli.TaskManager;
import com.tasktracker.cli.Taskcli;
import com.tasktracker.modelo.Status;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {




  public static void main(String[] args) {


    TaskManager manager = new TaskManager();
    manager.loadFromJson("tasks");



    // MODO INTERACTIVO
    new InteractiveShell(manager).start();
    manager.saveToJson("tasks");
  }

}