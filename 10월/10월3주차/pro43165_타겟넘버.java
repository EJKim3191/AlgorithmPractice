
class Solution {
    public static int answer=0;
    public int solution(int[] numbers, int target) {
        //plus minus 를 위한 int 배열   0은 플러스, 1은 마이너스
        int[] sign = new int[numbers.length];
        permu(numbers, sign, numbers.length, 0, target);
        return answer;
    }
    public static void permu(int[] numbers, int[] sign, int size, int r, int target){
        if(size==r){
            int temp=0;
            for(int i=0; i<size; i++){
                if(sign[i]==0){
                    temp+=numbers[i];
                }
                else if(sign[i]==1){
                    temp-=numbers[i];
                }
            }
            if(temp==target){
                answer+=1;
            }
            return;
        }
        sign[r]=0;
        permu(numbers, sign, size, r+1, target);
        sign[r]=1;
        permu(numbers, sign, size, r+1, target);
    }
}
