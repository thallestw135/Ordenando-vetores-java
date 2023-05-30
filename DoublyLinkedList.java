public class DoublyLinkedList {
    Node head;
    Node tail;

    public void insertSorted(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else if (data <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (data >= tail.data) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < data) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    public void removePrimes() {
        Node current = head;
        while (current != null) {
            if (isPrime(current.data)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                    current = head;
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                    current = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current = current.next;
                }
            } else {
                current = current.next;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void printAscending() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printDescending() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}