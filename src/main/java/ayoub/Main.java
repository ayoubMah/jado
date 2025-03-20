package ayoub;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("\nChoose an option: ");
            System.out.println("1️ Add Task");
            System.out.println("2️ View Tasks");
            System.out.println("3️ Edit Task");
            System.out.println("4️ Delete Task");
            System.out.println("5️ Exit");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addTask(scanner, taskManager);
                    break;
                case "2":
                    viewTasks(taskManager);
                    break;
                case "3":
                    editTask(scanner, taskManager);
                    break;
                case "4":
                    deleteTask(scanner, taskManager);
                    break;
                case "5":
                    System.out.println("👋 Exiting...");
                    return;
                default:
                    System.out.println("❌ Invalid option, try again.");
            }
        }
    }

    private static void addTask(Scanner scanner, TaskManager taskManager) {
        System.out.println("Enter task title:");
        String title = scanner.nextLine();

        System.out.println("Enter due date (YYYY-MM-DD):");
        LocalDate dueDate;
        while (true) {
            try {
                dueDate = LocalDate.parse(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("❌ Invalid date format! Please enter in YYYY-MM-DD format.");
            }
        }

        System.out.println("Choose priority: [1] RED [2] ORANGE [3] GREEN");
        Priority priority;
        while (true) {
            String priorityChoice = scanner.nextLine();
            if (priorityChoice.equals("1")) {
                priority = Priority.RED;
                break;
            } else if (priorityChoice.equals("2")) {
                priority = Priority.ORANGE;
                break;
            } else if (priorityChoice.equals("3")) {
                priority = Priority.GREEN;
                break;
            } else {
                System.out.println("❌ Invalid choice! Enter 1, 2, or 3.");
            }
        }

        Task newTask = new Task(title, Status.TODO, dueDate, priority);
        taskManager.addTask(newTask);
        System.out.println("✅ Task added successfully!");
    }


    private static int getIntInput(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a valid number.");
            }
        }
    }


    private static void editTask(Scanner scanner, TaskManager taskManager) {
        viewTasks(taskManager);
        System.out.println("Enter task number to edit:");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.println("Enter new title:");
        String newTitle = scanner.nextLine();

        Status newStatus = getStatus(scanner);
        LocalDate newDate = getDueDate(scanner);
        Priority newPriority = getPriority(scanner);

        Task updatedTask = new Task(newTitle, newStatus, newDate, newPriority);
        taskManager.editTask(index, updatedTask);
    }

    private static void deleteTask(Scanner scanner, TaskManager taskManager) {
        viewTasks(taskManager);
        System.out.println("Enter task number to delete:");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        taskManager.removeTask(index);
    }

    private static void viewTasks(TaskManager taskManager) {
        System.out.println("\n📌 Your Tasks:");
        List<Task> tasks = taskManager.getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static Status getStatus(Scanner scanner) {
        while (true) {
            System.out.println("Choose status: TODO, DONE");
            String input = scanner.nextLine().toUpperCase();
            try {
                return Status.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Status! Please enter TODO or DONE.");
            }
        }
    }

    private static LocalDate getDueDate(Scanner scanner) {
        while (true) {
            System.out.println("Enter due date (yyyy-MM-dd):");
            String input = scanner.nextLine();
            try {
                return LocalDate.parse(input);
            } catch (Exception e) {
                System.out.println("Invalid Date Format! Try again.");
            }
        }
    }

    private static Priority getPriority(Scanner scanner) {
        while (true) {
            System.out.println("Choose priority: RED, ORANGE, GREEN");
            String input = scanner.nextLine().toUpperCase();
            try {
                return Priority.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Priority! Please enter RED, ORANGE, or GREEN.");
            }
        }
    }
}

