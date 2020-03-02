import java.util.ArrayList;

public class Category {

    private String name;
    private double importance;
    private ArrayList<Integer> tasks = new ArrayList<>();

    public Category(String name, int importance) {
        this.name = name;
        this.importance = importance;
    }

    public String getName(){
        return name;
    }

    public double getImportance(){
        return importance;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setImportance(int importance){
        this.importance = importance;
    }

    public void addTask(int id){
        tasks.add(id);
    }

    public void printTasks(){
        for (int i : tasks) {
            Task task = Tasks.getInstance().getTaskById(i);
            System.out.println("\t" + task.getName() + "\t" + task.getImportance());
        }
    }
}
