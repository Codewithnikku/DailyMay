import java.util.*;

class FLLCP {
    public int digits(int x) {
        int cnt = 0;
        while(x > 0) {
            cnt++;
            x /= 10;
        }
        return cnt;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes =new HashSet<>();
        for(int num : arr1) {
            int x = num;
            while(x > 0) {
                prefixes.add(x);
                x /= 10;
            }
        }

        int ans = 0;
        for(int num : arr2) {
            int x = num;
            int len = digits(num);

            // checking from larger => smaller
            while(x > 0) {
                if(prefixes.contains(x)) {
                    ans = Math.max(ans, len);
                    // first match is the longest
                    // so we stop
                    break;
                }

                x /= 10;
                len--;
            }
        }

        return ans;
    }
}

public class FindTheLengthOfTheLongestCommonPrefix {
    public static void main(String[] args) {
        FLLCP fllcp = new FLLCP();
        int[] arr1 = {123, 456, 789};
        int[] arr2 = {12, 45, 78};
        int result = fllcp.longestCommonPrefix(arr1, arr2);
        System.out.println(result);
    }
}
