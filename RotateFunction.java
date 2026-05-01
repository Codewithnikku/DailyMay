class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int f = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }

        int maxF = f;

        for (int k = 1; k < n; k++) {
            f = f + sum - n * nums[n - k];
            maxF = Math.max(maxF, f);
        }

        return maxF;
    }
}

public class Main {
    public static void main(String[] args) {
        
    }
}