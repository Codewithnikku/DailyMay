class CcRaG {

    private void reverse(int[] arr, int left, int right) {
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++; right--;
        }
    }

    public int[][] rotateGrid(int[][] grid, int k) {

        int m=grid.length, n=grid[0].length;
        int r1=0, r2=m-1, c1=0, c2=n-1;

        while(r1<r2 && c1<c2) {

            int total=2*((r2-r1)+(c2-c1));
            int shift=k%total;

            int[] ring=new int[total];
            int idx=0;

            for(int j=c1; j<=c2; j++) ring[idx++]=grid[r1][j];
            for(int i=r1+1; i<=r2; i++) ring[idx++]=grid[i][c2];
            for(int j=c2-1; j>=c1; j--) ring[idx++]=grid[r2][j];
            for(int i=r2-1; i>r1; i--) ring[idx++]=grid[i][c1];

            reverse(ring, 0, shift-1);
            reverse(ring, shift, total-1);
            reverse(ring, 0, total-1);

            idx=0;

            for(int j=c1; j<=c2; j++) grid[r1][j]=ring[idx++];
            for(int i=r1+1; i<=r2; i++) grid[i][c2]=ring[idx++];
            for(int j=c2-1; j>=c1; j--) grid[r2][j]=ring[idx++];
            for(int i=r2-1; i>r1; i--) grid[i][c1]=ring[idx++];

            r1++; r2--;
            c1++; c2--;
        }

        return grid;
    }
}

public class CyclilcallyRotatingAGrid {

    public static void main(String[] args) {

        int[][] grid = {
            {40, 10},
            {30, 20}
        };

        int k = 1;

        CcRaG crg = new CcRaG();
        int[][] rotatedGrid = crg.rotateGrid(grid, k);

        for(int i=0; i<rotatedGrid.length; i++) {
            for(int j=0; j<rotatedGrid[0].length; j++) {
                System.out.print(rotatedGrid[i][j] + " ");
            }
            System.out.println();
        }
    }
}