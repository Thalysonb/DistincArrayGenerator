import java.util.stream.IntStream;

import static org.junit.Assert.*;
import  org.junit.Test;

public class DistinctArrayGeneratorTest {
    private DistinctArrayGenerator arrayGenerator = new DistinctArrayGenerator();

    @Test
    public void GenerateArrayTest(){
        int sizeArray = 5;
        int[] arrayResponse = this.arrayGenerator.GenerateArray(sizeArray);
        int sum = IntStream.of(arrayResponse).sum();
        assertEquals(sum, 0);
    }
}
