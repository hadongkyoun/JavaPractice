import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//테스트 케이스 수
		int T = Integer.parseInt(st.nextToken());
		Stack<String> stack = new Stack<String>();
		while(T!=0){
		//테스트 시작
			st = new StringTokenizer(br.readLine());	//괄호 문자열 입력
			String blanks = st.nextToken();
			int flag = 1; // VPS
			//괄호 문자열 분석
			for(int i=0; i<blanks.length(); i++){
					String b = blanks.substring(i,i+1);
					if(b.equals(")")){
						if(stack.isEmpty()){
							flag = 0; // No VPS
							break;
						}
						else{
							if(stack.peek().equals("("))
								stack.pop();
							else
								flag = 0;
						}
					}
					else{
						stack.push(b);
					}
			}
			if(stack.size() > 0)
				flag = 0;

			if(flag == 1)
				bw.write("YES\n");
			else
				bw.write("NO\n");

		//테스트 끝
			stack.clear();
			T--;
		}
		bw.flush();
		bw.close();
	}
}
