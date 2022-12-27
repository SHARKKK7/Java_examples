/*
 * Задание 1. Реализуйте структуру телефонной книги с помощью HashMap,учитывая,что 1 человек может иметь несколько телефонов.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hw1 {
    private static HashMap<String, String> phoneB = new HashMap<String, String>();

    // addPB - добавляет запись по заданным номеру телефона и фамилии
    private static void addPB(String phone, String name) {
        phoneB.put(phone, name);
    }

    // delPB - удаляет запись по номеру телефона
    private static void delPB(String phone) {
        phoneB.remove(phone);
    }

    // PrintPhonebook - выводит на екран все записи справочника
    public static void PrintPhonebook() {
        System.out.println("Телефонный справочник: ");
        for (Map.Entry<String, String> k : phoneB.entrySet()) {
            System.out.println(k.getValue() + ": " + k.getKey());
        }
    }

    // FindSurname - производит поиск фамилии по номеру телефона заданому в качестве аргумента
    // возвращает строку
    public static String FindSurname(String number) {
        String result = phoneB.get(number);
        if (result == null)
            return "абонент с таким номером не найдей";
        return result;
    }

    // FindNumberPhone - производит поиск списка номеров по фамилии заданой в качестве аргумента
    // возвращает массив строк
    public static String[] FindNumberPhone(String surname) {
        List<String> result = new ArrayList<String>();
        for (Map.Entry entry : phoneB.entrySet()) {
            if (surname.equalsIgnoreCase((String) entry.getValue())) {
                result.add((String) entry.getKey());
            }
        }
        if (result.size() == 0)
            result.add("абонент с такой фамилией не найден");
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException {
        
        // переменная описывает вызываемое действие
        String act;

        // вывод записей на екран
        // PrintPhonebook();

        // вывод на екран описания возможных действий с указанием команд
        System.out.println(
                "выбор действия: (phoneBook) Показать телефонный справочник, (add)добавить данные, (del)удалить данные, (num) найти номера по фамилии, (sur)найти фамилию, "
                        +
                        "(save)сохранить, (exit)выход");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        act = bf.readLine();
        while (!act.equals("exit")) {
            // добавление записи
            if (act.equals("add")) {
                System.out.println("Введите фамилию:");
                String name = bf.readLine();
                System.out.println("Введите телефон:");
                String phone = bf.readLine();
                addPB(phone, name);

            } else {
                // удаление записи
                if (act.equals("del")) {
                    System.out.println("Введите телефон:");
                    String phone = bf.readLine();
                    delPB(phone);
                } else {
                    // поиск номеров по фамилии
                    if (act.equals("num")) {
                        System.out.println("Введите фамилию:");
                        String surname = bf.readLine();
                        String[] numbers = FindNumberPhone(surname);
                        for (String number : numbers) {
                            System.out.println(number);
                        }
                    } else {
                        // поиск фамилии по номеру
                        if (act.equals("sur")) {
                            System.out.println("Введите номер:");
                            String number = bf.readLine();
                            System.out.println(FindSurname(number));
                        } else {
                            if (act.equals("phoneBook")) {
                                // System.out.println("Телефонный справочник: ");
                                PrintPhonebook();
                            }
                        }
                    }
                }
            }
            // запрос на следующее действие
            System.out.println(
                    "выбор действия: (phoneBook) Показать телефонный справочник, (add)добавить данные, (del)удалить данные, (num) найти номера по фамилии, (sur)найти фамилию, (save)сохранить, (exit)выход");
            act = bf.readLine();
        }
    }
}
