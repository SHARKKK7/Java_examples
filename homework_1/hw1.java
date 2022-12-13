/*
 * Задание 1.
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 */
import java.util.Scanner;

public class hw1 {

    // Метлд подсчитывающий факториал
    public static int calculateFactrorial(int n) {

        int resultFactorial = 1;

        for (int i = 1; i <= n; i++) {
            // resultFactorial = resultFactorial * i;
            resultFactorial *= i;
        }
        return resultFactorial;
    }

    // Метод подсчитывающий сумму чисел от 1-n
    public static int sumNumb(int n) {

        int resultSum = 0;

        for (int i = 1; i <= n; i++) {

            // resultSum = resultSum + i;
            resultSum += i;
        }
        return resultSum;
    }

    public static void main(String[] args) {

        // Получение числа n с консоли пользователем
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число n: ");
        // boolean flag = iScanner.hasNextInt();
        // System.out.println(flag);
        String nString = iScanner.next();
        int n = Integer.parseInt(nString);

        // System.out.printf("Hello, "+ i + '!'); // add format printf {}
        iScanner.close();
        
        System.out.println(sumNumb(n));
        System.out.println(calculateFactrorial(n));
    }
}
