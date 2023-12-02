import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DayTwoTest {

    @Test
    void testFirstExample() throws IOException {
        int result = DayTwo.first("day_two_first_example");

        Assert.assertEquals(result, 8);
    }

    @Test
    void testFirstReal() throws IOException {
        int result = DayTwo.first("day_two_first_real");

        Assert.assertEquals(result, 2563);
    }

    @Test
    void testSecondExample() throws IOException {
        int result = DayTwo.second("day_two_first_example");

        Assert.assertEquals(result, 2286);
    }

    @Test
    void testSecondReal() throws IOException {
        int result = DayTwo.second("day_two_first_real");

        Assert.assertEquals(result, 70768);
    }
}
