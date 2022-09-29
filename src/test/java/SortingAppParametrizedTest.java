import com.epam.SortingApp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SortingAppParametrizedTest {
    private final int[] array;
    private final int[] expectedArray;

    public SortingAppParametrizedTest(int[] array, int[] expectedArray) {
        this.array = array;
        this.expectedArray = expectedArray;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0, -1, -1, 5, 8, 9}, new int[]{-1, -1, 0, 5, 8, 9}},
                {new int[]{3, -5, -7, 44, 2, 5}, new int[]{-7, -5, 2, 3, 5, 44}},
                {new int[]{0, -2, 3, 69, 19, 1}, new int[]{-2, 0, 1, 3, 19, 69}},
                {new int[]{1, 3, 2}, new int[]{1, 2, 3}},
                {new int[]{3, 2, 1}, new int[]{1, 2, 3}},
                {new int[]{1, 2, 3}, new int[]{1, 2, 3}},
                {new int[]{1, 1, 1}, new int[]{1, 1, 1}},
                { new int[] { 1 }, new int[] { 1 } },
        });
    }

    @Test
    public void testDifferentCases() {
        SortingApp sortingApp = new SortingApp();
        sortingApp.mergeSort(array);
        Assert.assertArrayEquals(expectedArray, array);
    }

}
