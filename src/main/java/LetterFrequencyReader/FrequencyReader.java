package LetterFrequencyReader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyReader {

    private static final Charset charset = Charset.defaultCharset();
    private static final String file = "src/main/resources/text/story.txt";
    Map<Character, Integer> frequencies = new HashMap<>();
    final Path path = Paths.get(file);

    List<String> stringList = new ArrayList<>(Files.readAllLines(path, charset));
    String text = formattedString();

    public FrequencyReader() throws IOException {
    }

    public String formattedString() {
        List<String> list = stringList;
        String str = list.stream()
                .map(String::toLowerCase)
                .collect(Collectors.joining());
        return str.replaceAll("[^a-zA-Z]", "");
    }

    public void mapLettersToFrequenciesAndPrintOut() {
        String text = this.text;
        for (Character ch : text.toCharArray()) {
            frequencies.merge(ch, 1, Integer::sum);
        }
        frequencies.forEach((key, value) -> System.out.println(key + " = " + value));
    }
}
