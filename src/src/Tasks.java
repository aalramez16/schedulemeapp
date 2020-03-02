import java.util.ArrayList;

public class Tasks {

    private int taskIdCounter = 0;
    private ArrayList<Task> tasks = new ArrayList<Task>();

    private static Tasks instance = null;
    public static synchronized Tasks getInstance(){
        if (instance == null){
            instance = new Tasks();
        }
        return instance;
    }

    public Task getTaskById(int id){
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public void setTaskId(Task task){
        task.setId(taskIdCounter);
        taskIdCounter++;
    }

    public void assignTask(TimeBlock block, int id){
        block.setTask(getTaskById(id));
    }
}
