import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.dorum.algo.Habr.closestNumber;
import static org.dorum.algo.Habr.closestNumber1;

public class HabrTest {

    @Test
    public void closestNumberTest() {
        int[] array = new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21};
        int[] array1 = new int[]{};
        Assertions.assertEquals(12, closestNumber(12, array));
        Assertions.assertEquals(12, closestNumber(13, array));
        Assertions.assertEquals(-1, closestNumber(2, array));
        Assertions.assertEquals(21, closestNumber(22, array));
        Assertions.assertEquals(3, closestNumber(3, array));
        Assertions.assertEquals(21, closestNumber(21, array));
        Assertions.assertEquals(-1, closestNumber(12, array1));
        Assertions.assertEquals(-1, closestNumber(null, array));
        Assertions.assertEquals(12, closestNumber1(12, array));
        Assertions.assertEquals(12, closestNumber1(13, array));
        Assertions.assertEquals(-1, closestNumber1(2, array));
        Assertions.assertEquals(21, closestNumber1(22, array));
        Assertions.assertEquals(3, closestNumber1(3, array));
        Assertions.assertEquals(21, closestNumber1(21, array));
        Assertions.assertEquals(-1, closestNumber1(12, array1));
        Assertions.assertEquals(-1, closestNumber1(null, array));
    }
}
