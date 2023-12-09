import java.util.Scanner;

public class Main {
    static Store store = new Store();

    public static void main(String[] args) {
        Book[] movies = new Book[] {
                new Book("The Shawshank Redemption", "BlueRay", 9.2, 10.2),
                new Book("The Godfather", "BlueRay", 9.1, 11.3),
                new Book("The Godfather: Part II", "DVD", 9.0, 1.2),
                new Book("12 Angry Men", "DVD", 8.9, 5.2),
        };
        for (Book book : movies) {
            store.addBook(book);
        }
        printStore();
        userInput();

    }
    
    public static void userInput() {
        Scanner scanner = new Scanner(System.in);
        String status = "continue";
        while (status.equals("continue")) {
            System.out.print("\nPlease choose an integer between 0 - 3: ");
            int choice = scanner.nextInt();
            Book book = store.getBook(choice);
            System.out.print("Set a new rating for " + book.getTitle() + ": ");
            double rating = scanner.nextDouble();
            book.setRating(rating);
            store.setBook(choice, book);
            printStore();
            System.out.print("To edit another rating, type: 'continue': ");
            status = scanner.next();
        }
        scanner.close();
    }
    
    public static void printStore() {
        System.out.println("********************************MOVIE STORE*******************************");
        System.out.println(store.toString());
    }
}