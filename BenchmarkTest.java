import java.util.Random;

public class BenchmarkTest {

    public static void main(String[] args) {
        int numberOfElements = 100_000;
        int[] data = new int[numberOfElements];
        Random random = new Random();
        
        System.out.println("Generating " + numberOfElements + " random integers...");
        for (int i = 0; i < numberOfElements; i++) {
            data[i] = random.nextInt(1_000_000);
        }

        MyBinarySearchTree<Integer> myTree = new MyBinarySearchTree<>();

        // --- TEST 1: INSERTION ---
        System.out.println("Starting Insertion Test...");
        long startInsert = System.nanoTime();

        for (int num : data) {
            myTree.insert(num);
        }

        long endInsert = System.nanoTime();
        double insertTime = (endInsert - startInsert) / 1_000_000.0;
        System.out.println("-> Inserted " + numberOfElements + " items in: " + insertTime + " ms");

        // --- TEST 2: SEARCH (contains) ---
        System.out.println("Starting Search Test...");
        long startSearch = System.nanoTime();

        for (int num : data) {
            myTree.contains(num);
        }

        long endSearch = System.nanoTime();
        double searchTime = (endSearch - startSearch) / 1_000_000.0;
        System.out.println("-> Searched " + numberOfElements + " items in: " + searchTime + " ms");
    }
}