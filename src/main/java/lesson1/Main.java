package lesson1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HelloName();

    }

    private static void HelloName() {
        Scanner scanner = new Scanner(System.in);
        String YouName = scanner.nextLine();
        System.out.printf("Hello, %s", YouName);
    }
}

