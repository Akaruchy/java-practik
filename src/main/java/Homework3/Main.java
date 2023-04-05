package Homework3;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        delInt();
//        maxMinList();
//        planetList();
          stringNumArr();
    }

    //1. Пусть дан произвольный список целых чисел, удалить из него четные числа (в языке уже есть что-то готовое для этого)
    private static void delInt() {
        Integer[] arrInt = {1, 8, 7, 9, 12, 3, 5, 4, 25, 2, 17};
        ArrayList<Integer> nii = new ArrayList<>();
        nii.addAll(List.of(arrInt));
        System.out.println(nii);
        for (int i = 0; i < nii.size(); i++) {
            if (nii.get(i) % 2 == 0) {
                nii.remove(i);
            }
        }
        System.out.println(nii);
    }

    //2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
    private static void maxMinList() {
        Integer[] arrInt = {1, 8, 7, 9, 12, 3, 5, 4, 25, 2, 17};
        ArrayList<Integer> List1 = new ArrayList<>(List.of(arrInt));
        System.out.println(List1);
        Collections.sort(List1);
        System.out.println("минимальное число:");
        System.out.println(List1.get(0));
        System.out.println("максимальное число:");
        System.out.println(List1.get(List1.size() - 1));
        double midl = 0;
        for (int i = 0; i < List1.size(); i++) {
            midl = midl + List1.get(i);
        }
        midl = midl / arrInt.length;
        System.out.println("среднее арифметическое:");
        System.out.println(midl);
    }

    //3. Доделать начатое на семинаре. Пройтись по списку из задания 2 и удалить повторяющиеся элементы.
    private static void planetList() {
        String[] arrPlanet = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptun", "Pluto"};
        Random dom = new Random();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(arrPlanet[dom.nextInt(9)]);
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i);
                i--;
            }
        }
        System.out.println("Список без повторов:");
        System.out.println(list);
    }

    //4*. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа. Пройти по списку, найти и удалить целые числа.
    private static void stringNumArr(){
        ArrayList<String> numstr = new ArrayList<>();
        numstr.add(String.valueOf(1));
        numstr.add(String.valueOf("s"));
        numstr.add(String.valueOf("g"));
        numstr.add(String.valueOf("fgh"));
        numstr.add(String.valueOf(122));
        numstr.add(String.valueOf("p"));
        numstr.add(String.valueOf(4));
        numstr.add(String.valueOf(23));
        numstr.add(String.valueOf("b"));
        numstr.add(String.valueOf("p"));
        numstr.add(String.valueOf(789));
        System.out.println(numstr);
        for (int i=0; i< numstr.size(); i++){
            try {
                Integer.parseInt(numstr.get(i));
                numstr.remove(i);
                i--;
            } catch (NumberFormatException c) {
            }
        }System.out.println(numstr);
    }
}
