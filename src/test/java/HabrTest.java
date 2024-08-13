import static org.dorum.algo.Habr.closestNumber;
import static org.dorum.algo.Habr.closestNumber1;

public class HabrTest {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21};
        int[] array1 = new int[]{};

        System.out.print(closestNumber(12, array) + "  ");
        System.out.print(closestNumber(13, array) + "  ");
        System.out.print(closestNumber(2, array) + "  ");
        System.out.print(closestNumber(22, array) + "  ");
        System.out.print(closestNumber(3, array) + "  ");
        System.out.print(closestNumber(21, array) + "  ");
        System.out.print(closestNumber(12, array1) + "  ");
        System.out.print(closestNumber(null, array) + "  ");
        System.out.println();
        System.out.print(closestNumber1(12, array) + "  ");
        System.out.print(closestNumber1(13, array) + "  ");
        System.out.print(closestNumber1(2, array) + "  ");
        System.out.print(closestNumber1(22, array) + "  ");
        System.out.print(closestNumber1(3, array) + "  ");
        System.out.print(closestNumber1(21, array) + "  ");
        System.out.print(closestNumber1(12, array1) + "  ");
        System.out.print(closestNumber1(null, array) + "  ");
    }
}
