import java.util.*;

class MNNJRLI{
    public int maximumJumps(int[] nums, int target) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        dp[0]=0;

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(dp[j]!=-1 && Math.abs(nums[i]-nums[j])<=target) {
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
        }

        return dp[n-1];
    }
}


public class MaximumNumber_of_Jumps_to_ReachLastindex {
    public static void main(String[] args) {
        MNNJRLI solution = new MNNJRLI();
        int[] nums = {1, 3, 6, 7};
        int target = 3;
        System.out.println(solution.maximumJumps(nums, target));
    }
}
