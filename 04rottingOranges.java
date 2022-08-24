/*Problem Link https://leetcode.com/problems/rotting-oranges */

/*Multiple Source BFS
    number 994
    MEDIUM
*/


// BFS with remove, mark*, work, add children*
class Solution {
    
    
    public class Pair{
        int i;
        int j;
        int t;
        
        Pair(){
            
        }
        
        Pair(int i, int j, int t){
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }
    
    
    
    
    
    
    public int orangesRotting(int[][] grid) {
        
        Queue<Pair> q = new ArrayDeque<>();
        
        int foc = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }
                else if(grid[i][j]==1){
                    foc++;
                }
            }
        }
        
        if(foc ==0){
            return 0;
        }
        
        int time=0;
        while(q.size()>0){
            Pair rp = q.remove();
            
            if(grid[rp.i][rp.j]==-1){
                continue;
            }
                
            
                if(grid[rp.i][rp.j] == 1)
                    foc--;
            
                grid[rp.i][rp.j] = -1;
                
                if(foc == 0){
                    time = rp.t;
                    break;
                }
            
            
            
            
            int [][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};
            
            for(int k=0;k<4;k++){
                
                int ni = rp.i+dir[k][0];
                int nj = rp.j+dir[k][1];
                
                if(ni>=0&&nj>=0&&ni<grid.length&&nj<grid[0].length&&grid[ni][nj]==1){
                    q.add(new Pair(ni,nj,rp.t+1));
                }
            }
        }
        
       return (foc==0?time:-1);
    }
    
    
    
}




//BFS with remove, work, add (children* & mark*)
class Solution {
    static class Pair {
        int i;
        int j;
        int t;
        
        Pair(int i,int j,int t) {
            this.i = i;
            this.j = j;
            this.t = t;
        }
        
        Pair() {
            
        }
    }
    
    
    public int orangesRotting(int[][] grid) {
        ArrayDeque<Pair>q = new ArrayDeque<>();
        int fo = 0; //fresh oranges
        
        for(int i=0; i < grid.length;i++) {
            for(int j=0; j < grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i,j,0));
                }
                else if(grid[i][j] == 1) {
                    fo++;
                }
            }
        }
        
        
        int time = 0;
        int[][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
        
        //bfs
        while(q.size() > 0) {
            //remove
            Pair rem = q.remove();
            time = Math.max(time,rem.t);
            
            //add unvis and mark them as well
            for(int k = 0; k < 4;k++) {
                int ni = rem.i + dir[k][0];
                int nj = rem.j + dir[k][1];
                
                if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 1) {
                    q.add(new Pair(ni,nj,rem.t+1));
                    grid[ni][nj] = 2;
                    fo--;
                } 
            }
        }
        
        if(fo == 0) {
            return time;
        }
        else {
            return -1;
        }
        
        
    }    
}