package com.tasktracker.cli;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tasktracker.modelo.Status;
import com.tasktracker.modelo.Task;

import java.io.File;
import java.time.Instant;
import java.util.ArrayList;

import java.util.List;

public class TaskManager {

   private List<Task> tasks = new ArrayList<>();



    //__________
   //Guardar Json
    // _________________

    public void saveToJson(String filename){

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try
            {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename+".json"),tasks);
                System.out.println("TASK saved to" +  filename+".json");

            }catch (Exception e){
            e.printStackTrace();
        }
    }

    //_________________________
    //Cargar Json
    //_______________________

    public void loadFromJson(String filename){
        File file = new File(filename+".json");

        //si no existe .Inicializamos lista vacia
        if(!file.exists()){
            System.out.println("No existing tasks.json found. Starting with empty task list.");
            tasks = new ArrayList<>();
            return;
        }


        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            tasks = mapper.readValue(
                    new File(filename + ".json"),
                    new TypeReference<List<Task>>(){}
            );

            System.out.println("Tasks loaded from "+filename +".json");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void addTask(String description) {

        int id = generateId();
        Task task = new Task(id, description);
        if(idExists(id)) {
            System.out.println("Task already exists");
        }

        tasks.add(task);
        System.out.println("Task added successfully" + task);
    }






    public void listTasks(){
        if(tasks.isEmpty()){
            System.out.println("Nothing to list");
        }else {
            for(Task task:tasks){
                System.out.println(task);
            }
        }
    }


    //Listar estado

    public void listByStatus(Status status){
        boolean found = false;
        for(Task task:tasks){
            if(task.getStatus() == status){
                System.out.println(task);
                found = true;
            }
        }
        if(!found){
            System.out.println("No tasks with status "+status);
        }

    }



    //Metodos

    public void listByStatus(String statusText){
        try{
            Status status = Status.valueOf(statusText.toUpperCase().replace("-","-"));
            listByStatus(status);
        }catch (IllegalArgumentException e){
            System.out.println("Invalid status "+statusText);
        }
    }


    public int generateId(){
        if(tasks.isEmpty()){
            return 1;
        }
        int maxId =0;
        for(Task task:tasks){
            if(task.getId() > maxId){
                maxId = task.getId();
            }
        }
        return maxId+1;
    }

    //Encontrar por id
    public Task findById(int id){
        for(Task task:tasks){
            if(task.getId() == id){
                return task;
            }
        }return null;
    }

    //eVITAR DUPLICADOS
    public boolean idExists(int id){
       return findById(id) != null;
    }


    //update task


    public void updateTask(int id, String newdescription) {
        Task task = findById(id);

        if (task == null){
            System.out.println("Task not found: " + id);
        }
        task.setDescription(newdescription);
        task.setUpdatedAt(Instant.now());
        System.out.println("Task updated:\n" + task);


    }


    //delete task
    public void deleteTask(int id){
      Task task = findById(id);

      if (task == null){
          System.out.println("Task not found: " + id);
          return;
      }
      tasks.remove(task);
      System.out.println("Task deleted successfully " + id);
    }



    public void taskTodo(int id){
        Task task = findById(id);
        if (task == null){
            System.out.println("Task not found: " + id);
            return;
        }
        task.setStatus(Status.TODO);
        task.setUpdatedAt(Instant.now());

        System.out.println("Task marked as todo:\n" + task);
    }

    public void taskComplete(int id){
        Task task = findById(id);
        if (task == null){
            System.out.println("Task not found: " + id);
            return;
        }
        task.setStatus(Status.DONE);
        task.setUpdatedAt(Instant.now());

        System.out.println("Task marked  as done:\n" + task);
    }

    public void taskInProgress(int id){

        Task task= findById(id);
        if (task == null){
            System.out.println("Task not found: " + id);
            return;
        }
        task.setStatus(Status.IN_PROGRESS);
        task.setUpdatedAt(Instant.now());

        System.out.println("Task marked  as in-progress:\n" + task);

    }

}
