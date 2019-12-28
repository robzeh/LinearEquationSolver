import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GaussianEliminationTest {
    /*
     * Simple matrix for testing
     * 2 3 2 -3
     * 1 1 1 0
     * -1 2 -3 -1
     */
    private final static double[][] simpleMatrix = {
            {2, 3, 2, -3},
            {1, 1, 1, 0},
            {-1, 2, -3, -1}
    };

    /*
     * Ensure printout is equal to simple matrix
     */
    @Test
    void printMatrix() {
        GaussianElimination solver = new GaussianElimination(simpleMatrix);
        assertEquals("2.0 3.0 2.0 -3.0 \n1.0 1.0 1.0 0.0 \n-1.0 2.0 -3.0 -1.0 \n", solver.printMatrix(), "Printout of matrix");

    }
}