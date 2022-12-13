/*
 * Задание 3. 
 * Реализовать простой калькулятор (операции + - / * )
 */

import java.util.Scanner;
 
public class hw3 {
    static Scanner scanner = new Scanner(System.in);
 
    public static void main(String[] args) {

        // Опросим с пользователя 2 числа
        int num1 = getInt();
        int num2 = getInt();

        // выбор операции "+" "-" "*" "/"
        char operation = getOperation();
        int result = calc(num1,num2,operation);
        System.out.println("Результат операции: "+result);
    }
 
    // Метод проверяет целочисленное число поступает на ввод или нет
    public static int getInt(){

        System.out.println("Введите число:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");

            // рекурсия
            scanner.next();
            num = getInt();
        }
        return num;
    }
 
    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            // получаем значение 0-го элемента строки 
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");

            //возвращение к рекурсии, если пользователь ввёл неверный символ операции
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }
    // Реализация выбора операции через switch-case конструкцию
    public static int calc(int num1, int num2, char operation){
        int result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");

                //Вывод результата калькулятора
                result = calc(num1, num2, getOperation());
        }
        return result;
    }
}