import java.util.*;

public class Test {
    public static void main(String[] args) {
        String s = "сапог сарай арбуз болт бокс биржа";
        Map<Character, List<String>> result = new TreeMap<>();

        String[] wordsList = s.split(" ");
        // в мапу добавляются списки слов по буквам-ключам
        for (String word : wordsList) {
            char key = word.charAt(0);
            List<String> value = new ArrayList<>();
            if (result.containsKey(key)) {
                value = result.get(key);
            }
            value.add(word);
            result.put(key, value);
        }
        // фильтрация мапы с условием одного слова в списке
        result.entrySet().removeIf(characterSetEntry -> characterSetEntry.getValue().size() <= 1);
        // сортировка мапы по заданному условию
        result.values().forEach(ls -> ls.sort(Comparator.comparing(String::length).reversed().thenComparing(String::compareTo)));
        System.out.println(result.toString());
    }
}