import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private int id;
    private String description;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class TaskManager {
    private List<Task> taskList = new ArrayList<>();
    private int nextId = 1;

    public void createTask(String description) {
        Task task = new Task(nextId, description);
        taskList.add(task);
        nextId++;
        System.out.println("Task created: " + task.getId() + ", " + task.getDescription());
    }

    public void readTasks() {
        System.out.println("Task List:");
        for (Task task : taskList) {
            System.out.println(task.getId() + ", " + task.getDescription());
        }
    }

    public void updateTask(int id, String newDescription) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                task.setDescription(newDescription);
                System.out.println("Task updated: " + task.getId() + ", " + task.getDescription());
                return;
            }
        }
        System.out.println("Task not found with ID: " + id);
    }

    public void deleteTask(int id) {
        Task taskToRemove = null;
        for (Task task : taskList) {
            if (task.getId() == id) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove != null) {
            taskList.remove(taskToRemove);
            System.out.println("Task deleted: " + taskToRemove.getId() + ", " + taskToRemove.getDescription());
        } else {
            System.out.println("Task not found with ID: " + id);
        }
    }
}

public class TaskApp {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Task");
            System.out.println("2. Read Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.createTask(description);
                    break;
                case 2:
                    taskManager.readTasks();
                    break;
                case 3:
                    System.out.print("Enter task ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new task description: ");
                    String newDescription = scanner.nextLine();
                    taskManager.updateTask(idToUpdate, newDescription);
                    break;
                case 4:
                    System.out.print("Enter task ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    taskManager.deleteTask(idToDelete);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
