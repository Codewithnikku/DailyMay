class RotBox {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length, m = box[0].length;
        
        for (int i = 0; i < n; i++) {
            int empty = m - 1;
            for (int j = m - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    empty = j - 1;
                } else if (box[i][j] == '#') {
                    char temp = box[i][empty];
                    box[i][empty] = '#';
                    box[i][j] = temp;
                    empty--;
                }
            }
        }
        
        char[][] res = new char[m][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][n - 1 - i] = box[i][j];
            }
        }
        
        return res;
    }
}
public class RotatingTheBox {
    public static void main(String[] args) {
        RotBox rb = new RotBox();
        char[][] boxGrid = {
            {'#', '.', '*', '.'},
            {'#', '#', '*', '.'}
        };
        
        char[][] rotatedBox = rb.rotateTheBox(boxGrid);
        
        for (char[] row : rotatedBox) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
