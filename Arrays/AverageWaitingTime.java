public class AverageWaitingTime {
    public static double averageWaitingTime(int[][] customers) {
        int tempSum = customers[0][0] + customers[0][1];
        int waitingSum = tempSum - customers[0][0];
        for (int i = 1; i < customers.length; i++) {
            if (customers[i][0] < tempSum) {
                tempSum = tempSum + customers[i][1];
                waitingSum = waitingSum + (tempSum - customers[i][0]);
            } else {
                tempSum = customers[i][0] + customers[i][1];
                waitingSum = waitingSum + (tempSum - customers[i][0]);
            }
        }
        return (double) waitingSum / customers.length;
    }

    public static void main(String[] args) {
        int[][] customers = { { 1, 2 }, { 2, 5 }, { 4, 3 } };
        int[][] customers2 = { { 5, 2 }, { 5, 4 }, { 10, 3 }, { 20, 1 } };
        System.out.println(averageWaitingTime(customers));
        System.out.println(averageWaitingTime(customers2));
    }
}