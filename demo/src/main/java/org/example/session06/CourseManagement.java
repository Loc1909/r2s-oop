package org.example.session06;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseManagement {
    private ArrayList<Course> courses;

    public CourseManagement() {
        courses = new ArrayList<>();
    }

    public void input(Scanner sc) {
        System.out.println("\n=== TẠO KHÓA HỌC MỚI ===");
        Course course = new Course();
        course.input(sc, courses);
        courses.add(course);
        System.out.println("Đã thêm khóa học thành công!");
    }

    public ArrayList<Course> search(String type, Object data) {
        ArrayList<Course> result = new ArrayList<>();

        switch (type.toLowerCase()) {
            case Constant.SEARCH_BY_CODE:
                courses.stream()
                        .filter(c -> c.getCode().equalsIgnoreCase(data.toString()))
                        .forEach(result::add);
                break;
            case Constant.SEARCH_BY_NAME:
                courses.stream()
                        .filter(c -> c.getName().toLowerCase().contains(data.toString().toLowerCase()))
                        .forEach(result::add);
                break;
            case Constant.SEARCH_BY_STATUS:
                boolean statusValue = Boolean.parseBoolean(data.toString());
                courses.stream()
                        .filter(c -> c.isStatus() == statusValue)
                        .forEach(result::add); // tương đương .forEach(c -> result.add(c));
                break;
            case Constant.SEARCH_BY_DURATION:
                try {
                    short durationValue = Short.parseShort(data.toString());
                    courses.stream()
                            .filter(c -> c.getDuration() == durationValue)
                            .forEach(result::add);
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi: Thời lượng không hợp lệ!");
                }
                break;
            case Constant.SEARCH_BY_FLAG:
                courses.stream()
                        .filter(c -> c.getFlag().equalsIgnoreCase(data.toString()))
                        .forEach(result::add);
                break;
            default:
                System.out.println("Loại tìm kiếm không hợp lệ!");
        }

        return result;
    }

    public void displayAll(String flag) {
        System.out.println("\n=== DANH SÁCH KHÓA HỌC (FLAG: " + flag + ") ===");
        System.out.println("─".repeat(100));
        System.out.printf("%-10s | %-30s | %-10s | %-10s | %-15s%n",
                "Code", "Tên khóa học", "Trạng thái", "Thời lượng", "Flag");
        System.out.println("─".repeat(100));

        long count = courses.stream()
                .filter(c -> c.getFlag().equalsIgnoreCase(flag))
                .peek(System.out::println)
                .count();

        System.out.println("─".repeat(100));
        System.out.println("Tổng số: " + count + " khóa học");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseManagement cm = new CourseManagement();
        int choice;

        do {
            System.out.println("\n1. Tạo khóa học mới");
            System.out.println("2. Tìm kiếm khóa học");
            System.out.println("3. Hiển thị khóa học theo flag");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng (1-4): ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case Constant.MENU_CREATE:
                        cm.input(sc);
                        break;

                    case Constant.MENU_SEARCH:
                        System.out.println("\n=== TÌM KIẾM KHÓA HỌC ===");
                        System.out.println("Loại tìm kiếm: code, name, status, duration, flag");
                        System.out.print("Nhập loại tìm kiếm: ");
                        String type = sc.nextLine().trim();
                        System.out.print("Nhập dữ liệu tìm kiếm: ");
                        String data = sc.nextLine().trim();

                        ArrayList<Course> searchResult = cm.search(type, data);
                        if (searchResult.isEmpty()) {
                            System.out.println("Không tìm thấy khóa học nào!");
                        } else {
                            System.out.println("\n=== KẾT QUẢ TÌM KIẾM ===");
                            System.out.println("─".repeat(100));
                            System.out.printf("%-10s | %-30s | %-10s | %-10s | %-15s%n",
                                    "Code", "Tên khóa học", "Trạng thái", "Thời lượng", "Flag");
                            System.out.println("─".repeat(100));
                            searchResult.forEach(System.out::println);
                            System.out.println("─".repeat(100));
                            System.out.println("Tìm thấy: " + searchResult.size() + " khóa học");
                        }
                        break;

                    case Constant.MENU_DISPLAY_BY_FLAG:
                        System.out.print("\nNhập flag (optional/prerequisite/N/A): ");
                        String flag = sc.nextLine().trim();
                        if (Validator.validateFlag(flag)) {
                            cm.displayAll(flag);
                        } else {
                            System.out.println("Lỗi: Flag không hợp lệ!");
                        }
                        break;

                    case Constant.MENU_QUIT:
                        System.out.println("\nExiting...");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 1-4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                choice = 0;
            }
        } while (choice != 4);
    }
}