import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DayThreeTest {

    @Test
    void testFirstExample() throws IOException {
        int result = DayThree.first("day_three_first_example");

        Assert.assertEquals(result, 4361);
    }

    @Test
    void testFirstExample2() throws IOException {
        int result = DayThree.first("day_three_first_example2");

        Assert.assertEquals(result, 156);
    }

    @Test
    void testFirstExample3() throws IOException {
        int result = DayThree.first("day_three_first_example3");

        Assert.assertEquals(result, 1000);
    }

    @Test
    void testFirstExample4() throws IOException {
        int result = DayThree.first("day_three_first_example4");

        Assert.assertEquals(result, 10);
    }

    @Test
    void testFirstExample5() throws IOException {
        int result = DayThree.first("day_three_first_example5");

        Assert.assertEquals(result, 21);
    }

    @Test
    void testFirstExample6() throws IOException {
        int result = DayThree.first("day_three_first_example6");

        Assert.assertEquals(result, 676);
    }

    @Test
    void testFirstExample7() throws IOException {
        int result = DayThree.first("day_three_first_example7");

        Assert.assertEquals(result, 301);
    }

    @Test
    void testFirstExample8() throws IOException {
        int result = DayThree.first("day_three_first_example8");

        Assert.assertEquals(result, 100);
    }

    @Test
    void testFirstExample9() throws IOException {
        int result = DayThree.first("day_three_first_example9");

        Assert.assertEquals(result, 94);
    }

    @Test
    void testFirstExample10() throws IOException {
        int result = DayThree.first("day_three_first_example10");

        Assert.assertEquals(result, 94);
    }

    @Test
    void testFirstReal() throws IOException {
        int result = DayThree.first("day_three_first_real");

        Assert.assertEquals(result, 553079);
    }
}
