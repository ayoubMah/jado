package ayoub;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>() ;
    private Gson gson ;
    private static final String FILE_PATH = "src/main/resources/tasks.json" ;

    public TaskManager () {
        this.gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
        loadTasks() ;
    }

    // saving our task in the json file
    // i use gpt for ✅ ❌ ⚠ ...
    public void saveTasks() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(tasks, writer);
            System.out.println("📁 Tasks saved successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error saving tasks: " + e.getMessage());
        }
    }

    public void loadTasks() {
        try {
            if (!Files.exists(Paths.get(FILE_PATH))) return;
            String json = new String(Files.readAllBytes(Paths.get(FILE_PATH)));

            Type listType = new TypeToken<List<Task>>() {}.getType();
            tasks = gson.fromJson(json, listType);
            System.out.println("✅ Loaded " + tasks.size() + " existing tasks.");
        } catch (IOException e) {
            System.out.println("❌ Error loading tasks: " + e.getMessage());
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }


    // method to add tasks
    public void addTask(Task task){
        tasks.add(task);
        saveTasks();
    }

    // fetch all tasks
    public void listTasks(){

        if(tasks.isEmpty()){
            System.out.println("No Task available");
        }else {
            for(Task task : tasks){
                System.out.println(task);
            }
        }
    }

    // Mark a task as completed
    public void markedDone(int index){
        if (index >= 0 && index < tasks.size()){
            tasks.get(index).setStatus(Status.DONE);
            System.out.println("Tasked Marked Done ");
        }else {
            System.out.println("Invalid task index ! ");
        }
    }

    // remove a task
    public void removeTask(int index){
        if(index >= 0 && index < tasks.size()){
            tasks.remove(index);
            System.out.println("Task removed successfully ");
        }else{
            System.out.println("Invalid task index !");
        }
    }


}
