public class GaussianElimination {

    private double[][] A; // Augmented matrix

    /*
     * Constructor method
     * @param - 2d array that represents augmented matrix
     * @return - copies array into own array
     */
    public GaussianElimination(double[][] a) {

        A = new double[a.length][a.length + 1];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length + 1; j++) {
                A[i][j] = a[i][j];
            }
        }

    }
    /*
     * Method to print out entire augmented matrix
     */
    public String printMatrix() {
        String out = "";

        for (double[] row : A) {
            for (double col : row) {
                out = out + col + " ";
            }
            out = out + "\n";
        }

        return out;
    }

    /*
     * Method to multiply row by scalar. Used to reduce entries in row to 0
     * @param row - what row in the matrix to alter
     * @param d - double to make entries 1
     */
    public void rowMultiply(int row, double d) {

        for (int i = 0; i < A.length + 1; i++) {
            A[row][i] = A[row][i] / d;
        }
    }







}
