package Homework2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        palindromeStr();
//        testString("E:\\ОБУЧЕНИЕ\\JAVA\\java_projects\\java-practik\\src\\main\\java\\Homework2");
        typFile("E:\\ОБУЧЕНИЕ\\JAVA\\java_projects\\java-practik\\src\\main\\java\\Homework2");



    }

 // 1.Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение).
    private static void palindromeStr() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
//        System.out.println(str.toCharArray());
        StringBuilder res = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            res.append(str.charAt(i));
        }
        System.out.println(res);
        System.out.println(str);
        String str2 = res.toString();
        if (str.equals(str2)) {
            System.out.println("ПАЛИНДРОМ");
        } else {
            System.out.println("НЕ ПАЛИНДРОМ");
        }
    }

//2.Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод, который запишет эту
// строку в простой текстовый файл, обработайте исключения.

    private static void testString(String pathDir) throws FileNotFoundException {
        int count = 0;
        StringBuilder set = new StringBuilder();
        while (count < 100) {
            set.append("\nTEST ");
            count++;
        }
//        System.out.println(set);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("E:\\ОБУЧЕНИЕ\\JAVA\\java_projects\\java-practik\\src\\main\\java\\Homework2\\test.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pw.print(set);
        pw.close();


    }

//3*.Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида:
//        1 Расширение файла: txt
//        2 Расширение файла: pdf
//        3 Расширение файла:
//        4 Расширение файла: jpg
    private static void typFile(String pathDir) {
        File file = new File(pathDir);
        if (!file.isDirectory()) {
            return;
        }
        int count = 0;
        String[] dirListNames = file.list();
        StringBuilder sb = new StringBuilder();
        for (String fileName : dirListNames) {
            count++;
            sb.append(count).append(" Расширение файла: ").append(fileName).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}


