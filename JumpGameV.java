import java.util.*;

class jumpGameFive {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> arr[a] - arr[b]);

        int ans = 1;

        for (int i : idx) {

            for (int j = i - 1; j >= Math.max(0, i - d); j--) {
                if (arr[j] >= arr[i]) {
                    break;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
                if (arr[j] >= arr[i]) {
                    break;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}

public class JumpGameV {
    public static void main(String[] args) {
        jumpGameFive jcf = new jumpGameFive();
        int[] arr = {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        int d = 2;
        System.out.println(jcf.maxJumps(arr, d));
    }
}