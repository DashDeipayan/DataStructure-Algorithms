import java.util.*;

public class ZigzagArray {
    public static ArrayList<Integer> zigzagArray(ArrayList<ArrayList<Integer>> array) {
        int row = 0, col = 0;
        int len = array.size() - 1, wid = array.get(0).size() - 1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean down = true;
        while (!isExceeding(row, col, len, wid)) {
            result.add(array.get(row).get(col));
            if (down) {
                if (col == 0 || row == len) {
                    down = false;
                    if (row == len) {
                        col++;
                    } else {
                        row++;
                    }
                } else {
                    col--;
                    row++;
                }
            } else {
                if (row == 0 || col == wid) {
                    down = true;
                    if (col == wid) {
                        row++;
                    } else {
                        col++;
                    }
                } else {
                    col++;
                    row--;
                }
            }
        }
        return result;
    }

    private static boolean isExceeding(int row, int col, int len, int wid) {
        return row < 0 || row > len || col < 0 || col > wid;
    }

    public static void main(String[] args) {
        int[][] array = { { 1, 3, 4, 10 }, { 2, 5, 9, 11 }, { 6, 8, 12, 15 }, { 7, 13, 14, 16 } };

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int[] nums : array) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i : nums) {
                temp.add(i);
            }
            arr.add(temp);
        }

        System.out.println(zigzagArray(arr));
    }
}
