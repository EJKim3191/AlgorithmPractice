
import java.util.*;
class Solution {
    public static int answer = 0;
    public static int types;
    public static int many;
    public static String[][] relationC;
    public static List<Integer> list = new ArrayList<>(); 
    
    public int solution(String[][] relation) {
        //조합을 활용
        //각 속성은 string, 즉 append 후 문자열 비교(hashset)
        //크기가 방만큼 되는 것은 유일성을 만족한다
        //주의!! 이떄 최소성을 만족하는 경우는 제외해줘야한다!
        relationC = relation;
        types = relation[0].length;
        many = relation.length;
        for(int i=1; i<=types; i++){
            boolean[] isUsed = new boolean[types];
            comb(isUsed, 0, types, i);
        }
        
        return answer;
    }
    public void comb(boolean[] isUsed, int depth, int n, int r){
        if(r==0){
            if(addSetAndCount(isUsed)) answer+=1;
            // for(int i=0; i<isUsed.length; i++){
            //     if(isUsed[i]) System.out.printf("%d, ",i);
            // }
            // System.out.println();
            return;
        }
        if(depth==n) return;
        isUsed[depth]=true;
        comb(isUsed,depth+1,n,r-1);
        isUsed[depth]=false;
        comb(isUsed,depth+1,n,r);
        
    }
    public boolean addSetAndCount(boolean[] isUsed){
        HashSet<String> set = new HashSet<>();

        //유일성 검사
        for(int i=0; i<many; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<types; j++){
                if(isUsed[j]) {
                    sb.append(relationC[i][j]);
                }
            }
            set.add(sb.toString());
        }
        int k=0;
        for(int i=isUsed.length-1; i>=0; i--){
            if(isUsed[i]){
                k+=Math.pow(2,i);
            }
        }
        //최소성 검사
        if(answer>0){
            if(minimality(k)) return false;
        }
        if(set.size()==many){
            list.add(k);
            return true; 
        } 
        
        return false;
    }
    public boolean minimality(int set){
        for (int key : list) {
            if ((set & key) == key) return true; 
        } 
        return false; 
    }
}
