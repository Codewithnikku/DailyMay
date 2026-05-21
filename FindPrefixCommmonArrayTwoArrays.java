class FPCATA {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        boolean[] seenA = new boolean[n + 1];
        boolean[] seenB = new boolean[n + 1];
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            seenA[A[i]] = true;
            seenB[B[i]] = true;

            if (seenA[A[i]] && seenB[A[i]]) {
                commonCount++;
            }
            if (seenA[B[i]] && seenB[B[i]] && A[i] != B[i]) {
                commonCount++;
            }

            ans[i] = commonCount;
        }

        return ans;
    }
}

public class FindPrefixCommmonArrayTwoArrays {
    public static void main(String[] args) {
        FPCATA fpcata = new FPCATA();
        int[] A = {1, 2, 3, 4};
        int[] B = {2, 1, 4, 3};
        int[] result = fpcata.findThePrefixCommonArray(A, B);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}