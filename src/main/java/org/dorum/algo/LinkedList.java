package org.dorum.algo;

import org.dorum.utils.RecordMethodInfo;

import java.util.HashSet;
import java.util.Set;

import static org.dorum.algo.LeetCode.LC_150;

public class LinkedList {

    public static class Node {
        int val;
        public Node next;
    }

    public static Node newNode(int data) {
        Node newNode = new Node();
        newNode.val = data;
        newNode.next = null;
        return newNode;
    }

    public static Node createLinkedList(int count) {
        Node head = newNode(0);
        Node currentNode = head;
        for (int i = 1; i <= count; i++) {
            currentNode.next = newNode(i);
            currentNode = currentNode.next;
        }
        return head;
    }

    public static int countOfNodes(Node head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static Node deleteMid(Node head) {
        if (head == null)
            return null;
        if (head.next == null) {
            return null;
        }
        Node copyHead = head;
        int count = countOfNodes(head);
        int mid = count / 2;
        while (mid-- > 1) {
            head = head.next;
        }
        head.next = head.next.next;
        return copyHead;
    }

    public static Node deleteMid1(Node head) {
        if (head == null)
            return null;
        if (head.next == null) {
            return null;
        }
        Node slow_ptr = head, fast_ptr = head, prev = null;
        while (fast_ptr != null && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            prev = slow_ptr;
            slow_ptr = slow_ptr.next;
        }
        prev.next = slow_ptr.next;
        return head;
    }

    public static void printList(Node ptr) {
        while (ptr != null) {
            System.out.print(ptr.val + "->");
            ptr = ptr.next;
        }
        System.out.println("NULL");
    }

    /**
     * <a href="{@link LeetCode#LC_150}93/linked-list/553/">removeNthFromEnd</a>
     */
    @RecordMethodInfo(link = LC_150 + "93/linked-list/553/")
    public static void deleteNode(Node node) {
        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    /**
     * <a href="{@link LeetCode#LC_150}93/linked-list/603/">removeNthFromEnd</a>
     */
    @RecordMethodInfo(link = LC_150 + "93/linked-list/603/")
    public static Node removeNthFromEnd(Node head, int n) {
        int counter = 0, length = countOfNodes(head);
        if (length == 1) {
            head = null;
            return head;
        }
        Node previousNode = null;
        Node currentNode = head;
        while (counter++ < length - n) {
            previousNode = head;
            head = head.next;
        }
        if (head.next != null) {
            head.val = head.next.val;
            head.next = head.next.next;
        } else {
            head = previousNode;
            head.next = null;
        }
        return currentNode;
    }

    /**
     * <a href="{@link LeetCode#LC_150}93/linked-list/560/">reverseList</a>
     */
    @RecordMethodInfo(link = LC_150 + "93/linked-list/560/")
    public static Node reverseList(Node head) {
        Node previousNode = null, currentNode = head;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    /**
     * <a href="{@link LeetCode#LC_150}93/linked-list/771/">mergeTwoLists</a>
     */
    @RecordMethodInfo(link = LC_150 + "93/linked-list/771/")
    public static Node mergeTwoLists(Node head1, Node head2) {
        Node result = new Node();
        Node currentResult = result;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                currentResult.next = head1;
                head1 = head1.next;
            } else {
                currentResult.next = head2;
                head2 = head2.next;
            }
            currentResult = currentResult.next;
        }
        currentResult.next = head1 != null ? head1 : head2 != null ? head2 : currentResult.next;
        return result.next;
    }

    /**
     * <a href="{@link LeetCode#LC_150}93/linked-list/771/">mergeTwoListsRecursive</a>
     */
    @RecordMethodInfo(link = LC_150 + "93/linked-list/771/")
    public Node mergeTwoListsRecursive(Node list1, Node list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null)
            return list2;
        return list1;
    }

    /**
     * <a href="{@link LeetCode#LC_150}93/linked-list/772/">isPalindrome</a>
     */
    @RecordMethodInfo(link = LC_150 + "93/linked-list/772/")
    public static boolean isPalindrome(Node head) {
        Node reversedNode = null;
        Node originalNode = head;
        while (head != null) {
            Node newNode = newNode(head.val);
            newNode.next = reversedNode;
            reversedNode = newNode;
            head = head.next;
        }
        while (originalNode != null && reversedNode != null) {
            if (originalNode.val != reversedNode.val) {
                return false;
            }
            originalNode = originalNode.next;
            reversedNode = reversedNode.next;
        }
        return true;
    }

    /**
     * <a href="{@link LeetCode#LC_150}93/linked-list/772/">isPalindrome1</a>
     */
    @RecordMethodInfo(link = LC_150 + "93/linked-list/772/")
    public static boolean isPalindrome1(Node head) {
        Node slowPointer = head, fastPointer = head;
        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        Node reversedNode = reverseList(slowPointer);
        while (reversedNode != null && head != null) {
            if (reversedNode.val != head.val) {
                return false;
            }
            reversedNode = reversedNode.next;
            head = head.next;
        }
        return true;
    }

    /**
     * <a href="{@link LeetCode#LC_150}93/linked-list/773/">hasCycle</a>
     */
    @RecordMethodInfo(link = LC_150 + "93/linked-list/773/")
    public static boolean hasCycle(Node head) {
        Set<Node> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * <a href="{@link LeetCode#LC_150}93/linked-list/773/">hasCycle1</a>
     */
    @RecordMethodInfo(link = LC_150 + "93/linked-list/773/")
    public static boolean hasCycle1(Node head) {
        Node slowPointer = head, fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (fastPointer == slowPointer) {
                return true;
            }
        }
        return false;
    }
}
