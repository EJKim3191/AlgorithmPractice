package pro1002;

import java.util.ArrayList;

class Solution {
    public static int[] num;
    public static boolean[] visited;
    public static int answer;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public int solution(String numbers) {
        num = new int[numbers.length()];
        visited = new boolean[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            num[i]=numbers.charAt(i)-'0';
        }
        answer = 0;
        //순열
        int[] output=new int[numbers.length()];
        boolean[] visited= new boolean[numbers.length()];
        for(int i=1; i<=numbers.length(); i++){
            permu(visited,output, 0, numbers.length(), i);
        }
        
        
        return answer;
    }
    public static void permu(boolean[] visited,int[] output, int depth, int n, int r){
        if(depth==r){
            if(output[0]==0) return;
            int num=0;
            for(int i=0; i<r; i++){
                num+=(int)output[i]*Math.pow(10, r-1-i);
            }
            if(arr.contains(num)) return;
            arr.add(num);
            if(num==1 || num==0) return;
            if(isPrime(num)) answer+=1;
        }
        for(int i=0; i<n; i++){
            if(visited[i]!=true){
                visited[i]=true;
                output[depth] = num[i];
                permu(visited, output, depth+1, n, r);
                visited[i]=false;
            }
        }
    }
    public static boolean isPrime(int num){
        for(int i=2; i<num; i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
