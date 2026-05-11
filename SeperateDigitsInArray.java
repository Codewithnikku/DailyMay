import java.util.*;

class SepDig_in_Arr {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {
            String s = String.valueOf(num);

            for (char c : s.toCharArray()) {
                list.add(c - '0');
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}

public class SeperateDigitsInArray {
    public static void main(String[] args) {

        int[] nums = {13, 25, 83, 77};

        SepDig_in_Arr obj = new SepDig_in_Arr();

        int[] result = obj.separateDigits(nums);

        System.out.print("Output: ");

        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }
}