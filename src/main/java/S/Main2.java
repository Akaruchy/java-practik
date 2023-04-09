package S;

public class Main2 {
    public static void main(String[] args) {
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        try {

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < 5; j++) {
                    try {
                        int val = Integer.parseInt((arr[i][j]));
                        sum += val;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Выход за пределы массива");
                    } catch (NumberFormatException e) {
                        System.out.println("Не валидные данные");
                    }
                }
            }
            return sum;
        } catch (NullPointerException e) {
            System.out.println("Переданный масив имеет значение Null");
            return 0;
        }
    }
}
