import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.dorum.algo.LinkedIn.*;

public class LinkedInTest {
    private final static String TEST_STRING = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of" +
            " type and scrambled it to make a type specimen book. It has survived not only five centuries, but also" +
            " the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s" +
            " with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop" +
            " publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
    private final static String TEST_STRING_2 = "Penguins are aquatic, flightless birds that are highly adapted to life in the water. " +
            "Their distinct tuxedo-like appearance is called countershading, a form of camouflage that helps keep " +
            "them safe in the water. Penguins do have wing-bones, though they are flipper-like and extremely suited" +
            " to swimming. Penguins are found almost exclusively in the southern hemisphere, where they catch their" +
            " food underwater and raise their young on land.";
    private final static String TEST_STRING_3 = "Students seek relief from rising prices through the purchase of used copies of textbooks," +
            " which tend to be less expensive. Most college bookstores offer used copies of textbooks at lower" +
            " prices. Most bookstores will also buy used copies back from students at the end of a term if the book" +
            " is going to be re-used at the school. Books that are not being re-used at the school are often" +
            " purchased by an off-campus wholesaler for 0-30% of the new cost, for distribution to other bookstores" +
            " where the books will be sold. Textbook companies have countered this by encouraging faculty to assign" +
            " homework that must be done on the publisher's website. If a student has a new textbook, then he or she" +
            " can use the pass code in the book to register on the site. If the student has purchased a used" +
            " textbook, then he or she must pay money directly to the publisher in order to access the website and" +
            " complete assigned homework. ";

    @Test
    public void countWordsInSentenceTest() {
        Assertions.assertEquals("lorem", countWordsInSentence(TEST_STRING));
        Assertions.assertEquals("penguins", countWordsInSentence(TEST_STRING_2));
        Assertions.assertEquals("used", countWordsInSentence(TEST_STRING_3));
        Assertions.assertEquals("penguins", countWordsInSentence(TEST_STRING_2));
        Assertions.assertEquals("used", countWordsInSentence(TEST_STRING_3));
    }

    @Test
    public void findParenthesesTest() {
        Assertions.assertTrue(findParentheses1("()[]"));
        Assertions.assertTrue(findParentheses1("(Valik)[Ira]"));
        Assertions.assertFalse(findParentheses1("([>"));
        Assertions.assertFalse(findParentheses1("(Valik)[Ira"));
        Assertions.assertFalse(findParentheses1("(Valik[I>ra"));
        Assertions.assertFalse(findParentheses1("Valik)Ira"));
    }

    @Test
    public void decimalToBinaryTest() {
        Assertions.assertEquals("101001", decimalToBinary(37));
    }

    @Test
    public void palindromeCheckerTest() {
        Assertions.assertTrue(palindromeChecker("Civic"));
        Assertions.assertFalse(palindromeChecker("Valik"));
    }

    @Test
    public void printListTest() {
        CustomNode<Integer> head = CustomNode.buildNode(1);
        CustomNode<Integer> node2 = CustomNode.buildNode(2);
        CustomNode<Integer> node3 = CustomNode.buildNode(3);
        CustomNode<Integer> node4 = CustomNode.buildNode(4);
        CustomNode<Integer> node5 = CustomNode.buildNode(5);

        head.setNextNodeRef(node2);
        node2.setNextNodeRef(node3);
        node3.setNextNodeRef(node4);
        node4.setNextNodeRef(node5);

//        deleteMiddleNode();
        CustomNode.printList(head);
    }

    @Test
    public void maximumProductOf2NumbersTest() {
        maximumProductOf2Numbers(new int[]{5, 3, 2, 5, 7, 0});
        maximumProductOf2Numbers(new int[]{-2, -1, -3, 4, -8});
        maximumProductOf2Numbers(new int[]{2});
    }

    @Test
    public void vowelsCounterTest() {
        Assertions.assertEquals(4, vowelsCounter("Valentine"));
    }
}
