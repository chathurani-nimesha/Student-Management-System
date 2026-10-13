import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private static final ArrayList<Student> students=new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do{
            System.out.println("---------------------------------------------");
            System.out.println("|             Student Management System      |");
            System.out.println("---------------------------------------------");

            System.out.println("\n\t[01]. Add Student");
            System.out.println("\n\t[02]. View Students");
            System.out.println("\n\t[03]. Search Student");
            System.out.println("\n\t[04]. Exit");

            System.out.print("Choose your choice: ");
            choice= input.nextInt();

            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Good Bye...");
                    break;
                default:
                    System.out.println("Invalid Choice! Enter a valid choince between 1 and 4.");
            }
        }while (choice!=4);
    }
}
