import com.epam.SortingApp;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SortingAppTest {
    private static SortingApp sortingApp;

    @BeforeClass
    public static void createNewSortingApp() {

        sortingApp = new SortingApp();
    }

    @Test(expected = NullPointerException.class)
    public void nullCaseShouldThrowException() {

        sortingApp.mergeSort(null);
    }

    @Test(expected = NullPointerException.class)
    public void emptyArrayShouldThrowAnException() {
        int[] arr = {};
        sortingApp.mergeSort(arr);
    }

    @Test
    public void arrayAlreadySortedShouldBeTheSame() {
        int[] arr = new int[]{-1, -1, 0, 5, 8, 9};
        int[] expectedArr = new int[]{-1, -1, 0, 5, 8, 9};
        Assert.assertArrayEquals(expectedArr, sortingApp.mergeSort(arr));
    }

    @Test
    public void arrayWithOneElementShouldBeSorted() {
        int[] arr = new int[]{9};
        int[] expectedArr = new int[]{9};
        Assert.assertArrayEquals(expectedArr, sortingApp.mergeSort(arr));
    }

    @Test
    public void arrayShouldBeSorted() {
        int[] arr = {0, -2, 3, 69, 19, 1};
        int[] expectedArr = {-2, 0, 1, 3, 19, 69};
        Assert.assertArrayEquals(expectedArr, sortingApp.mergeSort(arr));
    }
}
