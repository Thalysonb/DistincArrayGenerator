package main;

import exception.NumberOutOfRangeException;

import java.util.Arrays;
import java.util.Scanner;

public class mainClass {
    public static void main(String[] args) throws NumberOutOfRangeException {
        System.out.print("Por favor digite um número maior ou igual a 1, e menor ou igual a 100: ");
        Scanner in = new Scanner(System.in);
        int sizeArrayInput = in.nextInt();
        DistinctArrayGenerator arrayGenerator = new DistinctArrayGenerator(sizeArrayInput);
        int[] arrayResponse = arrayGenerator.GenerateArray();
        System.out.println("Array gerado : " + Arrays.toString(arrayResponse));
    }
}
