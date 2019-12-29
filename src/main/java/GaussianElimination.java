import java.util.Scanner;

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

    /*
     * Splits augmented matrix form Ab = 0 where b is vector
     * Solve method. Finds pivot entries and swaps.
     * Then performs back substitution to find unique solutions
     * @return b - vector b that contains unique solutions
     */
    public double[] solve() {

        // Split augmented matrix into form Ab = 0
        double[][] a = new double[A.length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                a[i][j] = A[i][j];
            }
        }

        double[] b = new double[A.length];

        for (int k = 0; k < A.length; k++) {
            b[k] = A[k][A.length];
        }

        int n = b.length;

        for (int p = 0; p < n; p++) {

            // find pivot row and swap
            int max = p;
            for (int l = p + 1; l < n; l++) {
                if (Math.abs(a[l][p]) > Math.abs(a[max][p])) {
                    max = l;
                }
            }

            double[] temp = a[p];
            a[p] = a[max];
            a[max] = temp;

            double t = b[p];
            b[p] = b[max];
            b[max] = t;

            // pivot
            for (int i = p + 1; i < n; i++) {
                double alpha = a[i][p] / a[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    a[i][j] -= alpha * a[p][j];
                }
            }
        }

        // back substitute
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += a[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / a[i][i];
        }

        return x;

    }

    /*
     * Client to test input from command line
     * 3 3
     * 2 3 2 -3
     * 1 1 1 0
     * -1 2 -3 -1
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();

        double[][] a = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = scan.nextDouble();
            }
        }


        GaussianElimination solver = new GaussianElimination(a);

        double[] x = solver.solve();

        System.out.println("Solutions are: ");
        for (double d : x) {
            System.out.println(d);
        }


    }

}


