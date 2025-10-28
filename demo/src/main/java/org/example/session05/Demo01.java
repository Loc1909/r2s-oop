package org.example.session05;

import java.util.Scanner;

public class Demo01 {

    public static int inputInteger() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a whole number: ");
        int n = Integer.parseInt(sc.nextLine());

        if (n < 0 || n > 100) throw new Exception();

        return n;
    }

    public static void main(String[] args) {
        boolean cont = true;
        int n = 0;
        do {
            try {
                n = inputInteger();
                cont = false;
            } catch (Exception e) {
                System.out.println("0<=n<=100");
            }
        } while (cont);
        System.out.print("Number: " + n);
    }
}
