package ayoub;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>() ;

    public TaskManager(List<Task> tasks){
        this.tasks = tasks ;
    }

    // method to add tasks
    public void addTask(Task task){
        tasks.add(task);
    }

    // fetch all tasks
    public void listTasks(){
        for(Task task : tasks){
            System.out.println(task);
        }
    }

    // Mark a task as completed
    public void completed(Task task){

    }
}
