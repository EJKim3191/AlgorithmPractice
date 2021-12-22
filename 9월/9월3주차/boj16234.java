package java06_BaekAlgoSelf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//시간초과
public class boj16234 {
	public static int N, L, R;
	public static int[][] map;
	public static int[][] used;
	public static int[] arr;
	public static boolean isFinished;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		
		str= new StringTokenizer(bfr.readLine());
		N=Integer.parseInt(str.nextToken());
		L=Integer.parseInt(str.nextToken());
		R=Integer.parseInt(str.nextToken());
		
		map=new int[N][N];
		used=new int[N][N];
		for(int i=0; i<N; i++) {
			str = new StringTokenizer(bfr.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(str.nextToken());
			}
		}

		int day=0;
		while(true) {
			//used 초기화
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					used[i][j]=0;
				}
			}
			//방향탐색 --> cnt로 각방 마킹
			int cnt = 1;
			isFinished=true;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(used[i][j]==0) {
						move(i, j, cnt);
						cnt++;
					}		
				}
			}
			//System.out.println(cnt);
			//움직일 수 없을 떄 탈출
			if(isFinished==true) break;
			//arr 초기화
			arr=new int[cnt];
			for(int i=0; i<cnt; i++) {
				arr[i]=0;
			}
			//arr 할당
			for(int k=1; k<cnt; k++) {
				int temp=0;
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(used[i][j]==k) {
							arr[k]+=map[i][j];
							temp+=1;
						}
					}
				}
				if(temp!=0) arr[k]=arr[k]/temp;
			}
			//하루 후
			for(int k=1; k<cnt; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(used[i][j]==k) {
							map[i][j]=arr[k];
						}
					}
				}
			}
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			day++;
		}
		
		System.out.println(day);
		
	}
	public static void move(int y, int x, int k) {
		//왼쪽
		
		if(x-1>=0 && used[y][x-1]==0 && L<=Math.abs(map[y][x-1]-map[y][x]) && Math.abs(map[y][x-1]-map[y][x])<=R) {
			used[y][x-1]=k;
			move(y, x-1, k);
			isFinished=false;
		}
		//오른쪽
		if(x+1<N && used[y][x+1]==0 && L<=Math.abs(map[y][x+1]-map[y][x]) && Math.abs(map[y][x+1]-map[y][x])<=R) {
			used[y][x+1]=k;
			move(y, x+1, k);
			isFinished=false;
		}
		//위
		if(y-1>=0 && used[y-1][x]==0 && L<=Math.abs(map[y-1][x]-map[y][x]) && Math.abs(map[y-1][x]-map[y][x])<=R) {
			used[y-1][x]=k;
			move(y-1, x, k);
			isFinished=false;
		}
		//아래
		if(y+1<N && used[y+1][x]==0 && L<=Math.abs(map[y+1][x]-map[y][x]) && Math.abs(map[y+1][x]-map[y][x])<=R) {
			used[y+1][x]=k;
			move(y+1, x, k);
			isFinished=false;
		}
		
			
	}
}
