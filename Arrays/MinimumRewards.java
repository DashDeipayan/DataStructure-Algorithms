import java.util.stream.IntStream;
import java.util.*;

public class MinimumRewards {
    public static int minRewards(int[] scores) {
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[i - 1]) {
                rewards[i] = rewards[i - 1] + 1;
            }
        }
        for (int i = scores.length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                rewards[i] = Math.max(rewards[i + 1] + 1, rewards[i]);
            }
        }
        return IntStream.of(rewards).sum();
    }

    public static void main(String[] args) {
        int[] scores = { 8, 6, 4, 5, 6, 9, 10, 12, 3, 14, 16, 2 };
        System.out.println(minRewards(scores));
    }
}
