public class Event {
    private int id;
    private String name;
    private String categoryName;
    private boolean inCategory;
    private int start;
    private int end;

    public Event(String name, String categoryName, int start, int end){

        //variables for event definition
        this.name = name;
        this.categoryName = categoryName;
        this.start = start;
        this.end = end;
        inCategory = true;

        Events.getInstance().addEvent(this);
        Events.getInstance().setEventId(this); //Event ID
    }

    public Event(String name, int start, int end){

        this.name = name;
        this.start = start;
        this.end = end;
        inCategory = false;

        Events.getInstance().addEvent(this);
        Events.getInstance().setEventId(this); //Event ID
    }

    public int getId(){
        return id;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        //TODO: Find a way to switch the category in which this event is embedded.
    }
    public boolean isInCategory(){
        return inCategory;
    }

    public void setId(int id){
        this.id = id;

        if (isInCategory()){
            Category category = Categories.getInstance().getCategory(categoryName);
            category.addEvent(this.id);
        }
    }

}
