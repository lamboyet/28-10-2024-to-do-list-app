import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    private List<Task> tasks;
    private FileHandler fileHandler;

    public ToDoList() {
        fileHandler = new FileHandler();
        this.tasks = new ArrayList<>();
    }

    //add task
    //edit task
    //delete task
    // mark as complete

    public void addTask(Task task)
    {
        this.tasks.add(task);
        fileHandler.saveTasks(tasks);
        System.out.println("task added");
    }

    public void editTask(int index, String newDescription)
    {
        if(index >=0 && index<this.tasks.size())
        {
            Task task = this.tasks.get(index);
            task.setDescription(newDescription);
            fileHandler.saveTasks(this.tasks);
            System.out.println("Task updated: " + task.getDescription());
        }
        else {
            System.out.println("invalid task index");
        }
    }

    public void deleteTask(int index)
    {
        if(index >= 0 && index < this.tasks.size())
        {
            Task removedTask = this.tasks.remove(index);
            fileHandler.saveTasks(tasks);
            System.out.println("Task removed: " + removedTask.getDescription());

        }
        else
        {
            System.out.println("Invalid index");
        }
    }

    public void markAsComplete(int index)
    {
        if(index>=0 && index < this.tasks.size())
        {
            Task task = this.tasks.get(index);
            fileHandler.saveTasks(tasks);
            task.setComplete(true);
            System.out.println("task marked as complete: " + task.getDescription());
        }
    }

    public void viewAllTasks()
    {
        if(tasks.isEmpty())
            System.out.println("No tasks in the list");
        else {
            for(int i=0;i<this.tasks.size();i++) {
                Task task = tasks.get(i);
                System.out.println((i+1) + ". " + task);
            }
        }
    }

    public int getNumberOfElemetsInList()
    {
        return this.tasks.size();
    }
}
