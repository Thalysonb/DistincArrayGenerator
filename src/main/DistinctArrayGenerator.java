package main;

import exception.NumberOutOfRangeException;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class DistinctArrayGenerator {
    private int arraySize;

    public DistinctArrayGenerator(int arraySize){
        this.arraySize = arraySize;
    }

    public void isValidRangeNumber() throws NumberOutOfRangeException {
        if(this.arraySize <1 || arraySize >100)
            throw new NumberOutOfRangeException("O número deve ser maior ou igual a 1, e menor ou igual a 100");
    }

    public int[] GenerateArray() throws NumberOutOfRangeException {
        isValidRangeNumber();

        int[] arrayResponse = new int[this.arraySize];
        for(int i = 0; i < this.arraySize -1; i++){
            arrayResponse[i] = getNextValueToArray(arrayResponse);
        }
        int sum = IntStream.of(arrayResponse).sum();
        arrayResponse[this.arraySize -1] = sum * -1;
        return arrayResponse;
    }

    private static int getNextValueToArray(int[] currentArray){
        int nextValue = ThreadLocalRandom.current().nextInt();
        if(IntStream.of(currentArray).anyMatch(x -> x == nextValue)){
            getNextValueToArray(currentArray);
        }

        return nextValue;
    }
}
