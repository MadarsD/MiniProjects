package LetterFrequencyReader;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class FrequencyReaderTest {


    public FrequencyReaderTest() throws IOException {
    }


    @Test
    public void testJoinCharactersToString() throws IOException {
        FrequencyReader readerTest = new FrequencyReader();

        String formatted = readerTest.formattedString();

        Assertions.assertTrue(formatted.matches("^((?!.[\\d\\s]).)*$"));
    }


//    @Test
//    public void testMapLettersToFrequencies() throws IOException {
//
//        FrequencyReader readerTest = new FrequencyReader();
//        //GIVEN
//        String testString = "child";
//
//        //WHEN
//        readerTest.mapLettersToFrequenciesAndPrintOut();
//
//        //THEN
//        assertThat(readerTest.frequencies.size(), is(5));
//        assertThat(readerTest.frequencies, IsMapContaining.hasEntry('c', 1));
//        assertThat(readerTest.frequencies, IsMapContaining.hasEntry('h', 1));
//        assertThat(readerTest.frequencies, IsMapContaining.hasEntry('i', 1));
//        assertThat(readerTest.frequencies, IsMapContaining.hasEntry('l', 1));
//        assertThat(readerTest.frequencies, IsMapContaining.hasEntry('d', 1));
//    }

}
