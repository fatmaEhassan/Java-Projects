import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ToDoList {
    private List<Item> items;

    public ToDoList() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(new Item(item));
    }

    public void updateItem(Item itemToUpdate, Item updatedItem) {
        int index = items.indexOf(itemToUpdate);
        if (index != -1) {
            items.set(index, updatedItem);
        }
    }

    public void deleteItem(Item item) {
        items.remove(item);
    }

    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }
    public List<Item> getItems() {
        return items;
    }

    public List<Item> filterByCategory(String category) {
        return items.stream()
                .filter(item -> item.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Item> searchByTitle(String title) {
        return items.stream()
                .filter(item -> item.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Item> searchByCreationDateInterval(LocalDate startDate, LocalDate endDate) {
        return items.stream()
                .filter(item -> item.getCreationDate().compareTo(startDate) >= 0 &&
                        item.getCreationDate().compareTo(endDate) <= 0)
                .collect(Collectors.toList());
    }

    public List<Item> searchByDueDateInterval(LocalDate startDate, LocalDate endDate) {
        return items.stream()
                .filter(item -> item.getDueDate().compareTo(startDate) >= 0 &&
                        item.getDueDate().compareTo(endDate) <= 0)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        String temp = "";
        for (Item item : items) {
            temp += item.toString() + "\n";
        }
        return temp;
    }

}
