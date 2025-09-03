// Prince MJ D. Canencia
// BSIT 2B
// September 3,2025

public class ArrayLinkedListSimulation {
    private int[] elements = new int[5];
    private int size = 0;

    // Add element to end; resize if full
    public void add(int value) {
        if (size == elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = value;
    }

    // Remove and return first element; shift left
    public int poll() {
        if (size == 0) return -1;
        int val = elements[0];
        System.arraycopy(elements, 1, elements, 0, --size);
        return val;
    }

    // Return first element without removing
    public int peek() {
        return size == 0 ? -1 : elements[0];
    }

    // Remove and return last element
    public int pop() {
        return size == 0 ? -1 : elements[--size];
    }

    // Display elements
    public void display() {
        System.out.print(size == 0 ? "List is empty." : "Current List: ");
        for (int i = 0; i < size; i++) System.out.print(elements[i] + " ");
        System.out.println();
    }

    // Test the class
    public static void main(String[] args) {
        ArrayLinkedListSimulation list = new ArrayLinkedListSimulation();

        System.out.println("Adding elements:");
        for (int i = 1; i <= 5; i++) { list.add(i * 10); list.display(); }

        System.out.println("\nPeek: " + list.peek());
        System.out.println("\nPoll: " + list.poll()); list.display();
        System.out.println("\nPop: " + list.pop()); list.display();

        System.out.println("\nRemoving all:");
        while (list.peek() != -1) { System.out.println("Polled: " + list.poll()); list.display(); }

        System.out.println("\nTesting empty:");
        System.out.println("Peek: " + list.peek());
        System.out.println("Poll: " + list.poll());
        System.out.println("Pop: " + list.pop());
    }
}
// Adding elements:
// Current List: 10
// Current List: 10 20
// Current List: 10 20 30
// Current List: 10 20 30 40
// Current List: 10 20 30 40 50
// Peek: 10

// Poll: 10
// Current List: 20 30 40 50

// Pop: 50
// Current List: 20 30 40
// Removing all:
// Polled: 20
// Current List: 30 40
// Polled: 30
// Current List: 40
// Polled: 40
// List is empty.
// Testing empty:
// Peek: -1
// Poll: -1
// Pop: -1
