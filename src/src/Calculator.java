import java.util.*;

public class Calculator {
    public Calculator() {

    }

    public void sortByPriority() {
        ArrayList<Task> tasks = Tasks.getInstance().getTasks();
        int listSize = tasks.size();
        Double[] importanceArray = new Double[listSize];
        Double[] sortedImportanceArray = new Double[listSize];

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            Category category = Categories.getInstance().getCategory(task.getCategoryName());

            double taskImportance = task.getImportance();
            double totalImportance = taskImportance;

            if (task.isInCategory()){
                double categoryImportance = category.getImportance();
                totalImportance = (.4 * taskImportance) + (.6 * categoryImportance);
            }

            importanceArray[i] = totalImportance;
            sortedImportanceArray[i] = totalImportance;
        }
        Arrays.sort(sortedImportanceArray);

        ArrayList<Double> importanceList = new ArrayList<>();
        Collections.addAll(importanceList, sortedImportanceArray);
        Task[] taskArray = new Task[(int) (importanceList.get(importanceList.size() - 1) * listSize)];

        for (int i = 0; i < listSize; i++) {
            double tIndex = (importanceArray[i] * importanceList.indexOf(importanceArray[i]));
            importanceList.set(importanceList.indexOf(importanceArray[i]), 0.0);
            taskArray[(int) ((taskArray.length - tIndex) - 1)] = tasks.get(i);
        }

        ArrayList<Task> taskList = new ArrayList<>();
        for (Task task : taskArray) {
            if (task != null) {
                taskList.add(task);
            }
        }

        for (int i = 0; i < listSize; i++) {
            System.out.println(
                    taskList.get(i).getId() +
                    "\t" + taskList.get(i).getName() +
                    "\t" + sortedImportanceArray[(listSize - i) - 1]
            );
        }
    }
}
