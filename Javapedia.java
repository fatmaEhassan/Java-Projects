import java.util.Scanner;

public class Javapedia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n**********Javapedia**********");
        System.out.println("How many historical figures will you register?");
        int numberOfFigures = scan.nextInt();

        String[][] figures = new String[numberOfFigures][3];
        scan.nextLine();
        for (int i = 0; i < figures.length; i++){
            System.out.println("\n\tFigure " + (i + 1));
    
            System.out.print("\t - Name: ");
            figures[i][0] = scan.nextLine();

            System.out.print("\t - Date of birth: ");
            figures[i][1] = scan.nextLine();

            System.out.print("\t - Occupation: ");
            figures[i][2] = scan.nextLine();
        
            System.out.print("\n");
        }
        
        System.out.println("These are the values you stored:");
        print2DArray(figures);

        System.out.print("\nWho do you want information on? ");
        String nameToSearchFor = scan.nextLine();


        /*Task 5: Let the user search the database by name. 
            If there's a match:
              print(    tab of space    Name: <name>)
              print(    tab of space    Date of birth: <date of birth>)
              print(    tab of space    Occupation: <occupation>)
        
        */
        for(int i = 0; i < figures.length; i++){
            if (figures[i][0].equalsIgnoreCase(nameToSearchFor)) {
                System.out.print("\t.Name: " + figures[i][0] + "\n");
                System.out.print("\t.Date of birth: " + figures[i][1] + "\n");
                System.out.print("\t.Occupation: " + figures[i][2]);
            }
        }
            

        scan.close();
    }


    public static void print2DArray(String[][] array2D) {
        
        for (int i = 0; i < array2D.length; i++) {
            System.out.println("Figure " + (i+1) + ": ");
            for (int j = 0; j < array2D[i].length; j++) {
                System.out.print(array2D[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

}
