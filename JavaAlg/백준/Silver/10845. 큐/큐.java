import java.util.Scanner;

class QueueNode{
	private int data;
	QueueNode link;

	QueueNode(){
		data = -1;
		link = null;
	}
	QueueNode(int data){
		this.data = data;
		link = null;
	}
	int getData(){
		return this.data;
	}
}
class QueueManager{
	QueueNode front, rear;

	QueueManager(){
		front = null;
		rear = null;
	}
	boolean empty(){
		if(front == null && rear == null)
			return true;
		else
			return false;
	}

	int getFront(){
		if(empty())
			return -1;
		else
			return front.getData();
	}

	int getBack(){
		if(empty())
			return -1;
		else
			return rear.getData();
	}

	void push(int data){
		QueueNode newNode = new QueueNode(data);

		if(empty()){
				front = newNode;
				rear = newNode;
		}
		else{
			rear.link = newNode;
			rear = newNode;
		}
	}

	int pop(){
		if(empty())
			return -1;
		else{
			if(front==rear){
				int data = front.getData();
				front = null;
				rear = null;
				return data;
			}
			else{
				//여기서 원래 가리키고 있던 front의 link를 null로 해줘야 하는지
				QueueNode noNode = front;
				int data = noNode.getData();
				front = front.link;
				noNode.link = null;
				return data;
			}
		}
	}

	int returnSize(){
		if(empty())
			return 0;
		int cnt = 0;
		QueueNode tmpNode = front;
		while(tmpNode != rear){
			tmpNode = tmpNode.link;
			cnt++;
		}
		return cnt+1;
	}
}
public class Main{


	public static void main (String[] args){
		StringBuilder sb = new StringBuilder();
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int data;
		String command;
		
		QueueManager manager = new QueueManager();
		while(N > 0){
			command = input.next();
			switch(command){

					case "push":
							data = input.nextInt();
							manager.push(data);
							break;

					case "pop":
								sb.append(manager.pop() + "\n");
								break;
					
					case "size":
									sb.append(manager.returnSize() + "\n");
									break;

					case "empty":
							if(manager.empty())
									sb.append(1 + "\n");
							else
									sb.append(0 + "\n");
							break;
					case "front":
							sb.append(manager.getFront() + "\n");
							break;
					case "back":
							sb.append(manager.getBack() + "\n");

					default:
							break;
			}
			
			
			N--;
	}

	input.close();
	System.out.println(sb);
	}
}
