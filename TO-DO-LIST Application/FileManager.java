import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class FileManager {
    private String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public List<Item> readItemsFromFile() {
        List<Item> items = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("-");

                String title = data[0];
                String description = data[1];
                LocalDate creationDate = LocalDate.parse(data[2]);
                LocalDate dueDate = LocalDate.parse(data[3]);
                String category = data[4];

                Item item = new Item(title, description, creationDate, dueDate, category);
                items.add(item);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        return items;
    }

    public void saveItemsToFile(List<Item> items) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Item item : items) {
                String line = item.getTitle() + "-" +
                        item.getDescription() + "-" +
                        item.getCreationDate() + "-" +
                        item.getDueDate() + "-" +
                        item.getCategory();

                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}