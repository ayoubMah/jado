package ayoub;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager() ;


        while (true){
            System.out.println("\n ============ TO DO LIST MENU : ==============");
            System.out.println("\n Choose an option: ");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");

            int choice  = scanner.nextInt();
            scanner.nextLine() ;

            switch (choice){
                case 1:
                    System.out.println("Enter the Title of your Task :");
                    String title = scanner.nextLine() ;

                    System.out.println("Choose status : TODO or DONE ");
                    Status status = Status.valueOf(scanner.nextLine().toUpperCase());

                    System.out.println("Enter due date (yyyy-MM-dd) ");
                    LocalDate date = LocalDate.parse(scanner.nextLine()) ;

                    System.out.println("Choose priority: RED, ORANGE, GREEN");
                    Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());

                    Task newTask = new Task(title , status , date , priority) ;
                    taskManager.addTask(newTask);
                    System.out.println("Task added!");

                    break;


                case 2 :
                    taskManager.listTasks();
                    break;

                case 3 :
                    System.out.println("Enter Task number to marked Done ");
                    int taskIndex = scanner.nextInt() - 1 ;
                    taskManager.markedDone(taskIndex);

                case 4:
                    System.out.println("Enter task number to remove:");
                    int removeIndex = scanner.nextInt() - 1;
                    taskManager.removeTask(removeIndex);
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");

            }

        }
    }
}