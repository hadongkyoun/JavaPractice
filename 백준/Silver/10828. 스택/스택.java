
import java.util.Scanner;
import java.util.Stack;


public class Main{


	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int data;
        String command;

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(N > 0){
            command = input.next();
            switch(command){

                case "push":
                    data = input.nextInt();
                    stack.push(data);
                    break;

                case "top":
                if(stack.isEmpty())
                        sb.append(-1 + "\n");
                else
                        sb.append(stack.peek() + "\n");
                        break;
                
                case "size":
                        sb.append(stack.size() + "\n");
                        break;

                case "pop":
                    if(stack.isEmpty())
                        sb.append(-1 + "\n");
                    else
                        sb.append(stack.pop() + "\n");
                    break;
                case "empty":
                    if(stack.isEmpty())
                        sb.append(1 + "\n");
                    else
                        sb.append(0 + "\n");
                    break;
                    
                default:
                    break;
            }
            
            
            N--;
        }
        input.close();
        System.out.println(sb);
        
	}



}
