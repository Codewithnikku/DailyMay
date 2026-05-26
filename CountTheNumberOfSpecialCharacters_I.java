class CN_of_SC_I {
    public int  numberOfSpecialChars(String word) {
         boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower[ch - 'a'] = true;
            } else {
                upper[ch - 'A'] = true;
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i]) {
                count++;
            }
        }

        return count;
    }
}

public class CountTheNumberOfSpecialCharacters_I {
    public static void main(String[] args) {
       CN_of_SC_I cn = new CN_of_SC_I();
        String word = "aAbBcC";
        int counts = cn.numberOfSpecialChars(word);
        System.out.println("Special chararcters count: " + counts);
    }
}
