class JumpGameNine {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int maxPrefix[] = new int[n];
        int minSuffix[] = new int[n];

        maxPrefix[0] = nums[0];
        minSuffix[n - 1] = nums[n - 1];

        for(int i = 1; i < n; i++){
            maxPrefix[i] = Math.max(maxPrefix[i - 1], nums[i]);
        } 
        for(int i = n - 2; i >= 0; i--){
            minSuffix[i] = Math.min(minSuffix[i + 1], nums[i]);
        }

        int res[] = new int[n];
        res[n-1] = maxPrefix[n - 1];
        for(int i=n-2; i>=0; i--) {
            if(maxPrefix[i]  > minSuffix[i+1])
                res[i] = res[i+1];
            else res[i] = maxPrefix[i];
        }

        return res;
    }
}

public class JumpGameIX {
    public static void main(String[] args) {
        JumpGameNine jgn = new JumpGameNine();
        int[] nums = {2, 3, 1};
        int[] result = jgn.maxValue(nums);
        
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
