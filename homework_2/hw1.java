package homework_2;

import java.util.HashMap;
import java.util.Map;

/* 
1. Задача. Дана строка sql-запроса "select * from students where ".
Сформируйте часть WHERE этого запроса, используя StringBuilder.
Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.

Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
*/
public class hw1 {
    public static void main(String[] args) {
        Map<String, String> bdParams = new HashMap<String,String>();
        bdParams.put("name","Ivanov");
        bdParams.put("country","Russia");
        bdParams.put("city","Moscow");
        bdParams.put("age",null);
        System.out.println(getQuery(bdParams));
    }
    public static String getQuery(Map<String, String> Params)
    {
        StringBuilder sBuild = new StringBuilder();
        for (Map.Entry<String,String> pair : Params.entrySet())
        {
            if (pair.getValue() != null)
            {
                sBuild.append(pair.getKey() +" = '" + pair.getValue()+"' and ");
            }
        }
        sBuild.delete(sBuild.toString().length()-5,sBuild.toString().length());
        return sBuild.toString();
    }

}