/*Problem Link https://www.lintcode.com/problem/860/description */

/*Get Connected Components
    number 860
    MEDIUM
*/

public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    public int numberofDistinctIslands(int[][] grid) {
        // write your code here

         HashSet<String> set = new HashSet<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                sb = new StringBuilder();

                if(grid[i][j]==1){
                    sb = new StringBuilder();

                    dfs(i,j,grid);

                    set.add(sb.toString());
                }

            }
        }

            return set.size();
    }
    public StringBuilder sb;
    

    public void dfs(int i,int j, int[][] grid){

        grid[i][j] = 0;

        //t
        if(i-1>=0 && grid[i-1][j]==1){
            sb.append('t');
            dfs(i-1,j,grid);
        }

        //l
        if(j-1>=0 && grid[i][j-1]==1){
            sb.append('l');
            dfs(i,j-1,grid);
        }

        //d
        if(i+1<grid.length && grid[i+1][j]==1){
            sb.append('d');
            dfs(i+1,j,grid);
        }

        //r
        if(j+1<grid[0].length && grid[i][j+1]==1){
            sb.append('r');
            dfs(i,j+1,grid);
        }

        sb.append('b');

    }


}