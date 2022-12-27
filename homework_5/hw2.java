/*
 * Задание 2. Пусть дан список сотрудников:

    Иван Иванов
    Светлана Петрова
    Кристина Белова
    Анна Мусина
    Анна Крутова
    Иван Юрин
    Петр Лыков
    Павел Чернов
    Петр Чернышов
    Мария Федорова
    Марина Светлова
    Мария Савина
    Мария Рыкова
    Марина Лугова
    Анна Владимирова
    Иван Мечников
    Петр Петин
    Иван Ежов

    Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */

 import java.util.*;

 public class hw2 {
    public static void main(String[] args) {
               
        String stringNames = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова,Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        
        String[] peopleAarray = stringNames.split(", ");

        HashMap<String, Integer> peoples = new HashMap<String, Integer>();

        for (String name : peopleAarray) {
                    String[] FullName = name.split(" ");
                    if (peoples.containsKey(FullName[0])) {
                        peoples.put(FullName[0], peoples.get(FullName[0]) + 1);
                    } else {
                        peoples.put(FullName[0], 1);
                    }
                }
        
        List<Integer> positions = new ArrayList<Integer>(peoples.values());
        positions.sort(Collections.reverseOrder());

        HashMap<String, Integer> sortedPeoples = new LinkedHashMap<String, Integer>();
        for (int position : positions)
        {
            for (String name : peoples.keySet()){
                if (position == peoples.get(name)) {
                    sortedPeoples.put(name, position);
                 }
            }
        }     
        System.out.println(sortedPeoples);      
    }
}