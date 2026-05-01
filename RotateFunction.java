class RFunction {
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

public class RotateFunction {
    public static void main(String[] args) {
        RFunction solution = new RFunction();
        int[] nums = {4, 3, 2, 6};
        System.out.println(solution.maxRotateFunction(nums));
    }
}