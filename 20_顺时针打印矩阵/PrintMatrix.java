public class PrintMatrix {
    public static void print(int[][] matrix) {
        if (matrix == null) 
            return;

        int up = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (up <= bottom || left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[up][i]);
                System.out.print(" ");
            }
            up++;
            if (up > bottom)
                break;

            for (int i = up; i <= bottom; i++) {
                System.out.print(matrix[i][right]);
                System.out.print(" ");
            }
            right--;
            if (right < left)
                break;

            for (int i = right; i >= left; i--) {
                System.out.print(matrix[bottom][i]);
                System.out.print(" ");
            }
            bottom--;

            for (int i = bottom; i >= up; i--) {
                System.out.print(matrix[i][left]);
                System.out.print(" ");
            }
            left++;
        }
        System.out.println();
    }

    public static void test() {
        print(buildMatrix(4, 4));

        print(buildMatrix(4, 3));

        print(buildMatrix(3, 4));

        print(buildMatrix(1, 5));

        print(buildMatrix(5, 1));
    }

    private static int[][] buildMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = i * cols + j + 1;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        test();
    }
}
