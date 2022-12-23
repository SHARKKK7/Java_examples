/*
 * Задание 1. Пусть дан LinkedList с несколькими элементами. 
 * Реализуйте метод, который вернет “перевернутый” список.
 */
import java.util.LinkedList;
import java.util.Stack;

public class hw1 {

    // Реализация метода переворота списка через стек
    private static LinkedList<Integer> listRevert(LinkedList<Integer> intList) {

        // Создание нового стека
        Stack<Integer> stackInt = new Stack<>();

        // Сохраянем элементы в стек
        stackInt.addAll(intList);

        // Цикл очищает исходный linkedlist и добавляет элементы в обратном порядке
        intList.clear();
        // пока в стеке имеются элементы, продолжается заполнение linkedList
        while (!stackInt.empty()) {
            intList.add(stackInt.pop());
        }
        return intList;
    }

    public static void main(String[] args) {

        LinkedList<Integer> intList = new LinkedList<>();

        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        intList.add(7);

        System.out.println(intList);

        System.out.println(listRevert(intList));
    }
}
