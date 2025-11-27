import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {
    
    private TreeNode<T> root;
    private int size;
    
    public MyBinarySearchTree() {
        this.root = null;
        this.size = 0;
    }
    
    @Override
    public void insert(T data) {
        root = insertRecursive(root, data);
        size++;
    }
    
    private TreeNode<T> insertRecursive(TreeNode<T> node, T data) {
        if (node == null) {
            return new TreeNode<>(data);
        }
        
        int comparison = data.compareTo(node.data);
        
        if (comparison < 0) {
            node.left = insertRecursive(node.left, data);
        } else if (comparison > 0) {
            node.right = insertRecursive(node.right, data);
        }
        
        return node;
    }
    
    @Override
    public boolean contains(T data) {
        return containsRecursive(root, data);
    }
    
    private boolean containsRecursive(TreeNode<T> node, T data) {
        if (node == null) {
            return false;
        }
        
        int comparison = data.compareTo(node.data);
        
        if (comparison == 0) {
            return true;
        } else if (comparison < 0) {
            return containsRecursive(node.left, data);
        } else {
            return containsRecursive(node.right, data);
        }
    }
    
    @Override
    public void delete(T data) {
        if (contains(data)) {
            root = deleteRecursive(root, data);
            size--;
        }
    }
    
    private TreeNode<T> deleteRecursive(TreeNode<T> node, T data) {
        if (node == null) {
            return null;
        }
        
        int comparison = data.compareTo(node.data);
        
        if (comparison < 0) {
            node.left = deleteRecursive(node.left, data);
        } else if (comparison > 0) {
            node.right = deleteRecursive(node.right, data);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            }
            
            if (node.left == null) {
                return node.right;
            }
            
            if (node.right == null) {
                return node.left;
            }
            
            T minValue = findMin(node.right);
            node.data = minValue;
            node.right = deleteRecursive(node.right, minValue);
        }
        
        return node;
    }
    
    private T findMin(TreeNode<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }
    
    @Override
    public void inOrderTraversal() {
        inOrderRecursive(root);
        System.out.println();
    }
    
    private void inOrderRecursive(TreeNode<T> node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.data + " ");
            inOrderRecursive(node.right);
        }
    }
    
    @Override
    public void preOrderTraversal() {
        preOrderRecursive(root);
        System.out.println();
    }
    
    private void preOrderRecursive(TreeNode<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }
    
    @Override
    public void postOrderTraversal() {
        postOrderRecursive(root);
        System.out.println();
    }
    
    private void postOrderRecursive(TreeNode<T> node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }
    
    @Override
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println();
            return;
        }
        
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();
            System.out.print(current.data + " ");
            
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        System.out.println();
    }
    
    @Override
    public int height() {
        return heightRecursive(root);
    }
    
    private int heightRecursive(TreeNode<T> node) {
        if (node == null) {
            return -1;
        }
        
        int leftHeight = heightRecursive(node.left);
        int rightHeight = heightRecursive(node.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    private static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;
        
        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}