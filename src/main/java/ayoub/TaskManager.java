package ayoub;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>() ;

    private static final String FILE_PATH = "tasks.json" ;

    public TaskManager () {

    }

    public TaskManager(List<Task> tasks){
        this.tasks = tasks ;
    }

    // saving our task in the json file
    // i use gpt for ✅ ❌ ⚠ ...
    public void saveTasks(){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();

        try(FileWriter writer = new FileWriter(FILE_PATH)){
            gson.toJson(tasks , writer);
            System.out.println("✅ Tasks saved successfully!");
        }catch (IOException e){
            System.out.println("❌ Error saving tasks: " + e.getMessage());
        }
    }

    // read tasks.json and convert the json back into the List<Task>
    private List<Task> loadTasks(){
        File file  = new File(FILE_PATH) ;
        if(!file.exists()){
            System.out.println("⚠ No saved tasks found. Starting with an empty list.");
            return new ArrayList<>();
        }

        Gson gson = new Gson();
        Type taskListType = new TypeToken<List<Task>>() {}.getType();

        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, taskListType);
        } catch (IOException e) {
            System.out.println("❌ Error loading tasks: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }


    // method to add tasks
    public void addTask(Task task){
        tasks.add(task);
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
