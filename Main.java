// creat By Aryan Devloper 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Invigilator {
    String name;
    int dutyHours;
    int duties;

    Invigilator(String name, int dutyHours, int duties) {
        this.name = name;
        this.dutyHours = dutyHours;
        this.duties = duties;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of invigilators:");
        int numOfInvigilators = scanner.nextInt();

        System.out.println("Enter the number of examination halls:");
        int numOfHalls = scanner.nextInt();

        ArrayList<Invigilator> invigilators = new ArrayList<>();

        for (int i = 1; i <= numOfInvigilators; i++) {
            System.out.println("Enter details for Invigilator " + i + ":");
            System.out.print("Name: ");
            String name = scanner.next();

            System.out.print("Duty Hours: ");
            int dutyHours = scanner.nextInt();

            System.out.print("Number of Duties: ");
            int duties = scanner.nextInt();

            invigilators.add(new Invigilator(name, dutyHours, duties));
        }

        allocateInvigilators(invigilators, numOfHalls);

        scanner.close();
    }

    static void allocateInvigilators(ArrayList<Invigilator> invigilators, int numOfHalls) {
        Collections.shuffle(invigilators); // Shuffle to randomize invigilator allocation

        for (int hall = 1; hall <= numOfHalls; hall++) {
            System.out.println("Hall " + hall + ":");

            for (Invigilator invigilator : invigilators) {
                if (invigilator.duties > 0) {
                    System.out.println("Invigilator: " + invigilator.name);
                    invigilator.duties--;
                }
            }

            System.out.println(); // Add a line break between halls
        }
    }
}
