import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		for (int i = 0; i < k; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(a==x) {
				x=b;
			}else if(b==x) {
				x=a;
			}
		}
		sb.append(x).append('\n');
		System.out.println(sb);
	}
}
