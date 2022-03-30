package LetterFrequencyReader;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class MainTest {

    @Test
    void testJoinCharactersToString(){
        //GIVEN
        List<Character> list = new ArrayList<>(List.of('A','c', '-', 'e', 'R', '.', ' '));
        String expectedToString = "acer";

        //WHEN
        String result = list.stream()
                .map(String::valueOf)
                .map(String::toLowerCase)
                .collect(Collectors.joining());
        String actualResult = result.replaceAll("[^a-zA-Z0-9]", "");

        //THEN
        Assertions.assertEquals(expectedToString, actualResult);
    }

    @Test
    void testMapLettersToFrequencies(){
        //GIVEN
        String testString = "acer";
        Map<Character, Integer> toTest = new HashMap<>();
        Map<Character, Integer> correct = new HashMap<>();
        correct.put('a', 1);
        correct.put('c', 1);
        correct.put('e', 1);
        correct.put('r', 1);

        //WHEN
        for (int i = 0; i < testString.length(); i++) {
            char c = testString.charAt(i);
            toTest.merge(c, 1, Integer::sum);
        }

        //THEN
        assertThat(toTest, is(correct));
        assertThat(toTest.size(), is(4));
        assertThat(toTest, IsMapContaining.hasEntry('a', 1));
        assertThat(toTest, IsMapContaining.hasEntry('c', 1));
        assertThat(toTest, IsMapContaining.hasEntry('e', 1));
        assertThat(toTest, IsMapContaining.hasEntry('r', 1));
    }

}
