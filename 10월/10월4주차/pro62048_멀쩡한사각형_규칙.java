
class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        //최대공약수 구하기
        int gcd = gcd(w, h);
        int x = w / gcd;
        int y = h / gcd;
        answer = (long)w*h-(((long)x+y)-1)*gcd;
        
        return answer;
    }
    public int gcd(int x, int y){ // 최대공약수
        int a = x >= y ? x : y;
        int b = x < y ? x : y;
        while(b!=0){
            //a와 b, b 와 r의 최대 공약수는 같다
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
