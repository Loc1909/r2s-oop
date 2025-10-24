import java.util.Scanner;

public class StudentManagement0 {
    private static String name;

    public static void main(String[] args) {
//        Student student1 = new Student();
//        student1.name = "Loc";
//        student1.mark1 = 80;
//        student1.mark2 = 60;
//        student1.mark3 = 70;
//
//        float totalMark = student1.total();
//        float averageMark = student1.average();
//
//        System.out.println("Name: " + student1.name);
//        System.out.println("Total: " + totalMark);
//        System.out.println("Average: " + averageMark);

        Scanner sc = new Scanner(System.in);
        Student0 student0s[] = new Student0[100];
        int studentCount = 0;
        String option;

        do {
            System.out.println("1. Add student");
            System.out.println("2. View student");
            System.out.println("3. Exit");
            System.out.print("Select an option :");
            option = sc.nextLine();
            switch (option) {
                case "1":
                    Student0 newStudent0 = new Student0();
                    System.out.print("Nhập họ tên: ");
                    newStudent0.name = sc.nextLine();
                    System.out.print("Nhập mark1: ");
                    newStudent0.mark1 = Float.parseFloat(sc.nextLine());
                    System.out.print("Nhập mark2: ");
                    newStudent0.mark2 = Float.parseFloat(sc.nextLine());
                    System.out.print("Nhập mark3: ");
                    newStudent0.mark3 = Float.parseFloat(sc.nextLine());
                    student0s[studentCount++] = newStudent0;
                    break;

                    case "2":
                        for (int i=0; i<studentCount; i++) {
                            Student0 s = student0s[i];
                            System.out.println("Name: " + s.name);
                            System.out.println("Mark1: " + s.mark1);
                            System.out.println("Mark2: " + s.mark2);
                            System.out.println("Mark3: " + s.mark3);
                            System.out.println("Total: " + s.total());
                            System.out.println("Average: " + s.average());
                        }
                        break;

            }
        } while(!option.equals("3"));
    }
}
