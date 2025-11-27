import java.util.Random;

public class ListBenchmark {

    public static void main(String[] args) {
        int totalElements = 100_000;
        int testSamples = 1_000;

        int[] data = new int[totalElements];
        Random random = new Random();

        System.out.println("Generating " + totalElements + " random integers...");
        for (int i = 0; i < totalElements; i++) {
            data[i] = random.nextInt(1_000_000);
        }
        MyDoublyLinkedList<Integer> myList = new MyDoublyLinkedList<>();

        // --- TEST 1: ADDING TO END
        System.out.println("1. Starting 'addLast' Test (Insertion)...");
        long startAdd = System.nanoTime();

        for (int num : data) {
            myList.addLast(num);
        }

        long endAdd = System.nanoTime();
        double addTime = (endAdd - startAdd) / 1_000_000.0;
        System.out.println("-> Added " + totalElements + " items in: " + addTime + " ms");


        // --- TEST 2: RANDOM ACCESS
        System.out.println("2. Starting 'getAt' Test (Random Access)...");
        long startGet = System.nanoTime();

        for (int i = 0; i < testSamples; i++) {
            int randomIndex = random.nextInt(totalElements);
            myList.getAt(randomIndex);
        }

        long endGet = System.nanoTime();
        double getTime = (endGet - startGet) / 1_000_000.0;
        System.out.println("-> Retrieved " + testSamples + " random items in: " + getTime + " ms");


        // --- TEST 3: SEARCH
        System.out.println("3. Starting 'contains' Test (Search)...");
        long startSearch = System.nanoTime();

        for (int i = 0; i < testSamples; i++) {
            int target = data[random.nextInt(totalElements)];
            myList.contains(target);
        }

        long endSearch = System.nanoTime();
        double searchTime = (endSearch - startSearch) / 1_000_000.0;
        System.out.println("-> Searched for " + testSamples + " items in: " + searchTime + " ms");
    }
}