public class DoublyLinkedList {
    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Inserted " + value + " at the beginning.");
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Inserted " + value + " at the end.");
    }

    public void insertAtPosition(int value, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Positions start at 1.");
            return;
        }
        if (position == 1) {
            insertAtBeginning(value);
            return;
        }

        Node current = head;
        for (int i = 1; current != null && i < position - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }
        if (current == tail) {
            insertAtEnd(value);
            return;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        System.out.println("Inserted " + value + " at position " + position + ".");
    }

    public void insertAfterValue(int target, int value) {
        Node current = findNode(target);
        if (current == null) {
            System.out.println(target + " was not found.");
            return;
        }
        if (current == tail) {
            insertAtEnd(value);
            return;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        System.out.println("Inserted " + value + " after " + target + ".");
    }

    public void insertBeforeValue(int target, int value) {
        Node current = findNode(target);
        if (current == null) {
            System.out.println(target + " was not found.");
            return;
        }
        if (current == head) {
            insertAtBeginning(value);
            return;
        }
        Node newNode = new Node(value);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        System.out.println("Inserted " + value + " before " + target + ".");
    }

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        int removed = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        System.out.println("Deleted " + removed + " from the beginning.");
    }

    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("The list is empty.");
            return;
        }
        int removed = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        System.out.println("Deleted " + removed + " from the end.");
    }

    public void deleteAtPosition(int position) {
        if (position < 1 || head == null) {
            System.out.println(position < 1 ? "Invalid position." : "The list is empty.");
            return;
        }
        if (position == 1) {
            deleteFromBeginning();
            return;
        }

        Node current = head;
        for (int i = 1; current != null && i < position; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }
        if (current == tail) {
            deleteFromEnd();
            return;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        System.out.println("Deleted " + current.data + " from position " + position + ".");
    }

    public void deleteByValue(int value) {
        Node current = findNode(value);
        if (current == null) {
            System.out.println(value + " was not found.");
            return;
        }
        if (current == head) {
            deleteFromBeginning();
        } else if (current == tail) {
            deleteFromEnd();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            System.out.println("Deleted the first occurrence of " + value + ".");
        }
    }

    public int search(int value) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.data == value) {
                System.out.println(value + " found at position " + position + ".");
                return position;
            }
            current = current.next;
            position++;
        }
        System.out.println(value + " was not found.");
        return -1;
    }

    public void update(int oldValue, int newValue) {
        Node current = findNode(oldValue);
        if (current == null) {
            System.out.println(oldValue + " was not found.");
            return;
        }
        current.data = newValue;
        System.out.println("Updated " + oldValue + " to " + newValue + ".");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        System.out.print("NULL <- ");
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
            System.out.print(current == null ? " -> NULL" : " <-> ");
        }
        System.out.println();
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = tail;
        System.out.print("NULL <- ");
        while (current != null) {
            System.out.print(current.data);
            current = current.prev;
            System.out.print(current == null ? " -> NULL" : " <-> ");
        }
        System.out.println();
    }

    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Number of nodes: " + count);
        return count;
    }

    public void findMaximum() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        int maximum = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data > maximum) {
                maximum = current.data;
            }
            current = current.next;
        }
        System.out.println("Maximum value: " + maximum);
    }

    public void findMinimum() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        int minimum = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data < minimum) {
                minimum = current.data;
            }
            current = current.next;
        }
        System.out.println("Minimum value: " + minimum);
    }

    public void findMiddle() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element (second middle for even length): " + slow.data);
    }

    public void reverse() {
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = current.prev;
            current.prev = nextNode;
            current = nextNode;
        }
        Node oldHead = head;
        head = tail;
        tail = oldHead;
        System.out.println("List reversed.");
    }

    public void sort() {
        if (head == null || head.next == null) {
            System.out.println("List sorted.");
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("List sorted in ascending order.");
    }

    public void removeDuplicates() {
        Node current = head;
        while (current != null) {
            Node runner = current.next;
            while (runner != null) {
                if (runner.data == current.data) {
                    Node duplicate = runner;
                    runner = runner.next;
                    if (duplicate.prev != null) {
                        duplicate.prev.next = duplicate.next;
                    }
                    if (duplicate.next != null) {
                        duplicate.next.prev = duplicate.prev;
                    } else {
                        tail = duplicate.prev;
                    }
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        System.out.println("Duplicate values removed.");
    }

    private Node findNode(int value) {
        Node current = head;
        while (current != null && current.data != value) {
            current = current.next;
        }
        return current;
    }
}
