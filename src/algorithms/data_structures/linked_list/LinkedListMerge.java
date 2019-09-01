package algorithms.data_structures.linked_list;

import java.io.*;
import java.util.*;

public class LinkedListMerge {

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

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode newHead = head1;
        SinglyLinkedListNode tmpHead = newHead;
        SinglyLinkedListNode tmpNode = nextNode(head1);

        while (tmpNode != null){
            tmpHead.next = tmpNode;
            tmpNode = nextNode(tmpNode);
            tmpHead = nextNode(tmpHead);
        }

        tmpHead = newHead;
        tmpNode = head2;
        while (tmpNode != null){
//            if(tmpNode.data < tmpHead.data){
//                tmpHead.n
//            }
//
//            tmpNode = nextNode(tmpNode);
//            tmpHead = nextNode(tmpHead);
        }


//        SinglyLinkedListNode newHead = assign(head1, head2);
//        newHead.next = assign(head2, head1);
//

//        SinglyLinkedListNode tmpHead = newHead;
//
//        while (tmp1 != null || tmp2 != null) {
//            tmpHead.next = assign(tmp1, tmp2);
//            tmpHead.next.next = assign(tmp2, tmp1);
//            tmp1 = nextNode(tmp1);
//            tmp2 = nextNode(tmp2);
//            tmpHead = tmpHead.next.next;
//        }

        return newHead;
    }

    private static SinglyLinkedListNode nextNode(SinglyLinkedListNode tmp) {
        return tmp != null ? tmp.next : null;
    }

    private static SinglyLinkedListNode assign(
        SinglyLinkedListNode node1,
        SinglyLinkedListNode node2
    ) {
        if (node1 == null) {
            return copy(node2);
        }

        if (node2 == null) {
            return copy(node1);
        }

        return node1.data < node2.data ? copy(node1) : copy(node2);
    }

    private static SinglyLinkedListNode copy(SinglyLinkedListNode node) {
        return new SinglyLinkedListNode(node.data);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist1 = new SinglyLinkedList();

            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }

            SinglyLinkedList llist2 = new SinglyLinkedList();

            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }

            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

            printSinglyLinkedList(llist3, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
