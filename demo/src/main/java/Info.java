import java.util.Scanner;

public class Info {
    public static void main(String[] args) {
        String name;
        int age;
        String address;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập họ tên: ");
        name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập địa chỉ: ");
        address = sc.nextLine();
        System.out.println("Họ tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Địa chỉ: " + address);

    }
}
