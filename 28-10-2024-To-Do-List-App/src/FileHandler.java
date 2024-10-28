import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "tasks.txt";

    public void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                String line = task.getDescription() + "," + task.isComplete() + "," + task.getDueDate() + "," + task.getPriority();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Task saved to file");
        } catch (IOException e)
        {
            System.out.println("error saving tasks to file: " + e.getMessage());
        }
    }

    // method to load tasks from file
    public List<Task> loadTasks(){
        List<Task> tasks = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                String description = parts[0];
                boolean isComplete = Boolean.parseBoolean(parts[1]);
                String dueDate = parts[2];
                String priority = parts[3];
                Task task = new Task(description, isComplete,dueDate,priority);
                tasks.add(task);

            }
            System.out.println("Tasks loaded from file");
        }
        catch (IOException e){
            System.out.println("Error loading from file " + e.getMessage());
        }
        return tasks;
    }
}
