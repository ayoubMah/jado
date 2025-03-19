package ayoub;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for (int i = 0 ; i < 3 ; i++){
            System.out.println("Enter your Task : ");
            String yourTask = scanner.nextLine() ;

            System.out.println("Choose status: TODO, DONE");
            String statusInput = scanner.nextLine().toUpperCase();

            Status status ;
            try {
                status = Status.valueOf(statusInput) ;
            }catch (IllegalArgumentException e){
                System.out.println("Invalid Status --> default status is TODO ");
                status = Status.TODO ;
            }

            System.out.println("Enter due date (yyyy-MM-dd):");
            String dateInput = scanner.nextLine() ;

            LocalDate localDate ;
            try{
                localDate = LocalDate.parse(dateInput) ;
            }catch (DateTimeParseException e){
                System.out.println("Invalide Date Formate --> Default date in to day");
                localDate = LocalDate.now() ;
            }

            System.out.println("Choose priority: RED, ORANGE or GREEN");
            String priorityInput = scanner.nextLine().toUpperCase();

            Priority priority ;
            try {
                priority = Priority.valueOf(priorityInput) ;
            }catch (IllegalArgumentException e){
                System.out.println("Invalid Priority --> default Priority is ORANGE ");
                priority = Priority.ORANGE ;
            }

            Task t1 = new Task(yourTask, status , localDate , priority );

            List<Task> tasks = new ArrayList<>();
            tasks.add(t1);

            System.out.println(t1);

        }


    }
}