import java.util.*;

public class SpiralTraverse {
    public static Integer[] spiralTraverse(int[][] array) {
        int rowSize = array.length;
        int colmSize = array[0].length;
        List<Integer> result = new ArrayList<>();
        Integer[] finalResult = new Integer[rowSize * colmSize];
        int startRow = 0, endRow = rowSize - 1;
        int startCol = 0, endCol = colmSize - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                result.add(array[startRow][i]);
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                result.add(array[i][endCol]);
            }
            for (int i = endCol - 1; i >= startCol; i--) {
                if (startRow == endRow)
                    break;
                result.add(array[endRow][i]);
            }
            for (int i = endRow - 1; i > startRow; i--) {
                if (startCol == endCol)
                    break;
                result.add(array[i][startCol]);
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        finalResult = result.toArray(finalResult);
        return finalResult;
    }

    public static void main(String[] args) {
        int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
        System.out.println(Arrays.toString(spiralTraverse(array)));
    }
    /*
     * [1 2 3] [4 5 6] [7 8 9] [10 11 12]
     */

}
