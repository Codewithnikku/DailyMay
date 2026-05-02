class RotatedDIgts {
    private boolean isGood(int num) {
        boolean hasValidDigit = false;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 3 || digit == 4 || digit == 7) {
                return false; 
            }
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                hasValidDigit = true; 
            }
            num /= 10;
        }
        return hasValidDigit; 
    }
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        return count;
    }
}

public class RotatedDigits {
    public static void main(String[] args) {
        RotatedDIgts solution = new RotatedDIgts();
        int n = 100;
        System.out.println(solution.rotatedDigits(n));
    }
}
