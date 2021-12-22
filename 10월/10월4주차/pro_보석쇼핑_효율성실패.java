
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        //hashmap 활용하여 몇가지의 종류가 있는지 체크
        //1부터-> 길이 저장
        //가장 짧은것 !
        HashSet<String> map = new HashSet<>();
        HashSet<String> checker = new HashSet<>();
        for(int i=0; i<gems.length; i++){
            map.add(gems[i]);
        }
        int type = map.size();
        int start=0;
        int end=0;
        int shortest=9999;
        int[] answer = new int[2];
        for(int i=0; i<gems.length; i++){
            if(gems.length-i<type) break;
            checker.clear();
            int length=0;
            start=i;
            for(int j=i; j<gems.length; j++){
                checker.add(gems[j]);
                length+=1;
                if(checker.size()==type){
                    end=j;
                    break;
                } 
            }
            if(shortest> length && checker.size()==type){
                shortest=length;
                answer[0]=start+1;
                answer[1]=end+1;
            }
        }
        
        return answer;
    }
}
