import java.util.*;

public class MinWaitingTime {
    public static int minWaitingTime(int[] times) {
        int minWaitingTime = 0;
        Arrays.sort(times);
        for (int i = 0; i < times.length; i++) {
            int duration = times[i];
            minWaitingTime += duration * (times.length - i - 1);
        }
        return minWaitingTime;
    }

    public static void main(String[] args) {
        int[] times = { 5, 1, 4 };
        System.out.println(minWaitingTime(times));
    }
}