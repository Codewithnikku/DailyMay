class RotStr {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        
        String combined = s + s;
        return combined.contains(goal);
    }
}

public class RotateString {
    public static void main(String[] args) {
        RotStr rs = new RotStr();
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(rs.rotateString(s, goal));
    }
}