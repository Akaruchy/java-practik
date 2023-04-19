package S;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

    public class MainHome3 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String FamiliName = "";
            String pervName = "";
            String OtchestvoName = "";
            String birthdDate = "";
            long phoneNumber = 0;
            char gender = ' ';

            System.out.println("Введите фамилию:");
            FamiliName = scanner.nextLine();

            System.out.println("Введите имя:");
            pervName = scanner.nextLine();

            System.out.println("Введите отчество:");
            OtchestvoName = scanner.nextLine();

            while (true) {
                System.out.println("Введите дату рождения (например: 01.01.2000):");
                String inputDate = scanner.nextLine();
                try {
                    birthdDate = parseDate(inputDate);
                    break;
                } catch (ParseException e) {
                    System.out.println("Неверный формат даты. Попробуйте еще раз.");
                }
            }

            while (true) {
                System.out.println("Введите номер телефона:");
                String inputPhoneNumber = scanner.nextLine();
                try {
                    phoneNumber = parsePhoneNumber(inputPhoneNumber);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат номера телефона. Попробуйте еще раз.");
                }
            }

            while (true) {
                System.out.println("Введите пол указав m или f для male и female соответственно:");
                String inputGender = scanner.nextLine();
                try {
                    gender = parseGender(inputGender);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Неверный формат пола. Попробуйте еще раз.");
                }
            }

            scanner.close();

            try {
                writeToOutputFile(FamiliName, pervName, OtchestvoName, birthdDate, phoneNumber, gender);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static String parseDate(String date) throws ParseException {
            SimpleDateFormat dateFormat = new SimpleDateFormat(" например: 01.01.2000");
            dateFormat.setLenient(false);
            dateFormat.parse(date);
            return date;
        }

        private static long parsePhoneNumber(String phoneNumber) throws NumberFormatException {
            return Long.parseLong(phoneNumber);
        }

        private static char parseGender(String gender) throws IllegalArgumentException {
            if (gender.length() != 1 || !(gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f"))) {
                throw new IllegalArgumentException("Выберите из вариантов: 'male ' или 'female'");
            }
            return gender.charAt(0);
        }

        private static void writeToOutputFile(String FamiliName, String pervName, String OtchestvoName, String birthdDate, long phoneNumber, char gender) throws IOException {
            File outputFile = new File(FamiliName + ".txt");
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
                writer.write(String.format("%s %s %s %s %d %c", FamiliName, pervName, OtchestvoName, birthdDate, phoneNumber, gender));
                writer.newLine();
            }
        }
    }
