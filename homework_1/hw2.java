/*
 * Задание 2.
 * Вывести все простые числа от 1 до 1000
 */

import java.util.ArrayList;

public class hw2 {

    public static void primeNumbers() {
        // int count = 4;// начинаем с 4, т.к. до 10 нам известны все простые числа и программа их не
                      // обрабатывает.
        int count = 3;
        int n = 1000;// число до которого необходимо найти все простые числа
        ArrayList<Integer> numbers = new ArrayList<>();// создаем массив, необходим для вывода чисел на экран, можно
                                                       // и без массива, просто выводить каждое найденное простое
                                                       // число
        numbers.add(2);// добавляем в массив простые числа до 7(см count = 3)
        numbers.add(3);
        numbers.add(5);

        for (int i = 5; i <= n; i += 2) {// проверяем все числа до нашего значения
            if (simple(i)) {// метод ниже
                count++;// меняем счетчик простых чисел
                numbers.add(i);// заносим простые в массив
            }
        }

        System.out.println("Количество простых чисел: " + count);// вывод количества
        System.out.print("\n"+ numbers);// вывод всех чисел

    }

    static boolean simple(int a) {// берем число i
        int p = 0;// переменная для определения результата
        if ((a % 2 == 0) || (a % 10 == 5)) {// исключаем числа, которые заканчиваются на 5 и четные
            return false;
        } else {
            for (int j = 3; j <= Math.sqrt(a); j += 2) {// делим на все нечетные числа до корня из i
                if (a % j == 0) {// если хотя бы на одно число делится, то остановка цикла, переход к следующему
                                 // числу
                    p += 1;
                    break;
                }
            }
        }
        if (p > 0) {// если p = 0, то возвращаем true, число простое
            return false;
        } else
            return true;

    }

    public static void main(String[] args) {

        primeNumbers();
    }
}
