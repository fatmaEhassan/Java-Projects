import java.time.LocalDate;
import java.util.Objects;

class Item {
    private String title;
    private String description;
    private LocalDate creationDate;
    private LocalDate dueDate;
    private String category;

    public Item(String title, String description, LocalDate creationDate, LocalDate dueDate, String category) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.category = category;
    }
    
    public Item(Item source) {
        this.title = source.title;
        this.description = source.description;
        this.creationDate = source.creationDate;
        this.dueDate = source.dueDate;
        this.category = source.category;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(title, item.title) && Objects.equals(description, item.description) && Objects.equals(creationDate, item.creationDate) && Objects.equals(dueDate, item.dueDate) && Objects.equals(category, item.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, creationDate, dueDate, category);
    }
    

    @Override
    public String toString() {
        return "Title: " + title +
                "\nDescription: " + description +
                "\nCreation Date: " + creationDate +
                "\nDue Date: " + dueDate +
                "\nCategory: " + category;
    }
}