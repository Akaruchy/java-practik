package lesson2;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
//        stringN();
        compressionMethod();
//

    }


    // 1. Дано число N >0 и символы c1 c2. Написать метод, который вернет строку длины N, которая
    // состоит из чередующихся символов c1 и c2, начиная с с1.
    private static void stringN() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String str = "";
        for (int i = 0; i <= N - 1; i++) {
            if (i % 2 == 0) {
                str += "c1";
            } else {
                str += "c2";
            }
        }
        System.out.println(str);
    }

// 2. напишите метод, который сжимает строку.

    private static void compressionMethod() {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                if (count > 1) {
                    res.append(str.charAt(i)).append(count);
                } else {
                    res.append((str.charAt(i)));
                }
                count = 1;
            }
        }
        res.append(str.charAt(str.length() - 1)).append(count);
        System.out.println(res);
    }
}





