/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlelinkedlistimplementation;

import java.util.Scanner;

/**
 *
 * @author rameshwarDayal
 */
public class SinglyLinkedList {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        LinkedList list = new LinkedList();
        list.insertAtStart(1);
        list.insertAtStart(2);
        list.insertAtStart(7);

        /*  Display List  */
        list.display();

        char ch;
        /*  Perform list operations  */
        do {
            System.out.println("\nSelect the operation you want to perform::::\n");
            System.out.println("1. Append an element into the linkedlist ");
            System.out.println("2. Remove the tail element from a linkedlist");
            System.out.println("3. Remove all element in the linkedlist that is greater than a target value");

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    list.insertAtStart(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Deleting element from linked list ");
                    list.deleteAtEnd();
                    list.display();
                    break;
                case 3:
                    System.out.println("Enter integer element to remove all element in the linkedlist that is greater than a entered value");
                    int enteredNumber = scan.nextInt();
                    list.removeElementGreaterThan(enteredNumber);
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            System.out.println("Current Linked List\n");
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}
