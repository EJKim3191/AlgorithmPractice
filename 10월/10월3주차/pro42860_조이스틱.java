
class Solution {
    public int solution(String name) {
        int answer = 0;
        int size = name.length();
        char[] name_char = new char[size];
        for(int i=0; i<size; i++){
            name_char[i]=name.charAt(i);
        }
        answer = simul(name_char, size);
        return answer;
    }
    public int simul(char[] name_char, int size){
        //1. 한쪽 방향만 진행하게 된다
        //2. 이미 원형이라고 생각하고 풀자 가장 가까운거부터 처리한다
        int moved=0;
        int cursor=0;
        boolean[] isUsed = new boolean[size];
        //처음에 안가도 되는 A true 해놓기
        for(int i=0; i<size; i++){
            if(name_char[i]=='A') isUsed[i]=true;
        }
        boolean isFin = false;
        while(true){
            isFin=true;

            //조이스틱 위아래 동작
            if(!isUsed[cursor]){
                int temp=0;
                temp=name_char[cursor]-'A';
                //위아래 동작 이라서 뺴먹지 말자 ㅠㅠ
                if(temp>13) {
                    temp=(temp-26)*(-1);
                }
                
                moved+=temp;
                isUsed[cursor]=true;
            }
            //탈출문 조건 검사
            for(int i=0; i<size; i++){
                if(!isUsed[i]){
                    isFin=false;
                    break;
                }
            }
            if(isFin) break;
            //조이스틱 왼오 동작
            int left=cursor;
            int countLeft=0;
            while(true){
                //왼쪽으로 가보기
                left-=1;
                if(left<0) left=size-1;
                countLeft+=1;
                if(!isUsed[left]) break;
            }
            int right=cursor;
            int countRight=0;
            while(true){
                //왼쪽으로 가보기
                right+=1;
                if(right>size-1) right=0;
                countRight+=1;
                if(!isUsed[right]) break;
            }
            //같으면? 상관없다
            //왼쪽 오른쪽중 더 작은거 선택
            if(countLeft<countRight){
                moved+=countLeft;
                cursor=left;
                System.out.println("left");
            } 
            else{
                moved+=countRight;
                cursor=right;
                System.out.println("right");
            }
        }
        return moved;
    }
}
