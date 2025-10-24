import java.util.Scanner;

public class TrainingManagement {
    private TraineeForm traineeForm;
    private Scanner scanner;
    private Trainee[] listOfTrainees = new Trainee[100];
    private byte count = 0;

    public TrainingManagement() {
        scanner = new Scanner(System.in);
        traineeForm = new TraineeForm(scanner);
    }

    public static void main(String[] args) {
        new TrainingManagement().menu();
    }

    public void menu() {
        int choice;
        do {
            System.out.println("1. Add Trainee");
            System.out.println("2. Display All Trainees");
            System.out.println("3. Find Trainee by ID");
            System.out.println("4. Find Trainee by Name");
            System.out.println("5. Update Trainee by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1 -> addTrainee();
                case 2 -> displayAllTrainees();
                case 3 -> {
                    System.out.print("Enter ID to search: ");
                    String id = scanner.nextLine().trim();
                    Trainee t = findTraineeById(id);
                    System.out.println(t != null ? t : "Trainee not found!");
                }
                case 4 -> {
                    System.out.print("Enter name to search: ");
                    String name = scanner.nextLine().trim();
                    Trainee[] found = findTraineeByName(name);
                    if (found.length == 0) System.out.println("No trainee found with that name!");
                    else for (Trainee t : found) System.out.println(t);
                }
                case 5 -> {
                    System.out.print("Enter ID to update: ");
                    String id = scanner.nextLine().trim();
                    Trainee newTrainee = traineeForm.getTrainee();
                    updateTrainee(id, newTrainee);
                }
                case 6 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    private boolean isIdExist(String id) {
        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getId().equalsIgnoreCase(id)) return true;
        }
        return false;
    }

    private void addTrainee() {
        Trainee t = traineeForm.getTrainee();
        if (t == null) return;

        if (isIdExist(t.getId())) {
            System.out.println("Error: ID already exists!");
            return;
        }

        listOfTrainees[count++] = t;
        System.out.println("Trainee added successfully!");
    }

    private void displayAllTrainees() {
        if (count == 0) {
            System.out.println("No trainees available!");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(listOfTrainees[i]);
        }
    }

    private Trainee findTraineeById(String id) {
        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getId().equalsIgnoreCase(id))
                return listOfTrainees[i];
        }
        return null;
    }

    private Trainee[] findTraineeByName(String name) {
        Trainee[] temp = new Trainee[count];
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getName().equalsIgnoreCase(name))
                temp[found++] = listOfTrainees[i];
        }

        Trainee[] result = new Trainee[found];
        System.arraycopy(temp, 0, result, 0, found);
        return result;
    }

    private void updateTrainee(String id, Trainee newTrainee) {
        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getId().equalsIgnoreCase(id)) {
                if (!newTrainee.getId().equalsIgnoreCase(id)) {
                    System.out.println("Error: Cannot change trainee ID!");
                    return;
                }
                listOfTrainees[i] = newTrainee;
                System.out.println("Trainee updated successfully!");
                return;
            }
        }
        System.out.println("Trainee not found!");
    }
}
