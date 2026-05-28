class LCSQ {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int idx = -1;
    }

    TrieNode root = new TrieNode();

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int best = 0;

        for (int i = 1; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < wordsContainer[best].length()) {
                best = i;
            }
        }

        root.idx = best;

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i, wordsContainer);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }

    private void insert(String s, int idx, String[] wordsContainer) {
        TrieNode node = root;

        for (int i = s.length() - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';

            if (node.child[c] == null) {
                node.child[c] = new TrieNode();
            }

            node = node.child[c];

            int cur = node.idx;

            if (cur == -1 ||
                wordsContainer[idx].length() < wordsContainer[cur].length()) {
                node.idx = idx;
            }
        }
    }

    private int search(String s) {
        TrieNode node = root;

        for (int i = s.length() - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';

            if (node.child[c] == null) {
                break;
            }

            node = node.child[c];
        }

        return node.idx;
    }
}

public class LongestCommonSuffixQueries {
    public static void main(String[] args) {
        LCSQ lcsq = new LCSQ();
        String[] wordsContainer = {"abc", "bc", "c"};
        String[] wordsQuery = {"abc", "bc", "c", "d"};
        int[] ans = lcsq.stringIndices(wordsContainer, wordsQuery);
        System.out.println("Indices: " + java.util.Arrays.toString(ans));
    }
}
