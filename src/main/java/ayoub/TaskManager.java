package ayoub;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>() ;


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
