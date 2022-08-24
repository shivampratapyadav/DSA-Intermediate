/*Problem Link https://leetcode.com/problems/number-of-islands */

/*Get Connected Components
    number 200
    MEDIUM
*/

class Solution {
    public int numIslands(char[][] grid) {
        
        boolean [][] vis = new boolean[grid.length][grid[0].length];
        int count =0;
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && vis[i][j]!=true){
                    count+=1;
                    marking(i,j,vis,grid);
                }
            }
        }
        
        
        return count;
        
    }
    
    public void marking(int i, int j, boolean[][]vis, char[][]grid){
        if(i<0||j<0 || i>grid.length-1||j>grid[0].length-1||grid[i][j]=='0'||vis[i][j]==true){
            return;
        }
        
        vis[i][j] = true;
        
        marking(i-1,j,vis,grid);
        marking(i,j-1,vis,grid);
        marking(i+1,j,vis,grid);
        marking(i,j+1,vis,grid);
        
    }
    
    
}