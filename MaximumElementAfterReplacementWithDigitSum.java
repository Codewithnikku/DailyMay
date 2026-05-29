import java.lang.*;


class MEARWDS {
    public int minElement(int[] nums) {
        int res = 36;
        for (int n : nums)
            res = Math.min(res, n - 9 * ((n/10) + (n/100) + (n/1000) + (n/10000)));
        
        return res;
    }
}

public class MaximumElementAfterReplacementWithDigitSum {
    public static void main(String[] args) {
        MEARWDS mds = new MEARWDS();
        int[] nums = {10, 12, 13, 14};
        int result = mds.minElement(nums);
        System.out.println("Digits Sum: " + result);       
    }
}