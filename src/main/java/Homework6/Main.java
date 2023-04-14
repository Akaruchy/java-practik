package Homework6;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    //1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    @Getter
    public static class laptop { // создаем новый класс laptop
        private int id;
        String brandname;
        String cpu;
        String member;
        String system;
        String color;
        public void main(String[] args) { // экземпляры класса:
            laptop laptop1 = new laptop(10);
            laptop1.brandname = "DEXP Aquilon";
            laptop1.cpu = "Intel Celeron N4020";
            laptop1.member = "RAM 4 ГБ";
            laptop1.system = "Windows 11 Pro";
            laptop1.color = "серебристый";

            laptop laptop2 = new laptop(20);
            laptop2.brandname = "Irbis NB270";
            laptop2.cpu = "Intel Celeron N4020";
            laptop2.member = "RAM 4 ГБ";
            laptop2.system = "Windows 10 Pro";
            laptop2.color = "белый";

            laptop laptop3 = new laptop(30);
            laptop3.brandname = "ASUS Laptop 15 D543MA-DM1368";
            laptop3.cpu = "Intel Celeron N4020";
            laptop3.member = "RAM 4 ГБ";
            laptop3.system = "без ОС";
            laptop3.color = "черный";

            laptop laptop4 = new laptop(40);
            laptop4.brandname = "Lenono";
            laptop4.cpu = "IdeaPad 3S";
            laptop4.member = "RAM 4 ГБ";
            laptop4.system = "Windows 10 Pro";
            laptop4.color = "серый";

            laptop laptop5 = new laptop(50);
            laptop5.brandname = "TCL Book 14 Go";
            laptop5.cpu = "Qualcomm Snapdragon 7c Gen 1";
            laptop5.member = "RAM 4 ГБ";
            laptop5.system = "Windows 11 Home Single Language";
            laptop5.color = "белый";


//2.Создать множество ноутбуков (ArrayList).
            List<laptop> laptopList = new ArrayList<>();
            laptopList.add(laptop1);
            laptopList.add(laptop2);
            laptopList.add(laptop3);
            laptopList.add(laptop4);
            laptopList.add(laptop5);


// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям. Например, спросить у
// пользователя минимальный размер оперативной памяти или конкретный цвет. Выводить только те ноутбуки, что
// соответствуют условию:
            HashSet<laptop> hashLaptop = new HashSet<>(laptopList);
            System.out.println("Список ноутбуков: ");
            for (var item : hashLaptop) {
                System.out.println(item);

            }
            while (true) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Информация по ноутбуку (укажите число для получения справочной информации): ");
            }
        }

        public laptop(int id) {
            this.id = id;
        }
        @Override
        public String toString() {
            return String.format(" %s %s", brandname, color);
        }
    }
}
