import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Mưa", "Lộc", 1925);
        Book book2 = new Book("Mèo", "Đại", 1960);
        Book book3 = new Book("Mây", "Dũng", 1949);

        book1.displayBook();
        book2.displayBook();
        book3.displayBook();
    }
}
