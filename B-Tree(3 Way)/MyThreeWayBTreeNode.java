package org.dfpl.db.hash.m16011279;

import java.util.ArrayList;
//package 이름은 org.dfpl.db.hash.m학번 입니다. 
//지키지 않을 시 반려합니다. 
import java.util.List;

@SuppressWarnings("unused")
public class MyThreeWayBTreeNode {

	// Data Abstraction은 예시일 뿐 자유롭게 B-Tree의 범주 안에서 어느정도 수정가능
	
	/*
	 * 자바의 클래스 캡슐화 취지를 봤을땐 private로 사용해서 get 메서드로 얻어 오는게 맞지만 코드 자체가 너무 복잡하고 길어지는 관계로
	 * private 삭제
	 */
	
	MyThreeWayBTreeNode parent;
	List<Integer> keyList;
	
	List<MyThreeWayBTreeNode> children;
	
	//노드 생성
	MyThreeWayBTreeNode(){ 
		this.parent = null;
		this.keyList = new ArrayList<Integer>();
		this.children = null;
		/*	children의 갯수를 4로 하는 이유는
		 * 	LeafNode에서 overflow로 인해 부모 노드로 middle up을 해주는데
		 * 	부모노드에서 만약 overflow가 일어난다면
		 * 	부모노드의 키가 세개이며, Leaf Node에서 제일 작은 키 혹은 큰 키가
		 * 	형제 노드로 넘어가야 하므로 logical 하게 당연히 child가 4개 생긴다
		 * 	그치만 3 Way BTree이므로 child 4개중 중앙 2개 부분을
		 * 	분리하는 함수를 만들기 위해 children의 갯수를 4개로 했다
		 * 
		 * 	또한, 이러한 형태로하면 직관적으로 BTree가 기능하는대로 코드 구현이 가능하며
		 * 	여러 다양한 케이스를 하나의 함수로 General하게 변경 가능하다
		 * 	
		 * 	null로 초기화 함으로써 Middle Child인 children[1], children[2]
		 * 	둘 중 하나만 Node가 생성 시킬 것이고 그럼으로써 children 갯수가 계속해서 세개를 유지하는
		 * 	3WayBTree를 표현함
		 */
	}
	
	//Leaf Node 인지 확인
	boolean isLeaf() {
		if(this.children == null)
			return true;
		return false;
	}
	
	void makeChildSpace() {
		this.children = new ArrayList<MyThreeWayBTreeNode>();
	}
		
}
