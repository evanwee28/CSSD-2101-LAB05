import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyDoublyLinkedListTest {

    @Test
    void basicLinkedListBehaviour() {
        MyDoublyLinkedList<String> list = new MyDoublyLinkedList<>();

        // Actions
        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("c");
        list.addFirst("d"); // [d, c, b, a]

        // Checks
        assertEquals(4, list.size(), "List size after 4 inserts");
        assertFalse(list.isEmpty(), "List should not be empty");

        list.removeFirst(); // [c, b, a]
        assertEquals(3, list.size(), "List size after removeFirst");

        list.addLast("e"); // [c, b, a, e]
        assertEquals("e", list.getLast(), "Last element should be 'e'");
    }
}
