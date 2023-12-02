import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DayOneTest {

    @Test
    void testFirstExample() throws IOException {
        int result = DayOne.first("day_one_first_example");

        Assert.assertEquals(result, 142);
    }

    @Test
    void testFirstReal() throws IOException {
        int result = DayOne.first("day_one_first_real");

        Assert.assertEquals(result, 55017);
    }

    @Test
    void testSecondExample() throws IOException {
        int result = DayOne.second("day_one_second_example");

        Assert.assertEquals(result, 281);
    }

    @Test
    void testSecondReal() throws IOException {
        int result = DayOne.second("day_one_first_real");

        Assert.assertEquals(result, 53539);
    }
}
