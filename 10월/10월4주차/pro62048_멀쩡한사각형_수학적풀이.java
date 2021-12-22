
class Solution {
    public long solution(int w, int h) {
        long answer = w*h;
        long sub=0;
        
        //double slope = (double)h/w;
        //slope=Math.round(slope*10000000)/10000000.0;
        
        for(long i=0; i<w; i++){
            sub+=Math.ceil((double)h*(i+1)/w)-Math.floor((double)h*i/w);
        }
        
        return (long)h*w-sub;
    }
}
