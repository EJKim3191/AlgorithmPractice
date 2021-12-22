
class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='z'){
                i+=3;
                sb.append("0");
            }
            else if(s.charAt(i)=='o'){
                i+=2;
                sb.append("1");
            }
            else if(s.charAt(i)=='t'){
                if(s.charAt(i+1)=='w'){
                    i+=2;
                    sb.append("2");
                }
                else if(s.charAt(i+1)=='h'){
                    i+=4;
                    sb.append("3");
                }
            }
            else if(s.charAt(i)=='f'){
                if(s.charAt(i+1)=='o'){
                    i+=3;
                    sb.append("4");
                }
                else if(s.charAt(i+1)=='i'){
                    i+=3;
                    sb.append("5");
                }
            }
            else if(s.charAt(i)=='s'){
                if(s.charAt(i+1)=='i'){
                    i+=2;
                    sb.append("6");
                }
                else if(s.charAt(i+1)=='e'){
                    i+=4;
                    sb.append("7");
                }
            }
            else if(s.charAt(i)=='e'){
                i+=4;
                sb.append("8");
            }
            else if(s.charAt(i)=='n'){
                i+=3;
                sb.append("9");
            }
            else{
                sb.append(s.charAt(i));
            }
            
        }
        answer=Integer.parseInt(sb.toString());
        return answer;
    }
}
