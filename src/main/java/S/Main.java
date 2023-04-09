package S;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int[][] array = new int[][]{{1, 0, 1, 1},
//                {0, 1, 1, 1},
//                {1, 1, 1, 1},
//                {1, 1, 1, 1}
//        };
//        int num = 5;
//        int[] nullarr = null;
//        System.out.println(newArr(new int[] {1, 2, 3}, num));
//        System.out.println(newArr(nullarr, num));
//        System.out.println(newArr(array, -4));
//        System.out.println(newArr(array, 6));
//        System.out.println(newArr(array, 8));
//        System.out.println(sumBinArr(array));
//        System.out.println(Arrays.toString(sumArr(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[] {7, 6, 5, 4, 3, 2, 1}));
    }

    private static int meArg(int[] array, int num) {
        if (array.length < num) {
            return -1;
        } else {
            return array.length;
        }

    }

    public static int newArr(int[] array, int num) {
        int minArrSize = 5;
        if (array == null) {
            return -3;

        }
        if (array.length < minArrSize) {
            return -1;
        }

        if (num < 0) {
            return -4;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -2;
    }

    public static int sumBinArr(int[][] array) {
        if (array.length != array[0].length) {
            throw new RuntimeException("Массив не квадратный");
        }
        int sum = 0;
        for (int[] ints : array) {
            for (int j = 0; j < array.length; j++) {
                sum += ints[j];
                if (ints[j] != 0 && ints[j] != 1) {
                    throw new RuntimeException("Массив не валидный");
                }
            }
        }
        return sum;


}
//
//public  static  int [] sumArr(int[]arr1, int[]arr2){
//        int[] result = new int[arr1.length];
//        if(arr1.length != arr2.length){
//            throw  new RuntimeException(String.format("%d не равно %b", arr1.length, arr2.length)
//        }
//        for (int i =0; i<0; i++){
//            result[i] = arr1[i] +arr2[i];
//        }
//        return result;
//}

}

// Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
//Если длина массива меньше некоторого заданного минимума, метод возвращает -1,
// в качестве кода ошибки, иначе - длину массива.

