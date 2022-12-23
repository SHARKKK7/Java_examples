/*
 * Задание 2. Реализуйте очередь с помощью LinkedList со следующими методами:
 - enqueue() - помещает элемент в конец очереди,
 - dequeue() - возвращает первый элемент из очереди и удаляет его,
 - first() - возвращает первый элемент из очереди, не удаляя.
 */
import java.util.LinkedList;

public class hw2 {

    // int data;
    // hw2 next;

    private static LinkedList listNums = new LinkedList();

    public hw2(LinkedList listNums) {

        // this.data = data;
        // this.next = null;
        this.listNums = listNums;
    }

    static class Queue {

        public void dequeue() {

            Object first = listNums.getFirst();
            listNums.removeFirst();
            System.out.println("\nУдаляем элемент: ");

            System.out.printf("Удаление числа %d\n", first);
        }

        public void enqueue(Object listNum) {

            listNums.add(listNum);
            System.out.printf("Вставка %d\n", listNum);
        }

        // Вспомогательная функция для возврата верхнего элемента в queue
        public Object first() {
            return listNums.getFirst();
        }

        public LinkedList printValue() {
            return listNums;
        }

        static class Main {

            public static void main(String[] args) {

                Queue q = new Queue();

                q.enqueue(1);
                q.enqueue(2);
                q.enqueue(3);
                q.enqueue(4);
                q.enqueue(5);
                q.enqueue(6);
                q.enqueue(7);
                q.enqueue(8);

                System.out.println(q.printValue() + "\n");
                System.out.printf("Первый элемент в очереди: %d\n", q.first());

                q.dequeue();
                q.dequeue();
                q.dequeue();
                q.dequeue();
                // q.dequeue();

                System.out.printf("\nПервый элемент в очереди: %d",q.first());
            }
        }
    }
}
