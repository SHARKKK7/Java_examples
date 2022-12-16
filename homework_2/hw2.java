package homework_2;

import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

/* 
2.Задача.Реализуйте алгоритм сортировки пузырьком числового массива, 
результат после каждой итерации запишите в лог-файл.
*/

public class hw2 {

    // СОздаём переменную типа файл для логирования
    private static File logger;
    private static FileWriter fWriter;

    // Метод записывает изменения в файл лога "txt" в миллисекундах
    public static void LogMaker(String text) {
        try {
            fWriter.write(new Timestamp(System.currentTimeMillis()) + " " + text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод сортирвки массива пузыркём
    public static void bubbleSort(int[] sortArr) {

        for (int i = 0; i < sortArr.length - 1; i++) {
            for (int j = 0; j < sortArr.length - i - 1; j++) {

                if (sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;

                    // Запись каждой итерации сортировки в лог
                    LogMaker(Arrays.toString(sortArr));
                }
            }
        }
    }

    // Метод печати массива в консоль
    public static void printArray(int[] inputArray) {

        for (int i = 0; i < inputArray.length - 1; i++) {

            System.out.print(inputArray[i] + ", ");
        }
        System.out.println(inputArray[(inputArray.length) - 1]);
        System.out.println("\n" + "--------Конец массива---------");
    }

    public static void main(String[] args) {

        try {

            // Создание файла
            logger = new File("log.txt");
            logger.createNewFile();
            fWriter = new FileWriter(logger);

            // объявление массива для сортировки
            int[] sortArr = new int[] { 6, 23, 9, 2, 3, 7, 9, 12, 4 };

            // Вызов метода сортировки
            bubbleSort(sortArr);

            // вызов метода печати
            printArray(sortArr);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.print("\n" + "Логи сохранены");
            try {
                fWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}