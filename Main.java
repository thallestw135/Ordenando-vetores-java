import java.util.Random;

public class Main {
    private static int[] generateRandomNumbers(int count, int min, int max) {
        int[] numbers = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextInt((max - min) + 1) + min;
        }

        return numbers;
    }

    
    public static void main(String[] args) {
        int[] numbers = generateRandomNumbers(1000, -9999, 9999);
        DoublyLinkedList list = new DoublyLinkedList();

        for (int number : numbers) {
            list.insertSorted(number);
        }

        System.out.println("\nLista em ordem crescente:");
        list.printAscending();

        System.out.println("\nLista em ordem decrescente:");
        list.printDescending();

        list.removePrimes();

        System.out.println("\nLista sem números primos em ordem crescente:");
        list.printAscending();
    }
}