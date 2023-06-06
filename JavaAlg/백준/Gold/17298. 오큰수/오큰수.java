import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		

		//수열 A
		int[] A = new int[N];

		//정답을 저장할 배열 answer
		int[] answer = new int[N];
		int index = 0;		
		//수열 A 값 입력
		String[] data = br.readLine().split(" ");	//공백으로 나눠서 값 받음
		for(int i=0; i<N; i++){
			A[i] = Integer.parseInt(data[i]);
		}
			
		//스택 생성 ( my Class : 56 )
		MyStack stackManager = new MyStack(N);

		//마지막 원소까지 push 됐을때
		while(index < N){

			//스택이 안비었을때 각 수의 오큰수 정하기
			while(!(stackManager.isEmpty()) && (A[stackManager.peek()] < A[index])){
				answer[stackManager.peek()] = A[index];
				stackManager.pop();
			}

			//index push
			stackManager.push(index);
			index++;
		
		}

		//오큰수가 없으면 스택에 남는다
		while(!stackManager.isEmpty()){
			answer[stackManager.peek()] = -1;
			stackManager.pop();
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<N; i++)
			bw.write(answer[i] + " ");
		bw.flush();
	}
}

class MyStack{
	//정해진 크기
	private int[] arr;
	private int top = -1;
	MyStack(int size){
		arr = new int[size];
	}
	int topIndex(){
		return top;
	}
  boolean isFull(){
		if(top == (arr.length-1))
			return true;
		return false;
	}

	boolean isEmpty(){
		if(top == -1)
			return true;
		return false;
	}

	void push(int data){
		//Stack이 다 찼는지 확인
		if(!isFull()){
			top++;
			arr[top] = data;
		}
	}

	int pop(){
		if(!isEmpty()){
				int data = arr[top];
				top--;
				return data; 
		}
		//스택이 비었을때
		return -1;
	}

	int peek(){
		if(!isEmpty()){
			return arr[top];
		}
		return -1;
	}

}