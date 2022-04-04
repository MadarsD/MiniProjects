package LetterFrequencyReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FrequencyReader reader = new FrequencyReader();
        reader.mapLettersToFrequenciesAndPrintOut();
    }
}
