package ayoub;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        System.out.println("📋 Welcome to To-Do List CLI");
        System.out.println("✅ Loaded " + taskManager.getTasks().size() + " existing tasks.\n");

        while (true) {
            System.out.println("Choose an option: ");
            System.out.println("1️⃣ Add Task ---> type 1");
            System.out.println("2️⃣ View Tasks ---> type 2");
            System.out.println("3️⃣ Exit ---> type 3");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addTask(scanner, taskManager);
                    break;
                case "2":
                    viewTasks(taskManager);
                    break;
                case "3":
                    System.out.println("👋 Exiting... Tasks saved.");
                    taskManager.saveTasks();
                    return;
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    private static void addTask(Scanner scanner, TaskManager taskManager) {
        System.out.println("Enter task title:");
        String title = scanner.nextLine();

        System.out.println("Choose status: TODO, DONE");
        String statusInput = scanner.nextLine().toUpperCase();
        Status status;
        try {
            status = Status.valueOf(statusInput);
        } catch (IllegalArgumentException e) {
            System.out.println("⚠ Invalid status. Defaulting to TODO.");
            status = Status.TODO;
        }

        System.out.println("Enter due date (yyyy-MM-dd):");
        String dateInput = scanner.nextLine();
        LocalDate dueDate;
        try {
            dueDate = LocalDate.parse(dateInput);
        } catch (DateTimeParseException e) {
            System.out.println("⚠ Invalid date. Defaulting to today.");
            dueDate = LocalDate.now();
        }

        System.out.println("Choose priority: RED, ORANGE, GREEN");
        String priorityInput = scanner.nextLine().toUpperCase();
        Priority priority;
        try {
            priority = Priority.valueOf(priorityInput);
        } catch (IllegalArgumentException e) {
            System.out.println("⚠ Invalid priority. Defaulting to ORANGE.");
            priority = Priority.ORANGE;
        }

        Task newTask = new Task(title, status, dueDate, priority);
        taskManager.getTasks().add(newTask);
        taskManager.saveTasks();
        System.out.println("✅ Task added successfully!\n");
    }

    private static void viewTasks(TaskManager taskManager) {
        if (taskManager.getTasks().isEmpty()) {
            System.out.println("📭 No tasks found.");
            return;
        }
        System.out.println("\n📌 Your Tasks:");
        for (Task task : taskManager.getTasks()) {
            System.out.println(task);
        }
        System.out.println();
    }
}
