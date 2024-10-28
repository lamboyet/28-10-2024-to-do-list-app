public class ToDoListRunner {
    public static void main(String[] args) {
        Task task = new Task("description",false,"25/10/2024","important");
        Task task2 = new Task("description2",true,"25/10/2025","notimportant");
        ToDoList toDoList = new ToDoList();

        toDoList.addTask(task);
        toDoList.addTask(task2);
        toDoList.viewAllTasks();

        toDoList.deleteTask(1);
        toDoList.viewAllTasks();

        toDoList.editTask(0,"best description for a task");
        toDoList.viewAllTasks();

    }
}
