/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlelinkedlistimplementation;

/**
 *
 * @author rameshwarDayal
 */
public class LinkedList {

    protected Node start;
    protected Node end;
    public int size;

    /*  Constructor  */
    public LinkedList() {
        start = null;
        end = null;
        size = 0;
    }

    /*  Function to check if list is empty  */
    public boolean isEmpty() {
        return start == null;
    }

    /*  Function to get size of list  */
    public int getSize() {
        return size;
    }

    /*  Function to insert an element at begining  */
    public void insertAtStart(int val) {
        Node nptr = new Node(val, null);
        size++;
        if (start == null) {
            start = nptr;
            end = start;
        } else {
            nptr.setLink(start);
            start = nptr;
        }
    }

    /*  Function to insert an element at end  */
    public void insertAtEnd(int val) {
        Node nptr = new Node(val, null);
        size++;
        if (start == null) {
            start = nptr;
            end = start;
        } else {
            end.setLink(nptr);
            end = nptr;
        }
    }

    /*  Function to insert an element at position  */
    public void deleteAtEnd() {

        Node currentElement = start;
        Node nextElement = currentElement.getLink();

        if (size == 1) {
            start = null;
            size--;
        } else {
            while (currentElement.getLink() != null) {
                if (nextElement.getLink() == null) {
                    currentElement.setLink(null);
                    size--;
                } else {
                    currentElement = nextElement;
                    nextElement = currentElement.getLink();
                }
            }
        }
    }

    /*  Function to remove all element in the linkedlist that is greater than a target value  */
    public void removeElementGreaterThan(int val) {

        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (start.getLink() == null) {
            System.out.println("Only Single element :");
            System.out.println(start.getData());
            return;
        }
        Node currentElement = start;
        for (int i = 1; i <= size; i++) {
            if (currentElement.getData() < val) {
                deleteAtPos(i);
                i--;
            }
            currentElement = currentElement.getLink();
        }
    }

    /*  Function to delete an element at position  */
    public void deleteAtPos(int pos) {
        if (pos == 1) {
            start = start.getLink();
            size--;
            return;
        }
        if (pos == size) {
            Node s = start;
            Node t = start;
            while (s != end) {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null);
            size--;
            return;
        }
        Node ptr = start;
        pos = pos - 1;
        for (int i = 1; i < size - 1; i++) {
            if (i == pos) {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size--;
    }

    /*  Function to display elements  */
    public void display() {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (start.getLink() == null) {
            System.out.println(start.getData());
            return;
        }
        Node ptr = start;
        System.out.print(start.getData() + "->");
        ptr = start.getLink();
        while (ptr.getLink() != null) {
            System.out.print(ptr.getData() + "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData() + "\n");
    }
}
