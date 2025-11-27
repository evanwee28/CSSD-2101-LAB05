import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyBinarySearchTreeTest {

    @Test
    void basicBSTBehaviour() {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>();

        // Actions
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);

        // Checks
        assertEquals(3, tree.size(), "Size after 3 inserts");
        assertFalse(tree.isEmpty(), "Tree should not be empty");

        assertTrue(tree.contains(10), "Tree should contain 10");
        assertTrue(tree.contains(5),  "Tree should contain 5");
        assertTrue(tree.contains(15), "Tree should contain 15");
        assertFalse(tree.contains(99), "Tree should NOT contain 99");
    }
}
