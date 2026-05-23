class CIAISAR {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for(int i = 1; i < n; i++) {
            if(nums[i] < nums[i - 1]) {
                count++;
            }
        }

        if(nums[0] < nums[n - 1]) {
            count++;
        }

        return count <= 1;
    }
}

public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        CIAISAR ciaisar = new CIAISAR();
        int[] nums = {3, 4, 5, 1, 2};
        boolean result = ciaisar.check(nums);
        System.out.println(result);
    }
}
