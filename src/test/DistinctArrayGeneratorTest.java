package test;

import java.util.stream.IntStream;
import static org.junit.Assert.*;
import  org.junit.Test;

import exception.NumberOutOfRangeException;
import main.DistinctArrayGenerator;

public class DistinctArrayGeneratorTest {

    @Test
    public void deveriaGerarOArraySemErro() throws NumberOutOfRangeException {
        int sizeArray = 5;
        DistinctArrayGenerator arrayGenerator = new DistinctArrayGenerator(sizeArray);
        int[] arrayResponse = arrayGenerator.GenerateArray();
        int sum = IntStream.of(arrayResponse).sum();
        assertEquals(sum, 0);
    }

    @Test(expected = NumberOutOfRangeException.class)
    public void deveriaLancarExceptionAoGerarOArrray() throws NumberOutOfRangeException {
        int sizeArray = 150;
        DistinctArrayGenerator arrayGenerator = new DistinctArrayGenerator(sizeArray);
        arrayGenerator.GenerateArray();
    }
}
