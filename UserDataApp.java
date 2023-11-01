import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataApp {
    public static void main(String[] args) {
        try {
            String[] userData = getUserData();
            writeUserDataToFile(userData);
            System.out.println("Данные успешно записаны в файл.");
        } catch (InvalidDataException e) {
            System.out.println("Ошибка ввода данных: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка чтения/записи файла: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String[] getUserData() throws InvalidDataException {
        // Здесь можно реализовать логику ввода данных пользователем
        // В данном примере ввод данных происходит вручную
        System.out.print("Введите данные: ");
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        String[] userData = input.split(" ");

        if (userData.length != 6) {
            throw new InvalidDataException("Неверное количество данных.");
        }

        return userData;
    }

    private static void writeUserDataToFile(String[] userData) throws IOException {
        String filename = userData[0] + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(String.join("", userData));
            writer.newLine();
        }
    }

    private static class InvalidDataException extends Exception {
        public InvalidDataException(String message) {
            super(message);
        }
    }
}