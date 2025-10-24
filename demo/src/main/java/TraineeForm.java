import java.util.Scanner;

public class TraineeForm {
    private Scanner sc;

    public TraineeForm(Scanner scanner) {
        this.sc = scanner;
    }

    public String getId() {
        System.out.print("Enter Trainee ID: ");
        return sc.nextLine().trim();
    }

    public Trainee getTrainee() {
        try {
            System.out.print("Enter ID: ");
            String id = sc.nextLine().trim();

            System.out.print("Enter Name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter Gender (male/female): ");
            String gender = sc.nextLine().trim();

            System.out.print("Enter Age: ");
            byte age = Byte.parseByte(sc.nextLine().trim());

            return new Trainee(id, name, gender, age);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
