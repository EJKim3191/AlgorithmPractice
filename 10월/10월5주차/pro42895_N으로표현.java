
class Solution {
    public static int n;
    public static int num;
    public static int answer = Integer.MAX_VALUE;
    public int solution(int N, int number) {
        num=number;
        n=N;
        
        dfs(0, 0);
        if(answer==Integer.MAX_VALUE) answer=-1;
        return answer;
    }
    public void dfs(int count, int sum){
        //탈출문
        if(count>8){
            answer = -1;
            return;
        }
        if(num==sum){
            answer = Math.min(count, answer);
            return;
        }
        int tempNum = n;
        for(int i=0; i<8-count; i++){
            int tempCount = count+i+1;
            dfs(tempCount, sum+tempNum);
            dfs(tempCount, sum-tempNum);
            dfs(tempCount, sum*tempNum);
            dfs(tempCount, sum/tempNum);
            //계속 일의 자리만 갱신해주면 된다
            tempNum = tempNum*10 + n;
            //--> 그림적으로
            //dfs(tempCount, (sum+n)+n)
            //dfs(tempCount, (sum+n)-n)
            //...
        }
    }
}
