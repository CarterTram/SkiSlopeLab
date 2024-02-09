import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SkiSlopeTest {

    @Test
    public void testCountRuns() {
        // Test case 1, this is the 3 10
    	//1 2 1 2 1 3 2 3 2 4 2 4 4 0 4 0 3 0 3 0

        int numNodes1 = 3;
        int[][] multiplier1 = {
            {0, 0, 0, 0, 0},
            {0, 0, 2, 1, 0},
            {0, 0, 0, 1, 2},
            {2, 0, 0, 0, 0},
            {2, 0, 0, 0, 0}
        };
        assertEquals(14, SkiSlope.countRuns(numNodes1 + 2, multiplier1));

        // Test case 2
        int numNodes2 = 2;
        int[][] multiplier2 = {
            {0, 0, 0, 0},
            {0, 1, 2, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };
        assertEquals(2, SkiSlope.countRuns(numNodes2 + 2, multiplier2));

        // Test case 3
        int numNodes3 = 2;
        int[][] multiplier3 = {
            {0, 0, 0, 0},
            {0, 0, 3, 1},
            {2, 0, 0, 1},
            {0, 0, 0, 0}
        };
        assertEquals(6, SkiSlope.countRuns(numNodes3 + 2, multiplier3));

        // Test case 4: No nodes connected
        int numNodes4 = 2;
        int[][] multiplier4 = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        assertEquals(0, SkiSlope.countRuns(numNodes4 + 2, multiplier4));
    }
}
