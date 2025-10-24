import java.util.Scanner;

public class Book {
    String title;
    String author;
    int publicationYear;

    Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    void input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter title: ");
        this.title = input.nextLine();
        System.out.print("Enter author: ");
        this.author = input.nextLine();
        System.out.print("Enter publication year: ");
        this.publicationYear = input.nextInt();
    }

    void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("-----------------------");
    }
}
