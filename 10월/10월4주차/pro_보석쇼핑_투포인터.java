

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        //hashmap 활용하여 몇가지의 종류가 있는지 체크
        //1부터-> 길이 저장
        //가장 짧은것 !
        //투포인터 알고리즘 활용
        HashSet<String> map = new HashSet<>();
        HashMap<String, Integer> checker = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        for(int i=0; i<gems.length; i++){
            map.add(gems[i]);
        }
        int type = map.size();
        //System.out.println(type);
        int start=0;
        int startR=0;
        int shortest=Integer.MAX_VALUE;
        int[] answer = new int[2];
        for(int i=0; i<gems.length; i++){
            //if(gems.length-i<type) break;
            //보석 이름, 갯수
            if(checker.containsKey(gems[i])){
               checker.put(gems[i], checker.get(gems[i])+1);
            } 
            else{
                checker.put(gems[i], 1);
            }
            q.add(gems[i]);
            while(true){
                String temp = q.peek();
                if(checker.get(temp)>1){
                    checker.put(temp, checker.get(temp)-1);
                    q.poll();
                    start+=1;
                }
                else break;
            }
            if(shortest> q.size() && checker.size()==type){
                shortest=q.size();
                startR=start;
            }
        }
        answer[0]=startR+1;
        answer[1]=startR+shortest;
        return answer;
    }
}
