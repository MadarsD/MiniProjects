package LetterFrequencyReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static final List<Character> list = new ArrayList<>();
    private static final Map<Character, Integer> frequencies = new HashMap<>();

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("C:\\Users\\User\\Desktop\\VeryShortText.txt");
        int i;
        while ((i = reader.read()) != -1) {
            list.add((char) i);
        }

        String text = joinCharactersToString(list);

        mapLettersToFrequencies(text);

        showLetterFrequencies(frequencies);
    }

    public static String joinCharactersToString(List<Character> list) {
        String str = list.stream()
                .map(String::valueOf)
                .map(String::toLowerCase)
                .collect(Collectors.joining());
        return str.replaceAll("[^a-zA-Z0-9]", "");
    }

    public static void mapLettersToFrequencies(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            frequencies.merge(c, 1, Integer::sum);
        }
    }

    public static void showLetterFrequencies(Map<Character, Integer> map) {
        map.forEach((key, value) -> System.out.println(key + " = " + value));
    }
}
