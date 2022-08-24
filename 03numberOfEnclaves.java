/*Problem Link https://leetcode.com/problems/number-of-enclaves */

/*Get Connected Components
    number 1020
    MEDIUM
*/

class Solution {
    public int numEnclaves(int[][] grid) {
        
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                
                if((i==0||j==0||i==grid.length-1||j==grid[0].length-1)&&grid[i][j]==1){
                    
                    dfs(i,j,grid);
                    
                }
                
                
            }
        }
        
        
        int count = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count+=1;
                }
            }
        }
        
        return count;
    }
    
    public int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
    
    public void dfs(int i, int j, int grid[][]){
        grid[i][j] = 0;
        
        for(int k=0;k<dir.length;k++){
            int ni = i+dir[k][0];
            int nj = j+dir[k][1];
            
            if(ni>=0&&nj>=0&&ni<grid.length&&nj<grid[0].length&&grid[ni][nj]==1){
                dfs(ni,nj,grid);
            }
            
        }
        
    }
    
    
}