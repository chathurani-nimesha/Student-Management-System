import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private static final ArrayList<Student> students=new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);

    private static void addStudent(){

        while (true){
            System.out.println("--------------------------------------");
            System.out.println("|           Add Student               |");
            System.out.println("--------------------------------------");

            int id;

            while(true){
                System.out.print("Enter Student ID: ");

                try {
                    id = Integer.parseInt(input.nextLine().trim());

                    if (id<=0){
                        System.out.println("ID must be a positive number.");
                        continue;
                    }

                    boolean duplicate = false;

                    for (Student student: students){
                        if (student.getId()==id){
                            duplicate=true;
                            break;
                        }
                    }
                    if (duplicate){
                        System.out.println("Student ID already exists.");
                        continue;
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Please enter a valid integer ID.");
                }
            }
            String name;
            while (true){
                System.out.print("Enter Student name: ");
                name = input.nextLine().trim();

                if(!name.isEmpty()){
                    break;
                }
                System.out.println("\tName Cannot be empty.");
            }

            double marks;

            while (true){
                System.out.print("Enter Marks: ");

                try{
                    marks=Double.parseDouble(input.nextLine().trim());

                    if (Double.isFinite(marks) && marks >=0 && marks <= 100){
                        break;
                    }
                    System.out.println("Marks must be between 0 and 100.");
                }catch (NumberFormatException e){
                    System.out.println("Please enter valid numeric marks.");
                }
            }

            students.add(new Student(id,name,marks));
            System.out.println("\n\tStudent added Successfully...");

            while (true){
                System.out.print("Add another student? (Y/N)");
                String answer=input.nextLine().trim();

                if(answer.equalsIgnoreCase("Y")){
                    break;
                }else if(answer.equalsIgnoreCase("N")){
                    return;
                }else {
                    System.out.println("Please enter Y or N.");
                }
            }
        }
    }

    private static void viewStudent(){

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

    private static void searchStudent(){
        System.out.println("+------------------------------------------+");
        System.out.println("|             Search student               |");
        System.out.println("+------------------------------------------+");

        if(students.isEmpty()){
            System.out.println("No student records available...");
            return;
        }

        System.out.print("Enter student ID to search: ");
        int searchId = Integer.parseInt(input.nextLine());

        for(Student student: students){
            if(student.getId()==searchId){
                System.out.println("Student Found.");
                student.displayDetails();
                return;
            }
        }
        System.out.println("Student with ID "+searchId+" not found.");
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

            try {
                choice= Integer.parseInt(input.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Invalid input! Enter a number from 1 to 4.");
                choice = 0;
            }


            switch (choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    searchStudent();
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
