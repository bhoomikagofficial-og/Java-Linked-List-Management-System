import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SinglyLinkedList singlyList = new SinglyLinkedList();
    private static final DoublyLinkedList doublyList = new DoublyLinkedList();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==================================================");
            System.out.println("           LINKED LIST MANAGEMENT SYSTEM");
            System.out.println("==================================================");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Compare Singly vs Doubly Linked List");
            System.out.println("4. Exit");
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> singlyMenu();
                case 2 -> doublyMenu();
                case 3 -> compareLists();
                case 4 -> System.out.println("Thank you for using the Linked List Management System.");
                default -> System.out.println("Invalid choice. Please select 1 to 4.");
            }
        } while (choice != 4);
        scanner.close();
    }

    private static void singlyMenu() {
        int choice;
        do {
            System.out.println("\n********** Operations on Singly Linked List **********");
            System.out.println(" 1. Insert at Beginning       2. Insert at End");
            System.out.println(" 3. Insert at Position        4. Insert After a Node");
            System.out.println(" 5. Insert Before a Node      6. Delete from Beginning");
            System.out.println(" 7. Delete from End           8. Delete from Position");
            System.out.println(" 9. Delete by Value          10. Search");
            System.out.println("11. Update                   12. Display");
            System.out.println("13. Count Nodes              14. Find Maximum");
            System.out.println("15. Find Minimum             16. Find Middle Element");
            System.out.println("17. Reverse                  18. Sort");
            System.out.println("19. Remove Duplicates        20. Exit to Main Menu");
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> singlyList.insertAtBeginning(readInt("Enter value: "));
                case 2 -> singlyList.insertAtEnd(readInt("Enter value: "));
                case 3 -> {
                    int value = readInt("Enter value: ");
                    int position = readInt("Enter 1-based position: ");
                    singlyList.insertAtPosition(value, position);
                }
                case 4 -> {
                    int target = readInt("Insert after which value? ");
                    int value = readInt("Enter new value: ");
                    singlyList.insertAfterValue(target, value);
                }
                case 5 -> {
                    int target = readInt("Insert before which value? ");
                    int value = readInt("Enter new value: ");
                    singlyList.insertBeforeValue(target, value);
                }
                case 6 -> singlyList.deleteFromBeginning();
                case 7 -> singlyList.deleteFromEnd();
                case 8 -> singlyList.deleteAtPosition(readInt("Enter 1-based position: "));
                case 9 -> singlyList.deleteByValue(readInt("Enter value to delete: "));
                case 10 -> singlyList.search(readInt("Enter value to search: "));
                case 11 -> {
                    int oldValue = readInt("Enter value to update: ");
                    int newValue = readInt("Enter replacement value: ");
                    singlyList.update(oldValue, newValue);
                }
                case 12 -> singlyList.display();
                case 13 -> singlyList.countNodes();
                case 14 -> singlyList.findMaximum();
                case 15 -> singlyList.findMinimum();
                case 16 -> singlyList.findMiddle();
                case 17 -> singlyList.reverse();
                case 18 -> singlyList.sort();
                case 19 -> singlyList.removeDuplicates();
                case 20 -> System.out.println("Returning to main menu.");
                default -> System.out.println("Invalid choice. Please select 1 to 20.");
            }
        } while (choice != 20);
    }

    private static void doublyMenu() {
        int choice;
        do {
            System.out.println("\n********** Operations on Doubly Linked List **********");
            System.out.println(" 1. Insert at Beginning       2. Insert at End");
            System.out.println(" 3. Insert at Position        4. Insert After a Node");
            System.out.println(" 5. Insert Before a Node      6. Delete from Beginning");
            System.out.println(" 7. Delete from End           8. Delete from Position");
            System.out.println(" 9. Delete by Value          10. Search");
            System.out.println("11. Update                   12. Display Forward");
            System.out.println("13. Display Backward         14. Count Nodes");
            System.out.println("15. Find Maximum             16. Find Minimum");
            System.out.println("17. Find Middle Element      18. Reverse");
            System.out.println("19. Sort                     20. Remove Duplicates");
            System.out.println("21. Exit to Main Menu");
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> doublyList.insertAtBeginning(readInt("Enter value: "));
                case 2 -> doublyList.insertAtEnd(readInt("Enter value: "));
                case 3 -> {
                    int value = readInt("Enter value: ");
                    int position = readInt("Enter 1-based position: ");
                    doublyList.insertAtPosition(value, position);
                }
                case 4 -> {
                    int target = readInt("Insert after which value? ");
                    int value = readInt("Enter new value: ");
                    doublyList.insertAfterValue(target, value);
                }
                case 5 -> {
                    int target = readInt("Insert before which value? ");
                    int value = readInt("Enter new value: ");
                    doublyList.insertBeforeValue(target, value);
                }
                case 6 -> doublyList.deleteFromBeginning();
                case 7 -> doublyList.deleteFromEnd();
                case 8 -> doublyList.deleteAtPosition(readInt("Enter 1-based position: "));
                case 9 -> doublyList.deleteByValue(readInt("Enter value to delete: "));
                case 10 -> doublyList.search(readInt("Enter value to search: "));
                case 11 -> {
                    int oldValue = readInt("Enter value to update: ");
                    int newValue = readInt("Enter replacement value: ");
                    doublyList.update(oldValue, newValue);
                }
                case 12 -> doublyList.displayForward();
                case 13 -> doublyList.displayBackward();
                case 14 -> doublyList.countNodes();
                case 15 -> doublyList.findMaximum();
                case 16 -> doublyList.findMinimum();
                case 17 -> doublyList.findMiddle();
                case 18 -> doublyList.reverse();
                case 19 -> doublyList.sort();
                case 20 -> doublyList.removeDuplicates();
                case 21 -> System.out.println("Returning to main menu.");
                default -> System.out.println("Invalid choice. Please select 1 to 21.");
            }
        } while (choice != 21);
    }

    private static void compareLists() {
        System.out.println("\n========== Singly vs Doubly Linked List ==========");
        System.out.println("Singly Linked List:");
        System.out.println("- Each node stores data and a next reference.");
        System.out.println("- Traversal is forward only.");
        System.out.println("- Uses less memory per node.");
        System.out.println("- Deleting a node often requires finding its previous node.");
        System.out.println("\nDoubly Linked List:");
        System.out.println("- Each node stores data, a previous reference, and a next reference.");
        System.out.println("- Traversal is possible in both directions.");
        System.out.println("- Uses more memory per node.");
        System.out.println("- Deleting a known node is easier because the previous reference is available.");
        System.out.println("\nCommon operations such as search, display, and finding min/max take O(n).");
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next();
        }
    }
}
