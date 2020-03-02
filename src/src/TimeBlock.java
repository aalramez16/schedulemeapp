public class TimeBlock {

    private int timeStart;
    private int timeEnd;
    private Task task;
    private Event event;

    public TimeBlock(int timeStart, int timeEnd){
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        task = null;
        event = null;
    }

    public TimeBlock(int timeStart){
        this.timeStart = timeStart;
        this.timeEnd = timeStart;
        task = null;
        event = null;
    }

    public void setTask(Task task){
        this.task = task;
    }

    public void setEvent(Event event){
        this.event = event;
    }

    public int getTimeStart() {
        return timeStart;
    }

    public int getTimeEnd() {
        return timeEnd;
    }

    public void trimAtStart(int trim) {
        timeStart += trim;
    }

    public void trimAtEnd(int trim) {
        timeEnd -= trim;
    }

    public int getDuration(){
        return timeEnd - timeStart;
    }
}
