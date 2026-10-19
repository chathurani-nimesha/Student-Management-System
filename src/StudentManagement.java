import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private static final ArrayList<Student> students=new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);

    private static void addStudent(){
        System.out.println("--------------------------------------");
        System.out.println("|           Add Student               |");
        System.out.println("--------------------------------------");

        System.out.print("\n\tEnter Student ID: ");
        int id = Integer.parseInt(input.nextLine());

        System.out.print("\tEnter Name: ");
        String name = input.nextLine();

        System.out.print("\tEnter Marks: ");
        double marks = Double.parseDouble(input.nextLine());

        students.add(new Student(id,name,marks));
        System.out.println("\n\nStudent added successfully!...");

        System.out.print("\n\tDo you want to add another student(Y/N): ");
        String anotherOne = input.nextLine();

        if(anotherOne.equalsIgnoreCase("Y")){
            addStudent();
        }else {
           homeMenu();
        }

    }

    private static void viewStudent(){
        System.out.println("--------------------------------------");
        System.out.println("|           View Student             |");
        System.out.println("--------------------------------------");

        if (students.isEmpty()){
            System.out.println("No student records available...");
            return;
        }

        System.out.println("===================================");
        System.out.println("|         Student Details         |");
        System.out.println("===================================");

        for (Student student:students){
            student.displayDetails();
            System.out.println("-------------------------");
            System.out.println("\n");
        }
    }

    private static void homeMenu(){
        int choice;

        do{
            System.out.println("---------------------------------------------");
            System.out.println("|             Student Management System     |");
            System.out.println("---------------------------------------------");

            System.out.println("\n\t[01]. Add Student");
            System.out.println("\n\t[02]. View Students");
            System.out.println("\n\t[03]. Search Student");
            System.out.println("\n\t[04]. Exit");

            System.out.print("\nChoose your choice: ");
            choice= Integer.parseInt(input.nextLine());

            switch (choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    //searchStudent();
                    break;
                case 4:
                    System.out.println("Good Bye...");
                    break;
                default:
                    System.out.println("Invalid Choice! Enter a valid choice between 1 and 4.");
            }
        }while (choice!=4);

    }

    public static void main(String[] args) {
        homeMenu();
    }
}
