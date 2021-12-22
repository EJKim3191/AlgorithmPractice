
import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        //행개수 n, 선택 행 위치 k,
        int size = n;
        Stack<Integer> tempTrash = new Stack<>();

        for(int i=0; i<cmd.length; i++){
            if(cmd[i].charAt(0)=='D'){
                k+=Integer.parseInt(cmd[i].substring(2));
            }
            else if(cmd[i].charAt(0)=='U'){
                k-=Integer.parseInt(cmd[i].substring(2));
            }
            else if(cmd[i].charAt(0)=='C'){
                tempTrash.push(k);
                size-=1;
                if(size==k){
                    k-=1;
                }
            }
            else if(cmd[i].charAt(0)=='Z'){
                if(tempTrash.pop()<=k)  k+=1;
                size+=1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++)  sb.append("O");    
        while(!tempTrash.isEmpty()){
            int x = tempTrash.pop();
            sb.insert(x,"X");
        }
        String answer = sb.toString();
        
        return answer;
    }
}
