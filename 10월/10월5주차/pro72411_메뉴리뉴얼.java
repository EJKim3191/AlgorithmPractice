
import java.util.*;

class Solution {
    public static HashMap<String, Integer> map = new HashMap<>();
    public static boolean isUsed[];
    public static List<String> list = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        
        //들어온 문자열의 조합 생성 및 hashmap에 담기
        for(String temp : orders){
            isUsed = new boolean[temp.length()];
            if(temp.length()<2) continue;
            
            comb(0, temp.length(), isUsed, temp);
            
        }
        //키값이 course에 맞게 필터링
        Iterator<String> keys;
        for(int i: course){
            int max = 0;
            System.out.printf("길이 %d 짜리\n", i);
            keys = map.keySet().iterator();
            while(keys.hasNext()){
                String key = keys.next();
                System.out.printf("%s, %d\n", key, map.get(key));
                
                if(key.length()==i && map.get(key)>=2){
                    if(map.get(key)>=max){
                        max = map.get(key);
                    }
                }
            }
            keys = map.keySet().iterator();
            System.out.printf("max값은 : %d\n", max);
            while(keys.hasNext()){
                String key = keys.next();
                
                if(map.get(key)==max && key.length()==i){
                    list.add(key);
                }
            }
            
        }
        Collections.sort(list);

        String[] answer = list.toArray(new String[list.size()]);
        return answer;
    }
    public void comb(int r, int n, boolean[] isUsed, String temp){
        if(r==n){
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; i++){
                if(isUsed[i]){
                    sb.append(temp.charAt(i));
                    //System.out.printf("%c", temp.charAt(i));
                }
                
            }
            //System.out.println();
            String f = sb.toString();
            char[] tempChar = f.toCharArray();
            Arrays.sort(tempChar);
            f = new String(tempChar);
            //System.out.println(f);
            if(f.length()>1){
                if(map.containsKey(f)){
                    map.put(f,map.get(f)+1);
                }
                else{
                    map.put(f,1); 
                }
            }
            return;
        }
        isUsed[r]=true;
        comb(r+1, n, isUsed, temp);
        isUsed[r]=false;
        comb(r+1, n, isUsed, temp);
    }
}
