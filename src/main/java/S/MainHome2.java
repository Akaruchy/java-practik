package S;

import java.util.Scanner;
public class MainHome2 {

        public static void main(String[] args) {
//              methodFloat();
//              kodTwo();
//              kodThree();
                kodExept();
        }

//1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное
// значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно
// запросить у пользователя ввод данных.

        private static void methodFloat() {
                Scanner scan = new Scanner(System.in);
                boolean vol = true;
                while (vol) {
                        System.out.println("Введите число (типа float)");
                        try {
                                float intnum = Float.parseFloat(scan.nextLine());
                                System.out.println("Ваше число: " + intnum);
                                vol = false;
                        } catch (NumberFormatException e) {
                                System.out.println("Неверный ввод");
                        }
                }
        }

//2. Если необходимо, исправьте данный код
// (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
//Дан следующий код, исправьте его там, где требуется
// (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)


        private static void kodTwo() {
                try {
                        int d = 0;
                        int[] intArray = {11, 2, 123, 74, 55, 36, 17, 8, 94};
                        double catchedRes1 = intArray[8] / d;
                        System.out.println("catchedRes1 = " + catchedRes1);
                } catch (ArithmeticException e) {
                        System.out.println("Catching exception: " + e);
                }
        }
        public static void kodThree() {
                try {
                        int a = 90;
                        int b = 3;
                        System.out.println(a / b);
                        printSum(23, 234);
                        int[] abc = {1, 2};
                        abc[3] = 9;
                } catch (NullPointerException ex) {
                        System.out.println("Указатель не может указывать на null!");
                        System.out.println(ex.getMessage());
                } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Массив выходит за пределы своего размера!");
                        System.out.println(ex.getMessage());
                }
        }

        public static void printSum(Integer a, Integer b) {
                System.out.println(a + b);
        }
//3.Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

        public static String kodExept() {
                System.out.println("Введите строчку:");
                String vol = " ";
                Scanner scan = new Scanner(System.in);
                String vol1 = scan.nextLine();
                if (vol1 != vol) {
                        throw new RuntimeException("Пустые строки вводить нельзя" );
                }
                return vol1;
                }
        }



