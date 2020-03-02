import java.util.ArrayList;

public class Categories{

    private ArrayList<Category> categories = new ArrayList<>();

    private static Categories instance = null;
    public static synchronized Categories getInstance(){
        if (instance == null){
            instance = new Categories();
        }
        return instance;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public Category getCategory(String categoryName){
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                return category;
            }
        }
        Category newCategory = new Category(categoryName, 3);
        addCategory(newCategory);
        return newCategory;
    }

    public void printCategories(){
        for (Category category : categories) {
            System.out.println(category.getName() + "\t" + category.getImportance());
            category.printTasks();
        }
    }
}
