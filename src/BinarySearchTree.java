public interface BinarySearchTree<T extends Comparable<T>>{
   // Core operations
    void insert(T data); // Insert a new value
    boolean contains(T data); // Search for a value
    void delete(T data); // Delete a value
    // Traversals
    void inOrderTraversal(); // Left, Root, Right
    void preOrderTraversal(); // Root, Left, Right
    void postOrderTraversal(); // Left, Right, Root
    void levelOrderTraversal(); // BFS
    // Properties
    int height(); // Height of tree
    int size(); // Number of nodes
    boolean isEmpty(); // Check if empty 

    
}
