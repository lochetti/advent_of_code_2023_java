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
    void testFirstReal() throws IOException {
        int result = DayThree.first("day_three_first_real");

        Assert.assertEquals(result, 553096);

        //maior que 508447 e menor que 553096
    }
}
