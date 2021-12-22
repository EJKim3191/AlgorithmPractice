
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Solution {
    public static Map<String, String> map;
    public static ArrayList<String> arr;
    public static ArrayList<Integer> action;
    public static ArrayList<String> ans;
    public String[] solution(String[] record) {
        map=new HashMap<>();
        arr=new ArrayList<>();

        StringTokenizer str = null;
        // int length=0;
    
        String[] temp;
        for(int i=0; i<record.length; i++){
            temp=record[i].split(" ");
            if(record[i].charAt(0)=='L') continue;
            
            map.put(temp[1], temp[2]);
            
            
            // str=new StringTokenizer(record[i]);
            // String tempAction = str.nextToken();
            // String tempID = str.nextToken();
            // if(!tempAction.equals("Leave")){
            //     String tempNickName = str.nextToken();
            //     if(tempAction.equals("Enter")){
            //         map.put(tempID, tempNickName);
            //         // arr.add(tempID);
            //         // arr.add("님이 들어왔습니다.");
            //         // length+=1;
            //     }
            //     else if(tempAction.equals("Change")){
            //         map.put(tempID, tempNickName);
            //     }
            // }
            // else if(tempAction.equals("Leave")){
            //         map.remove(tempID);
            //         // arr.add(tempID);
            //         // arr.add("님이 나갔습니다.");
            //         // length+=1;
            // }
            
        }
        //답은 arraylist
        //key를 저장, value를 마지막에 arraylist 에 append
        //--->hashmap 사용
        // String[] answer = new String[length];
        // for(int i=0; i<arr.size(); i++){
        //     answer[i/2]=map.get(arr.get(i))+arr.get(++i);
        // }
        String[] msg;
        for(int i=0; i<record.length; i++){
            msg=record[i].split(" ");
            if(record[i].charAt(0)=='C') continue;
            if(record[i].charAt(0)=='E'){
               arr.add(map.get(msg[1])+"님이 들어왔습니다."); 
            }
            else if(record[i].charAt(0)=='L'){
                arr.add(map.get(msg[1])+"님이 나갔습니다.");
            }
        }
        String[] answer={};
        answer=new String[arr.size()];
        arr.toArray(answer);
        return answer;
    }
}
