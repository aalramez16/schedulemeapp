public class Task {
    private int id;
    private String name;
    private double importance;
    private String categoryName;
    private int startBy;
    private int duration;
    private int deadline;
    private boolean inCategory;

    public Task(String name, int importance, String categoryName, int startBy, int duration, int deadline){

        //variables for task definition
        this.name = name;
        this.importance = importance;
        this.categoryName = categoryName;

        this.startBy = startBy;
        this.duration = duration;
        this.deadline = deadline;

        inCategory = true;

        Tasks.getInstance().addTask(this);
        Tasks.getInstance().setTaskId(this); //Task ID
    }

    public Task(String name, int importance, int startBy, int duration, int deadline){

        this.name = name;
        this.importance = importance;
        this.startBy = startBy;
        this.duration = duration;
        this.deadline = deadline;

        inCategory = false;

        Tasks.getInstance().addTask(this);
        Tasks.getInstance().setTaskId(this); //Task ID
    }

    public int getId(){
        return id;
    }

    public int getStartBy() { return startBy; }
    public int getDuration() { return duration; }
    public int getDeadline() { return deadline; }

    public void setStartBy(int startBy) { this.startBy = startBy; }
    public void setDuration(int duration) { this.duration = duration; }
    public void setDeadline(int deadline) { this.deadline = deadline; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getImportance() {
        return importance;
    }
    public void setImportance(int importance) {
        this.importance = importance;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        //TODO: Find a way to switch the category in which this task is embedded.
    }
    public boolean isInCategory(){
        return inCategory;
    }

    public void setId(int id){
        this.id = id;

        if (isInCategory()){
            Category category = Categories.getInstance().getCategory(categoryName);
            category.addTask(this.id);
        }
    }


}
