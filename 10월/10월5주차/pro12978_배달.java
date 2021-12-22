
import java.util.*;
class Solution {
    public int[][] map;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        map = new int[N+1][N+1];
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(i==j) map[i][j]=0;
                else{
                    map[i][j]=500001;
                }
            }
        }
        for(int i=0; i<road.length; i++){
            int from = road[i][0];
            int to = road[i][1];
            int length = road[i][2];
            if(map[from][to]<road[i][2]) continue;
            map[from][to] = road[i][2];
            map[to][from] = road[i][2];
        }
        //플로이드 와샬
        for(int k=1; k<N+1; k++){
            for(int i=1; i<N+1; i++){
                for(int j=1; j<N+1; j++){
                    if(i==j) continue;
                    if(map[i][j] > map[i][k]+map[k][j]){
                        map[i][j] = map[i][k]+map[k][j];
                        map[j][i] = map[i][j];
                    } 
                }
            }
        }
        //count
        
        for(int i=1; i<N+1; i++){
            if(map[1][i]<=K){
                answer+=1;
            }
        }
        return answer;
    }
    
}
