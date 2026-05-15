class FM_in_RSA {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {

        FM_in_RSA fmra = new FM_in_RSA();

        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {11, 13, 15, 17};

        System.out.println("Minimum in nums1: " + fmra.findMin(nums1));
        System.out.println("Minimum in nums2: " + fmra.findMin(nums2));
        System.out.println("Minimum in nums3: " + fmra.findMin(nums3));
    }
}