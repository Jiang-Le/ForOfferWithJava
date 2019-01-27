public class FindInPartiallySortedMatrix {
    
    public static boolean find(int[][] martix, int number) {
        if (martix.length == 0)
            return false;
        
        int max_row = martix.length - 1;
        int max_col = martix[0].length - 1;

        int cur_row = 0;
        int cur_col = max_col;

        while (cur_row <= max_row && cur_col >= 0) {
            int val = martix[cur_row][cur_col];
            if (val == number)
                return true;
            else if (val < number)
                cur_row++;
            else
                cur_col--;
        }
        return false;
    }

    public static void test() {
        int[][] matrix = {
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}
        };
        assert find(matrix, 8) == true;
        assert find(matrix, 10) == true;
        assert find(matrix, 1) == true;
        assert find(matrix, 4) == true;
        assert find(matrix, 100) == false;
        
        assert find(new int[5][5], 1) == false;

        int[][] matrix1 = {
            {1, 2, 8, 9}
        };

        assert find(matrix1, 8) == true;
        assert find(matrix1, 100) == false;

        int[][] matrix2 = {
            {1},
            {2},
            {8},
            {9}
        };

        assert find(matrix2, 8) == true;
        assert find(matrix2, 100) == false;

        System.out.println("success");
    }


    public static void main(String[] args) {
        test();
    }

}