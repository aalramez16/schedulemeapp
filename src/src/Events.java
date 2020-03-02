import java.util.ArrayList;

public class Events {

    private int eventIdCounter = 0;
    private ArrayList<Event> events = new ArrayList<Event>();

    private static Events instance = null;
    public static synchronized Events getInstance(){
        if (instance == null){
            instance = new Events();
        }
        return instance;
    }

    public Event getEventById(int id){
        for (Event event : events) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }

    public void addEvent(Event event){
        events.add(event);
    }

    public ArrayList<Event> getEvents(){
        return events;
    }

    public void setEventId(Event event){
        event.setId(eventIdCounter);
        eventIdCounter++;
    }

    public void assignEvent(TimeBlock block, int id){
        block.setEvent(getEventById(id));
    }
}
