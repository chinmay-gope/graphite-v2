package io.graphite.graph.transform;

class StrassenMatrix {

    public static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;

        // Base case: small matrix, use naive multiplication
        if (n <= 2) {
            return naiveMultiply(A, B);
        }

        // Ensure n is a power of 2
        int m = nextPowerOfTwo(n);
        int[][] APrep = padMatrix(A, m);
        int[][] BPrep = padMatrix(B, m);

        int[][] CPrep = strassen(APrep, BPrep);

        // Trim back to original size
        return trimMatrix(CPrep, n);
    }

    private static int[][] strassen(int[][] A, int[][] B) {
        int n = A.length;

        if (n == 1) {
            return new int[][]{{A[0][0] * B[0][0]}};
        }

        int newSize = n / 2;
        int[][] a11 = new int[newSize][newSize];
        int[][] a12 = new int[newSize][newSize];
        int[][] a21 = new int[newSize][newSize];
        int[][] a22 = new int[newSize][newSize];

        int[][] b11 = new int[newSize][newSize];
        int[][] b12 = new int[newSize][newSize];
        int[][] b21 = new int[newSize][newSize];
        int[][] b22 = new int[newSize][newSize];

        // Splitting matrices into quadrants
        split(A, a11, 0, 0);
        split(A, a12, 0, newSize);
        split(A, a21, newSize, 0);
        split(A, a22, newSize, newSize);

        split(B, b11, 0, 0);
        split(B, b12, 0, newSize);
        split(B, b21, newSize, 0);
        split(B, b22, newSize, newSize);

        // Strassen’s 7 products calc
        int[][] m1 = strassen(add(a11, a22), add(b11, b22));
        int[][] m2 = strassen(add(a21, a22), b11);
        int[][] m3 = strassen(a11, subtract(b12, b22));
        int[][] m4 = strassen(a22, subtract(b21, b11));
        int[][] m5 = strassen(add(a11, a12), b22);
        int[][] m6 = strassen(subtract(a21, a11), add(b11, b12));
        int[][] m7 = strassen(subtract(a12, a22), add(b21, b22));

        // Combined results
        int[][] c11 = add(subtract(add(m1, m4), m5), m7);
        int[][] c12 = add(m3, m5);
        int[][] c21 = add(m2, m4);
        int[][] c22 = add(subtract(add(m1, m3), m2), m6);

        // Join all quadrants
        int[][] C = new int[n][n];
        join(c11, C, 0, 0);
        join(c12, C, 0, newSize);
        join(c21, C, newSize, 0);
        join(c22, C, newSize, newSize);

        return C;
    }

    static int[][] naiveMultiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    private static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }

    private static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }

    private static void split(int[][] P, int[][] C, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }

    private static void join(int[][] C, int[][] P, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }

    private static int[][] padMatrix(int[][] A, int size) {
        int[][] padded = new int[size][size];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, padded[i], 0, A[i].length);
        return padded;
    }

    private static int[][] trimMatrix(int[][] A, int size) {
        int[][] trimmed = new int[size][size];
        for (int i = 0; i < size; i++)
            System.arraycopy(A[i], 0, trimmed[i], 0, size);
        return trimmed;
    }

    private static int nextPowerOfTwo(int n) {
        int m = 1;
        while (m < n) m <<= 1;
        return m;
    }
}
