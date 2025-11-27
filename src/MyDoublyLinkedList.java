public class MyDoublyLinkedList<T> implements DoublyLinkedList<T> {
    
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public MyDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    @Override
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    @Override
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    @Override
    public void insertAt(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            addFirst(data);
            return;
        }
        
        if (index == size) {
            addLast(data);
            return;
        }
        
        Node<T> newNode = new Node<>(data);
        Node<T> current = getNodeAt(index);
        
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
        
        size++;
    }
    
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        
        T data = head.data;
        
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        
        size--;
        return data;
    }
    
    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        
        T data = tail.data;
        
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        
        size--;
        return data;
    }
    
    @Override
    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            return removeFirst();
        }
        
        if (index == size - 1) {
            return removeLast();
        }
        
        Node<T> current = getNodeAt(index);
        T data = current.data;
        
        current.prev.next = current.next;
        current.next.prev = current.prev;
        
        size--;
        return data;
    }
    
    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }
    
    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return tail.data;
    }
    
    @Override
    public T getAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return getNodeAt(index).data;
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }
    
    @Override
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }
    
    @Override
    public int indexOf(T data) {
        Node<T> current = head;
        int index = 0;
        
        while (current != null) {
            if ((data == null && current.data == null) || 
                (data != null && data.equals(current.data))) {
                return index;
            }
            current = current.next;
            index++;
        }
        
        return -1;
    }
    
    private Node<T> getNodeAt(int index) {
        Node<T> current;
        
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        
        return current;
    }
    
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}