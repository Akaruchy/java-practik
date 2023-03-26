package Homework;

import java.util.Date;
import java.util.Arrays;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
//        MinMax();
//        ArrayNumsRemove();
//        TimeNow();


    }

    // 1. Задать одномерный массив и найти в нем минимальный и максимальный элементы
    private static void MinMax() {
        int arr[] = {2, 2, 12, 4, 5, -2, 0};
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (i <= min) {
                min = arr[i];
//                System.out.printf("Min=%s\n", max);
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (i >= max) {
                max = arr[i];
//              System.out.printf("Max=%s\n", max);
            }
        }
        System.out.printf("Min= %s\n", min);
        System.out.printf("Max= %s", max);


    }

    //Дан массив nums = [3,2,2,3] и число val = 3. Если в массиве есть числа, равные заданному,
// нужно перенести эти элементы в конец массива. Таким образом, первые несколько (или все)
// элементов массива должны быть отличны от заданного, а остальные - равны ему.
    private static void ArrayNumsRemove() {
        int array[] = {3, 2, 2, 3};
        int val = 3;
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] == val) {
                for (int j = array.length - 1; j >= 0; j--) {
                    if (array[j] != val && j > i) {
                        int tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;

                    }
                }

            }
        }
        System.out.printf(Arrays.toString(array));

    }
//3*. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
//        "Доброе утро, <Имя>!", если время от 05:00 до 11:59
//        "Добрый день, <Имя>!", если время от 12:00 до 17:59;
//        "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//        "Доброй ночи, <Имя>!", если время от 23:00 до 4:59


    private static void TimeNow() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Date date = new Date();
        int hour = date.getHours();
        System.out.println(date.getHours());
        if ( hour >= 12 && hour <=17){
            System.out.printf("Добрый день %s", name, "!");
        }
        else if ( hour >= 18 && hour <=22){
            System.out.printf("Добрый вечер %s", name, "!");
        }
        else if  ( hour >= 5 && hour <=11){
            System.out.printf("Доброе утро %s", name, "!");
        }else  {
            System.out.printf("Доброй ночи %s", name, "!");}
    }
}
