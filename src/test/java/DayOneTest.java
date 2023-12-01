import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DayOneTest {

    @Test
    void test_day_one_first_example() throws IOException {
        int result = DayOne.first("day_one_first_example");

        Assert.assertEquals(result, 142);
    }

    @Test
    void test_day_one_first_real() throws IOException {
        int result = DayOne.first("day_one_first_real");

        Assert.assertEquals(result, 55017);
    }

    @Test
    void test_day_one_second_example() throws IOException {
        int result = DayOne.second("day_one_second_example");

        Assert.assertEquals(result, 281);
    }

    @Test
    void test_day_one_second_real() throws IOException {
        int result = DayOne.second("day_one_first_real");

        Assert.assertEquals(result, 53539);
    }
}
