import java.util.LinkedList;

public class Day {

    private LinkedList<TimeBlock> freeTimeList = new LinkedList<TimeBlock>();
    private LinkedList<TimeBlock> taskTimeList = new LinkedList<TimeBlock>();
    private int dayStart;
    private int dayEnd;

    public Day(int dayStart, int dayEnd){
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;

        //Load entirety of available time as free time at start of instantiation
        freeTimeList.add(new TimeBlock(dayStart,dayEnd));

        //Load nodes to mark the beginning and end of the day, each at length 0
        taskTimeList.add(new TimeBlock(dayStart));
        taskTimeList.add(new TimeBlock(dayEnd));
    }

    public LinkedList<TimeBlock> getFreeTimeList() {
        return freeTimeList;
    }

    public LinkedList<TimeBlock> getTaskTimeList() {
        return taskTimeList;
    }

    public int getDayStart() {
        return dayStart;
    }

    public int getDayEnd() {
        return dayEnd;
    }

    public boolean assignTime(int start, int end){
        int duration = end-start;
        int index;
        for (int i = 0; i < freeTimeList.size(); i++) {
             TimeBlock block = freeTimeList.get(i);
             if (block.getTimeStart() <= start && block.getTimeEnd() >= end){
                 index = i;
                 TimeBlock splitBlock[] = split(freeTimeList.get(index),start);
                 splitBlock[1].trimAtStart(end-start);
                 freeTimeList.set(index,splitBlock[0]);
                 freeTimeList.add(index+1,splitBlock[1]);
                 clean(freeTimeList);
                 break;
             }
        }
        for (int i = 0; i < taskTimeList.size(); i++) {
            TimeBlock block = taskTimeList.get(i);
            TimeBlock nextBlock = taskTimeList.get(i+1);
            if (block.getTimeStart() <= start && nextBlock != null && nextBlock.getTimeStart() >= end){
                index = i;

                taskTimeList.add(index+1,new TimeBlock(start,end));
                return true;
            }
        }
        System.out.println("cannot schedule this");
        //TODO: have functionality ready to warn against this condition in the app
        return false;
    }

    private void clean(LinkedList<TimeBlock> l){
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getDuration() == 0){
                l.remove(l.get(i));
            }
        }
    }

    private TimeBlock[] split(TimeBlock timeBlock, int splitTime){
        TimeBlock[] s = new TimeBlock[2];

        TimeBlock block1 = new TimeBlock(timeBlock.getTimeStart(),splitTime);
        TimeBlock block2 = new TimeBlock(splitTime, timeBlock.getTimeEnd());

        s[0] = block1;
        s[1] = block2;
        return s;
    }

}
