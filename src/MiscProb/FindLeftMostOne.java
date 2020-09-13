package MiscProb;

public class FindLeftMostOne {
    
    public static int findLeftmostIndexOfOne(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int candidate = -1;
        for (int r = 0, c = cols - 1; r < rows && c >= 0; ) {
            if (matrix[r][c] == 1) {
                candidate = c;
                c--;
            } else {
                r++;
            }
        }
        return candidate;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0, 1},
                          {0, 0, 1, 1},
                          {0, 1, 1, 1},
                          {0, 0, 0, 0}};
        test(matrix, 1);
        
        int[][] matrix2 = {{0, 0, 0, 0},
                          {0, 0, 0, 0},
                          {0, 0, 0, 0},
                          {0, 0, 0, 0}};
        
        test(matrix2, -1);
        
        int[][] matrix3 = {{0, 0, 0, 0},
                          {0, 0, 0, 0},
                          {0, 0, 0, 0},
                          {0, 0, 0, 1}};
        
        test(matrix3, 3);
    }
    
    private static void test(int[][] matrix, int expected) {
        int actual = findLeftmostIndexOfOne(matrix);
        if (actual == expected) {
            System.out.println("PASSED!");
        } else {
            System.out.println(String.format("FAILED! Expected: %d, but got: %d", expected, actual));
        }
    }
}
