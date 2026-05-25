class jumpGameSeven {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = s.charAt(0) == '0';
        int count = 0;

        for (int i = minJump; i < n; i++) {
            if (dp[i - minJump]) {
                count++;
            }
            if (i > maxJump && dp[i - maxJump - 1]) {
                count--;
            }
            dp[i] = count > 0 && s.charAt(i) == '0';
        }

        return dp[n - 1];
    }
}

public class JumpGame_VII {
    public static void main(String[] args) {
        jumpGameSeven jgs = new jumpGameSeven();
        String s = "011010";
        int minJump = 2;
        int maxJump = 3;
        boolean result = jgs.canReach(s, minJump, maxJump);
        System.out.println(result);
    }
}
