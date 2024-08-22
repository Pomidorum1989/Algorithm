import org.dorum.algo.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.dorum.algo.LinkedList.*;
import static org.dorum.algo.LinkedList.printList;

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
        Assertions.assertTrue(isPalindrome(left));
        Assertions.assertFalse(isPalindrome(right));
        Assertions.assertFalse(isPalindrome1(right));
        Assertions.assertTrue(isPalindrome(left));
        Assertions.assertTrue(isPalindrome1(left));
    }

    @Test
    public void hasCycleTest() {
        LinkedList.Node loop = newNode(3);
        loop.next = newNode(2);
        loop.next.next = newNode(0);
        loop.next.next.next = newNode(-4);
        loop.next.next.next.next = loop.next;

        Assertions.assertTrue(hasCycle(loop));
        Assertions.assertFalse(hasCycle(right));
        Assertions.assertTrue(hasCycle1(loop));
        Assertions.assertFalse(hasCycle1(right));
    }

    @Test
    public void mergeTwoListsTest() {
        Node head = createLinkedList(7);
        Node head1 = createLinkedList(9);
        printList(head);
        printList(head1);

        printList(left);
        printList(right);

        Node modifiedListHead = removeNthFromEnd(head, 2);
        printList(modifiedListHead);

        deleteNode(head);
        Node reversedHead = reverseList(head);
        printList(reversedHead);

        head = deleteMid(head);
        printList(head);

        Node mergedHead = mergeTwoLists(left, right);
        printList(mergedHead);
    }
}
