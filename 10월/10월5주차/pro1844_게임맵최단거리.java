
import java.util.*;
class Solution {
    int[] dx = {0,1,0,-1};
    int[] dy = {-1,0,1,0};
    boolean[][] visited;
    int m, n;
    public int solution(int[][] maps) {
        n=maps.length;
        m=maps[0].length;
        visited = new boolean[n][m];
        return bfs(maps);
    }
    public int bfs(int[][] maps){
        Queue<Node> q = new LinkedList<>();
        
        Node start = new Node(0,0,1);
        q.add(start);
        visited[0][0]=true;
        
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.x ==m-1 && temp.y == n-1) return temp.moved;
            for(int i=0; i<4; i++){
                int kx = temp.x+dx[i];
                int ky = temp.y+dy[i];
                //범위밖
                if(kx<0 || ky<0 || kx>=m || ky>=n) continue;
                //벽
                if(maps[ky][kx]==0) continue;
                //지나간곳
                if(visited[ky][kx]) continue;
                visited[ky][kx]=true;
                q.add(new Node(kx,ky,temp.moved+1));
            
            }
        }
        return -1;
    }
    public class Node{
        int x;
        int y;
        int moved;
        public Node(int x, int y, int moved){
            this.x=x;
            this.y=y;
            this.moved=moved;
        }
    }
}
