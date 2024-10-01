import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    boolean isCompleted;

    Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    void markAsCompleted() {
        this.isCompleted = true;
    }

    public String toString() {
        return description + (isCompleted ? " (Completed)" : " (Pending)");
    }
}

public class coderush_2 {
    private static ArrayList<Task> taskList = new ArrayList<>();

    public static void addTask(String taskDescription) {
        Task newTask = new Task(taskDescription);
        taskList.add(newTask);
        System.out.println("Task added successfully!");
    }

    public static void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Your tasks:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println((i + 1) + ". " + taskList.get(i));
            }
        }
    }

    public static void markTaskAsCompleted(int taskIndex) {
        if (taskIndex <= 0 || taskIndex > taskList.size()) {
            System.out.println("Invalid task number.");
        } else {
            Task task = taskList.get(taskIndex - 1);
            task.markAsCompleted();
            System.out.println("Task marked as completed!");
        }
    }

    public static void deleteTask(int taskIndex) {
        if (taskIndex <= 0 || taskIndex > taskList.size()) {
            System.out.println("Invalid task number.");
        } else {
            taskList.remove(taskIndex - 1);
            System.out.println("Task deleted successfully!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Task Organizer ---");
            System.out.println("1. Add a task");
            System.out.println("2. View tasks");
            System.out.println("3. Mark a task as completed");
            System.out.println("4. Delete a task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String taskDescription = sc.nextLine();
                    addTask(taskDescription);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    System.out.print("Enter the task number to mark as completed: ");
                    int taskIndex = sc.nextInt();
                    markTaskAsCompleted(taskIndex);
                    break;
                case 4:
                    System.out.print("Enter the task number to delete: ");
                    taskIndex = sc.nextInt();
                    deleteTask(taskIndex);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting Task Organizer. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        sc.close();
    }
}