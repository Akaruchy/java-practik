package Homework5;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.Map.Entry;
public class Main {

    public static void main(String[] args) {
//       phoneBook();
//       filterName();
       romNumer();

    }

//1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

    private static void phoneBook() {
        Map<String, String> tellBook = new HashMap<>();
        tellBook.put("89346546464", "Чернов");
        tellBook.put("89546545432", "Чернов");
        tellBook.put("89894956215", "Иванов");
        tellBook.put("89854621846", "Белова");
        tellBook.put("89313431594", "Иванов");
        tellBook.put("89421568413", "Иванов");
        tellBook.put("89311111525", "Белова");
        tellBook.put("89584444568", "Петров");
        tellBook.put("89959595224", "Иванов");
        tellBook.put("89898955464", "Белова");
        tellBook.put("89561615854", "Петрова");
        tellBook.put("89145145486", "Иванов");
        while (true) {
            Scanner scan = new Scanner(System.in);
            menu();
            System.out.print("Выберите опцию: ");
            int num = scan.nextInt();
            switch (num) {
                case 1 -> showAll(tellBook);
                case 2 -> searchRecord(tellBook);
                case 3 -> newRecord(tellBook);
                case 4 -> delitRecord(tellBook);
                case 0 -> exit();
                default -> System.out.println("Введен неверный номер");
            }
        }
    }

    private static void delitRecord(Map<String, String> hm) {
        List<String> numbers = searchNumber(hm);
        if (numbers != null) {
            System.out.print("Результат поиска:\n");
            for (var item : numbers) {
                for (var key : hm.keySet()) {
                    if (item.equals(key)) {
                        System.out.printf("%s был удален\n", item);
                        hm.remove(key);
                        break;
                    }
                }
            }
        } else {
            System.out.print("Результат поиска: Контакт не найден\n");
        }
    }

    private static void searchRecord(Map<String, String> hm) {
        List<String> numbers = searchNumber(hm);
        if (numbers != null) {
            System.out.print("Результат поиска:\n");
            for (var item : numbers) {
                for (var key : hm.keySet()) {
                    if (item.equals(key)) {
                        System.out.printf("%s %s\n", hm.get(item), item);
                    }
                }
            }
        } else {
            System.out.print("Результат поиска: Контакт не найден\n");
        }
    }

    private static List<String> searchNumber(Map<String, String> hm) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Выберите имя контакта: ");
        String searchValue = scan.nextLine();
        List<String> contactNumber = new ArrayList<>();
        if (hm.containsValue(searchValue)) {
            for (var key : hm.keySet()) {
                if (searchValue.equals(hm.get(key))) {
                    contactNumber.add(key);
                }
            }
            return contactNumber;
        } else {
            return null;
        }
    }

    private static void showAll(Map<String, String> hm) {
        if (!hm.isEmpty()) {
            for (var item : hm.entrySet()) {
                System.out.printf("%s : %s\n", item.getValue(), item.getKey());
            }
        } else System.out.println("Список пуст\n ============");
    }

    private static Map<String, String> newRecord(Map<String, String> hm) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Выберите имя контакта: ");
        String value = scan.nextLine();
        System.out.print("Выберите номер контакта: ");
        String key = scan.nextLine();
        hm.putIfAbsent(key, value);
        System.out.printf("Контакт добавлен: %s %s\n", hm.get(key), key);
        return hm;
    }

    private static void exit() {
        System.out.println("Выход");
        System.exit(0);
    }

    private static void menu() {
        System.out.println(
                """
                        Режимы работы:\s
                        1. Загрузить весь справочник\s
                        2. Поиск контакта\s
                        3. Добавить запись\s
                        4. Удаление контакта\s
                        0. Закрыть программу"""
        );
    }

//2. Пусть дан список сотрудников:
//    Иван Иванов
//    Светлана Петрова
//    Кристина Белова
//    Анна Мусина
//    Анна Крутова
//    Иван Юрин
//    Петр Лыков
//    Павел Чернов
//    Петр Чернышов
//    Мария Федорова
//    Марина Светлова
//    Мария Савина
//    Мария Рыкова
//    Марина Лугова
//    Анна Владимирова
//    Иван Мечников
//    Петр Петин
//    Иван Ежов
//Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.


    private static void filterName() {
        String[] fullNames = new String[]{
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"
        };
        List<String> listNames = getName(fullNames);
        Map<String, Integer> mapNames = getMap(listNames);
        System.out.println("Повтор имен: ");
        povtorNames(mapNames);
        System.out.println(" \n");
        System.out.println("Самые популярные имена (отсортировано по убыванию): ");
        sortNames(mapNames);
    }
    private static void povtorNames(Map<String, Integer> map) {
        for (var item : map.entrySet()) {
            if (item.getValue() > 1) {
                System.out.printf("%s: %d; ", item.getKey(), item.getValue());
            }
        }
    }

    private static void sortNames(Map<String, Integer> map) {
        Map<String, Integer> sortMap = new LinkedHashMap<>();
        List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> item : list) {
            sortMap.put(item.getKey(), item.getValue());
        }
        for (var item : sortMap.entrySet()) {
            System.out.printf("%s; ", item.getKey());
        }
    }
    private static Map<String, Integer> getMap(List<String> list) {
        Map<String, Integer> strInMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            String element = list.get(i);
            for (String item : list) {
                if (element.equals(item)) {
                    count++;
                }
            }
            if (!strInMap.containsKey(element)) {
                strInMap.put(element, count);
            }
        }
        return strInMap;
    }
    private static List<String> getName(String[] list) {
        List<String> listName = new ArrayList<>();
        for (String item : list) {
            String[] listItems = item.split(" ");
            listName.add(listItems[0]);
        }
        return listName;
    }



//3***. Написать метод, который переведёт данное целое число в римский формат.

    private static void romNumer() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Укажите число в диапазоне: 1 - 10000: ");
        int num = scanner1.nextInt();
        if (num > 0 && num < 10000) {
            System.out.printf("Римское число: %d = %s", num, arabRom(num));
        }
        else
        {System.out.println("Некорректное значение");}
    }

    private static String arabRom(int number) {
        TreeMap<Integer, String> romNum = new TreeMap<>();
        romNum.put(1, "I");
        romNum.put(4, "IV");
        romNum.put(5, "V");
        romNum.put(9, "IX");
        romNum.put(10, "X");
        romNum.put(40, "XL");
        romNum.put(50, "L");
        romNum.put(90, "XC");
        romNum.put(100, "C");
        romNum.put(400, "CD");
        romNum.put(500, "D");
        romNum.put(900, "DM");
        romNum.put(1000, "M");
        int maxKey = romNum.floorKey(number);
        if (number == maxKey) {
            return romNum.get(number);
        }
        return romNum.get(maxKey) + arabRom(number - maxKey);
    }

}
