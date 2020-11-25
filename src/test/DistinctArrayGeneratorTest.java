package test;

import java.util.stream.IntStream;
import static org.junit.Assert.*;
import  org.junit.Test;

import exception.NumberOutOfRangeException;
import main.DistinctArrayGenerator;

public class DistinctArrayGeneratorTest {
    private DistinctArrayGenerator arrayGenerator = new DistinctArrayGenerator();

    @Test
    public void deveriaGerarOArraySemErro() throws NumberOutOfRangeException {
        int sizeArray = 5;
        int[] arrayResponse = this.arrayGenerator.GenerateArray(sizeArray);
        int sum = IntStream.of(arrayResponse).sum();
        assertEquals(sum, 0);
    }

    @Test(expected = NumberOutOfRangeException.class)
    public void deveriaLancarExceptionAoGerarOArrray() throws NumberOutOfRangeException {
        int sizeArray = 150;
        this.arrayGenerator.GenerateArray(sizeArray);
    }
}
