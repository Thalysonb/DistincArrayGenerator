import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class DistinctArrayGenerator {
    public static void main(String[] args) {
        System.out.print("Por favor digite um número maior ou igual a 1, e menor ou igual a 100: ");
        Scanner in = new Scanner(System.in);
        int sizeArrayInput = in.nextInt();

        DistinctArrayGenerator arrayGenerator = new DistinctArrayGenerator();
        int[] arrayResponse = arrayGenerator.GenerateArray(sizeArrayInput);
        System.out.println("Array gerado : " + Arrays.toString(arrayResponse));
    }

    public int[] GenerateArray(int sizeOfArray){
        int[] arrayResponse = new int[sizeOfArray];
        for(int i = 0; i < sizeOfArray -1; i++){
            arrayResponse[i] = getNextValueToArray(arrayResponse);
        }

        int sum = IntStream.of(arrayResponse).sum();
        arrayResponse[sizeOfArray -1] = sum * -1;

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
