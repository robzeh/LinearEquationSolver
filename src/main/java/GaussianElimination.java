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

        for (double[] dd : A) {
            for (double d : dd) {
                out = out + d + " ";
            }
            out = out + "\n";
        }

        return out;
    }







}
