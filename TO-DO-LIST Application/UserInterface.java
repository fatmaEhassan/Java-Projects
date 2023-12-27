import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

class UserInterface {
    private ToDoList toDoList;
    private FileManager fileManager;
    private Scanner scanner;

    public UserInterface(String fileName) {
        toDoList = new ToDoList();
        fileManager = new FileManager(fileName);
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("===== To-Do Application =====");
        System.out.println("1. Add a new item");
        System.out.println("2. Update an item");
        System.out.println("3. Delete an item");
        System.out.println("4. Filter items by category");
        System.out.println("5. Search items by title");
        System.out.println("6. Search items by creation date interval");
        System.out.println("7. Search items by due date interval");
        System.out.println("8. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                addItem();
                break;
            case 2:
                updateItem();
                break;
            case 3:
                deleteItem();
                break;
            case 4:
                filterByCategory();
                break;
            case 5:
                searchByTitle();
                break;
            case 6:
                searchByCreationDateInterval();
                break;
            case 7:
                searchByDueDateInterval();
                break;
            case 8:
                System.out.println("Exiting the application...");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

        showMenu(); // Show the menu again after completing the chosen operation
    }

    private void addItem() {
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();

        System.out.print("Enter the description: ");
        String description = scanner.nextLine();

        System.out.print("Enter the creation date (yyyy-mm-dd): ");
        String creationDateString = scanner.nextLine();
        LocalDate creationDate = LocalDate.parse(creationDateString);

        System.out.print("Enter the due date (yyyy-mm-dd): ");
        String dueDateString = scanner.nextLine();
        LocalDate dueDate = LocalDate.parse(dueDateString);

        System.out.print("Enter the category: ");
        String category = scanner.nextLine();

        Item item = new Item(title, description, creationDate, dueDate, category);
        toDoList.addItem(item);
        fileManager.saveItemsToFile(toDoList.getItems());
        System.out.println("Item added successfully.");
    }

    private void updateItem() {
        System.out.print("Enter the title of the item to update: ");
        String title = scanner.nextLine();

        List<Item> items = toDoList.searchByTitle(title);

        if (items.isEmpty()) {
            System.out.println("No items found with the given title.");
            return;
        }

        System.out.println("Select the item to update:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getTitle());
        }

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice < 1 || choice > items.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Item selectedItem = items.get(choice - 1);

        System.out.print("Enter the new title: ");
        String newTitle = scanner.nextLine();

        System.out.print("Enter the new description: ");
        String newDescription = scanner.nextLine();

        System.out.print("Enter the new creation date (yyyy-mm-dd): ");
        String newCreationDateString = scanner.nextLine();
        LocalDate newCreationDate = LocalDate.parse(newCreationDateString);

        System.out.print("Enter the new due date (yyyy-mm-dd): ");
        String newDueDateString = scanner.nextLine();
        LocalDate newDueDate = LocalDate.parse(newDueDateString);

        System.out.print("Enter the new category: ");
        String newCategory = scanner.nextLine();

        Item updatedItem = new Item(newTitle, newDescription, newCreationDate, newDueDate, newCategory);
        toDoList.updateItem(selectedItem, updatedItem);
        fileManager.saveItemsToFile(toDoList.getItems());
        System.out.println("Item updated successfully.");
    }

    private void deleteItem() {
        System.out.print("Enter the title of the item to delete: ");
        String title = scanner.nextLine();

        List<Item> items = toDoList.searchByTitle(title);

        if (items.isEmpty()) {
            System.out.println("No items found with the given title.");
           return;
        }

        System.out.println("Select the item to delete:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getTitle());
        }

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > items.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Item selectedItem = items.get(choice - 1);
        toDoList.deleteItem(selectedItem);
        fileManager.saveItemsToFile(toDoList.getItems());
        System.out.println("Item deleted successfully.");
    }

    private void filterByCategory() {
        System.out.print("Enter the category: ");
        String category = scanner.nextLine();

        List<Item> filteredItems = toDoList.filterByCategory(category);

        if (filteredItems.isEmpty()) {
            System.out.println("No items found with the given category.");
        } else {
            System.out.println("Filtered items:");
            for (Item item : filteredItems) {
                System.out.println(item);
            }
        }
    }

    private void searchByTitle() {
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();

        List<Item> foundItems = toDoList.searchByTitle(title);

        if (foundItems.isEmpty()) {
            System.out.println("No items found with the given title.");
        } else {
            System.out.println("Found items:");
            for (Item item : foundItems) {
                System.out.println(item);
            }
        }
    }

    private void searchByCreationDateInterval() {
        System.out.print("Enter the start date (yyyy-mm-dd): ");
        String startDateString = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(startDateString);

        System.out.print("Enter the end date (yyyy-mm-dd): ");
        String endDateString = scanner.nextLine();
        LocalDate endDate = LocalDate.parse(endDateString);

        List<Item> foundItems = toDoList.searchByCreationDateInterval(startDate, endDate);

        if (foundItems.isEmpty()) {
            System.out.println("No items found within the given date interval.");
        } else {
            System.out.println("Found items:");
            for (Item item : foundItems) {
                System.out.println(item);
            }
        }
    }

    private void searchByDueDateInterval() {
        System.out.print("Enter the start date (yyyy-mm-dd): ");
        String startDateString = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(startDateString);

        System.out.print("Enter the end date (yyyy-mm-dd): ");
        String endDateString = scanner.nextLine();
        LocalDate endDate = LocalDate.parse(endDateString);

        List<Item> foundItems = toDoList.searchByDueDateInterval(startDate, endDate);

        if (foundItems.isEmpty()) {
            System.out.println("No items found within the given date interval.");
        } else {
            System.out.println("Found items:");
            for (Item item : foundItems) {
                System.out.println(item);
            }
        }
    }
}
