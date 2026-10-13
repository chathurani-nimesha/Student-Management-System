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

            System.out.print("\nChoose your choice: ");
            choice= Integer.parseInt(input.nextLine());

            switch (choice){
                case 1:
                    //addStudent();
                    break;
                case 2:
                    //viewStudent();
                    break;
                case 3:
                    //searchStudent();
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
