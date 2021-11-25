import java.util.*;

public class ApartmentHunting {
    private static int[][] lowestPricesMatrix(ArrayList<HashMap<String, Boolean>> blocks, String[] reqs) {
        int[][] reqChart = new int[reqs.length][blocks.size()];
        for (int i = 0; i < reqs.length; i++) {
            for (int j = 0; j < blocks.size(); j++) {
                if (blocks.get(j).get(reqs[i])) {
                    reqChart[i][j] = 0;
                } else if (j != 0 && reqChart[i][j - 1] != -1) {
                    reqChart[i][j] = reqChart[i][j - 1] + 1;
                } else {
                    reqChart[i][j] = -1;
                }
            }
            for (int j = blocks.size() - 1; j >= 0; j--) {
                if (reqChart[i][j] == 0) {
                    continue;
                } else if (j != blocks.size() - 1 && reqChart[i][j + 1] != -1) {
                    reqChart[i][j] = Math.max(reqChart[i][j + 1] + 1, reqChart[i][j]);
                }
            }
        }
        return reqChart;
    }

    private static int minDistanceColumn(int[][] reqChart) {
        int minValue = Integer.MAX_VALUE;
        int idealBlockNumber = 0;
        for (int i = 0; i < reqChart[0].length; i++) {
            int temp = 0, k = reqChart.length / 2, p = reqChart.length / 2;
            while (k >= 0) {
                temp = temp - reqChart[k][i];
            }
            while (p < reqChart.length) {
                temp = temp + reqChart[p][i];
            }
            if (temp < minValue) {
                minValue = temp;
                idealBlockNumber = i;
            }
        }
        // Find the minimum distances column
        return idealBlockNumber;
    }

    public static int apartmentHunting(ArrayList<HashMap<String, Boolean>> blocks, String[] reqs) {
        int[][] reqChart = lowestPricesMatrix(blocks, reqs);
        int idealBlockNumber = minDistanceColumn(reqChart);
        return idealBlockNumber;
    }

    public static void main(String[] args) {
        ArrayList<HashMap<String, Boolean>> blocks = new ArrayList<HashMap<String, Boolean>>();

        HashMap<String, Boolean> block1 = new HashMap<String, Boolean>();
        block1.put("gym", false);
        block1.put("office", true);
        block1.put("school", true);
        block1.put("store", false);
        blocks.add(block1);

        HashMap<String, Boolean> block2 = new HashMap<String, Boolean>();
        block2.put("gym", true);
        block2.put("office", false);
        block2.put("school", false);
        block2.put("store", false);
        blocks.add(block2);

        HashMap<String, Boolean> block3 = new HashMap<String, Boolean>();
        block3.put("gym", false);
        block3.put("office", false);
        block3.put("school", false);
        block3.put("store", true);
        blocks.add(block3);

        HashMap<String, Boolean> block4 = new HashMap<String, Boolean>();
        block4.put("gym", false);
        block4.put("office", true);
        block4.put("school", false);
        block4.put("store", false);
        blocks.add(block4);

        HashMap<String, Boolean> block5 = new HashMap<String, Boolean>();
        block5.put("gym", false);
        block5.put("office", false);
        block5.put("school", true);
        block5.put("store", false);
        blocks.add(block5);

        HashMap<String, Boolean> block6 = new HashMap<String, Boolean>();
        block6.put("gym", false);
        block6.put("office", false);
        block6.put("school", false);
        block6.put("store", false);
        blocks.add(block6);

        String[] reqs = { "gym", "office", "school", "store" };

        System.out.println(apartmentHunting(blocks, reqs));
    }
}
/*
 * [ { "gym": false, "office": true, "school": true, "store": false }, { "gym":
 * true, "office": false, "school": false, "store": false }, { "gym": true,
 * "office": false, "school": true, "store": false }, { "gym": false, "office":
 * false, "school": true, "store": false }, { "gym": false, "office": false,
 * "school": true, "store": true } ]
 */