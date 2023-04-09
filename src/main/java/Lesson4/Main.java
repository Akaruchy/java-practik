package Lesson4;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static  void main(String[] args) {
//         textNum();
         ex1();
    }

// РЕализовать консольное приложение, которое:
//1. Принимает от пользователя строку вида text~num.
//2. Нужно рассплитить строку по ~ сохранить text  в связанный список на позицию num.
//3. Если введено print-num, выводит строку из позиции тгь в связанном списке и удаляет ее из списка.
 
    private static void  textNum() {
        Scanner in = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        while (true) {
            System.out.printf("Введите строку-позицию вида text~num: ");
            String text = in.nextLine();

            String[] array = text.split("\\~");
            int index = Integer.parseInt(array[1]);
            String val = array[0];
            if (val.equals(("print"))) {
                if (list.get(index) == null){
                    System.out.printf("Нет значения");
                } else {
                System.out.println(list.get(index));
                list.remove(index);}
            } else {
                if (index < list.size()) {
                    list.set(index, val);
                }else  {
                    for (int i =list.size(); i<index-1; i++) {
                        list.add(null);
                    }
                    list.add(val);
                }
            }System.out.println(list);
        }
    }
    private static void ex1() {
        Scanner in = new Scanner(System.in);
        LinkedList<String> wordsList = new LinkedList<>();
        Collections.addAll(wordsList, "apple", "orange", "banana", "tomato", "strawberry", "melon");


        while (true) {
            System.out.println();
            System.out.print("Введите значение: ");
            String inputString = in.nextLine();

            if (inputString.trim().length() == 0) {
//            if (inputString.isBlank()) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            if (inputString.equalsIgnoreCase("горшочек не вари")) {
                break;
            }
            if (inputString.equalsIgnoreCase("print~all")) {
                printAllNotNullValues(wordsList);
                continue;
            }
            if (!inputString.contains("~")) {
                System.out.println("не содержит тильду");
                continue;
            }

            String[] parts = inputString.split("\\~");

            if (parts.length != 2) {
                System.out.println("Ошибка ввода шаблона. Должно быть \"word~num\". Пример: apple~6");
                continue;
            }

            String word = parts[0];
            int num = 0;

            try {
                num = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Выражение не содержит числа");
                continue;
            }

            if (num < 1) {
                System.out.println("Введите num более 1");
                continue;
            }

            if (word.equalsIgnoreCase("print")) {
                if (!isNumberInRange(num, wordsList.size()) || valueIsNull(wordsList, num)) {
                    System.out.println("указанного значение не существует");
                } else {
                    System.out.printf("Под номером %d содержится слово: %s%n", num, wordsList.get(num - 1));
                    wordsList.remove(num - 1);
                }
            } else if (isNumberInRange(num, wordsList.size())) {
                String oldWord = wordsList.get(num - 1);

                if (valueIsNull(wordsList, num)) {
                    printAddMessage(word, num);
                } else {
                    printSetMessage(word, num, oldWord);
                }
                wordsList.set(num - 1, word);
            } else {
                int nullCount = num - wordsList.size() - 1;
                addNulls(wordsList, nullCount);
                wordsList.add(word);
                printAddMessage(word, num);
            }
        }
    }

    private static void addNulls(LinkedList<String> wordsList, int count) {
        for (int i = 0; i < count; i++) {
            wordsList.add(null);
        }
    }

    private static void printAllNotNullValues(LinkedList<String> wordsList) {
        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsList.get(i) != null) {
                System.out.printf("%d) %s%n", i + 1, wordsList.get(i));
            }
        }
    }

    private static void printSetMessage(String word, int num, String oldWord) {
        System.out.printf("Слово %s заменило на позиции %d слово %s%n", word, num, oldWord);
    }

    private static void printAddMessage(String word, int num) {
        System.out.printf("РЎР»РѕРІРѕ %s РґРѕР±Р°РІР»РµРЅРѕ РЅР° РїРѕР·РёС†РёСЋ %d%n", word, num);
    }

    private static boolean valueIsNull(LinkedList<String> wordsList, int num) {
        return wordsList.get(num - 1) == null;
    }

    private static boolean isNumberInRange(int num, int size) {
        return num >= 1 & num <= size;
    }
}



