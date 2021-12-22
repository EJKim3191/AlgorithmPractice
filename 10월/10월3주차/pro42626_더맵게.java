
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //0.sort
        //1.배열을 deque로
        //while true
        //2.모든 음식이(첫번째가) k이상인가?
        //2-1. no-> 동작, 횟수 +1
        //2-2. yes-> return(break)
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            q.add(scoville[i]);
        }
        while(true){
            if(q.size()<2 && q.peek()<K) return -1;
            int temp1=q.poll();
            if(temp1>=K) break;
            int temp2=q.poll();
            temp1=temp1+temp2*2;
            q.add(temp1);
            answer+=1;
        }
        return answer;
    }
}
