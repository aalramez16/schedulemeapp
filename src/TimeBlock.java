public class TimeBlock {

    private int timeStart;
    private int timeEnd;
    private Task task;

    public TimeBlock(int timeStart, int timeEnd){
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        task = null;
    }

    public TimeBlock(int timeStart){
        this.timeStart = timeStart;
        this.timeEnd = timeStart;
        task = null;
    }

    public void setTask(Task task){
        this.task = task;
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
