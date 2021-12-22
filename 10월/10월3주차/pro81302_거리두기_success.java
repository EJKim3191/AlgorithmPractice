
import java.util.*;

class Solution {
    //O일떄 조건과 P일때의 차이
    public static int[] dx={0,0,-1,1};
    public static int[] dy={-1,1,0,0};
    
    public int[] solution(String[][] places) {
        Queue<Point> q = new LinkedList<>();
        char map[][]= new char [5][5];
        int[] answer = new int[5];
        boolean[][] isUsed = new boolean[5][5];
        for(int k=0; k<5; k++){
            //testCase start
            for(int i=0; i<5; i++){
                String temp= places[k][i];
                
                for(int j=0; j<5; j++){
                    map[i][j]=temp.charAt(j);
                    if(map[i][j]=='P' || map[i][j]=='O'){
                        q.add(new Point(j, i));
                    }
                }         
            }
            int semiResult=0;
            semiResult=look(map,q, isUsed);
            answer[k]=semiResult;
            q.clear();
        }
        
        return answer;
    }
    public static int look(char[][] map, Queue<Point> q, boolean[][] isUsed){
        
        while(!q.isEmpty()){
            Point temp=q.poll();
            int k=0;
            for(int i=0; i<4; i++){
                int kx = temp.x+dx[i];
                int ky = temp.y+dy[i];
                if(kx<0 || ky<0 || kx>=5 || ky>=5) continue;
                
                if(map[ky][kx]=='X') continue;
                if(map[temp.y][temp.x]=='O' && map[ky][kx]=='O') continue;
                if(map[temp.y][temp.x]=='O' && map[ky][kx]=='P') k+=1;
                if(map[temp.y][temp.x]=='P' && map[ky][kx]=='P') return 0;
                if(k>=2) return 0;
            }
        }
        return 1;
    }
    public static class Point{
    int x; int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
}
