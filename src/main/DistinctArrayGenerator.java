package main;

import exception.NumberOutOfRangeException;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class DistinctArrayGenerator {
    public boolean isValidRangeNumber(int sizeArrayInput) throws NumberOutOfRangeException {
        if(sizeArrayInput <1 || sizeArrayInput >100)
            throw new NumberOutOfRangeException("O número deve ser maior ou igual a 1, e menor ou igual a 100");
        return true;
    }

    public int[] GenerateArray(int sizeOfArray) throws NumberOutOfRangeException {
        boolean validNumber = isValidRangeNumber(sizeOfArray);
        int[] arrayResponse = new int[sizeOfArray];
        if(validNumber){
            for(int i = 0; i < sizeOfArray -1; i++){
                arrayResponse[i] = getNextValueToArray(arrayResponse);
            }
            int sum = IntStream.of(arrayResponse).sum();
            arrayResponse[sizeOfArray -1] = sum * -1;
        }
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
