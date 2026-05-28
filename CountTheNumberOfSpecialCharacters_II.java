class CN_of_SC_II {
    public int numberOfSpecialChars(String word) {
        int[] lowerLast = new int[26];
        int[] upperFirst = new int[26];

        for (int i = 0; i < 26; i++) {
            lowerLast[i] = -1;
            upperFirst[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                lowerLast[ch - 'a'] = i;
            } else {
                upperFirst[ch - 'A'] = Math.min(upperFirst[ch - 'A'], i);
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (lowerLast[i] != -1 && upperFirst[i] != Integer.MAX_VALUE
                    && lowerLast[i] < upperFirst[i]) {
                count++;
            }
        }

        return count;
    }
}

public class CountTheNumberOfSpecialCharacters_II {
    public static void main(String[] args) {
        CN_of_SC_II cn = new CN_of_SC_II();
        String word = "aAbBcC";
        int counts = cn.numberOfSpecialChars(word);
        System.out.println("Special chararcters count: " + counts);
    }
}
