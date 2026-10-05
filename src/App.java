import grades.GradeManager;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        GradeManager gradeManager = new GradeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add grade");
            System.out.println("2. View average grade");
            System.out.println("3. View number of passing grades");
            System.out.println("4. Exit");
            System.out.println("5. Delete grade");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid option. Please enter a number.");
                scanner.next();
                continue;
            }

            Integer choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a grade: ");

                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid grade. Please enter a numeric value.");
                        scanner.next();
                        break;
                    }

                    Double grade = scanner.nextDouble();

                    if (grade < 0.0 || grade > 100.0) {
                        System.out.println("Invalid grade. Enter a value between 0 and 100.");
                        break;
                    }

                    gradeManager.addGrade(grade);
                    System.out.println("Grade added successfully.");
                    break;

                case 2:
                    System.out.println("Average grade: " + gradeManager.calculateAverage());
                    break;

                case 3:
                    System.out.println("Number of passing grades: " + gradeManager.countPassingGrades());
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                case 5:
                    if (gradeManager.isEmpty()) {
                        System.out.println("There are no grades to delete.");
                        break;
                    }

                    System.out.println("Grades: " + gradeManager.getGrades());
                    System.out.println("1. Delete by value");
                    System.out.println("2. Delete by position");
                    System.out.print("Choose a delete option: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid option. Please enter a number.");
                        scanner.next();
                        break;
                    }

                    Integer deleteChoice = scanner.nextInt();

                    if (deleteChoice == 1) {
                        System.out.print("Enter the grade value to delete: ");

                        if (!scanner.hasNextDouble()) {
                            System.out.println("Invalid grade. Please enter a numeric value.");
                            scanner.next();
                            break;
                        }

                        Double gradeToDelete = scanner.nextDouble();

                        if (gradeManager.removeGradeByValue(gradeToDelete)) {
                            System.out.println("Grade deleted successfully.");
                        } else {
                            System.out.println("Grade not found.");
                        }
                    } else if (deleteChoice == 2) {
                        System.out.print("Enter the position to delete (1-" + gradeManager.size() + "): ");

                        if (!scanner.hasNextInt()) {
                            System.out.println("Invalid position. Please enter a number.");
                            scanner.next();
                            break;
                        }

                        Integer position = scanner.nextInt();

                        if (gradeManager.removeGradeByPosition(position)) {
                            System.out.println("Grade deleted successfully.");
                        } else {
                            System.out.println("Invalid position.");
                        }
                    } else {
                        System.out.println("Invalid delete option.");
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
