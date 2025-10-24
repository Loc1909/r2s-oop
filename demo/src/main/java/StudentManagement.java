import java.util.Scanner;

public class StudentManagement {
    private static final int MAX_STUDENTS = 100;
    private Student[] listStudents = new Student[MAX_STUDENTS];
    private int currentSize = 0;
    private Scanner scanner = new Scanner(System.in);

    private boolean isDuplicateId(String id) {
        for (int i = 0; i < currentSize; i++) {
            if (listStudents[i].getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private boolean validateStudent(String id, String name, int age, String gender, boolean isUpdate) {
        if (!isUpdate && isDuplicateId(id)) {
            System.out.println("Lỗi: ID đã tồn tại!");
            return false;
        }

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Lỗi: Tên không được để trống!");
            return false;
        }

        if (age < 18) {
            System.out.println("Lỗi: Tuổi phải >= 18!");
            return false;
        }

        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
            System.out.println("Lỗi: Giới tính phải là 'male' hoặc 'female'!");
            return false;
        }

        return true;
    }

    public void createStudent() {
        if (currentSize >= MAX_STUDENTS) {
            System.out.println("Danh sách đã đầy! Không thể thêm sinh viên mới.");
            return;
        }

        System.out.println("\n=== TẠO SINH VIÊN MỚI ===");

        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();

        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        System.out.print("Nhập giới tính (male/female): ");
        String gender = scanner.nextLine();

        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        if (validateStudent(id, name, age, gender, false)) {
            listStudents[currentSize] = new Student(id, name, age, address, gender, email);
            currentSize++;
            System.out.println("Thêm sinh viên thành công!");
        }
    }

    public void displayAll() {
        System.out.println("\n=== DANH SÁCH SINH VIÊN ===");
        if (currentSize == 0) {
            System.out.println("Danh sách trống!");
            return;
        }

        for (int i = 0; i < currentSize; i++) {
            System.out.println((i + 1) + ". " + listStudents[i].toString());
        }
        System.out.println("Tổng số sinh viên: " + currentSize);
    }

    private Student findById(String id) {
        for (int i = 0; i < currentSize; i++) {
            if (listStudents[i].getId().equals(id)) {
                return listStudents[i];
            }
        }
        return null;
    }

    public void findStudentById() {
        System.out.println("\n=== TÌM SINH VIÊN ===");
        System.out.print("Nhập ID cần tìm: ");
        String id = scanner.nextLine();

        Student student = findById(id);
        if (student != null) {
            System.out.println("Tìm thấy sinh viên:");
            System.out.println(student.toString());
        } else {
            System.out.println("Không tìm thấy sinh viên với ID: " + id);
        }
    }

    public void updateStudent() {
        System.out.println("\n=== CẬP NHẬT SINH VIÊN ===");
        System.out.print("Nhập ID sinh viên cần cập nhật: ");
        String id = scanner.nextLine();

        Student student = findById(id);
        if (student == null) {
            System.out.println("Không tìm thấy sinh viên với ID: " + id);
            return;
        }

        System.out.println("Thông tin hiện tại:");
        System.out.println(student.toString());
        System.out.println("\nNhập thông tin mới (nhấn Enter để giữ nguyên):");

        System.out.print("Tên mới [" + student.getName() + "]: ");
        String name = scanner.nextLine();
        if (name.trim().isEmpty()) {
            name = student.getName();
        }

        System.out.print("Tuổi mới [" + student.getAge() + "]: ");
        String ageInput = scanner.nextLine();
        int age = ageInput.trim().isEmpty() ? student.getAge() : Integer.parseInt(ageInput);

        System.out.print("Địa chỉ mới [" + student.getAddress() + "]: ");
        String address = scanner.nextLine();
        if (address.trim().isEmpty()) {
            address = student.getAddress();
        }

        System.out.print("Giới tính mới (male/female) [" + student.getGender() + "]: ");
        String gender = scanner.nextLine();
        if (gender.trim().isEmpty()) {
            gender = student.getGender();
        }

        System.out.print("Email mới [" + student.getEmail() + "]: ");
        String email = scanner.nextLine();
        if (email.trim().isEmpty()) {
            email = student.getEmail();
        }

        if (validateStudent(id, name, age, gender, true)) {
            student.setName(name);
            student.setAge(age);
            student.setAddress(address);
            student.setGender(gender);
            student.setEmail(email);
            System.out.println("Cập nhật thành công!");
        }
    }

    public void showMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1. Create a student");
        System.out.println("2. Display all");
        System.out.println("3. Find a student by id");
        System.out.println("4. Update a student by id");
        System.out.println("5. Quit");
        System.out.println("==========================");
        System.out.print("Chọn chức năng: ");
    }

    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        int choice;
        do {
            studentManagement.showMenu();
            choice = Integer.parseInt(studentManagement.scanner.nextLine());

            switch (choice) {
                case 1:
                    studentManagement.createStudent();
                    break;
                case 2:
                    studentManagement.displayAll();
                    break;
                case 3:
                    studentManagement.findStudentById();
                    break;
                case 4:
                    studentManagement.updateStudent();
                    break;
                case 5:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }
}
