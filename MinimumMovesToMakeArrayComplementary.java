class MMAC {

    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[(2 * limit) + 2];

        for (int i = 0; i < n / 2; i++) {

            int a = nums[i];
            int b = nums[n - 1 - i];
            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;
            int sum = a + b;

            diff[2] += 2;
            diff[low] -= 1;
            diff[sum] -= 1;
            diff[sum + 1] += 1;
            diff[high + 1] += 1;
        }

        int res = Integer.MAX_VALUE;
        int moves = 0;

        for (int target = 2; target <= 2 * limit; target++) {
            moves += diff[target];
            res = Math.min(res, moves);
        }

        return res;
    }
}

public class MinimumMovesToMakeArrayComplementary {
    public static void main(String[] args) {

        MMAC solution = new MMAC();

        int[] nums1 = {1, 2, 4, 3};
        int[] nums2 = {1, 2, 2, 1};
        int[] nums3 = {1, 2, 1, 2};

        int limit1 = 4;
        int limit2 = 2;
        int limit3 = 2;

        System.out.println(solution.minMoves(nums1, limit1));
        System.out.println(solution.minMoves(nums2, limit2));
        System.out.println(solution.minMoves(nums3, limit3));
    }
}