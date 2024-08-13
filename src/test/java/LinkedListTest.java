import org.dorum.algo.LinkedList;
import org.junit.jupiter.api.Test;

import static org.dorum.algo.LinkedList.*;
import static org.dorum.algo.LinkedList.hasCycle;

public class LinkedListTest {
    private static final LinkedList.Node left;
    private static final LinkedList.Node right;

    static {
        left = newNode(1);
        left.next = newNode(2);
        left.next.next = newNode(2);
        left.next.next.next = newNode(1);

        right = newNode(1);
        right.next = newNode(1);
        right.next.next = newNode(2);
        right.next.next.next = newNode(1);
    }

    @Test
    public void isPalindromeTest() {
        System.out.println(isPalindrome(left));
        System.out.println(isPalindrome(right));
        System.out.println(isPalindrome1(right));
        System.out.println(isPalindrome(left));
        System.out.println(isPalindrome1(left));
    }

    @Test
    public void hasCycleTest() {
        LinkedList.Node loop = newNode(3);
        loop.next = newNode(2);
        loop.next.next = newNode(0);
        loop.next.next.next = newNode(-4);
        loop.next.next.next.next = loop.next;

        System.out.println(hasCycle(loop));
        System.out.println(hasCycle(right));
        System.out.println(hasCycle1(loop));
        System.out.println(hasCycle1(right));
    }

    @Test
    public void mergeTwoListsTest() {
        Node head = createLinkedList(7);
        Node head1 = createLinkedList(9);

        printList(left);
        printList(right);
        Node modifiedListHead = removeNthFromEnd(head, 2);
        deleteNode(head);
        Node reversedHead = reverseList(head);
        head = deleteMid(head);
        Node mergedHead = mergeTwoLists(left, right);
        printList(mergedHead);
    }
}
