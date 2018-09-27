package com.company.NQueen;

public class NQueen {
    char[][] grid;
    boolean[][] visited;
    static int n;
    int placed;

    public NQueen(int n){
        this.grid = new char[n][n];
        for(int i = 0 ;i<n;i++){
            for (int j=0;j<n;j++){
                grid[i][j]='X';
            }
        }
        this.visited= new boolean[n][n];
        this.n=n;
        this.placed=0;
    }

    public boolean backtrack(){
        //find free spot
        for(int i = 0 ;i<n;i++){
            for (int j=0;j<n;j++){
                if(grid[i][j]!='Q'){
                    if(isSafe(this.grid,i,j)){
                        placed++;
                        grid[i][j]='Q';
                        if(placed==n)
                            return true;
                        else if(backtrack())
                            return true;
                        else
                        {
                            placed--;
                            grid[i][j]='X';
                        }
                    }
                }
            }
        }
        return false;
    }

        //is safe?




    /*

     */
    public void show(){
        for(int i = 0 ;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(char[][] grid,int x , int y) {
        for(int i = 0 ; i<n ; i++) {
            if (grid[x][i] == 'Q')
                return false;
        }
        for(int i = 0 ; i<n ; i++) {
            if (grid[i][y] == 'Q')
                return false;
        }
        int i = x;
        int j = y;
        //upper right
        while(i<n && j>0) {
            i++;
            j--;
            if (i>=n || j < 0)
                break;
            if (grid[i][j] == 'Q')
                return false;
        }
         i = x;
         j = y;
        //lower right
        while(i<n && j<n) {
            i++;
            j++;
            if (i>=n || j >=n)
                break;
            if (grid[i][j] == 'Q')
                return false;
        }
        i = x;
        j = y;
        //lower left
        while(i>0 && j<n) {
            i--;
            j++;
            if (i<0 || j >=n)
                break;
            if (grid[i][j] == 'Q')
                return false;
        }
        i = x;
        j = y;
        //upper left
        while(i>0 && j>0) {
            i--;
            j--;
            if (i<0 || j < 0)
                break;
            if (grid[i][j] == 'Q')
                return false;
        }

            return true;

    }
}
