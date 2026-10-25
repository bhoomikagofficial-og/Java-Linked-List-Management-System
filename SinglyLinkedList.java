public class SinglyLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted " + value + " at the beginning.");
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
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

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Inserted " + value + " at position " + position + ".");
    }

    public void insertAfterValue(int target, int value) {
        Node current = head;
        while (current != null && current.data != target) {
            current = current.next;
        }
        if (current == null) {
            System.out.println(target + " was not found.");
            return;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Inserted " + value + " after " + target + ".");
    }

    public void insertBeforeValue(int target, int value) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.data == target) {
            insertAtBeginning(value);
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != target) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println(target + " was not found.");
            return;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Inserted " + value + " before " + target + ".");
    }

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        int removed = head.data;
        head = head.next;
        System.out.println("Deleted " + removed + " from the beginning.");
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.next == null) {
            int removed = head.data;
            head = null;
            System.out.println("Deleted " + removed + " from the end.");
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int removed = current.next.data;
        current.next = null;
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
        for (int i = 1; current.next != null && i < position - 1; i++) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Invalid position.");
            return;
        }
        int removed = current.next.data;
        current.next = current.next.next;
        System.out.println("Deleted " + removed + " from position " + position + ".");
    }

    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.data == value) {
            deleteFromBeginning();
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println(value + " was not found.");
            return;
        }
        current.next = current.next.next;
        System.out.println("Deleted the first occurrence of " + value + ".");
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
        Node current = head;
        while (current != null && current.data != oldValue) {
            current = current.next;
        }
        if (current == null) {
            System.out.println(oldValue + " was not found.");
            return;
        }
        current.data = newValue;
        System.out.println("Updated " + oldValue + " to " + newValue + ".");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
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
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        head = previous;
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
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        System.out.println("Duplicate values removed.");
    }
}
