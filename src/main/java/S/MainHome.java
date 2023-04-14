package S;

import java.util.Arrays;

public class MainHome {

    public static void main(String[] args) {
        expMethod();
//        arrMethod();
//        newMethod();
    }

//Реализуйте 2 метода, чтобы в каждом из них получить разные исключения
// Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?


    private static void expMethod() {
        int[] numersArr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        arrayEx(numersArr);
    }

    private static void arrayEx(int[] arr) {
        boolean flag = true;
        if (arr == null) {
            throw new NullPointerException("Array is null");
        }
        if (arr.length == 0) {
            throw new ArrayIndexOutOfBoundsException("Array is empty");
        }
        for (int i = 0; i < arr.length; i++) {
            try {
                if (arr[i] == 0) {
                    flag = false;
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                System.out.printf("Null in array. Index is %d\n", i);
            }
        }
        if (flag) {
            System.out.println("Null not found");
        }
    }

// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
// каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не
// равны, необходимо как-то оповестить пользователя.
    private static void arrMethod() {
        int[] numArrayA = new int[]{10, 8, 21, 0, 4, 12, 1, 88, 15};
        int[] numArrayB = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] numArrayC = getSummArrays(numArrayA, numArrayB);
        System.out.println(Arrays.toString(numArrayC));
}

    private static int[] getSummArrays(int[] arrayA, int[] arrayB) {
        int[] arrayResult = new int[arrayA.length];
        if (arrayA.length != arrayB.length) {
            throw new RuntimeException("Длины массивов не совпадают");
        }
        for (int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = arrayA[i] + arrayB[i];
        }
        return arrayResult;
    }

// * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
//каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не
// равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение, которое
// пользователь может увидеть - RuntimeException, т.е. ваше.

    private static void newMethod() {
        int[][] numMatrix = new int[][]{{1, 5, 12}, {0, 4, 6}, {7, 2, 9, 8}};
        checkMatrix(numMatrix);
    }

    private static void checkMatrix(int[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException("Matrix is null");
        }
        if (matrix.length == 0) {
            throw new ArrayIndexOutOfBoundsException("Matrix is empty");
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != matrix.length) {
                throw new RuntimeException("Длинна строк и столбцов различна");
            }
        }
        System.out.println("Длинна строк и столбцов совпадает");
    }
}