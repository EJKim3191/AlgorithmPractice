
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        //queue는 index값으로 받지 않는다---> 지나간 일자를 기록해서 speed에 곲
        for(int i=0; i<progresses.length; i++){
            q.add(progresses[i]);
        }
        int day=1;
        int num = 0;

        while(!q.isEmpty()){
            int out=0;
            while(true){
                if(q.isEmpty()) break;
                int temp = q.peek();
                if(temp+speeds[num]*day>=100){
                    q.poll();
                    out+=1;
                    num+=1;
                }
                else break;
            }
            if(out>0) arr.add(out);
            day+=1;
        }
        int[] answer = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            answer[i]=arr.get(i);
        }
        
        return answer;
    }
}
