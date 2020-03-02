import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
/*        Task t1 = new Task("Vacuum the Living Room", 3,"Chores");
        Task t2 = new Task("Feed Cat", 3, "Chores");
        Task t3 = new Task("Mow the lawn", 4, "Chores");
        Task t4 = new Task("Wash Dishes", 3, "Chores");
        Task t5 = new Task("Science Paper", 4, "Homework");
        Task t6 = new Task("Fill out Form", 1, "Homework");
        Task t7 = new Task("Math Problems", 2, "Homework");
        Task t8 = new Task("Buy Bread", 3, "Errands");
        Task t9 = new Task("Buy Soap", 3, "Errands");
        Task t10 = new Task("Meeting with The President", 5);

        Categories.getInstance().getCategory("Chores").setImportance(3);
        Categories.getInstance().getCategory("Homework").setImportance(5);
        Categories.getInstance().getCategory("Errands").setImportance(2);


        Calculator calculator = new Calculator();
        calculator.sortByPriority();*/

        Day day = new Day(0,24);
        day.assignTime(8,15);
        day.assignTime(7,8);
        day.assignTime(17,20);
        day.assignTime(21,23);

        System.out.println("Times Busy:");
        for (int i = 1; i < day.getTaskTimeList().size()-1; i++) {
            System.out.println(day.getTaskTimeList().get(i).getTimeStart() +
                    "\t" + day.getTaskTimeList().get(i).getTimeEnd());
        }
        System.out.println("\n" +
                "Times Available:");
        for (int i = 0; i < day.getFreeTimeList().size(); i++) {
            System.out.println(day.getFreeTimeList().get(i).getTimeStart() +
                    "\t" + day.getFreeTimeList().get(i).getTimeEnd());
        }

    }


}
