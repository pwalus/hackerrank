package algorithms.data_structures.linked_list;

import java.io.*;
import java.util.*;

public class PositionNodeLinkedList {

    static class SinglyLinkedListNode {

        public int data;

        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {

        public SinglyLinkedListNode head;

        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(
        SinglyLinkedListNode node,
        String sep,
        BufferedWriter bufferedWriter
    ) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the insertNodeAtPosition function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtPosition(
        SinglyLinkedListNode head,
        int data,
        int position
    ) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);

        if (position == 0) {
            node.next = head;
            return node;
        }

        SinglyLinkedListNode tmpNode = head;
        for (int i = 1; i < position; i++) {
            tmpNode = tmpNode.next;
        }

        node.next = tmpNode.next;
        tmpNode.next = node;

        return head;
    }

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if (position == 0) {
            SinglyLinkedListNode node = head.next;
            head.next = null;

            return node;
        }

        SinglyLinkedListNode tmpNode = head;
        for (int i = 1; i < position; i++) {
            tmpNode = tmpNode.next;
        }

        tmpNode.next = tmpNode.next != null ? tmpNode.next.next : null;

        return head;
    }

    static void reversePrint(SinglyLinkedListNode head) {
        if (head == null) {
            return;
        }

        reversePrint(head.next);
        System.out.println(head.data);
    }


    protected static SinglyLinkedListNode reversedHead;

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null) {
            return null;
        }

        _reverse(head, head.next);

        return reversedHead;
    }

    private static SinglyLinkedListNode _reverse(
        SinglyLinkedListNode head,
        SinglyLinkedListNode next
    ) {
        if (next == null) {
            reversedHead = new SinglyLinkedListNode(head.data);
            return reversedHead;
        }

        SinglyLinkedListNode newHead = _reverse(next, next.next);
        newHead.next = new SinglyLinkedListNode(head.data);

        return newHead.next;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

//        int data = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int position = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//        SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);
        SinglyLinkedListNode llist_head = reverse(llist.head);

        printSinglyLinkedList(llist_head, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
