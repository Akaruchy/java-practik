package Homework4;


import java.sql.Array;
import java.util.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
//        stringMember();
        System.out.println(reverseList());

    }

//1. Реализовать консольное приложение, которое:
//        Принимает от пользователя и “запоминает” строки.
//        Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//        Если введено revert, удаляет предыдущую введенную строку из памяти.


    private static void stringMember() {
        Scanner nein = new Scanner(System.in);
        LinkedList<String> wordsList = new LinkedList<>();
        String str ="";
        while (true) {
            System.out.print("Введите значение: ");
            str = nein.nextLine();

            if (str.equals("stop")) {
               break;

            } else if (str.equals("print")) {
                Collections.swap(wordsList, 0, wordsList.size()-1);
            }

            else if (str.equals("revert")){
                wordsList.remove(wordsList.size()-1);
            }

            else {
                wordsList.addLast(str);

            }
            System.out.println(wordsList);
        }
    }

//        2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
    public static LinkedList reverseList(){
        LinkedList<String> wordsList = new LinkedList<>();
        Collections.addAll(wordsList, "apple", "orange", "banana", "tomato", "strawberry", "melon");

        LinkedList<String> newWordsList = new LinkedList<>();
        for (int i =0; i<wordsList.size(); i++){
            newWordsList.addFirst(wordsList.get(i));
        }
        return newWordsList;
    }
}
